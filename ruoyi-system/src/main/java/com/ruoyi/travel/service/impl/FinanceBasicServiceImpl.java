package com.ruoyi.travel.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.travel.mapper.FinanceBasicMapper;
import com.ruoyi.travel.domain.FinanceBasic;
import com.ruoyi.travel.service.IFinanceBasicService;

/**
 * 财务信息Service业务层处理
 * 
 * @author buaa_travel
 * @date 2021-05-12
 */
@Service
public class FinanceBasicServiceImpl implements IFinanceBasicService 
{
    @Autowired
    private FinanceBasicMapper financeBasicMapper;

    /**
     * 查询财务信息
     * 
     * @param id 财务信息ID
     * @return 财务信息
     */
    @Override
    public FinanceBasic selectFinanceBasicById(Long id)
    {
        return financeBasicMapper.selectFinanceBasicById(id);
    }

    /**
     * 查询财务信息列表
     * 
     * @param financeBasic 财务信息
     * @return 财务信息
     */
    @Override
    public List<FinanceBasic> selectFinanceBasicList(FinanceBasic financeBasic)
    {
        return financeBasicMapper.selectFinanceBasicList(financeBasic);
    }

    /**
     * 新增财务信息
     * 
     * @param financeBasic 财务信息
     * @return 结果
     */
    @Override
    public int insertFinanceBasic(FinanceBasic financeBasic)
    {
        return financeBasicMapper.insertFinanceBasic(financeBasic);
    }

    /**
     * 修改财务信息
     * 
     * @param financeBasic 财务信息
     * @return 结果
     */
    @Override
    public int updateFinanceBasic(FinanceBasic financeBasic)
    {
        return financeBasicMapper.updateFinanceBasic(financeBasic);
    }

    /**
     * 批量删除财务信息
     * 
     * @param ids 需要删除的财务信息ID
     * @return 结果
     */
    @Override
    public int deleteFinanceBasicByIds(Long[] ids)
    {
        return financeBasicMapper.deleteFinanceBasicByIds(ids);
    }

    /**
     * 删除财务信息信息
     * 
     * @param id 财务信息ID
     * @return 结果
     */
    @Override
    public int deleteFinanceBasicById(Long id)
    {
        return financeBasicMapper.deleteFinanceBasicById(id);
    }
}
