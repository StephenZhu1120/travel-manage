package com.ruoyi.travel.controller;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.travel.domain.UserBasic;
import com.ruoyi.travel.service.IUserBasicService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.utils.SecurityUtils;

/**
 * 账户管理Controller
 *
 * @author buaa_travel
 * @date 2021-05-11
 */
@RestController
@RequestMapping("/travel/userBasic")
public class UserBasicController extends BaseController
{
    @Autowired
    private IUserBasicService userBasicService;

    /**
     * 查询账户管理列表
     */
    @PreAuthorize("@ss.hasPermi('travel:userBasic:list') or @ss.hasRole('Market_Dept') or @ss.hasRole('Operate_Dept') or @ss.hasRole('Sale_Dept') or @ss.hasRole('Finance_Dept')")
    @GetMapping("/list")
    public TableDataInfo list(UserBasic userBasic)
    {
        startPage();
        List<UserBasic> list = userBasicService.selectUserBasicList(userBasic);
        return getDataTable(list);
    }

    /**
     * 导出账户管理列表
     */
    @PreAuthorize("@ss.hasPermi('travel:userBasic:export') or @ss.hasRole('Market_Dept') or @ss.hasRole('Operate_Dept') or @ss.hasRole('Sale_Dept') or @ss.hasRole('Finance_Dept')")
    @Log(title = "账户管理", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(UserBasic userBasic)
    {
        List<UserBasic> list = userBasicService.selectUserBasicList(userBasic);
        ExcelUtil<UserBasic> util = new ExcelUtil<UserBasic>(UserBasic.class);
        return util.exportExcel(list, "账户管理数据");
    }

    /**
     * 获取账户管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('travel:userBasic:query') or @ss.hasRole('Market_Dept') or @ss.hasRole('Operate_Dept') or @ss.hasRole('Sale_Dept') or @ss.hasRole('Finance_Dept')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(userBasicService.selectUserBasicById(id));
    }

    /**
     * 新增账户管理
     */
    @PreAuthorize("@ss.hasPermi('travel:userBasic:add') or @ss.hasRole('Market_Dept') or @ss.hasRole('Operate_Dept') or @ss.hasRole('Sale_Dept') or @ss.hasRole('Finance_Dept')")
    @Log(title = "账户管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody UserBasic userBasic)
    {
        return toAjax(userBasicService.insertUserBasic(userBasic));
    }


    /**
     * 修改账户管理
     */
    @PreAuthorize("@ss.hasPermi('travel:userBasic:edit') or @ss.hasRole('Market_Dept') or @ss.hasRole('Operate_Dept') or @ss.hasRole('Sale_Dept') or @ss.hasRole('Finance_Dept')")
    @Log(title = "账户管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody UserBasic userBasic)
    {
        UserBasic temp = userBasicService.selectUserBasicByPhoneNumber(userBasic.getPhoneNumber());
        if(temp!=null && temp.getId()!=userBasic.getId())
            return AjaxResult.error("该手机号已被占用，请尝试绑定其他手机号");
        return toAjax(userBasicService.updateUserBasic(userBasic));
    }


    /**
     * 重置密码
     */
    @PreAuthorize("@ss.hasPermi('travel:userBasic:resetPwd') or @ss.hasRole('Market_Dept') or @ss.hasRole('Operate_Dept') or @ss.hasRole('Sale_Dept') or @ss.hasRole('Finance_Dept')")
    @Log(title = "账户管理", businessType = BusinessType.UPDATE)
    @PutMapping("/resetPwd")
    public AjaxResult resetPwd(@RequestBody UserBasic userBasic) {
//        UserBasic userBasic = userBasicService.selectUserBasicById(userPassword.getId());
        userBasic.setPassword(SecurityUtils.encryptPassword(userBasic.getPassword()));
        return toAjax(userBasicService.resetPwd(userBasic));
    }

    /**
     * 封禁/解封用户
     */
    @PreAuthorize("@ss.hasPermi('travel:userBasic:edit') or @ss.hasRole('Market_Dept') or @ss.hasRole('Operate_Dept') or @ss.hasRole('Sale_Dept') or @ss.hasRole('Finance_Dept')")
    @Log(title = "账户管理", businessType = BusinessType.UPDATE)
    @PutMapping("/changeStatus")
    public AjaxResult changeStatus(@RequestBody UserBasic userBasic) {
        UserBasic new_userBasic = userBasicService.selectUserBasicById(userBasic.getId());
        if(new_userBasic.getUserStatus() == 1L)
            new_userBasic.setUserStatus(0L);
        else if(new_userBasic.getUserStatus() == 0L)
            new_userBasic.setUserStatus(1L);
        return toAjax(userBasicService.updateUserBasic(new_userBasic));
    }

    /**
     * 删除账户管理
     */
    @PreAuthorize("@ss.hasPermi('travel:userBasic:remove') or @ss.hasRole('Market_Dept') or @ss.hasRole('Operate_Dept') or @ss.hasRole('Sale_Dept') or @ss.hasRole('Finance_Dept')")
    @Log(title = "账户管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(userBasicService.deleteUserBasicByIds(ids));
    }
}
