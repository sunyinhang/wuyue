package com.ruoyi.yw.mapper;

import java.util.List;

import com.ruoyi.yw.domain.YwSewageFlow;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * 水流量， 进的是污水， 出的是处理好的水Mapper接口
 *
 * @author sun
 * @date 2021-05-15
 */
public interface YwSewageFlowMapper extends BaseMapper<YwSewageFlow> {
    /**
     * 查询水流量， 进的是污水， 出的是处理好的水
     *
     * @param id 水流量， 进的是污水， 出的是处理好的水ID
     * @return 水流量， 进的是污水， 出的是处理好的水
     */
    public YwSewageFlow selectYwSewageFlowById(Long id);

    /**
     * 查询水流量， 进的是污水， 出的是处理好的水列表
     *
     * @param ywSewageFlow 水流量， 进的是污水， 出的是处理好的水
     * @return 水流量， 进的是污水， 出的是处理好的水集合
     */
    public List<YwSewageFlow> selectYwSewageFlowList(YwSewageFlow ywSewageFlow);

    /**
     * 新增水流量， 进的是污水， 出的是处理好的水
     *
     * @param ywSewageFlow 水流量， 进的是污水， 出的是处理好的水
     * @return 结果
     */
    public int insertYwSewageFlow(YwSewageFlow ywSewageFlow);

    /**
     * 修改水流量， 进的是污水， 出的是处理好的水
     *
     * @param ywSewageFlow 水流量， 进的是污水， 出的是处理好的水
     * @return 结果
     */
    public int updateYwSewageFlow(YwSewageFlow ywSewageFlow);

    /**
     * 删除水流量， 进的是污水， 出的是处理好的水
     *
     * @param id 水流量， 进的是污水， 出的是处理好的水ID
     * @return 结果
     */
    public int deleteYwSewageFlowById(Long id);

    /**
     * 批量删除水流量， 进的是污水， 出的是处理好的水
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteYwSewageFlowByIds(Long[] ids);
    }
