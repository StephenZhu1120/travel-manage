package com.ruoyi.travel.service;

import java.util.List;
import com.ruoyi.travel.domain.ProductBasic;

/**
 * 产品信息Service接口
 * 
 * @author buaa_travel
 * @date 2021-05-11
 */
public interface IProductBasicService 
{
    /**
     * 查询产品信息
     * 
     * @param id 产品信息ID
     * @return 产品信息
     */
    public ProductBasic selectProductBasicById(Long id);

    /**
     * 查询产品信息列表
     * 
     * @param productBasic 产品信息
     * @return 产品信息集合
     */
    public List<ProductBasic> selectProductBasicList(ProductBasic productBasic);

    /**
     * 新增产品信息
     * 
     * @param productBasic 产品信息
     * @return 结果
     */
    public int insertProductBasic(ProductBasic productBasic);

    /**
     * 修改产品信息
     * 
     * @param productBasic 产品信息
     * @return 结果
     */
    public int updateProductBasic(ProductBasic productBasic);

    /**
     * 批量删除产品信息
     * 
     * @param ids 需要删除的产品信息ID
     * @return 结果
     */
    public int deleteProductBasicByIds(Long[] ids);

    /**
     * 删除产品信息信息
     * 
     * @param id 产品信息ID
     * @return 结果
     */
    public int deleteProductBasicById(Long id);
}
