package com.ruoyi.yw.mapper;

import java.util.List;

import com.ruoyi.yw.domain.YwElectricFlow;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * 电量Mapper接口
 *
 * @author sun
 * @date 2021-05-15
 */
public interface YwElectricFlowMapper extends BaseMapper<YwElectricFlow> {
    /**
     * 查询电量
     *
     * @param id 电量ID
     * @return 电量
     */
    public YwElectricFlow selectYwElectricFlowById(Long id);

    /**
     * 查询电量列表
     *
     * @param ywElectricFlow 电量
     * @return 电量集合
     */
    public List<YwElectricFlow> selectYwElectricFlowList(YwElectricFlow ywElectricFlow);

    /**
     * 新增电量
     *
     * @param ywElectricFlow 电量
     * @return 结果
     */
    public int insertYwElectricFlow(YwElectricFlow ywElectricFlow);

    /**
     * 修改电量
     *
     * @param ywElectricFlow 电量
     * @return 结果
     */
    public int updateYwElectricFlow(YwElectricFlow ywElectricFlow);

    /**
     * 删除电量
     *
     * @param id 电量ID
     * @return 结果
     */
    public int deleteYwElectricFlowById(Long id);

    /**
     * 批量删除电量
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteYwElectricFlowByIds(Long[] ids);
    }
