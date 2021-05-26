package com.ruoyi.yw.service;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.yw.mapper.YwDeviceMapper;
import com.ruoyi.yw.domain.YwDevice;

/**
 * 设备Service业务层处理
 *
 * @author sun
 * @date 2021-05-15
 */
@Service
public class YwDeviceService extends ServiceImpl<YwDeviceMapper, YwDevice> {

    /**
     * 查询设备
     *
     * @param id 设备ID
     * @return 设备
     */
    public YwDevice selectYwDeviceById(Long id) {
        return baseMapper.selectYwDeviceById(id);
    }

    /**
     * 查询设备列表
     *
     * @param ywDevice 设备
     * @return 设备
     */
    public List<YwDevice> selectYwDeviceList(YwDevice ywDevice) {
        return baseMapper.selectYwDeviceList(ywDevice);
    }

    /**
     * 新增设备
     *
     * @param ywDevice 设备
     * @return 结果
     */

    public int insertYwDevice(YwDevice ywDevice) {
                                                                                                                                                                                                                                                                ywDevice.setCreateTime(DateUtils.getNowDate());
                                                                                return baseMapper.insertYwDevice(ywDevice);
            }

    /**
     * 修改设备
     *
     * @param ywDevice 设备
     * @return 结果
     */

    public int updateYwDevice(YwDevice ywDevice) {
                                                                                                                                                                                                                                                                                                        ywDevice.setUpdateTime(DateUtils.getNowDate());
                                    return baseMapper.updateYwDevice(ywDevice);
    }

    /**
     * 批量删除设备
     *
     * @param ids 需要删除的设备ID
     * @return 结果
     */

    public int deleteYwDeviceByIds(Long[] ids) {
                return baseMapper.deleteYwDeviceByIds(ids);
    }

    /**
     * 删除设备信息
     *
     * @param id 设备ID
     * @return 结果
     */

    public int deleteYwDeviceById(Long id) {
                return baseMapper.deleteYwDeviceById(id);
    }
    }
