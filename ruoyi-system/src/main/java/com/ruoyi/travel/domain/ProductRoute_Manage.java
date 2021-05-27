package com.ruoyi.travel.domain;

import com.ruoyi.common.annotation.Excel;

import java.math.BigDecimal;

public class ProductRoute_Manage {
    /** 路线id */
    @Excel(name = "路线id")
    private Long id;

    /** 所属产品id */
    @Excel(name = "所属产品id")
    private Long productId;

    /** 所属产品名称 */
    @Excel(name = "所属产品名称")
    private String productName;

    /** 路线名称 */
    @Excel(name = "路线名称")
    private String routeName;

    /** 路线价格 */
    @Excel(name = "路线价格")
    private BigDecimal price;

    /** 交通工具描述 */
    @Excel(name = "交通工具描述")
    private String transportType;

    /** 交通工具部分价格 */
    @Excel(name = "交通工具部分价格")
    private BigDecimal transportPrice;

    /** 宾馆描述 */
    @Excel(name = "宾馆描述")
    private String hotelType;

    /** 宾馆部分价格 */
    @Excel(name = "宾馆部分价格")
    private BigDecimal hotelPrice;

    /** 旅行描述 */
    @Excel(name = "旅行描述")
    private String travelType;

    /** 旅行部分价格 */
    @Excel(name = "旅行部分价格")
    private BigDecimal travelPrice;

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

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }

    public void setRouteName(String routeName)
    {
        this.routeName = routeName;
    }

    public String getRouteName()
    {
        return routeName;
    }
    public void setPrice(BigDecimal price)
    {
        this.price = price;
    }

    public BigDecimal getPrice()
    {
        return price;
    }
    public void setTransportType(String transportType)
    {
        this.transportType = transportType;
    }

    public String getTransportType()
    {
        return transportType;
    }
    public void setTransportPrice(BigDecimal transportPrice)
    {
        this.transportPrice = transportPrice;
    }

    public BigDecimal getTransportPrice()
    {
        return transportPrice;
    }
    public void setHotelType(String hotelType)
    {
        this.hotelType = hotelType;
    }

    public String getHotelType()
    {
        return hotelType;
    }
    public void setHotelPrice(BigDecimal hotelPrice)
    {
        this.hotelPrice = hotelPrice;
    }

    public BigDecimal getHotelPrice()
    {
        return hotelPrice;
    }
    public void setTravelType(String travelType)
    {
        this.travelType = travelType;
    }

    public String getTravelType()
    {
        return travelType;
    }
    public void setTravelPrice(BigDecimal travelPrice)
    {
        this.travelPrice = travelPrice;
    }

    public BigDecimal getTravelPrice()
    {
        return travelPrice;
    }
}
