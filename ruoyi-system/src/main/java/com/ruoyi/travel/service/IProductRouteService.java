package com.ruoyi.travel.service;

import java.math.BigDecimal;
import java.util.List;
import com.ruoyi.travel.domain.ProductRoute;

/**
 * 产品路线Service接口
 *
 * @author buaa_travel
 * @date 2021-05-11
 */
public interface IProductRouteService
{
    /**
     * 查询产品路线
     *
     * @param id 产品路线ID
     * @return 产品路线
     */
    public ProductRoute selectProductRouteById(Long id);

    /**
     * 查询产品路线列表
     *
     * @param productRoute 产品路线
     * @return 产品路线集合
     */
    public List<ProductRoute> selectProductRouteList(ProductRoute productRoute);

    /**
     * 新增产品路线
     *
     * @param productRoute 产品路线
     * @return 结果
     */
    public int insertProductRoute(ProductRoute productRoute);

    /**
     * 修改产品路线
     *
     * @param productRoute 产品路线
     * @return 结果
     */
    public int updateProductRoute(ProductRoute productRoute);

    /**
     * 批量删除产品路线
     *
     * @param ids 需要删除的产品路线ID
     * @return 结果
     */
    public int deleteProductRouteByIds(Long[] ids);

    /**
     * 删除产品路线信息
     *
     * @param id 产品路线ID
     * @return 结果
     */
    public int deleteProductRouteById(Long id);

    /**
     * 计算产品路线总价格
     *
     * @param productRoute 产品路线信息
     * @return 路线总价格
     */
    public BigDecimal calculateRoutePrice(ProductRoute productRoute);
}
