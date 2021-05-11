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
import com.ruoyi.travel.domain.TestTravel;
import com.ruoyi.travel.service.ITestTravelService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 测试功能Controller
 * 
 * @author buaa_travel
 * @date 2021-05-11
 */
@RestController
@RequestMapping("/travel/testTravel")
public class TestTravelController extends BaseController
{
    @Autowired
    private ITestTravelService testTravelService;

    /**
     * 查询测试功能列表
     */
    @PreAuthorize("@ss.hasPermi('travel:testTravel:list')")
    @GetMapping("/list")
    public TableDataInfo list(TestTravel testTravel)
    {
        startPage();
        List<TestTravel> list = testTravelService.selectTestTravelList(testTravel);
        return getDataTable(list);
    }

    /**
     * 导出测试功能列表
     */
    @PreAuthorize("@ss.hasPermi('travel:testTravel:export')")
    @Log(title = "测试功能", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(TestTravel testTravel)
    {
        List<TestTravel> list = testTravelService.selectTestTravelList(testTravel);
        ExcelUtil<TestTravel> util = new ExcelUtil<TestTravel>(TestTravel.class);
        return util.exportExcel(list, "测试功能数据");
    }

    /**
     * 获取测试功能详细信息
     */
    @PreAuthorize("@ss.hasPermi('travel:testTravel:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(testTravelService.selectTestTravelById(id));
    }

    /**
     * 新增测试功能
     */
    @PreAuthorize("@ss.hasPermi('travel:testTravel:add')")
    @Log(title = "测试功能", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TestTravel testTravel)
    {
        return toAjax(testTravelService.insertTestTravel(testTravel));
    }

    /**
     * 修改测试功能
     */
    @PreAuthorize("@ss.hasPermi('travel:testTravel:edit')")
    @Log(title = "测试功能", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TestTravel testTravel)
    {
        return toAjax(testTravelService.updateTestTravel(testTravel));
    }

    /**
     * 删除测试功能
     */
    @PreAuthorize("@ss.hasPermi('travel:testTravel:remove')")
    @Log(title = "测试功能", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(testTravelService.deleteTestTravelByIds(ids));
    }
}
