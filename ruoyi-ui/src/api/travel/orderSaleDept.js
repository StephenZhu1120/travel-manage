import request from '@/utils/request'

// 查询订单门市部列表
export function listOrderSaleDept(query) {
  return request({
    url: '/travel/orderSaleDept/list',
    method: 'get',
    params: query
  })
}

// 查询订单门市部详细
export function getOrderSaleDept(id) {
  return request({
    url: '/travel/orderSaleDept/' + id,
    method: 'get'
  })
}

// 新增订单门市部
export function addOrderSaleDept(data) {
  return request({
    url: '/travel/orderSaleDept',
    method: 'post',
    data: data
  })
}

// 修改订单门市部
export function updateOrderSaleDept(data) {
  return request({
    url: '/travel/orderSaleDept',
    method: 'put',
    data: data
  })
}

// 删除订单门市部
export function delOrderSaleDept(id) {
  return request({
    url: '/travel/orderSaleDept/' + id,
    method: 'delete'
  })
}

// 导出订单门市部
export function exportOrderSaleDept(query) {
  return request({
    url: '/travel/orderSaleDept/export',
    method: 'get',
    params: query
  })
}