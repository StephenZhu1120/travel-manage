package com.ruoyi.travel.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.travel.mapper.TestTravelMapper;
import com.ruoyi.travel.domain.TestTravel;
import com.ruoyi.travel.service.ITestTravelService;

/**
 * 测试功能Service业务层处理
 * 
 * @author buaa_travel
 * @date 2021-05-11
 */
@Service
public class TestTravelServiceImpl implements ITestTravelService 
{
    @Autowired
    private TestTravelMapper testTravelMapper;

    /**
     * 查询测试功能
     * 
     * @param id 测试功能ID
     * @return 测试功能
     */
    @Override
    public TestTravel selectTestTravelById(Long id)
    {
        return testTravelMapper.selectTestTravelById(id);
    }

    /**
     * 查询测试功能列表
     * 
     * @param testTravel 测试功能
     * @return 测试功能
     */
    @Override
    public List<TestTravel> selectTestTravelList(TestTravel testTravel)
    {
        return testTravelMapper.selectTestTravelList(testTravel);
    }

    /**
     * 新增测试功能
     * 
     * @param testTravel 测试功能
     * @return 结果
     */
    @Override
    public int insertTestTravel(TestTravel testTravel)
    {
        return testTravelMapper.insertTestTravel(testTravel);
    }

    /**
     * 修改测试功能
     * 
     * @param testTravel 测试功能
     * @return 结果
     */
    @Override
    public int updateTestTravel(TestTravel testTravel)
    {
        return testTravelMapper.updateTestTravel(testTravel);
    }

    /**
     * 批量删除测试功能
     * 
     * @param ids 需要删除的测试功能ID
     * @return 结果
     */
    @Override
    public int deleteTestTravelByIds(Long[] ids)
    {
        return testTravelMapper.deleteTestTravelByIds(ids);
    }

    /**
     * 删除测试功能信息
     * 
     * @param id 测试功能ID
     * @return 结果
     */
    @Override
    public int deleteTestTravelById(Long id)
    {
        return testTravelMapper.deleteTestTravelById(id);
    }
}
