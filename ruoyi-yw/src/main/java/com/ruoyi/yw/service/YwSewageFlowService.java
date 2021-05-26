package com.ruoyi.yw.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.yw.mapper.YwSewageFlowMapper;
import com.ruoyi.yw.domain.YwSewageFlow;

/**
 * 水流量， 进的是污水， 出的是处理好的水Service业务层处理
 *
 * @author sun
 * @date 2021-05-15
 */
@Service
public class YwSewageFlowService extends ServiceImpl<YwSewageFlowMapper, YwSewageFlow> {

    /**
     * 查询水流量， 进的是污水， 出的是处理好的水
     *
     * @param id 水流量， 进的是污水， 出的是处理好的水ID
     * @return 水流量， 进的是污水， 出的是处理好的水
     */
    public YwSewageFlow selectYwSewageFlowById(Long id) {
        return baseMapper.selectYwSewageFlowById(id);
    }

    /**
     * 查询水流量， 进的是污水， 出的是处理好的水列表
     *
     * @param ywSewageFlow 水流量， 进的是污水， 出的是处理好的水
     * @return 水流量， 进的是污水， 出的是处理好的水
     */
    public List<YwSewageFlow> selectYwSewageFlowList(YwSewageFlow ywSewageFlow) {
        return baseMapper.selectYwSewageFlowList(ywSewageFlow);
    }

    /**
     * 新增水流量， 进的是污水， 出的是处理好的水
     *
     * @param ywSewageFlow 水流量， 进的是污水， 出的是处理好的水
     * @return 结果
     */

    public int insertYwSewageFlow(YwSewageFlow ywSewageFlow) {
                                                                                                                                                    return baseMapper.insertYwSewageFlow(ywSewageFlow);
            }

    /**
     * 修改水流量， 进的是污水， 出的是处理好的水
     *
     * @param ywSewageFlow 水流量， 进的是污水， 出的是处理好的水
     * @return 结果
     */

    public int updateYwSewageFlow(YwSewageFlow ywSewageFlow) {
                                                                                                                                                return baseMapper.updateYwSewageFlow(ywSewageFlow);
    }

    /**
     * 批量删除水流量， 进的是污水， 出的是处理好的水
     *
     * @param ids 需要删除的水流量， 进的是污水， 出的是处理好的水ID
     * @return 结果
     */

    public int deleteYwSewageFlowByIds(Long[] ids) {
                return baseMapper.deleteYwSewageFlowByIds(ids);
    }

    /**
     * 删除水流量， 进的是污水， 出的是处理好的水信息
     *
     * @param id 水流量， 进的是污水， 出的是处理好的水ID
     * @return 结果
     */

    public int deleteYwSewageFlowById(Long id) {
                return baseMapper.deleteYwSewageFlowById(id);
    }
    }
