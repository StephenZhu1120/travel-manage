package com.ruoyi.travel.controller;

import java.util.List;

import com.ruoyi.travel.domain.ProductBasic;
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
        return getDataTable(list);
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
        productRoute.setPrice(productRouteService.calculateRoutePrice(productRoute));
        ProductBasic productBasic = productBasicService.selectProductBasicById(productRoute.getProductId());
        productBasicService.updateProductBasic(productBasic);
        return toAjax(productRouteService.insertProductRoute(productRoute));
    }

    /**
     * 修改产品路线
     */
    @PreAuthorize("@ss.hasPermi('travel:productRoute:edit')")
    @Log(title = "产品路线", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ProductRoute productRoute)
    {
        productRoute.setPrice(productRouteService.calculateRoutePrice(productRoute));
        ProductBasic productBasic = productBasicService.selectProductBasicById(productRoute.getProductId());
        productBasicService.updateProductBasic(productBasic);
        return toAjax(productRouteService.updateProductRoute(productRoute));
    }

    /**
     * 删除产品路线
     */
    @PreAuthorize("@ss.hasPermi('travel:productRoute:remove')")
    @Log(title = "产品路线", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(productRouteService.deleteProductRouteByIds(ids));
    }
}
