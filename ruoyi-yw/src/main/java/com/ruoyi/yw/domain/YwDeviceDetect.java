package com.ruoyi.yw.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 设备检修记录对象 yw_device_detect
 *
 * @author sun
 * @date 2021-05-15
 */
public class YwDeviceDetect extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 设备id */
    @Excel(name = "设备id")
    private Long deviceId;

    /** 检修情况 */
    @Excel(name = "检修情况")
    private String detectDetail;

    /** 检修人 */
    @Excel(name = "检修人")
    private Long detecter;

    /** 检修时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "检修时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date detectTime;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setDeviceId(Long deviceId)
    {
        this.deviceId = deviceId;
    }

    public Long getDeviceId()
    {
        return deviceId;
    }
    public void setDetectDetail(String detectDetail)
    {
        this.detectDetail = detectDetail;
    }

    public String getDetectDetail()
    {
        return detectDetail;
    }
    public void setDetecter(Long detecter)
    {
        this.detecter = detecter;
    }

    public Long getDetecter()
    {
        return detecter;
    }
    public void setDetectTime(Date detectTime)
    {
        this.detectTime = detectTime;
    }

    public Date getDetectTime()
    {
        return detectTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("deviceId", getDeviceId())
            .append("detectDetail", getDetectDetail())
            .append("detecter", getDetecter())
            .append("detectTime", getDetectTime())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
