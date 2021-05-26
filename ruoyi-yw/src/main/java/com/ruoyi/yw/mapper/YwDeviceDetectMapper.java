package com.ruoyi.yw.mapper;

import java.util.List;

import com.ruoyi.yw.domain.YwDeviceDetect;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * 设备检修记录Mapper接口
 *
 * @author sun
 * @date 2021-05-15
 */
public interface YwDeviceDetectMapper extends BaseMapper<YwDeviceDetect> {
    /**
     * 查询设备检修记录
     *
     * @param id 设备检修记录ID
     * @return 设备检修记录
     */
    public YwDeviceDetect selectYwDeviceDetectById(Long id);

    /**
     * 查询设备检修记录列表
     *
     * @param ywDeviceDetect 设备检修记录
     * @return 设备检修记录集合
     */
    public List<YwDeviceDetect> selectYwDeviceDetectList(YwDeviceDetect ywDeviceDetect);

    /**
     * 新增设备检修记录
     *
     * @param ywDeviceDetect 设备检修记录
     * @return 结果
     */
    public int insertYwDeviceDetect(YwDeviceDetect ywDeviceDetect);

    /**
     * 修改设备检修记录
     *
     * @param ywDeviceDetect 设备检修记录
     * @return 结果
     */
    public int updateYwDeviceDetect(YwDeviceDetect ywDeviceDetect);

    /**
     * 删除设备检修记录
     *
     * @param id 设备检修记录ID
     * @return 结果
     */
    public int deleteYwDeviceDetectById(Long id);

    /**
     * 批量删除设备检修记录
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteYwDeviceDetectByIds(Long[] ids);
    }
