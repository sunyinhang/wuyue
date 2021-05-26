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
import com.ruoyi.yw.domain.YwDevice;
import com.ruoyi.yw.service.YwDeviceService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 设备Controller
 *
 * @author sun
 * @date 2021-05-15
 */
@RestController
@RequestMapping("/yw/device")
public class YwDeviceController extends BaseController
{
    @Autowired
    private YwDeviceService ywDeviceService;

    /**
     * 查询设备列表
     */
    @PreAuthorize("@ss.hasPermi('yw:device:list')")
    @GetMapping("/list")
    public TableDataInfo list(YwDevice ywDevice)
    {
        startPage();
        List<YwDevice> list = ywDeviceService.selectYwDeviceList(ywDevice);
        return getDataTable(list);
    }

    /**
     * 导出设备列表
     */
    @PreAuthorize("@ss.hasPermi('yw:device:export')")
    @Log(title = "设备", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(YwDevice ywDevice)
    {
        List<YwDevice> list = ywDeviceService.selectYwDeviceList(ywDevice);
        ExcelUtil<YwDevice> util = new ExcelUtil<YwDevice>(YwDevice.class);
        return util.exportExcel(list, "设备数据");
    }

    /**
     * 获取设备详细信息
     */
    @PreAuthorize("@ss.hasPermi('yw:device:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(ywDeviceService.selectYwDeviceById(id));
    }

    /**
     * 新增设备
     */
    @PreAuthorize("@ss.hasPermi('yw:device:add')")
    @Log(title = "设备", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody YwDevice ywDevice)
    {
        return toAjax(ywDeviceService.insertYwDevice(ywDevice));
    }

    /**
     * 修改设备
     */
    @PreAuthorize("@ss.hasPermi('yw:device:edit')")
    @Log(title = "设备", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody YwDevice ywDevice)
    {
        return toAjax(ywDeviceService.updateYwDevice(ywDevice));
    }

    /**
     * 删除设备
     */
    @PreAuthorize("@ss.hasPermi('yw:device:remove')")
    @Log(title = "设备", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(ywDeviceService.deleteYwDeviceByIds(ids));
    }
}
