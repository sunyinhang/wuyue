package com.ruoyi.web.controller.business;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.yw.domain.YwSewageStatistics;
import com.ruoyi.yw.service.YwSewageStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 污水量统计， 按周期Controller
 *
 * @author sun
 * @date 2021-05-15
 */
@RestController
@RequestMapping("/yw/sewageStatistics")
public class YwSewageStatisticsController extends BaseController {
    @Autowired
    private YwSewageStatisticsService ywSewageStatisticsService;

    /**
     * 查询污水量统计， 按周期列表
     */
    @PreAuthorize("@ss.hasPermi('yw:sewageStatistics:list')")
    @GetMapping("/getLineData/{time}")
    public AjaxResult getLineData(@PathVariable String time) {
        return AjaxResult.success(ywSewageStatisticsService.getLineData(time));
    }

    /**
     * 查询污水量统计， 按周期列表
     */
    @PreAuthorize("@ss.hasPermi('yw:sewageStatistics:list')")
    @GetMapping("/list")
    public TableDataInfo list(YwSewageStatistics ywSewageStatistics) {
        startPage();
        List<YwSewageStatistics> list = ywSewageStatisticsService.selectYwSewageStatisticsList(ywSewageStatistics);
        return getDataTable(list);
    }

    /**
     * 导出污水量统计， 按周期列表
     */
    @PreAuthorize("@ss.hasPermi('yw:sewageStatistics:export')")
    @Log(title = "污水量统计， 按周期", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(YwSewageStatistics ywSewageStatistics) {
        List<YwSewageStatistics> list = ywSewageStatisticsService.selectYwSewageStatisticsList(ywSewageStatistics);
        ExcelUtil<YwSewageStatistics> util = new ExcelUtil<YwSewageStatistics>(YwSewageStatistics.class);
        return util.exportExcel(list, "污水量统计， 按周期数据");
    }

    /**
     * 获取污水量统计， 按周期详细信息
     */
    @PreAuthorize("@ss.hasPermi('yw:sewageStatistics:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(ywSewageStatisticsService.selectYwSewageStatisticsById(id));
    }

    /**
     * 新增污水量统计， 按周期
     */
    @PreAuthorize("@ss.hasPermi('yw:sewageStatistics:add')")
    @Log(title = "污水量统计， 按周期", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody YwSewageStatistics ywSewageStatistics) {
        return toAjax(ywSewageStatisticsService.insertYwSewageStatistics(ywSewageStatistics));
    }

    /**
     * 修改污水量统计， 按周期
     */
    @PreAuthorize("@ss.hasPermi('yw:sewageStatistics:edit')")
    @Log(title = "污水量统计， 按周期", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody YwSewageStatistics ywSewageStatistics) {
        return toAjax(ywSewageStatisticsService.updateYwSewageStatistics(ywSewageStatistics));
    }

    /**
     * 删除污水量统计， 按周期
     */
    @PreAuthorize("@ss.hasPermi('yw:sewageStatistics:remove')")
    @Log(title = "污水量统计， 按周期", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(ywSewageStatisticsService.deleteYwSewageStatisticsByIds(ids));
    }
}
