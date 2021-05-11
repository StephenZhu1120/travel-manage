package com.ruoyi.travel.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 产品信息对象 travel_product_basic
 *
 * @author buaa_travel
 * @date 2021-05-11
 */
public class ProductBasic extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 旅游产品id */
    @Excel(name = "旅游产品id")
    private Long id;

    /** 旅游产品名称 */
    @Excel(name = "旅游产品名称")
    private String productName;

    /** 旅游产品状态 */
    @Excel(name = "旅游产品状态")
    private String productStatus;

    /** 旅行天数 */
    @Excel(name = "旅行天数")
    private String productDay;

    /** 产品最后编辑时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "产品最后编辑时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date editTime;

    /** 产品策划（市场部） */
    @Excel(name = "产品策划", readConverterExp = "市=场部")
    private String productDesign;

    /** 产品计划（计调部） */
    @Excel(name = "产品计划", readConverterExp = "计=调部")
    private String productPlan;

    /** 出发地 */
    @Excel(name = "出发地")
    private String birthland;

    /** 目的地 */
    @Excel(name = "目的地")
    private String destination;

    /** 起始最低价格 */
    @Excel(name = "起始最低价格")
    private Long priceStart;

    /** 订单完成数量 */
    @Excel(name = "订单完成数量")
    private Long orderNumber;

    /** 产品展示文字 */
    @Excel(name = "产品展示文字")
    private String description;

    /** 图片链接地址 */
    @Excel(name = "图片链接地址")
    private String imgUrl;

    /** 图片宣传内容 */
    @Excel(name = "图片宣传内容")
    private String productDetailAds;

    /** 路线数量 */
    @Excel(name = "路线数量")
    private Long routeNumber;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setProductName(String productName)
    {
        this.productName = productName;
    }

    public String getProductName()
    {
        return productName;
    }
    public void setProductStatus(String productStatus)
    {
        this.productStatus = productStatus;
    }

    public String getProductStatus()
    {
        return productStatus;
    }
    public void setProductDay(String productDay)
    {
        this.productDay = productDay;
    }

    public String getProductDay()
    {
        return productDay;
    }
    public void setEditTime(Date editTime)
    {
        this.editTime = editTime;
    }

    public Date getEditTime()
    {
        return editTime;
    }
    public void setProductDesign(String productDesign)
    {
        this.productDesign = productDesign;
    }

    public String getProductDesign()
    {
        return productDesign;
    }
    public void setProductPlan(String productPlan)
    {
        this.productPlan = productPlan;
    }

    public String getProductPlan()
    {
        return productPlan;
    }
    public void setBirthland(String birthland)
    {
        this.birthland = birthland;
    }

    public String getBirthland()
    {
        return birthland;
    }
    public void setDestination(String destination)
    {
        this.destination = destination;
    }

    public String getDestination()
    {
        return destination;
    }
    public void setPriceStart(Long priceStart)
    {
        this.priceStart = priceStart;
    }

    public Long getPriceStart()
    {
        return priceStart;
    }
    public void setOrderNumber(Long orderNumber)
    {
        this.orderNumber = orderNumber;
    }

    public Long getOrderNumber()
    {
        return orderNumber;
    }
    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getDescription()
    {
        return description;
    }
    public void setImgUrl(String imgUrl)
    {
        this.imgUrl = imgUrl;
    }

    public String getImgUrl()
    {
        return imgUrl;
    }
    public void setProductDetailAds(String productDetailAds)
    {
        this.productDetailAds = productDetailAds;
    }

    public String getProductDetailAds()
    {
        return productDetailAds;
    }
    public void setRouteNumber(Long routeNumber)
    {
        this.routeNumber = routeNumber;
    }

    public Long getRouteNumber()
    {
        return routeNumber;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("productName", getProductName())
            .append("productStatus", getProductStatus())
            .append("productDay", getProductDay())
            .append("createTime", getCreateTime())
            .append("editTime", getEditTime())
            .append("productDesign", getProductDesign())
            .append("productPlan", getProductPlan())
            .append("birthland", getBirthland())
            .append("destination", getDestination())
            .append("priceStart", getPriceStart())
            .append("orderNumber", getOrderNumber())
            .append("description", getDescription())
            .append("imgUrl", getImgUrl())
            .append("productDetailAds", getProductDetailAds())
            .append("routeNumber", getRouteNumber())
            .toString();
    }
}
