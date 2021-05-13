package com.ruoyi.travel.controller;

import java.util.List;

import com.ruoyi.travel.domain.FinanceBasic;
import com.ruoyi.travel.service.IFinanceBasicService;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.poi.ss.usermodel.DateUtil;
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
@RequestMapping(value = {
        "/travel/orderBasic",
        "/travel/orderSaleDept"
})
public class OrderBasicController extends BaseController
{
    @Autowired
    private IOrderBasicService orderBasicService;

    @Autowired
    private IFinanceBasicService financeBasicService;

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
        AjaxResult ajaxResult = toAjax(orderBasicService.updateOrderBasic(orderBasic));
        return ajaxResult;
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

    /**
     * 取消订单
     */
    @PreAuthorize("@ss.hasPermi('travel:orderBasic:edit')")
    @Log(title = "订单管理", businessType = BusinessType.UPDATE)
    @PutMapping("/cancel/{id}")
    public AjaxResult CancelOrderBasic(@PathVariable Long id)
    {
        return toAjax(orderBasicService.cancelOrderBasic(id));
    }

    /**
     * 支付订单更改状态
     */
    @PreAuthorize("@ss.hasPermi('travel:orderBasic:edit')")
    @Log(title = "订单管理", businessType = BusinessType.UPDATE)
    @PutMapping("/pay/status/{id}")
    public AjaxResult payOrderBasic(@PathVariable Long id)
    {
        OrderBasic orderBasic = orderBasicService.selectOrderBasicById(id);
        FinanceBasic financeBasic = new FinanceBasic(orderBasic.getId(), orderBasic.getPrice(), 0L, orderBasic.getPayComment());
        financeBasicService.insertFinanceBasicByOrder(financeBasic);
        return toAjax(orderBasicService.payOrderBasic(id));
    }
}
