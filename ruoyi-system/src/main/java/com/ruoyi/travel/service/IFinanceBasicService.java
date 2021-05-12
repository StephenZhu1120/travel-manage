package com.ruoyi.travel.service;

import java.util.List;
import com.ruoyi.travel.domain.FinanceBasic;

/**
 * 财务信息Service接口
 * 
 * @author buaa_travel
 * @date 2021-05-12
 */
public interface IFinanceBasicService 
{
    /**
     * 查询财务信息
     * 
     * @param id 财务信息ID
     * @return 财务信息
     */
    public FinanceBasic selectFinanceBasicById(Long id);

    /**
     * 查询财务信息列表
     * 
     * @param financeBasic 财务信息
     * @return 财务信息集合
     */
    public List<FinanceBasic> selectFinanceBasicList(FinanceBasic financeBasic);

    /**
     * 新增财务信息
     * 
     * @param financeBasic 财务信息
     * @return 结果
     */
    public int insertFinanceBasic(FinanceBasic financeBasic);

    /**
     * 修改财务信息
     * 
     * @param financeBasic 财务信息
     * @return 结果
     */
    public int updateFinanceBasic(FinanceBasic financeBasic);

    /**
     * 批量删除财务信息
     * 
     * @param ids 需要删除的财务信息ID
     * @return 结果
     */
    public int deleteFinanceBasicByIds(Long[] ids);

    /**
     * 删除财务信息信息
     * 
     * @param id 财务信息ID
     * @return 结果
     */
    public int deleteFinanceBasicById(Long id);
}
