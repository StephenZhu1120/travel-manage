package com.ruoyi.web.controller.app;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.travel.domain.UserBasic;
import com.ruoyi.travel.service.IUserBasicService;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserMallController extends BaseController {

    @Autowired
    private IUserBasicService userBasicService;

     @GetMapping
     public AjaxResult api(){
         return toAjax(1);
     }

    /**
     * 新注册客户
     */
    @PostMapping("/signup")
    @Log(title = "账户管理", businessType = BusinessType.INSERT)
    public AjaxResult signUp(@RequestBody UserBasic userBasic)
    {
        userBasic.setUserStatus(1L);
        AjaxResult ajaxResult = toAjax(userBasicService.insertUserBasic(userBasic));
        return ajaxResult;
    }

    /**
     * 判断用户名是否合法
     */
    @GetMapping("/isNameLegal")
//    public AjaxResult isNameLegal(@RequestBody UserBasic userBasic)
      public AjaxResult isNameLegal(UserBasic userBasic)
    {
        List<UserBasic> userBasicList = userBasicService.selectUserBasicList(userBasic);
        for(int i=0; i<userBasicList.size(); i++){
            if(userBasicList.get(i).getUserName().equals(userBasic.getUserName()))
                return error("该用户名已被使用");
        }
        return success();
    }

    /**
     * 判断用户id是否存在
     */
    @GetMapping("/isExist")
    public AjaxResult isUserExist(UserBasic userBasic)
    {
        UserBasic new_userBasic = userBasicService.selectUserBasicById(userBasic.getId());
        if(new_userBasic == null)
            return error("该用户不存在");
        return success();
    }

    /**
     * 判断用户登录逻辑
     */
    @PostMapping("/login")
    public AjaxResult login(@RequestBody UserBasic userBasic)
    {
        if(userBasic.getUserName().equals(""))
            return error("用户名不能为空，请输入用户名");
        if(userBasic.getPassword().equals(""))
            return error("密码不能为空，请输入密码");

        List<UserBasic> userBasicList = userBasicService.selectUserBasicList(userBasic);
        UserBasic new_userBasic = new UserBasic();
        for(int i=0; i<userBasicList.size(); i++){
            if(userBasicList.get(i).getUserName().equals(userBasic.getUserName()))
                new_userBasic = userBasicList.get(i);
            break;
        }
        if(new_userBasic.getId() == null)
            return error("该用户未注册，请先注册");
        else{
            if(! SecurityUtils.matchesPassword(userBasic.getPassword(), new_userBasic.getPassword()))
                return error("密码填写错误，请重新输入");
            if(new_userBasic.getUserStatus() != 1L)
                return error("账户封禁中，请联系客服人员");
        }
        AjaxResult ajaxResult = AjaxResult.success();
        ajaxResult.put("user", new_userBasic);
        return ajaxResult;
    }

    /**
     * 判断用户注销逻辑
     */
    @PostMapping("/logout")
    public AjaxResult logout(@RequestBody UserBasic userBasic)
    {
        return AjaxResult.success();
    }
}
