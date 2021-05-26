package com.ruoyi.yw.service;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.yw.mapper.YwDeviceDetectMapper;
import com.ruoyi.yw.domain.YwDeviceDetect;

/**
 * 设备检修记录Service业务层处理
 *
 * @author sun
 * @date 2021-05-15
 */
@Service
public class YwDeviceDetectService extends ServiceImpl<YwDeviceDetectMapper, YwDeviceDetect> {

    /**
     * 查询设备检修记录
     *
     * @param id 设备检修记录ID
     * @return 设备检修记录
     */
    public YwDeviceDetect selectYwDeviceDetectById(Long id) {
        return baseMapper.selectYwDeviceDetectById(id);
    }

    /**
     * 查询设备检修记录列表
     *
     * @param ywDeviceDetect 设备检修记录
     * @return 设备检修记录
     */
    public List<YwDeviceDetect> selectYwDeviceDetectList(YwDeviceDetect ywDeviceDetect) {
        return baseMapper.selectYwDeviceDetectList(ywDeviceDetect);
    }

    /**
     * 新增设备检修记录
     *
     * @param ywDeviceDetect 设备检修记录
     * @return 结果
     */

    public int insertYwDeviceDetect(YwDeviceDetect ywDeviceDetect) {
                                                                                                                                                            ywDeviceDetect.setCreateTime(DateUtils.getNowDate());
                                                                                return baseMapper.insertYwDeviceDetect(ywDeviceDetect);
            }

    /**
     * 修改设备检修记录
     *
     * @param ywDeviceDetect 设备检修记录
     * @return 结果
     */

    public int updateYwDeviceDetect(YwDeviceDetect ywDeviceDetect) {
                                                                                                                                                                                                    ywDeviceDetect.setUpdateTime(DateUtils.getNowDate());
                                    return baseMapper.updateYwDeviceDetect(ywDeviceDetect);
    }

    /**
     * 批量删除设备检修记录
     *
     * @param ids 需要删除的设备检修记录ID
     * @return 结果
     */

    public int deleteYwDeviceDetectByIds(Long[] ids) {
                return baseMapper.deleteYwDeviceDetectByIds(ids);
    }

    /**
     * 删除设备检修记录信息
     *
     * @param id 设备检修记录ID
     * @return 结果
     */

    public int deleteYwDeviceDetectById(Long id) {
                return baseMapper.deleteYwDeviceDetectById(id);
    }
    }
