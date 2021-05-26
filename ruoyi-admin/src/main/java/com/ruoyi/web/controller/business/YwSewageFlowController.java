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
import com.ruoyi.yw.domain.YwSewageFlow;
import com.ruoyi.yw.service.YwSewageFlowService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 水流量， 进的是污水， 出的是处理好的水Controller
 *
 * @author sun
 * @date 2021-05-15
 */
@RestController
@RequestMapping("/yw/sewageFlow")
public class YwSewageFlowController extends BaseController
{
    @Autowired
    private YwSewageFlowService ywSewageFlowService;

    /**
     * 查询水流量， 进的是污水， 出的是处理好的水列表
     */
    @PreAuthorize("@ss.hasPermi('yw:sewageFlow:list')")
    @GetMapping("/list")
    public TableDataInfo list(YwSewageFlow ywSewageFlow)
    {
        startPage();
        List<YwSewageFlow> list = ywSewageFlowService.selectYwSewageFlowList(ywSewageFlow);
        return getDataTable(list);
    }

    /**
     * 导出水流量， 进的是污水， 出的是处理好的水列表
     */
    @PreAuthorize("@ss.hasPermi('yw:sewageFlow:export')")
    @Log(title = "水流量， 进的是污水， 出的是处理好的水", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(YwSewageFlow ywSewageFlow)
    {
        List<YwSewageFlow> list = ywSewageFlowService.selectYwSewageFlowList(ywSewageFlow);
        ExcelUtil<YwSewageFlow> util = new ExcelUtil<YwSewageFlow>(YwSewageFlow.class);
        return util.exportExcel(list, "水流量， 进的是污水， 出的是处理好的水数据");
    }

    /**
     * 获取水流量， 进的是污水， 出的是处理好的水详细信息
     */
    @PreAuthorize("@ss.hasPermi('yw:sewageFlow:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(ywSewageFlowService.selectYwSewageFlowById(id));
    }

    /**
     * 新增水流量， 进的是污水， 出的是处理好的水
     */
    @PreAuthorize("@ss.hasPermi('yw:sewageFlow:add')")
    @Log(title = "水流量， 进的是污水， 出的是处理好的水", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody YwSewageFlow ywSewageFlow)
    {
        return toAjax(ywSewageFlowService.insertYwSewageFlow(ywSewageFlow));
    }

    /**
     * 修改水流量， 进的是污水， 出的是处理好的水
     */
    @PreAuthorize("@ss.hasPermi('yw:sewageFlow:edit')")
    @Log(title = "水流量， 进的是污水， 出的是处理好的水", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody YwSewageFlow ywSewageFlow)
    {
        return toAjax(ywSewageFlowService.updateYwSewageFlow(ywSewageFlow));
    }

    /**
     * 删除水流量， 进的是污水， 出的是处理好的水
     */
    @PreAuthorize("@ss.hasPermi('yw:sewageFlow:remove')")
    @Log(title = "水流量， 进的是污水， 出的是处理好的水", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(ywSewageFlowService.deleteYwSewageFlowByIds(ids));
    }
}
