package com.ruoyi.yw.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 设备对象 yw_device
 *
 * @author sun
 * @date 2021-05-15
 */
public class YwDevice extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 设备编码 */
    @Excel(name = "设备编码")
    private String code;

    /** 设备型号 */
    @Excel(name = "设备型号")
    private String model;

    /** 设备名 */
    @Excel(name = "设备名")
    private String name;

    /** 设备类型 */
    @Excel(name = "设备类型")
    private Long type;

    /** 描述 */
    @Excel(name = "描述")
    private String description;

    /** 购买日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "购买日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date buyTime;

    /** 年限 */
    @Excel(name = "年限")
    private Long timeLimit;

    /** 状态 */
    @Excel(name = "状态")
    private Long status;

    /** 负责人id */
    @Excel(name = "负责人id")
    private Long supervisor;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setCode(String code)
    {
        this.code = code;
    }

    public String getCode()
    {
        return code;
    }
    public void setModel(String model)
    {
        this.model = model;
    }

    public String getModel()
    {
        return model;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
    public void setType(Long type)
    {
        this.type = type;
    }

    public Long getType()
    {
        return type;
    }
    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getDescription()
    {
        return description;
    }
    public void setBuyTime(Date buyTime)
    {
        this.buyTime = buyTime;
    }

    public Date getBuyTime()
    {
        return buyTime;
    }
    public void setTimeLimit(Long timeLimit)
    {
        this.timeLimit = timeLimit;
    }

    public Long getTimeLimit()
    {
        return timeLimit;
    }
    public void setStatus(Long status)
    {
        this.status = status;
    }

    public Long getStatus()
    {
        return status;
    }
    public void setSupervisor(Long supervisor)
    {
        this.supervisor = supervisor;
    }

    public Long getSupervisor()
    {
        return supervisor;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("code", getCode())
            .append("model", getModel())
            .append("name", getName())
            .append("type", getType())
            .append("description", getDescription())
            .append("buyTime", getBuyTime())
            .append("timeLimit", getTimeLimit())
            .append("status", getStatus())
            .append("supervisor", getSupervisor())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
