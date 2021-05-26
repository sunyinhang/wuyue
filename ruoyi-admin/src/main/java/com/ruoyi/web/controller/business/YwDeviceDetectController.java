package com.ruoyi.web.controller.business;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.yw.domain.YwDeviceDetect;
import com.ruoyi.yw.service.YwDeviceDetectService;
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

import java.util.HashMap;
import java.util.List;

/**
 * 设备检修记录Controller
 *
 * @author sun
 * @date 2021-05-15
 */
@RestController
@RequestMapping("/yw/deviceDetect")
public class YwDeviceDetectController extends BaseController {
    @Autowired
    private YwDeviceDetectService ywDeviceDetectService;

    /**
     * 查询设备检修记录列表
     */
    @PreAuthorize("@ss.hasPermi('yw:deviceDetect:list')")
    @GetMapping("/list")
    public TableDataInfo list(YwDeviceDetect ywDeviceDetect) {
        startPage();
        List<YwDeviceDetect> list = ywDeviceDetectService.selectYwDeviceDetectList(ywDeviceDetect);
        return getDataTable(list);
    }

    /**
     * 导出设备检修记录列表
     */
    @PreAuthorize("@ss.hasPermi('yw:deviceDetect:export')")
    @Log(title = "设备检修记录", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(YwDeviceDetect ywDeviceDetect) {
        List<YwDeviceDetect> list = ywDeviceDetectService.selectYwDeviceDetectList(ywDeviceDetect);
        ExcelUtil<YwDeviceDetect> util = new ExcelUtil<YwDeviceDetect>(YwDeviceDetect.class);
        return util.exportExcel(list, "设备检修记录数据");
    }

    /**
     * 获取设备检修记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('yw:deviceDetect:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(ywDeviceDetectService.selectYwDeviceDetectById(id));
    }

    /**
     * 新增设备检修记录
     */
    @PreAuthorize("@ss.hasPermi('yw:deviceDetect:add')")
    @Log(title = "设备检修记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody YwDeviceDetect ywDeviceDetect) {
        return toAjax(ywDeviceDetectService.insertYwDeviceDetect(ywDeviceDetect));
    }

    /**
     * 修改设备检修记录
     */
    @PreAuthorize("@ss.hasPermi('yw:deviceDetect:edit')")
    @Log(title = "设备检修记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody YwDeviceDetect ywDeviceDetect) {
        return toAjax(ywDeviceDetectService.updateYwDeviceDetect(ywDeviceDetect));
    }

    /**
     * 删除设备检修记录
     */
    @PreAuthorize("@ss.hasPermi('yw:deviceDetect:remove')")
    @Log(title = "设备检修记录", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(ywDeviceDetectService.deleteYwDeviceDetectByIds(ids));
    }
}
