import request from '@/utils/request'

// 查询电量列表
export function listElectricFlow(query) {
  return request({
    url: '/yw/electricFlow/list',
    method: 'get',
    params: query
  })
}

// 查询电量详细
export function getElectricFlow(id) {
  return request({
    url: '/yw/electricFlow/' + id,
    method: 'get'
  })
}

// 新增电量
export function addElectricFlow(data) {
  return request({
    url: '/yw/electricFlow',
    method: 'post',
    data: data
  })
}

// 修改电量
export function updateElectricFlow(data) {
  return request({
    url: '/yw/electricFlow',
    method: 'put',
    data: data
  })
}

// 删除电量
export function delElectricFlow(id) {
  return request({
    url: '/yw/electricFlow/' + id,
    method: 'delete'
  })
}

// 导出电量
export function exportElectricFlow(query) {
  return request({
    url: '/yw/electricFlow/export',
    method: 'get',
    params: query
  })
}
