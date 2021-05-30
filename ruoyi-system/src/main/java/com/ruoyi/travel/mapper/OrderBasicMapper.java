package com.ruoyi.travel.mapper;

import java.util.List;
import com.ruoyi.travel.domain.OrderBasic;
import com.ruoyi.travel.domain.OrderMember;

/**
 * 订单管理Mapper接口
 *
 * @author buaa_travel
 * @date 2021-05-12
 */
public interface OrderBasicMapper
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
     * 查询订单管理列表倒序
     *
     * @param orderBasic 订单管理
     * @return 订单管理集合
     */
    public List<OrderBasic> selectOrderBasicListDesc(OrderBasic orderBasic);

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
     * 删除订单管理
     *
     * @param id 订单管理ID
     * @return 结果
     */
    public int deleteOrderBasicById(Long id);

    /**
     * 批量删除订单管理
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteOrderBasicByIds(Long[] ids);

    /**
     * 批量删除订单成员管理
     *
     * @param customerIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteOrderMemberByOrderIds(Long[] ids);

    /**
     * 批量新增订单成员管理
     *
     * @param orderMemberList 订单成员管理列表
     * @return 结果
     */
    public int batchOrderMember(List<OrderMember> orderMemberList);


    /**
     * 通过订单管理ID删除订单成员管理信息
     *
     * @param roleId 角色ID
     * @return 结果
     */
    public int deleteOrderMemberByOrderId(Long id);
}
