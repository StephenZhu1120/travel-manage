package com.ruoyi.travel.service;

import java.util.List;
import com.ruoyi.travel.domain.UserBasic;

/**
 * 账户管理Service接口
 * 
 * @author buaa_travel
 * @date 2021-05-11
 */
public interface IUserBasicService 
{
    /**
     * 查询账户管理
     * 
     * @param id 账户管理ID
     * @return 账户管理
     */
    public UserBasic selectUserBasicById(Integer id);

    /**
     * 查询账户管理
     * 
     * @param userName 账户名称
     * @return 账户管理
     */
    public UserBasic selectUserBasicByUserName(String userName);

    /**
     * 查询账户管理列表
     * 
     * @param userBasic 账户管理
     * @return 账户管理集合
     */
    public List<UserBasic> selectUserBasicList(UserBasic userBasic);

    /**
     * 新增账户管理
     * 
     * @param userBasic 账户管理
     * @return 结果
     */
    public int insertUserBasic(UserBasic userBasic);

    /**
     * 修改账户管理
     * 
     * @param userBasic 账户管理
     * @return 结果
     */
    public int updateUserBasic(UserBasic userBasic);

    /**
     * 批量删除账户管理
     * 
     * @param ids 需要删除的账户管理ID
     * @return 结果
     */
    public int deleteUserBasicByIds(Integer[] ids);

    /**
     * 删除账户管理信息
     * 
     * @param id 账户管理ID
     * @return 结果
     */
    public int deleteUserBasicById(Integer id);

    /**
     * 重置用户密码
     *
     * @param userBasic 用户信息
     * @return 结果
     */
    public int resetPwd(UserBasic userBasic);
}
