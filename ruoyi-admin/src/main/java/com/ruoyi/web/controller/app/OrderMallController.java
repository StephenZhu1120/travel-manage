package com.ruoyi.web.controller.app;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.travel.domain.*;
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
    public AjaxResult getOrderList(OrderBasic orderBasic)
    {
        UserBasic userBasic = userBasicService.selectUserBasicById(orderBasic.getUserId());
        OrderBasic temp = new OrderBasic();
        temp.setUserId(orderBasic.getUserId());

        List<OrderBasic> orderBasicList = orderBasicService.selectOrderBasicListDesc(temp);
        List<Order_Mall> orderMallList = new ArrayList<Order_Mall>();
        if(orderBasicList.size() == 0)
            return AjaxResult.success(orderMallList);
        else {
            for(int i=0; i<orderBasicList.size(); i++){
                Order_Mall order_mall = new Order_Mall();
                ProductBasic productBasic = productBasicService.selectProductBasicById(orderBasicList.get(i).getProductId());
                ProductRoute productRoute = productRouteService.selectProductRouteById(orderBasicList.get(i).getRouteId());
                order_mall.setOrderId(orderBasicList.get(i).getId());
                order_mall.setProductName(productBasic.getProductName());
                String img = productBasic.getImgUrl();
                if(!(img == null || img.equals("")))
                    if(img.contains(";"))
                        order_mall.setImgUrl(img.substring(0, img.indexOf(";")));
                    else
                        order_mall.setImgUrl(img);
                order_mall.setRouteName(productRoute.getRouteName());
                order_mall.setUserName(userBasic.getUserName());
                order_mall.setPhoneNumber(userBasic.getPhoneNumber());
                order_mall.setOrderTime(orderBasicList.get(i).getOrderTime());
                order_mall.setTravelTime(orderBasicList.get(i).getTravelTime());
                order_mall.setOrderStatus(orderBasicList.get(i).getOrderStatus());
                order_mall.setPrice(orderBasicList.get(i).getPrice());
                order_mall.setPeopleNumber(orderBasicList.get(i).getPeopleNumber());
                order_mall.setPayWay(orderBasicList.get(i).getPayWay());
                order_mall.setPayTime(orderBasicList.get(i).getPayTime());
                order_mall.setRefundTime(orderBasicList.get(i).getRefundTime());

                orderMallList.add(order_mall);
            }
        }
        return AjaxResult.success(orderMallList);
    }

    @Log(title = "订单管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult createOrder(@RequestBody OrderBasic orderBasic)
    {
        UserBasic userBasic = userBasicService.selectUserBasicById(orderBasic.getUserId());
        ProductBasic productBasic = productBasicService.selectProductBasicById(orderBasic.getProductId());
        ProductRoute productRoute = productRouteService.selectProductRouteById(orderBasic.getRouteId());
        orderBasic.setPhonenumber(userBasic.getPhoneNumber());
        orderBasic.setProductName(productBasic.getProductName());
        orderBasic.setPrice(BigDecimal.valueOf(orderBasic.getPeopleNumber()).multiply(productRoute.getPrice()));
        orderBasic.setOrderStatus(0L);
        return toAjax(orderBasicService.insertOrderBasic(orderBasic));
    }

}
