package com.ruoyi.yw.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.vo.SewageLineData;
import com.ruoyi.yw.domain.YwSewageStatistics;
import com.ruoyi.yw.mapper.YwSewageStatisticsMapper;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * 污水量统计， 按周期Service业务层处理
 *
 * @author sun
 * @date 2021-05-15
 */
@Service
public class YwSewageStatisticsService extends ServiceImpl<YwSewageStatisticsMapper, YwSewageStatistics> {

    /**
     * 查询污水量统计， 按周期
     *
     * @param id 污水量统计， 按周期ID
     * @return 污水量统计， 按周期
     */
    public YwSewageStatistics selectYwSewageStatisticsById(Long id) {
        return baseMapper.selectYwSewageStatisticsById(id);
    }

    /**
     * 查询污水量统计， 按周期列表
     *
     * @param ywSewageStatistics 污水量统计， 按周期
     * @return 污水量统计， 按周期
     */
    public List<YwSewageStatistics> selectYwSewageStatisticsList(YwSewageStatistics ywSewageStatistics) {
        return baseMapper.selectYwSewageStatisticsList(ywSewageStatistics);
    }

    /**
     * 新增污水量统计， 按周期
     *
     * @param ywSewageStatistics 污水量统计， 按周期
     * @return 结果
     */

    public int insertYwSewageStatistics(YwSewageStatistics ywSewageStatistics) {
        return baseMapper.insertYwSewageStatistics(ywSewageStatistics);
    }

    /**
     * 修改污水量统计， 按周期
     *
     * @param ywSewageStatistics 污水量统计， 按周期
     * @return 结果
     */

    public int updateYwSewageStatistics(YwSewageStatistics ywSewageStatistics) {
        return baseMapper.updateYwSewageStatistics(ywSewageStatistics);
    }

    /**
     * 批量删除污水量统计， 按周期
     *
     * @param ids 需要删除的污水量统计， 按周期ID
     * @return 结果
     */

    public int deleteYwSewageStatisticsByIds(Long[] ids) {
        return baseMapper.deleteYwSewageStatisticsByIds(ids);
    }

    /**
     * 删除污水量统计， 按周期信息
     *
     * @param id 污水量统计， 按周期ID
     * @return 结果
     */

    public int deleteYwSewageStatisticsById(Long id) {
        return baseMapper.deleteYwSewageStatisticsById(id);
    }

    public SewageLineData getLineData(String time) {

        SewageLineData data = new SewageLineData();

        data.setXData(Arrays.asList("8:00", "9:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00"));
        SewageLineData.YData yData = new SewageLineData.YData();
        yData.setYdata1(Arrays.asList(1.1, 3.23, 2.2, 2.3, 6.6));
        yData.setYdata2(Arrays.asList(4.4, 0.2, 4.2, 22.3, 60.6));
        data.setYData(yData);

        data.setLines(Arrays.asList("进水量", "出水量"));




        return data;
    }
}
