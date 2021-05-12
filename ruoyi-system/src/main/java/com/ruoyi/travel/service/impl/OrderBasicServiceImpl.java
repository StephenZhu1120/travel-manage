package com.ruoyi.travel.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.travel.domain.OrderMember;
import com.ruoyi.travel.mapper.OrderBasicMapper;
import com.ruoyi.travel.domain.OrderBasic;
import com.ruoyi.travel.service.IOrderBasicService;

/**
 * 订单管理Service业务层处理
 * 
 * @author buaa_travel
 * @date 2021-05-12
 */
@Service
public class OrderBasicServiceImpl implements IOrderBasicService 
{
    @Autowired
    private OrderBasicMapper orderBasicMapper;

    /**
     * 查询订单管理
     * 
     * @param id 订单管理ID
     * @return 订单管理
     */
    @Override
    public OrderBasic selectOrderBasicById(Long id)
    {
        return orderBasicMapper.selectOrderBasicById(id);
    }

    /**
     * 查询订单管理列表
     * 
     * @param orderBasic 订单管理
     * @return 订单管理
     */
    @Override
    public List<OrderBasic> selectOrderBasicList(OrderBasic orderBasic)
    {
        return orderBasicMapper.selectOrderBasicList(orderBasic);
    }

    /**
     * 新增订单管理
     * 
     * @param orderBasic 订单管理
     * @return 结果
     */
    @Transactional
    @Override
    public int insertOrderBasic(OrderBasic orderBasic)
    {
        int rows = orderBasicMapper.insertOrderBasic(orderBasic);
        insertOrderMember(orderBasic);
        return rows;
    }

    /**
     * 修改订单管理
     * 
     * @param orderBasic 订单管理
     * @return 结果
     */
    @Transactional
    @Override
    public int updateOrderBasic(OrderBasic orderBasic)
    {
        orderBasicMapper.deleteOrderMemberByOrderId(orderBasic.getId());
        insertOrderMember(orderBasic);
        return orderBasicMapper.updateOrderBasic(orderBasic);
    }

    /**
     * 批量删除订单管理
     * 
     * @param ids 需要删除的订单管理ID
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteOrderBasicByIds(Long[] ids)
    {
        orderBasicMapper.deleteOrderMemberByOrderIds(ids);
        return orderBasicMapper.deleteOrderBasicByIds(ids);
    }

    /**
     * 删除订单管理信息
     * 
     * @param id 订单管理ID
     * @return 结果
     */
    @Override
    public int deleteOrderBasicById(Long id)
    {
        orderBasicMapper.deleteOrderMemberByOrderId(id);
        return orderBasicMapper.deleteOrderBasicById(id);
    }

    /**
     * 新增订单成员管理信息
     * 
     * @param orderBasic 订单管理对象
     */
    public void insertOrderMember(OrderBasic orderBasic)
    {
        List<OrderMember> orderMemberList = orderBasic.getOrderMemberList();
        Long id = orderBasic.getId();
        if (StringUtils.isNotNull(orderMemberList))
        {
            List<OrderMember> list = new ArrayList<OrderMember>();
            for (OrderMember orderMember : orderMemberList)
            {
                orderMember.setOrderId(id);
                list.add(orderMember);
            }
            if (list.size() > 0)
            {
                orderBasicMapper.batchOrderMember(list);
            }
        }
    }
}
