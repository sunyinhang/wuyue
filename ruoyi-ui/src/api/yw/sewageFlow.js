import request from '@/utils/request'

// 查询水流量， 进的是污水， 出的是处理好的水列表
export function listSewageFlow(query) {
  return request({
    url: '/yw/sewageFlow/list',
    method: 'get',
    params: query
  })
}

// 查询水流量， 进的是污水， 出的是处理好的水详细
export function getSewageFlow(id) {
  return request({
    url: '/yw/sewageFlow/' + id,
    method: 'get'
  })
}

// 新增水流量， 进的是污水， 出的是处理好的水
export function addSewageFlow(data) {
  return request({
    url: '/yw/sewageFlow',
    method: 'post',
    data: data
  })
}

// 修改水流量， 进的是污水， 出的是处理好的水
export function updateSewageFlow(data) {
  return request({
    url: '/yw/sewageFlow',
    method: 'put',
    data: data
  })
}

// 删除水流量， 进的是污水， 出的是处理好的水
export function delSewageFlow(id) {
  return request({
    url: '/yw/sewageFlow/' + id,
    method: 'delete'
  })
}

// 导出水流量， 进的是污水， 出的是处理好的水
export function exportSewageFlow(query) {
  return request({
    url: '/yw/sewageFlow/export',
    method: 'get',
    params: query
  })
}
