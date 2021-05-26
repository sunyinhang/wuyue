package com.ruoyi.yw.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 水流量， 进的是污水， 出的是处理好的水对象 yw_sewage_flow
 *
 * @author sun
 * @date 2021-05-15
 */
public class YwSewageFlow extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date time;

    /** 流量 秒/吨 */
    @Excel(name = "流量 秒/吨")
    private BigDecimal flow;

    /** 方向 0:进， 1:出 */
    @Excel(name = "方向 0:进， 1:出")
    private Long direction;

    /** 开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "开始时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date beginTime;

    /** 结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endTime;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setTime(Date time)
    {
        this.time = time;
    }

    public Date getTime()
    {
        return time;
    }
    public void setFlow(BigDecimal flow)
    {
        this.flow = flow;
    }

    public BigDecimal getFlow()
    {
        return flow;
    }
    public void setDirection(Long direction)
    {
        this.direction = direction;
    }

    public Long getDirection()
    {
        return direction;
    }
    public void setBeginTime(Date beginTime)
    {
        this.beginTime = beginTime;
    }

    public Date getBeginTime()
    {
        return beginTime;
    }
    public void setEndTime(Date endTime)
    {
        this.endTime = endTime;
    }

    public Date getEndTime()
    {
        return endTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("time", getTime())
            .append("flow", getFlow())
            .append("direction", getDirection())
            .append("beginTime", getBeginTime())
            .append("endTime", getEndTime())
            .toString();
    }
}
