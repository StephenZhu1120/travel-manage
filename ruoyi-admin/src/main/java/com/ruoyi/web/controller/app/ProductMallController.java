package com.ruoyi.web.controller.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.travel.domain.ProductBasic;
import com.ruoyi.travel.domain.ProductRoute;
import com.ruoyi.travel.domain.Product_Route_Img;
import com.ruoyi.travel.domain.Route_Mall;
import com.ruoyi.travel.service.IProductBasicService;
import com.ruoyi.travel.service.IProductRouteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
        if(product_list.size() != 0)
            for(int i=0; i<product_list.size(); i++){
                String img_string = product_list.get(i).getImgUrl();
                if(!(img_string == null || img_string.equals("")))
                    if(img_string.contains(";"))
                        product_list.get(i).setImgUrl(img_string.substring(0, img_string.indexOf(";")));
            }
        return getDataTable(product_list);
    }

    /**
     * 根据id获取某个产品的详细信息
     */
    @GetMapping("/getProduct")
    public AjaxResult getProduct(ProductBasic productBasic)
    {
        Product_Route_Img product_route_img = new Product_Route_Img();//新建一个前端商城信息展示类

        ProductRoute productRoute = new ProductRoute();//新建一个路线查询
        productRoute.setProductId(productBasic.getId());
        ProductBasic new_productBasic = productBasicService.selectProductBasicById(productBasic.getId());//通过id查询到产品
        List<ProductRoute> new_productRoute = productRouteService.selectProductRouteList(productRoute);//通过id查询到路线的List
        List<Route_Mall> routeMallList = new ArrayList<Route_Mall>();

        if(new_productBasic == null)
            return error("未找到该旅游产品");

        product_route_img.setId(new_productBasic.getId()); product_route_img.setProductName(new_productBasic.getProductName());
        product_route_img.setProductStatus(new_productBasic.getProductStatus()); product_route_img.setProductDay(new_productBasic.getProductDay());
        product_route_img.setBirthland(new_productBasic.getBirthland()); product_route_img.setDestination(new_productBasic.getDestination());
        product_route_img.setPriceStart(new_productBasic.getPriceStart()); product_route_img.setOrderNumber(new_productBasic.getOrderNumber());
        product_route_img.setDescription(new_productBasic.getDescription());product_route_img.setProductDetailAds(new_productBasic.getProductDetailAds());
        if(!(new_productBasic.getImgUrl() == null || new_productBasic.getImgUrl().equals("")))
            product_route_img.setImgs(Arrays.asList(new_productBasic.getImgUrl().split(";")));//按照分号对图片地址进行分割
        if(new_productRoute.size() != 0) {
            for (int i = 0; i < new_productRoute.size(); i++) {//对路线详细报价进行隐藏屏蔽，不显示给客户
                Route_Mall route_mall = new Route_Mall();
                route_mall.setIndex(i);
                route_mall.setRouteId(new_productRoute.get(i).getId());
                route_mall.setProductId(new_productRoute.get(i).getProductId());
                route_mall.setRouteName(new_productRoute.get(i).getRouteName());
                route_mall.setPrice(new_productRoute.get(i).getPrice());
                route_mall.setTransportType(new_productRoute.get(i).getTransportType());
                route_mall.setHotelType(new_productRoute.get(i).getHotelType());
                route_mall.setTravelType(new_productRoute.get(i).getTravelType());
                routeMallList.add(route_mall);
            }
            product_route_img.setProductRoutes(routeMallList);
        }
        return AjaxResult.success(product_route_img);
    }

    /**
     * 根据产品id获取所有路线的详细信息列表
     */
    // @GetMapping("/getRouteByProduct")
    // public AjaxResult getRoute(@RequestBody Long productId)
    // {
    //     ProductRoute productRoute = new ProductRoute();
    //     productRoute.setProductId(productId);
    //     return AjaxResult.success(productRouteService.selectProductRouteList(productRoute));
    // }
}
