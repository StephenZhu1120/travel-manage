package com.ruoyi.travel.service;

import java.util.List;
import com.ruoyi.travel.domain.OrderBasic;

/**
 * 订单管理Service接口
 * 
 * @author buaa_travel
 * @date 2021-05-12
 */
public interface IOrderBasicService 
{
    /**
     * 查询订单管理
     * 
     * @param id 订单管理ID
     * @return 订单管理
     */
    public OrderBasic selectOrderBasicById(Long id);

    /**
     * 查询订单管理列表
     * 
     * @param orderBasic 订单管理
     * @return 订单管理集合
     */
    public List<OrderBasic> selectOrderBasicList(OrderBasic orderBasic);

    /**
     * 新增订单管理
     * 
     * @param orderBasic 订单管理
     * @return 结果
     */
    public int insertOrderBasic(OrderBasic orderBasic);

    /**
     * 修改订单管理
     * 
     * @param orderBasic 订单管理
     * @return 结果
     */
    public int updateOrderBasic(OrderBasic orderBasic);

    /**
     * 批量删除订单管理
     * 
     * @param ids 需要删除的订单管理ID
     * @return 结果
     */
    public int deleteOrderBasicByIds(Long[] ids);

    /**
     * 删除订单管理信息
     * 
     * @param id 订单管理ID
     * @return 结果
     */
    public int deleteOrderBasicById(Long id);
}
