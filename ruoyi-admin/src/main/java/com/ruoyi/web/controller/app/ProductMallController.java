package com.ruoyi.web.controller.app;

import java.util.List;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.travel.domain.ProductBasic;
import com.ruoyi.travel.domain.ProductRoute;
import com.ruoyi.travel.service.IProductBasicService;
import com.ruoyi.travel.service.IProductRouteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/product")
public class ProductMallController extends BaseController{

    @Autowired
    private IProductBasicService productBasicService;

    @Autowired
    private IProductRouteService productRouteService;

    /**
     * 获取所有旅游产品的列表信息
     */
    @GetMapping("/getAllProductList")
    public TableDataInfo list(ProductBasic productBasic)
    {
        startPage();
        productBasic.setProductStatus(3L);
        List<ProductBasic> product_list = productBasicService.selectProductBasicList(productBasic);
        return getDataTable(product_list);
    }

    /**
     * 根据id获取某个产品的详细信息
     */
    @GetMapping("/getProduct")
    public AjaxResult getProduct(@RequestBody ProductBasic productBasic)
    {
        return AjaxResult.success(productBasicService.selectProductBasicById(productBasic.getId()));
    }

    /**
     * 根据产品id获取所有路线的详细信息列表
     */
    @GetMapping("/getRouteByProduct")
    public AjaxResult getRoute(@RequestBody Long productId)
    {
        ProductRoute productRoute = new ProductRoute();
        productRoute.setProductId(productId);
        return AjaxResult.success(productRouteService.selectProductRouteList(productRoute));
    }
}
