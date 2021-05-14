package com.ruoyi.web.controller.app;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.travel.domain.UserBasic;
import com.ruoyi.travel.service.IUserBasicService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        return toAjax(userBasicService.insertUserBasic(userBasic));
    }

    /**
     * 判断用户名是否合法
     */
    @GetMapping("/isNameLegal")
    public AjaxResult isNameLegal(@RequestBody String userName)
    {
        UserBasic userBasic = userBasicService.selectUserBasicByUserName(userName);
        if(userBasic == null)
            return success();
        else
            return error("该用户名已被使用");
    }

    /**
     * 判断用户登录逻辑
     */
    @GetMapping("/login")
    public AjaxResult login(@RequestBody UserBasic userBasic)
    {
        if(userBasic.getUserName() == null)
            return error("用户名不能为空，请输入用户名");
        if(userBasic.getPassword() == null)
            return error("密码不能为空，请输入密码");

        UserBasic new_userBasic = userBasicService.selectUserBasicByUserName(userBasic.getUserName());
        if(new_userBasic == null)
            return error("该用户未注册，请先注册");
        else{
            if(! SecurityUtils.matchesPassword(userBasic.getPassword(), new_userBasic.getPassword()))
                return error("密码填写错误，请重新输入");
        }
        AjaxResult ajaxResult = AjaxResult.success();
        ajaxResult.put("user", new_userBasic);
        return ajaxResult;
    }
}
