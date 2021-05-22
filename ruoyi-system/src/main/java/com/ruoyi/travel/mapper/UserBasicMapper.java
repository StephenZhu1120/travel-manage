package com.ruoyi.travel.mapper;

import java.util.List;
import com.ruoyi.travel.domain.UserBasic;

/**
 * 账户管理Mapper接口
 *
 * @author buaa_travel
 * @date 2021-05-11
 */
public interface UserBasicMapper
{
    /**
     * 查询账户管理
     *
     * @param id 账户管理ID
     * @return 账户管理
     */
    public UserBasic selectUserBasicById(Long id);

    /**
     * 根据用户名查询用户
     *
     * @param userName 账户管理ID
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
     * 删除账户管理
     *
     * @param id 账户管理ID
     * @return 结果
     */
    public int deleteUserBasicById(Long id);

    /**
     * 批量删除账户管理
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteUserBasicByIds(Long[] ids);
}
