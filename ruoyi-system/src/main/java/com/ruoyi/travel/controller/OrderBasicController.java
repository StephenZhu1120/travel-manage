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
import com.ruoyi.travel.domain.OrderBasic;
import com.ruoyi.travel.service.IOrderBasicService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 订单管理Controller
 * 
 * @author buaa_travel
 * @date 2021-05-12
 */
@RestController
@RequestMapping("/travel/orderBasic")
public class OrderBasicController extends BaseController
{
    @Autowired
    private IOrderBasicService orderBasicService;

    /**
     * 查询订单管理列表
     */
    @PreAuthorize("@ss.hasPermi('travel:orderBasic:list')")
    @GetMapping("/list")
    public TableDataInfo list(OrderBasic orderBasic)
    {
        startPage();
        List<OrderBasic> list = orderBasicService.selectOrderBasicList(orderBasic);
        return getDataTable(list);
    }

    /**
     * 导出订单管理列表
     */
    @PreAuthorize("@ss.hasPermi('travel:orderBasic:export')")
    @Log(title = "订单管理", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(OrderBasic orderBasic)
    {
        List<OrderBasic> list = orderBasicService.selectOrderBasicList(orderBasic);
        ExcelUtil<OrderBasic> util = new ExcelUtil<OrderBasic>(OrderBasic.class);
        return util.exportExcel(list, "订单管理数据");
    }

    /**
     * 获取订单管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('travel:orderBasic:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(orderBasicService.selectOrderBasicById(id));
    }

    /**
     * 新增订单管理
     */
    @PreAuthorize("@ss.hasPermi('travel:orderBasic:add')")
    @Log(title = "订单管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody OrderBasic orderBasic)
    {
        return toAjax(orderBasicService.insertOrderBasic(orderBasic));
    }

    /**
     * 修改订单管理
     */
    @PreAuthorize("@ss.hasPermi('travel:orderBasic:edit')")
    @Log(title = "订单管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody OrderBasic orderBasic)
    {
        return toAjax(orderBasicService.updateOrderBasic(orderBasic));
    }

    /**
     * 删除订单管理
     */
    @PreAuthorize("@ss.hasPermi('travel:orderBasic:remove')")
    @Log(title = "订单管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(orderBasicService.deleteOrderBasicByIds(ids));
    }
}
