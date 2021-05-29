package com.ruoyi.travel.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.ruoyi.common.constant.HttpStatus;
import com.ruoyi.travel.domain.ProductBasic;
import com.ruoyi.travel.domain.ProductRoute_Manage;
import com.ruoyi.travel.service.IProductBasicService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.travel.domain.ProductRoute;
import com.ruoyi.travel.service.IProductRouteService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 产品路线Controller
 *
 * @author buaa_travel
 * @date 2021-05-11
 */
@RestController
@RequestMapping("/travel/productRoute")
public class ProductRouteController extends BaseController
{
    @Autowired
    private IProductRouteService productRouteService;
    @Autowired
    private IProductBasicService productBasicService;

    /**
     * 查询产品路线列表
     */
    @PreAuthorize("@ss.hasPermi('travel:productRoute:list')")
    @GetMapping("/list")
    public TableDataInfo list(ProductRoute productRoute)
    {
        startPage();
        List<ProductRoute> list = productRouteService.selectProductRouteList(productRoute);
        List<ProductRoute_Manage> new_list = new ArrayList<ProductRoute_Manage>();
        if(list.size()>0){
            for(int i=0; i<list.size(); i++){
                ProductRoute_Manage productRoute_manage = new ProductRoute_Manage();
                productRoute_manage.setId(list.get(i).getId());
                productRoute_manage.setProductId(list.get(i).getProductId());
                productRoute_manage.setProductName(productBasicService.selectProductBasicById(list.get(i).getProductId()).getProductName());
                productRoute_manage.setRouteName(list.get(i).getRouteName());
                productRoute_manage.setPrice(list.get(i).getPrice());
                productRoute_manage.setTransportPrice(list.get(i).getTransportPrice());
                productRoute_manage.setTransportType(list.get(i).getTransportType());
                productRoute_manage.setHotelPrice(list.get(i).getHotelPrice());
                productRoute_manage.setHotelType(list.get(i).getHotelType());
                productRoute_manage.setTravelPrice(list.get(i).getTravelPrice());
                productRoute_manage.setTravelType(list.get(i).getTravelType());
                new_list.add(productRoute_manage);
            }
        }
        return getDataTable(new_list);
    }

    /**
     * 导出产品路线列表
     */
    @PreAuthorize("@ss.hasPermi('travel:productRoute:export')")
    @Log(title = "产品路线", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ProductRoute productRoute)
    {
        List<ProductRoute> list = productRouteService.selectProductRouteList(productRoute);
        ExcelUtil<ProductRoute> util = new ExcelUtil<ProductRoute>(ProductRoute.class);
        return util.exportExcel(list, "产品路线数据");
    }

    /**
     * 获取产品路线详细信息
     */
    @PreAuthorize("@ss.hasPermi('travel:productRoute:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(productRouteService.selectProductRouteById(id));
    }

    /**
     * 新增产品路线
     */
    @PreAuthorize("@ss.hasPermi('travel:productRoute:add')")
    @Log(title = "产品路线", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ProductRoute productRoute)
    {
        BigDecimal price_now = productRouteService.calculateRoutePrice(productRoute);//自动计算路线总金额
        productRoute.setPrice(price_now);
        ProductBasic productBasic = productBasicService.selectProductBasicById(productRoute.getProductId());//通过id找到该路线属于的产品

        BigDecimal present_price = productRouteService.getProductRoutePriceMin(productBasic.getId());//获取插入前的最低价格
        if(present_price == null)
            present_price = BigDecimal.ZERO;
        productBasic.setPriceStart(present_price.min(price_now));//找到更小的值
        if(productBasic.getProductStatus() == 0L)
            productBasic.setProductStatus(1L);
        AjaxResult ajaxResult = toAjax(productRouteService.insertProductRoute(productRoute));//执行路线插入
        productBasic.setRouteNumber(productRouteService.countRouteNumberByProductId(productBasic.getId()));//自动更新路线数量
        productBasicService.updateProductBasic(productBasic);//执行更新
        return ajaxResult;
    }

    /**
     * 修改产品路线
     */
    @PreAuthorize("@ss.hasPermi('travel:productRoute:edit')")
    @Log(title = "产品路线", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ProductRoute productRoute)
    {
        productRoute.setPrice(productRouteService.calculateRoutePrice(productRoute));//自动计算路线总金额
        ProductBasic productBasic = productBasicService.selectProductBasicById(productRoute.getProductId());//通过id找到该路线属于的产品
        AjaxResult ajaxResult = toAjax(productRouteService.updateProductRoute(productRoute));
        productBasic.setPriceStart(productRouteService.getProductRoutePriceMin(productBasic.getId()));//还找到产品所有路线中的最低价格
        productBasic.setRouteNumber(productRouteService.countRouteNumberByProductId(productBasic.getId()));//自动更新路线数量
        productBasicService.updateProductBasic(productBasic);//执行更新
        return ajaxResult;
    }

    /**
     * 删除产品路线
     */
    @PreAuthorize("@ss.hasPermi('travel:productRoute:remove')")
    @Log(title = "产品路线", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        AjaxResult ajaxResult = new AjaxResult();
        int num = ids.length;
        for(int i=0; i < num; i++){
            ProductRoute productRoute = productRouteService.selectProductRouteById(ids[i]);//先通过路线id定位到路线
            ProductBasic productBasic = productBasicService.selectProductBasicById(productRoute.getProductId());//通过id找到该路线属于的产品
            ajaxResult = toAjax(productRouteService.deleteProductRouteById(ids[i]));
//            if(! (ajaxResult.getCodeTag() == 200))
//                break;
            productBasic.setRouteNumber(productRouteService.countRouteNumberByProductId(productBasic.getId()));//更新路线数量
            productBasic.setPriceStart(productRouteService.getProductRoutePriceMin(productBasic.getId()));//找到产品所有路线中的最低价格
            productBasicService.updateProductBasic(productBasic);//自动更新产品的最后编辑时间
        }
        return ajaxResult;
    }
}
