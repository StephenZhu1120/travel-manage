package com.ruoyi.travel.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 账户管理对象 travel_user_basic
 * 
 * @author buaa_travel
 * @date 2021-05-11
 */
public class UserBasic extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 用户id */
    @Excel(name = "用户id")
    private Long id;

    /** 用户昵称 */
    @Excel(name = "用户昵称")
    private String userName;

    /** 用户密码 */
    @Excel(name = "用户密码")
    private String password;

    /** 用户状态 */
    @Excel(name = "用户状态")
    private Long userStatus;

    /** 真实姓名 */
    @Excel(name = "真实姓名")
    private String userIdName;

    /** 身份证号 */
    @Excel(name = "身份证号")
    private String userIdCard;

    /** 电子邮箱 */
    @Excel(name = "电子邮箱")
    private String email;

    /** 手机号码 */
    @Excel(name = "手机号码")
    private String phoneNumber;

    /** 性别 */
    @Excel(name = "性别")
    private Long sex;

    /** 头像链接地址 */
    @Excel(name = "头像链接地址")
    private String avatar;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setUserName(String userName) 
    {
        this.userName = userName;
    }

    public String getUserName() 
    {
        return userName;
    }
    public void setPassword(String password) 
    {
        this.password = password;
    }

    public String getPassword() 
    {
        return password;
    }
    public void setUserStatus(Long userStatus) 
    {
        this.userStatus = userStatus;
    }

    public Long getUserStatus() 
    {
        return userStatus;
    }
    public void setUserIdName(String userIdName) 
    {
        this.userIdName = userIdName;
    }

    public String getUserIdName() 
    {
        return userIdName;
    }
    public void setUserIdCard(String userIdCard) 
    {
        this.userIdCard = userIdCard;
    }

    public String getUserIdCard() 
    {
        return userIdCard;
    }
    public void setEmail(String email) 
    {
        this.email = email;
    }

    public String getEmail() 
    {
        return email;
    }
    public void setPhoneNumber(String phoneNumber) 
    {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() 
    {
        return phoneNumber;
    }
    public void setSex(Long sex) 
    {
        this.sex = sex;
    }

    public Long getSex() 
    {
        return sex;
    }
    public void setAvatar(String avatar) 
    {
        this.avatar = avatar;
    }

    public String getAvatar() 
    {
        return avatar;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userName", getUserName())
            .append("password", getPassword())
            .append("userStatus", getUserStatus())
            .append("createTime", getCreateTime())
            .append("userIdName", getUserIdName())
            .append("userIdCard", getUserIdCard())
            .append("email", getEmail())
            .append("phoneNumber", getPhoneNumber())
            .append("sex", getSex())
            .append("avatar", getAvatar())
            .toString();
    }
}
