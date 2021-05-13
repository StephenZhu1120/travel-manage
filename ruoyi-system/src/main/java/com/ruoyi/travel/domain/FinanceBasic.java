package com.ruoyi.travel.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 财务信息对象 travel_finance_basic
 *
 * @author buaa_travel
 * @date 2021-05-12
 */
public class FinanceBasic extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 自动编号 */
    @Excel(name = "自动编号")
    private Long id;

    /** 对应订单编号 */
    @Excel(name = "对应订单编号")
    private Long orderId;

    /** 交易金额 */
    @Excel(name = "交易金额")
    private BigDecimal price;

    /** 交易方向（支付/退款） */
    @Excel(name = "交易方向", readConverterExp = "支=付/退款")
    private Long tradeType;

    /** 交易备注 */
    @Excel(name = "交易备注")
    private String comment;

    /** 发起时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "发起时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;

    /** 交易时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "交易时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date tradeTime;

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
    public void setPrice(BigDecimal price)
    {
        this.price = price;
    }

    public BigDecimal getPrice()
    {
        return price;
    }
    public void setTradeType(Long tradeType)
    {
        this.tradeType = tradeType;
    }

    public Long getTradeType()
    {
        return tradeType;
    }
    public void setComment(String comment)
    {
        this.comment = comment;
    }

    public String getComment()
    {
        return comment;
    }
    public void setStartTime(Date startTime)
    {
        this.startTime = startTime;
    }

    public Date getStartTime()
    {
        return startTime;
    }
    public void setTradeTime(Date tradeTime)
    {
        this.tradeTime = tradeTime;
    }

    public Date getTradeTime()
    {
        return tradeTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("orderId", getOrderId())
            .append("price", getPrice())
            .append("tradeType", getTradeType())
            .append("comment", getComment())
            .append("startTime", getStartTime())
            .append("tradeTime", getTradeTime())
            .toString();
    }
}
