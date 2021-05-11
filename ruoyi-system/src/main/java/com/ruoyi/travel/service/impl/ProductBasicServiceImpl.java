package com.ruoyi.travel.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.travel.mapper.ProductBasicMapper;
import com.ruoyi.travel.domain.ProductBasic;
import com.ruoyi.travel.service.IProductBasicService;

/**
 * 产品信息Service业务层处理
 *
 * @author buaa_travel
 * @date 2021-05-11
 */
@Service
public class ProductBasicServiceImpl implements IProductBasicService
{
    @Autowired
    private ProductBasicMapper productBasicMapper;

    /**
     * 查询产品信息
     *
     * @param id 产品信息ID
     * @return 产品信息
     */
    @Override
    public ProductBasic selectProductBasicById(Long id)
    {
        return productBasicMapper.selectProductBasicById(id);
    }

    /**
     * 查询产品信息列表
     *
     * @param productBasic 产品信息
     * @return 产品信息
     */
    @Override
    public List<ProductBasic> selectProductBasicList(ProductBasic productBasic)
    {
        return productBasicMapper.selectProductBasicList(productBasic);
    }

    /**
     * 新增产品信息
     *
     * @param productBasic 产品信息
     * @return 结果
     */
    @Override
    public int insertProductBasic(ProductBasic productBasic)
    {
        productBasic.setCreateTime(DateUtils.getNowDate());
        productBasic.setEditTime(DateUtils.getNowDate());
        return productBasicMapper.insertProductBasic(productBasic);
    }

    /**
     * 修改产品信息
     *
     * @param productBasic 产品信息
     * @return 结果
     */
    @Override
    public int updateProductBasic(ProductBasic productBasic)
    {
        productBasic.setEditTime(DateUtils.getNowDate());
        return productBasicMapper.updateProductBasic(productBasic);
    }

    /**
     * 批量删除产品信息
     *
     * @param ids 需要删除的产品信息ID
     * @return 结果
     */
    @Override
    public int deleteProductBasicByIds(Long[] ids)
    {
        return productBasicMapper.deleteProductBasicByIds(ids);
    }

    /**
     * 删除产品信息信息
     *
     * @param id 产品信息ID
     * @return 结果
     */
    @Override
    public int deleteProductBasicById(Long id)
    {
        return productBasicMapper.deleteProductBasicById(id);
    }

    /**
     * 通过id查询产品名称
     *
     * @param id 产品信息ID
     * @return 结果产品名称
     */
    @Override
    public String getProductNameById(Long id)
    {
        return  productBasicMapper.selectProductBasicById(id).getProductName();
    }
}
