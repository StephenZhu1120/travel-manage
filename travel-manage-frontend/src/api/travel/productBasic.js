import request from '@/utils/request'

// 查询产品信息列表
export function listProductBasic(query) {
  return request({
    url: '/travel/productBasic/list',
    method: 'get',
    params: query
  })
}

// 查询产品信息详细
export function getProductBasic(id) {
  return request({
    url: '/travel/productBasic/' + id,
    method: 'get'
  })
}

// 新增产品信息
export function addProductBasic(data) {
  return request({
    url: '/travel/productBasic',
    method: 'post',
    data: data
  })
}

// 修改产品信息
export function updateProductBasic(data) {
  return request({
    url: '/travel/productBasic',
    method: 'put',
    data: data
  })
}

// 删除产品信息
export function delProductBasic(id) {
  return request({
    url: '/travel/productBasic/' + id,
    method: 'delete'
  })
}

// 导出产品信息
export function exportProductBasic(query) {
  return request({
    url: '/travel/productBasic/export',
    method: 'get',
    params: query
  })
}

// 上架/下架产品
export function changeStatus(id) {
  const data = {
    id
  }
  return request({
    url: '/travel/productBasic/changeStatus',
    method: 'put',
    data: data
  })
}
