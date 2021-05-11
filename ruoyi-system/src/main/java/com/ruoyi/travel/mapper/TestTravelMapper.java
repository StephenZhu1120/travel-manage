package com.ruoyi.travel.mapper;

import java.util.List;
import com.ruoyi.travel.domain.TestTravel;

/**
 * 测试功能Mapper接口
 * 
 * @author buaa_travel
 * @date 2021-05-11
 */
public interface TestTravelMapper 
{
    /**
     * 查询测试功能
     * 
     * @param id 测试功能ID
     * @return 测试功能
     */
    public TestTravel selectTestTravelById(Long id);

    /**
     * 查询测试功能列表
     * 
     * @param testTravel 测试功能
     * @return 测试功能集合
     */
    public List<TestTravel> selectTestTravelList(TestTravel testTravel);

    /**
     * 新增测试功能
     * 
     * @param testTravel 测试功能
     * @return 结果
     */
    public int insertTestTravel(TestTravel testTravel);

    /**
     * 修改测试功能
     * 
     * @param testTravel 测试功能
     * @return 结果
     */
    public int updateTestTravel(TestTravel testTravel);

    /**
     * 删除测试功能
     * 
     * @param id 测试功能ID
     * @return 结果
     */
    public int deleteTestTravelById(Long id);

    /**
     * 批量删除测试功能
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTestTravelByIds(Long[] ids);
}
