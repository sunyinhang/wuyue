package com.ruoyi.web.controller.business;

import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.yw.domain.YwElectricFlow;
import com.ruoyi.yw.service.YwElectricFlowService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 电量Controller
 *
 * @author sun
 * @date 2021-05-15
 */
@RestController
@RequestMapping("/yw/electricFlow")
public class YwElectricFlowController extends BaseController
{
    @Autowired
    private YwElectricFlowService ywElectricFlowService;

    /**
     * 查询电量列表
     */
    @PreAuthorize("@ss.hasPermi('yw:electricFlow:list')")
    @GetMapping("/list")
    public TableDataInfo list(YwElectricFlow ywElectricFlow)
    {
        startPage();
        List<YwElectricFlow> list = ywElectricFlowService.selectYwElectricFlowList(ywElectricFlow);
        return getDataTable(list);
    }

    /**
     * 导出电量列表
     */
    @PreAuthorize("@ss.hasPermi('yw:electricFlow:export')")
    @Log(title = "电量", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(YwElectricFlow ywElectricFlow)
    {
        List<YwElectricFlow> list = ywElectricFlowService.selectYwElectricFlowList(ywElectricFlow);
        ExcelUtil<YwElectricFlow> util = new ExcelUtil<YwElectricFlow>(YwElectricFlow.class);
        return util.exportExcel(list, "电量数据");
    }

    /**
     * 获取电量详细信息
     */
    @PreAuthorize("@ss.hasPermi('yw:electricFlow:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(ywElectricFlowService.selectYwElectricFlowById(id));
    }

    /**
     * 新增电量
     */
    @PreAuthorize("@ss.hasPermi('yw:electricFlow:add')")
    @Log(title = "电量", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody YwElectricFlow ywElectricFlow)
    {
        return toAjax(ywElectricFlowService.insertYwElectricFlow(ywElectricFlow));
    }

    /**
     * 修改电量
     */
    @PreAuthorize("@ss.hasPermi('yw:electricFlow:edit')")
    @Log(title = "电量", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody YwElectricFlow ywElectricFlow)
    {
        return toAjax(ywElectricFlowService.updateYwElectricFlow(ywElectricFlow));
    }

    /**
     * 删除电量
     */
    @PreAuthorize("@ss.hasPermi('yw:electricFlow:remove')")
    @Log(title = "电量", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(ywElectricFlowService.deleteYwElectricFlowByIds(ids));
    }
}
