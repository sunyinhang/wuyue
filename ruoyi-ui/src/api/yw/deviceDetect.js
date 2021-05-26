import request from '@/utils/request'

// 查询设备检修记录列表
export function listDeviceDetect(query) {
  return request({
    url: '/yw/deviceDetect/list',
    method: 'get',
    params: query
  })
}

// 查询设备检修记录详细
export function getDeviceDetect(id) {
  return request({
    url: '/yw/deviceDetect/' + id,
    method: 'get'
  })
}

// 新增设备检修记录
export function addDeviceDetect(data) {
  return request({
    url: '/yw/deviceDetect',
    method: 'post',
    data: data
  })
}

// 修改设备检修记录
export function updateDeviceDetect(data) {
  return request({
    url: '/yw/deviceDetect',
    method: 'put',
    data: data
  })
}

// 删除设备检修记录
export function delDeviceDetect(id) {
  return request({
    url: '/yw/deviceDetect/' + id,
    method: 'delete'
  })
}

// 导出设备检修记录
export function exportDeviceDetect(query) {
  return request({
    url: '/yw/deviceDetect/export',
    method: 'get',
    params: query
  })
}
