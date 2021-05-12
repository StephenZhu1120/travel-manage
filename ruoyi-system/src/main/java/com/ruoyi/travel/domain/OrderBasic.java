package com.ruoyi.travel.domain;

import java.math.BigDecimal;
import java.util.List;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 订单管理对象 travel_order_basic
 * 
 * @author buaa_travel
 * @date 2021-05-12
 */
public class OrderBasic extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 订单id */
    @Excel(name = "订单id")
    private Long id;

    /** 下单产品id */
    @Excel(name = "下单产品id")
    private Long productId;

    /** 具体路线id */
    @Excel(name = "具体路线id")
    private Long routeId;

    /** 产品名称 */
    @Excel(name = "产品名称")
    private String productName;

    /** 下单用户id */
    @Excel(name = "下单用户id")
    private Long userId;

    /** 下单手机号 */
    @Excel(name = "下单手机号")
    private String phonenumber;

    /** 旅行时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "旅行时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date travelTime;

    /** 下单时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "下单时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date orderTime;

    /** 订单人数 */
    @Excel(name = "订单人数")
    private Long peopleNumber;

    /** 订单价格 */
    @Excel(name = "订单价格")
    private BigDecimal price;

    /** 订单状态 */
    @Excel(name = "订单状态")
    private Long orderStatus;

    /** 支付时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "支付时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date payTime;

    /** 支付备注 */
    @Excel(name = "支付备注")
    private String payComment;

    /** 支付方式 */
    @Excel(name = "支付方式")
    private Long payWay;

    /** 退款时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "退款时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date refundTime;

    /** 退款备注 */
    @Excel(name = "退款备注")
    private String refundComment;

    /** 最后编辑时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "最后编辑时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date editTime;

    /** 订单成员管理信息 */
    private List<OrderMember> orderMemberList;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setProductId(Long productId) 
    {
        this.productId = productId;
    }

    public Long getProductId() 
    {
        return productId;
    }
    public void setRouteId(Long routeId) 
    {
        this.routeId = routeId;
    }

    public Long getRouteId() 
    {
        return routeId;
    }
    public void setProductName(String productName) 
    {
        this.productName = productName;
    }

    public String getProductName() 
    {
        return productName;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setPhonenumber(String phonenumber) 
    {
        this.phonenumber = phonenumber;
    }

    public String getPhonenumber() 
    {
        return phonenumber;
    }
    public void setTravelTime(Date travelTime) 
    {
        this.travelTime = travelTime;
    }

    public Date getTravelTime() 
    {
        return travelTime;
    }
    public void setOrderTime(Date orderTime) 
    {
        this.orderTime = orderTime;
    }

    public Date getOrderTime() 
    {
        return orderTime;
    }
    public void setPeopleNumber(Long peopleNumber) 
    {
        this.peopleNumber = peopleNumber;
    }

    public Long getPeopleNumber() 
    {
        return peopleNumber;
    }
    public void setPrice(BigDecimal price) 
    {
        this.price = price;
    }

    public BigDecimal getPrice() 
    {
        return price;
    }
    public void setOrderStatus(Long orderStatus) 
    {
        this.orderStatus = orderStatus;
    }

    public Long getOrderStatus() 
    {
        return orderStatus;
    }
    public void setPayTime(Date payTime) 
    {
        this.payTime = payTime;
    }

    public Date getPayTime() 
    {
        return payTime;
    }
    public void setPayComment(String payComment) 
    {
        this.payComment = payComment;
    }

    public String getPayComment() 
    {
        return payComment;
    }
    public void setPayWay(Long payWay) 
    {
        this.payWay = payWay;
    }

    public Long getPayWay() 
    {
        return payWay;
    }
    public void setRefundTime(Date refundTime) 
    {
        this.refundTime = refundTime;
    }

    public Date getRefundTime() 
    {
        return refundTime;
    }
    public void setRefundComment(String refundComment) 
    {
        this.refundComment = refundComment;
    }

    public String getRefundComment() 
    {
        return refundComment;
    }
    public void setEditTime(Date editTime) 
    {
        this.editTime = editTime;
    }

    public Date getEditTime() 
    {
        return editTime;
    }

    public List<OrderMember> getOrderMemberList()
    {
        return orderMemberList;
    }

    public void setOrderMemberList(List<OrderMember> orderMemberList)
    {
        this.orderMemberList = orderMemberList;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("productId", getProductId())
            .append("routeId", getRouteId())
            .append("productName", getProductName())
            .append("userId", getUserId())
            .append("phonenumber", getPhonenumber())
            .append("travelTime", getTravelTime())
            .append("orderTime", getOrderTime())
            .append("peopleNumber", getPeopleNumber())
            .append("price", getPrice())
            .append("orderStatus", getOrderStatus())
            .append("payTime", getPayTime())
            .append("payComment", getPayComment())
            .append("payWay", getPayWay())
            .append("refundTime", getRefundTime())
            .append("refundComment", getRefundComment())
            .append("editTime", getEditTime())
            .append("orderMemberList", getOrderMemberList())
            .toString();
    }
}
