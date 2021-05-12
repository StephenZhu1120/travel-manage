package com.ruoyi.travel.mapper;

import java.util.List;
import com.ruoyi.travel.domain.ProductBasic;

/**
 * 产品信息Mapper接口
 * 
 * @author buaa_travel
 * @date 2021-05-12
 */
public interface ProductBasicMapper 
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
     * 删除产品信息
     * 
     * @param id 产品信息ID
     * @return 结果
     */
    public int deleteProductBasicById(Long id);

    /**
     * 批量删除产品信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteProductBasicByIds(Long[] ids);
}
