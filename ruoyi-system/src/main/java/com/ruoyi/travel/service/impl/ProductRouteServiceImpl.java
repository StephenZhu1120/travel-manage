package com.ruoyi.travel.service.impl;

import java.math.BigDecimal;
import java.util.List;

import com.ruoyi.travel.domain.ProductRoute_Manage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.travel.mapper.ProductRouteMapper;
import com.ruoyi.travel.domain.ProductRoute;
import com.ruoyi.travel.service.IProductRouteService;

/**
 * 产品路线Service业务层处理
 *
 * @author buaa_travel
 * @date 2021-05-11
 */
@Service
public class ProductRouteServiceImpl implements IProductRouteService
{
    @Autowired
    private ProductRouteMapper productRouteMapper;

    /**
     * 查询产品路线
     *
     * @param id 产品路线ID
     * @return 产品路线
     */
    @Override
    public ProductRoute selectProductRouteById(Long id)
    {
        return productRouteMapper.selectProductRouteById(id);
    }

    /**
     * 查询产品路线列表
     *
     * @param productRoute 产品路线
     * @return 产品路线
     */
    @Override
    public List<ProductRoute> selectProductRouteList(ProductRoute productRoute)
    {
        return productRouteMapper.selectProductRouteList(productRoute);
    }

    /**
     * 查询产品路线列表
     *
     * @param productRoute 产品路线
     * @return 产品路线
     */
    public List<ProductRoute_Manage> selectProductRouteListWithName(ProductRoute productRoute)
    {
        return productRouteMapper.selectProductRouteListWithName(productRoute);
    }

    /**
     * 新增产品路线
     *
     * @param productRoute 产品路线
     * @return 结果
     */
    @Override
    public int insertProductRoute(ProductRoute productRoute)
    {
        return productRouteMapper.insertProductRoute(productRoute);
    }

    /**
     * 修改产品路线
     *
     * @param productRoute 产品路线
     * @return 结果
     */
    @Override
    public int updateProductRoute(ProductRoute productRoute)
    {
        return productRouteMapper.updateProductRoute(productRoute);
    }

    /**
     * 批量删除产品路线
     *
     * @param ids 需要删除的产品路线ID
     * @return 结果
     */
    @Override
    public int deleteProductRouteByIds(Long[] ids)
    {
        return productRouteMapper.deleteProductRouteByIds(ids);
    }

    /**
     * 删除产品路线信息
     *
     * @param id 产品路线ID
     * @return 结果
     */
    @Override
    public int deleteProductRouteById(Long id)
    {
        return productRouteMapper.deleteProductRouteById(id);
    }

    /**
     * 计算产品路线总价格
     *
     * @param productRoute 产品路线信息
     * @return 路线总价格
     */
    public BigDecimal calculateRoutePrice(ProductRoute productRoute)
    {
        return productRoute.getTransportPrice().add(productRoute.getHotelPrice().add(productRoute.getTravelPrice()));
    }

    /**
     * 计算某个产品的最低路线价格
     *
     * @param productId 产品id
     * @return 产品路线的最低价格
     */
    public BigDecimal getProductRoutePriceMin(Long productId)
    {
        return productRouteMapper.getProductRoutePriceMin(productId);
    }

    /**
     * 统计某个产品的路线个数
     *
     * @param productId 产品id
     * @return 产品包含的路线数量
     */
    public Long countRouteNumberByProductId(Long productId)
    {
        return productRouteMapper.countRouteNumberByProductId(productId);
    }
}
