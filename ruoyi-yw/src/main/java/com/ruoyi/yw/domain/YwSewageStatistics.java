package com.ruoyi.yw.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 污水量统计， 按周期对象 yw_sewage_statistics
 *
 * @author sun
 * @date 2021-05-15
 */
public class YwSewageStatistics extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 统计周期 hour:时， day:天， week:周， month:月， year：年 */
    @Excel(name = "统计周期 hour:时， day:天， week:周， month:月， year：年")
    private String cycle;

    /** 进来的污水量， 单位吨 */
    @Excel(name = "进来的污水量， 单位吨")
    private BigDecimal enter;

    /** 处理完的污水， 单位吨 */
    @Excel(name = "处理完的污水， 单位吨")
    private BigDecimal out;

    /** 本周期的第一天 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "本周期的第一天", width = 30, dateFormat = "yyyy-MM-dd")
    private Date beginDate;

    /** 本周期的最后一天 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "本周期的最后一天", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endTime;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setCycle(String cycle)
    {
        this.cycle = cycle;
    }

    public String getCycle()
    {
        return cycle;
    }
    public void setEnter(BigDecimal enter)
    {
        this.enter = enter;
    }

    public BigDecimal getEnter()
    {
        return enter;
    }
    public void setOut(BigDecimal out)
    {
        this.out = out;
    }

    public BigDecimal getOut()
    {
        return out;
    }
    public void setBeginDate(Date beginDate)
    {
        this.beginDate = beginDate;
    }

    public Date getBeginDate()
    {
        return beginDate;
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
            .append("cycle", getCycle())
            .append("enter", getEnter())
            .append("out", getOut())
            .append("beginDate", getBeginDate())
            .append("endTime", getEndTime())
            .toString();
    }
}
