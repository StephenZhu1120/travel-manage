package com.ruoyi.travel.controller;

import java.util.List;

import com.ruoyi.travel.domain.FinanceBasic;
import com.ruoyi.travel.domain.ProductBasic;
import com.ruoyi.travel.service.IFinanceBasicService;
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
})
public class OrderBasicController extends BaseController
{
    @Autowired
    private IOrderBasicService orderBasicService;

    @Autowired
    private IFinanceBasicService financeBasicService;

    @Autowired
    private IProductBasicService productBasicService;

    /**
     * 查询订单管理列表
     */
    @PreAuthorize("@ss.hasPermi('travel:orderBasic:list') or @ss.hasRole('Market_Dept') or @ss.hasRole('Operate_Dept') or @ss.hasRole('Sale_Dept') or @ss.hasRole('Finance_Dept')")
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
    @PreAuthorize("@ss.hasPermi('travel:orderBasic:export') or @ss.hasRole('Market_Dept') or @ss.hasRole('Operate_Dept') or @ss.hasRole('Sale_Dept') or @ss.hasRole('Finance_Dept')")
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
    @PreAuthorize("@ss.hasPermi('travel:orderBasic:query') or @ss.hasRole('Market_Dept') or @ss.hasRole('Operate_Dept') or @ss.hasRole('Sale_Dept') or @ss.hasRole('Finance_Dept')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(orderBasicService.selectOrderBasicById(id));
    }

    /**
     * 新增订单管理
     */
    @PreAuthorize("@ss.hasPermi('travel:orderBasic:add') or @ss.hasRole('Market_Dept') or @ss.hasRole('Operate_Dept') or @ss.hasRole('Sale_Dept') or @ss.hasRole('Finance_Dept')")
    @Log(title = "订单管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody OrderBasic orderBasic)
    {
        ProductBasic  productBasic = productBasicService.selectProductBasicById(orderBasic.getProductId());
        orderBasic.setProductName(productBasic.getProductName());
        orderBasic.setOrderStatus(0L);
        return toAjax(orderBasicService.insertOrderBasic(orderBasic));
    }

    /**
     * 修改订单管理
     */
    @PreAuthorize("@ss.hasPermi('travel:orderBasic:edit') or @ss.hasRole('Market_Dept') or @ss.hasRole('Operate_Dept') or @ss.hasRole('Sale_Dept') or @ss.hasRole('Finance_Dept')")
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
    @PreAuthorize("@ss.hasPermi('travel:orderBasic:remove') or @ss.hasRole('Market_Dept') or @ss.hasRole('Operate_Dept') or @ss.hasRole('Sale_Dept') or @ss.hasRole('Finance_Dept')")
    @Log(title = "订单管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(orderBasicService.deleteOrderBasicByIds(ids));
    }

    /**
     * 取消订单
     */
    @PreAuthorize("@ss.hasPermi('travel:orderBasic:edit') or @ss.hasRole('Market_Dept') or @ss.hasRole('Operate_Dept') or @ss.hasRole('Sale_Dept') or @ss.hasRole('Finance_Dept')")
    @Log(title = "订单管理", businessType = BusinessType.UPDATE)
    @PutMapping("/cancel/{id}")
    public AjaxResult CancelOrderBasic(@PathVariable Long id)
    {
        //需要在财务信息中创建一条退款记录（暂不包括退款时间和退款附言）
        OrderBasic orderBasic = orderBasicService.selectOrderBasicById(id);
        if(orderBasic.getOrderStatus() == 1L){
            FinanceBasic financeBasic = new FinanceBasic();
            financeBasic.setOrderId(orderBasic.getId()); financeBasic.setPrice(orderBasic.getPrice()); financeBasic.setTradeType(1L);
            financeBasicService.insertFinanceBasicByOrder(financeBasic);
        }
        //最后实现取消订单的状态更改
        return toAjax(orderBasicService.cancelOrderBasic(id));
    }

    /**
     * 支付订单
     */
    @PreAuthorize("@ss.hasPermi('travel:orderBasic:edit') or @ss.hasRole('Market_Dept') or @ss.hasRole('Operate_Dept') or @ss.hasRole('Sale_Dept') or @ss.hasRole('Finance_Dept')")
    @Log(title = "订单管理", businessType = BusinessType.UPDATE)
    @PutMapping("/pay/status/{id}")
    public AjaxResult payOrderBasic(@PathVariable Long id)
    {
        OrderBasic orderBasic = orderBasicService.selectOrderBasicById(id);
        FinanceBasic financeBasic = new FinanceBasic();
        financeBasic.setOrderId(orderBasic.getId()); financeBasic.setPrice(orderBasic.getPrice()); financeBasic.setTradeType(0L);
        //需要在财务系统中创建一条支付记录（为保持与退款的一致性，拆分为两步干）
        financeBasicService.insertFinanceBasicByOrder(financeBasic);
        //通过订单id，流水方向，找到唯一财务记录，然后添加转账时间和附言
        financeBasicService.appendFinanceTimeByOrder(orderBasic.getId(), 0L, orderBasic.getPayComment());
        return toAjax(orderBasicService.payOrderBasic(id));
    }

    /**
     * 退款订单更改状态
     */
    @PreAuthorize("@ss.hasPermi('travel:orderBasic:edit') or @ss.hasRole('Market_Dept') or @ss.hasRole('Operate_Dept') or @ss.hasRole('Sale_Dept') or @ss.hasRole('Finance_Dept')")
    @Log(title = "订单管理", businessType = BusinessType.UPDATE)
    @PutMapping("/refund/status/{id}")
    public AjaxResult refundOrderBasic(@PathVariable Long id)
    {
        OrderBasic orderBasic = orderBasicService.selectOrderBasicById(id);
        //通过订单id，流水方向，找到唯一财务记录，然后添加转账时间和附言
        financeBasicService.appendFinanceTimeByOrder(orderBasic.getId(), 1L, orderBasic.getRefundComment());
        return toAjax(orderBasicService.refundOrderBasic(id));
    }
}
