package com.ruoyi.web.controller.app;

import java.math.BigDecimal;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.travel.domain.OrderBasic;
import com.ruoyi.travel.domain.ProductBasic;
import com.ruoyi.travel.domain.ProductRoute;
import com.ruoyi.travel.domain.UserBasic;
import com.ruoyi.travel.service.IOrderBasicService;
import com.ruoyi.travel.service.IProductBasicService;
import com.ruoyi.travel.service.IProductRouteService;
import com.ruoyi.travel.service.IUserBasicService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/order")
public class OrderMallController extends BaseController{

    @Autowired
    private IOrderBasicService orderBasicService;

    @Autowired
    private IProductBasicService productBasicService;

    @Autowired
    private IProductRouteService productRouteService;

    @Autowired
    private IUserBasicService userBasicService;

    /**
     * 查询订单列表
     */
    @GetMapping("getAllOrderList")
    public AjaxResult getOrderList(@RequestBody OrderBasic orderBasic)
    {
        ProductBasic productBasic = productBasicService.selectProductBasicById(orderBasic.getProductId());
        ProductRoute productRoute = productRouteService.selectProductRouteById(orderBasic.getRouteId());
        orderBasic.setProductName(productBasic.getProductName());
        orderBasic.setOrderStatus(0L);
        return toAjax(orderBasicService.insertOrderBasic(orderBasic));
    }

    @Log(title = "订单管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult createOrder(@RequestBody OrderBasic orderBasic)
    {
        UserBasic userBasic = userBasicService.selectUserBasicById((int)orderBasic.getUserId().intValue());
        ProductBasic productBasic = productBasicService.selectProductBasicById(orderBasic.getProductId());
        ProductRoute productRoute = productRouteService.selectProductRouteById(orderBasic.getRouteId());
        orderBasic.setPhonenumber(userBasic.getPhoneNumber());
        orderBasic.setProductName(productBasic.getProductName());
        orderBasic.setPrice(BigDecimal.valueOf(orderBasic.getPeopleNumber()).multiply(productRoute.getPrice()));
        orderBasic.setOrderStatus(0L);
        return toAjax(orderBasicService.insertOrderBasic(orderBasic));
    }

}
