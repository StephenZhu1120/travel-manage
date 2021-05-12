package com.ruoyi.travel.controller;

import java.util.List;
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
import com.ruoyi.travel.domain.FinanceBasic;
import com.ruoyi.travel.service.IFinanceBasicService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 财务信息Controller
 * 
 * @author buaa_travel
 * @date 2021-05-12
 */
@RestController
@RequestMapping("/travel/financeBasic")
public class FinanceBasicController extends BaseController
{
    @Autowired
    private IFinanceBasicService financeBasicService;

    /**
     * 查询财务信息列表
     */
    @PreAuthorize("@ss.hasPermi('travel:financeBasic:list')")
    @GetMapping("/list")
    public TableDataInfo list(FinanceBasic financeBasic)
    {
        startPage();
        List<FinanceBasic> list = financeBasicService.selectFinanceBasicList(financeBasic);
        return getDataTable(list);
    }

    /**
     * 导出财务信息列表
     */
    @PreAuthorize("@ss.hasPermi('travel:financeBasic:export')")
    @Log(title = "财务信息", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(FinanceBasic financeBasic)
    {
        List<FinanceBasic> list = financeBasicService.selectFinanceBasicList(financeBasic);
        ExcelUtil<FinanceBasic> util = new ExcelUtil<FinanceBasic>(FinanceBasic.class);
        return util.exportExcel(list, "财务信息数据");
    }

    /**
     * 获取财务信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('travel:financeBasic:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(financeBasicService.selectFinanceBasicById(id));
    }

    /**
     * 新增财务信息
     */
    @PreAuthorize("@ss.hasPermi('travel:financeBasic:add')")
    @Log(title = "财务信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody FinanceBasic financeBasic)
    {
        return toAjax(financeBasicService.insertFinanceBasic(financeBasic));
    }

    /**
     * 修改财务信息
     */
    @PreAuthorize("@ss.hasPermi('travel:financeBasic:edit')")
    @Log(title = "财务信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody FinanceBasic financeBasic)
    {
        return toAjax(financeBasicService.updateFinanceBasic(financeBasic));
    }

    /**
     * 删除财务信息
     */
    @PreAuthorize("@ss.hasPermi('travel:financeBasic:remove')")
    @Log(title = "财务信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(financeBasicService.deleteFinanceBasicByIds(ids));
    }
}
