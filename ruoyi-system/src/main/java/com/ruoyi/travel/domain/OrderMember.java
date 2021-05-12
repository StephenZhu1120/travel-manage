package com.ruoyi.travel.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 订单成员管理对象 travel_order_member
 * 
 * @author buaa_travel
 * @date 2021-05-12
 */
public class OrderMember extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 自动编号 */
    @Excel(name = "自动编号")
    private Long id;

    /** 所属订单id */
    @Excel(name = "所属订单id")
    private Long orderId;

    /** 真实姓名 */
    @Excel(name = "真实姓名")
    private String memberName;

    /** 身份证号 */
    @Excel(name = "身份证号")
    private String memberIdCard;

    /** 手机号码 */
    @Excel(name = "手机号码")
    private String memberPhonenumber;

    /** 性别 */
    @Excel(name = "性别")
    private Long memberSex;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setOrderId(Long orderId) 
    {
        this.orderId = orderId;
    }

    public Long getOrderId() 
    {
        return orderId;
    }
    public void setMemberName(String memberName) 
    {
        this.memberName = memberName;
    }

    public String getMemberName() 
    {
        return memberName;
    }
    public void setMemberIdCard(String memberIdCard) 
    {
        this.memberIdCard = memberIdCard;
    }

    public String getMemberIdCard() 
    {
        return memberIdCard;
    }
    public void setMemberPhonenumber(String memberPhonenumber) 
    {
        this.memberPhonenumber = memberPhonenumber;
    }

    public String getMemberPhonenumber() 
    {
        return memberPhonenumber;
    }
    public void setMemberSex(Long memberSex) 
    {
        this.memberSex = memberSex;
    }

    public Long getMemberSex() 
    {
        return memberSex;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("orderId", getOrderId())
            .append("memberName", getMemberName())
            .append("memberIdCard", getMemberIdCard())
            .append("memberPhonenumber", getMemberPhonenumber())
            .append("memberSex", getMemberSex())
            .toString();
    }
}
