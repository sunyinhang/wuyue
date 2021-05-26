package com.ruoyi.yw.mapper;

import java.util.List;

import com.ruoyi.yw.domain.YwSewageStatistics;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * 污水量统计， 按周期Mapper接口
 *
 * @author sun
 * @date 2021-05-15
 */
public interface YwSewageStatisticsMapper extends BaseMapper<YwSewageStatistics> {
    /**
     * 查询污水量统计， 按周期
     *
     * @param id 污水量统计， 按周期ID
     * @return 污水量统计， 按周期
     */
    public YwSewageStatistics selectYwSewageStatisticsById(Long id);

    /**
     * 查询污水量统计， 按周期列表
     *
     * @param ywSewageStatistics 污水量统计， 按周期
     * @return 污水量统计， 按周期集合
     */
    public List<YwSewageStatistics> selectYwSewageStatisticsList(YwSewageStatistics ywSewageStatistics);

    /**
     * 新增污水量统计， 按周期
     *
     * @param ywSewageStatistics 污水量统计， 按周期
     * @return 结果
     */
    public int insertYwSewageStatistics(YwSewageStatistics ywSewageStatistics);

    /**
     * 修改污水量统计， 按周期
     *
     * @param ywSewageStatistics 污水量统计， 按周期
     * @return 结果
     */
    public int updateYwSewageStatistics(YwSewageStatistics ywSewageStatistics);

    /**
     * 删除污水量统计， 按周期
     *
     * @param id 污水量统计， 按周期ID
     * @return 结果
     */
    public int deleteYwSewageStatisticsById(Long id);

    /**
     * 批量删除污水量统计， 按周期
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteYwSewageStatisticsByIds(Long[] ids);
    }
