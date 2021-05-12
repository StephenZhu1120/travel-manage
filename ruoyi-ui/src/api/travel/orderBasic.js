import request from '@/utils/request'

// 查询订单管理列表
export function listOrderBasic(query) {
  return request({
    url: '/travel/orderBasic/list',
    method: 'get',
    params: query
  })
}

// 查询订单管理详细
export function getOrderBasic(id) {
  return request({
    url: '/travel/orderBasic/' + id,
    method: 'get'
  })
}

// 新增订单管理
export function addOrderBasic(data) {
  return request({
    url: '/travel/orderBasic',
    method: 'post',
    data: data
  })
}

// 修改订单管理
export function updateOrderBasic(data) {
  return request({
    url: '/travel/orderBasic',
    method: 'put',
    data: data
  })
}

// 删除订单管理
export function delOrderBasic(id) {
  return request({
    url: '/travel/orderBasic/' + id,
    method: 'delete'
  })
}

// 导出订单管理
export function exportOrderBasic(query) {
  return request({
    url: '/travel/orderBasic/export',
    method: 'get',
    params: query
  })
}