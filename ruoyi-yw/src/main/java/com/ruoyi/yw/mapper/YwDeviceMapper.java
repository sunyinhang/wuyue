package com.ruoyi.yw.mapper;

import java.util.List;

import com.ruoyi.yw.domain.YwDevice;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * 设备Mapper接口
 *
 * @author sun
 * @date 2021-05-15
 */
public interface YwDeviceMapper extends BaseMapper<YwDevice> {
    /**
     * 查询设备
     *
     * @param id 设备ID
     * @return 设备
     */
    public YwDevice selectYwDeviceById(Long id);

    /**
     * 查询设备列表
     *
     * @param ywDevice 设备
     * @return 设备集合
     */
    public List<YwDevice> selectYwDeviceList(YwDevice ywDevice);

    /**
     * 新增设备
     *
     * @param ywDevice 设备
     * @return 结果
     */
    public int insertYwDevice(YwDevice ywDevice);

    /**
     * 修改设备
     *
     * @param ywDevice 设备
     * @return 结果
     */
    public int updateYwDevice(YwDevice ywDevice);

    /**
     * 删除设备
     *
     * @param id 设备ID
     * @return 结果
     */
    public int deleteYwDeviceById(Long id);

    /**
     * 批量删除设备
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteYwDeviceByIds(Long[] ids);
    }
