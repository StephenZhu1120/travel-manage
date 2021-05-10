package com.ruoyi.travel.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.travel.mapper.UserBasicMapper;
import com.ruoyi.travel.domain.UserBasic;
import com.ruoyi.travel.service.IUserBasicService;

/**
 * 账户管理Service业务层处理
 * 
 * @author buaa_travel
 * @date 2021-05-11
 */
@Service
public class UserBasicServiceImpl implements IUserBasicService 
{
    @Autowired
    private UserBasicMapper userBasicMapper;

    /**
     * 查询账户管理
     * 
     * @param id 账户管理ID
     * @return 账户管理
     */
    @Override
    public UserBasic selectUserBasicById(Integer id)
    {
        return userBasicMapper.selectUserBasicById(id);
    }

    /**
     * 查询账户管理列表
     * 
     * @param userBasic 账户管理
     * @return 账户管理
     */
    @Override
    public List<UserBasic> selectUserBasicList(UserBasic userBasic)
    {
        return userBasicMapper.selectUserBasicList(userBasic);
    }

    /**
     * 新增账户管理
     * 
     * @param userBasic 账户管理
     * @return 结果
     */
    @Override
    public int insertUserBasic(UserBasic userBasic)
    {
        userBasic.setCreateTime(DateUtils.getNowDate());
        return userBasicMapper.insertUserBasic(userBasic);
    }

    /**
     * 修改账户管理
     * 
     * @param userBasic 账户管理
     * @return 结果
     */
    @Override
    public int updateUserBasic(UserBasic userBasic)
    {
        return userBasicMapper.updateUserBasic(userBasic);
    }

    /**
     * 批量删除账户管理
     * 
     * @param ids 需要删除的账户管理ID
     * @return 结果
     */
    @Override
    public int deleteUserBasicByIds(Integer[] ids)
    {
        return userBasicMapper.deleteUserBasicByIds(ids);
    }

    /**
     * 删除账户管理信息
     * 
     * @param id 账户管理ID
     * @return 结果
     */
    @Override
    public int deleteUserBasicById(Integer id)
    {
        return userBasicMapper.deleteUserBasicById(id);
    }
}
