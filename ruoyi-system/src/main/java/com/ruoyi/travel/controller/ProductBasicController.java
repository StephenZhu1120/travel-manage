package com.ruoyi.travel.controller;

import java.util.List;

import com.ruoyi.travel.domain.UserBasic;
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
import com.ruoyi.travel.domain.ProductBasic;
import com.ruoyi.travel.service.IProductBasicService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 产品信息Controller
 *
 * @author buaa_travel
 * @date 2021-05-12
 */
@RestController
@RequestMapping("/travel/productBasic")
public class ProductBasicController extends BaseController
{
    @Autowired
    private IProductBasicService productBasicService;

    /**
     * 查询产品信息列表
     */
    @PreAuthorize("@ss.hasPermi('travel:productBasic:list')")
    @GetMapping("/list")
    public TableDataInfo list(ProductBasic productBasic)
    {
        startPage();
        List<ProductBasic> list = productBasicService.selectProductBasicList(productBasic);
        return getDataTable(list);
    }

    /**
     * 导出产品信息列表
     */
    @PreAuthorize("@ss.hasPermi('travel:productBasic:export')")
    @Log(title = "产品信息", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ProductBasic productBasic)
    {
        List<ProductBasic> list = productBasicService.selectProductBasicList(productBasic);
        ExcelUtil<ProductBasic> util = new ExcelUtil<ProductBasic>(ProductBasic.class);
        return util.exportExcel(list, "产品信息数据");
    }

    /**
     * 获取产品信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('travel:productBasic:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(productBasicService.selectProductBasicById(id));
    }

    /**
     * 新增产品信息
     */
    @PreAuthorize("@ss.hasPermi('travel:productBasic:add')")
    @Log(title = "产品信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ProductBasic productBasic)
    {
        productBasic.setProductStatus(0L);
        return toAjax(productBasicService.insertProductBasic(productBasic));
    }

    /**
     * 上架/下架产品
     */
    @PreAuthorize("@ss.hasPermi('travel:productBasic:edit')")
    @Log(title = "产品信息", businessType = BusinessType.UPDATE)
    @PutMapping("/changeStatus")
    public AjaxResult changeStatus(@RequestBody ProductBasic productBasic) {
        ProductBasic new_productBasic = productBasicService.selectProductBasicById(productBasic.getId());
        if(new_productBasic.getProductStatus() == 0L)
            return AjaxResult.error("当前产品内容缺失，请联系计调部工作人员");
        else if(new_productBasic.getProductStatus() == 1L || new_productBasic.getProductStatus() == 4L)
            new_productBasic.setProductStatus(3L);
        else if(new_productBasic.getProductStatus() == 3L)
            new_productBasic.setProductStatus(4L);
        return toAjax(productBasicService.updateProductBasic(new_productBasic));
    }

    /**
     * 修改产品信息
     */
    @PreAuthorize("@ss.hasPermi('travel:productBasic:edit')")
    @Log(title = "产品信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ProductBasic productBasic)
    {
        return toAjax(productBasicService.updateProductBasic(productBasic));
    }

    /**
     * 删除产品信息
     */
    @PreAuthorize("@ss.hasPermi('travel:productBasic:remove')")
    @Log(title = "产品信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(productBasicService.deleteProductBasicByIds(ids));
    }
}
