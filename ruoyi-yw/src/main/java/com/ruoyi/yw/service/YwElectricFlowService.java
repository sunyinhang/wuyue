package com.ruoyi.yw.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.yw.mapper.YwElectricFlowMapper;
import com.ruoyi.yw.domain.YwElectricFlow;

/**
 * 电量Service业务层处理
 *
 * @author sun
 * @date 2021-05-15
 */
@Service
public class YwElectricFlowService extends ServiceImpl<YwElectricFlowMapper, YwElectricFlow> {

    /**
     * 查询电量
     *
     * @param id 电量ID
     * @return 电量
     */
    public YwElectricFlow selectYwElectricFlowById(Long id) {
        return baseMapper.selectYwElectricFlowById(id);
    }

    /**
     * 查询电量列表
     *
     * @param ywElectricFlow 电量
     * @return 电量
     */
    public List<YwElectricFlow> selectYwElectricFlowList(YwElectricFlow ywElectricFlow) {
        return baseMapper.selectYwElectricFlowList(ywElectricFlow);
    }

    /**
     * 新增电量
     *
     * @param ywElectricFlow 电量
     * @return 结果
     */

    public int insertYwElectricFlow(YwElectricFlow ywElectricFlow) {
                                                                                                                                return baseMapper.insertYwElectricFlow(ywElectricFlow);
            }

    /**
     * 修改电量
     *
     * @param ywElectricFlow 电量
     * @return 结果
     */

    public int updateYwElectricFlow(YwElectricFlow ywElectricFlow) {
                                                                                                                            return baseMapper.updateYwElectricFlow(ywElectricFlow);
    }

    /**
     * 批量删除电量
     *
     * @param ids 需要删除的电量ID
     * @return 结果
     */

    public int deleteYwElectricFlowByIds(Long[] ids) {
                return baseMapper.deleteYwElectricFlowByIds(ids);
    }

    /**
     * 删除电量信息
     *
     * @param id 电量ID
     * @return 结果
     */

    public int deleteYwElectricFlowById(Long id) {
                return baseMapper.deleteYwElectricFlowById(id);
    }
    }
