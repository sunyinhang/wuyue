import request from '@/utils/request'

// 查询污水量统计， 按周期列表
export function getLineData(query) {
  return request({
    url: '/yw/sewageStatistics/getLineData/' + query,
    method: 'get'
  })
}

// 查询污水量统计， 按周期列表
export function listSewageStatistics(query) {
  return request({
    url: '/yw/sewageStatistics/list',
    method: 'get',
    params: query
  })
}

// 查询污水量统计， 按周期详细
export function getSewageStatistics(id) {
  return request({
    url: '/yw/sewageStatistics/' + id,
    method: 'get'
  })
}

// 新增污水量统计， 按周期
export function addSewageStatistics(data) {
  return request({
    url: '/yw/sewageStatistics',
    method: 'post',
    data: data
  })
}

// 修改污水量统计， 按周期
export function updateSewageStatistics(data) {
  return request({
    url: '/yw/sewageStatistics',
    method: 'put',
    data: data
  })
}

// 删除污水量统计， 按周期
export function delSewageStatistics(id) {
  return request({
    url: '/yw/sewageStatistics/' + id,
    method: 'delete'
  })
}

// 导出污水量统计， 按周期
export function exportSewageStatistics(query) {
  return request({
    url: '/yw/sewageStatistics/export',
    method: 'get',
    params: query
  })
}
