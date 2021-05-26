import request from '@/utils/request'

// 查询设备列表
export function listDevice(query) {
  return request({
    url: '/yw/device/list',
    method: 'get',
    params: query
  })
}

// 查询设备详细
export function getDevice(id) {
  return request({
    url: '/yw/device/' + id,
    method: 'get'
  })
}

// 新增设备
export function addDevice(data) {
  return request({
    url: '/yw/device',
    method: 'post',
    data: data
  })
}

// 修改设备
export function updateDevice(data) {
  return request({
    url: '/yw/device',
    method: 'put',
    data: data
  })
}

// 删除设备
export function delDevice(id) {
  return request({
    url: '/yw/device/' + id,
    method: 'delete'
  })
}

// 导出设备
export function exportDevice(query) {
  return request({
    url: '/yw/device/export',
    method: 'get',
    params: query
  })
}
