package com.ruoyi.travel.domain;

import com.ruoyi.common.annotation.Excel;

import java.math.BigDecimal;
import java.util.List;

public class Product_Route_Img {
    /** 旅游产品id */
    private Long id;

    /** 旅游产品名称 */
    private String productName;

    /** 旅游产品状态 */
    private Long productStatus;

    /** 旅行天数 */
    private Long productDay;

    /** 出发地 */
    private String birthland;

    /** 目的地 */
    private String destination;

    /** 产品最低起始价格 */
    private BigDecimal priceStart;

    /** 订单完成数量 */
    private Long orderNumber;

    /** 旅游产品简介 */
    private String description;

    /** 图片链接地址 */
    private List<String> imgs;

    /** 图片宣传内容 */
    private String productDetailAds;

    /** 路线详细内容 */
    private List<Route_Mall> productRoutes;

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
    public void setProductStatus(Long productStatus)
    {
        this.productStatus = productStatus;
    }
    public Long getProductStatus()
    {
        return productStatus;
    }
    public void setProductDay(Long productDay)
    {
        this.productDay = productDay;
    }
    public Long getProductDay()
    {
        return productDay;
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
    public void setPriceStart(BigDecimal priceStart)
    {
        this.priceStart = priceStart;
    }
    public BigDecimal getPriceStart()
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
    public void setImgs(List<String> imgs)
    {
        this.imgs = imgs;
    }
    public List<String> getImgs()
    {
        return imgs;
    }
    public void setProductDetailAds(String productDetailAds)
    {
        this.productDetailAds = productDetailAds;
    }
    public String getProductDetailAds()
    {
        return productDetailAds;
    }
    public void setProductRoutes(List<Route_Mall> productRoutes)
    {
        this.productRoutes = productRoutes;
    }
    public List<Route_Mall> getProductRoutes()
    {
        return productRoutes;
    }
}
