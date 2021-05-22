package com.ruoyi.travel.domain;

import java.math.BigDecimal;

public class Route_Mall {
    /** 标号id*/
    private int index;

    /** 路线id */
    private Long routeId;

    /** 所属产品id */
    private Long productId;

    /** 路线名称 */
    private String routeName;

    /** 路线价格 */
    private BigDecimal price;

    /** 交通方式价格 */
    private String transportType;

    /** 住宿方式价格 */
    private String hotelType;

    /** 旅游方式价格 */
    private String travelType;


    public void setIndex(int index) {
        this.index = index;
    }
    public int getIndex() {
        return index;
    }
    public void setRouteId(Long routeId) {
        this.routeId = routeId;
    }
    public Long getRouteId() {
        return routeId;
    }
    public void setProductId(Long productId) {
        this.productId = productId;
    }
    public Long getProductId() {
        return productId;
    }
    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }
    public String getRouteName() {
        return routeName;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    public BigDecimal getPrice() {
        return price;
    }
    public void setTransportType(String transportType) {
        this.transportType = transportType;
    }
    public String getTransportType() {
        return transportType;
    }
    public void setHotelType(String hotelType) {
        this.hotelType = hotelType;
    }
    public String getHotelType() {
        return hotelType;
    }
    public void setTravelType(String travelType) {
        this.travelType = travelType;
    }
    public String getTravelType() {
        return travelType;
    }
}
