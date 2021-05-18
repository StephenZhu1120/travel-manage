import request from '@/utils/request'

// 查询产品路线列表
export function listProductRoute(query) {
  return request({
    url: '/travel/productRoute/list',
    method: 'get',
    params: query
  })
}

// 查询产品路线详细
export function getProductRoute(id) {
  return request({
    url: '/travel/productRoute/' + id,
    method: 'get'
  })
}

// 新增产品路线
export function addProductRoute(data) {
  return request({
    url: '/travel/productRoute',
    method: 'post',
    data: data
  })
}

// 修改产品路线
export function updateProductRoute(data) {
  return request({
    url: '/travel/productRoute',
    method: 'put',
    data: data
  })
}

// 删除产品路线
export function delProductRoute(id) {
  return request({
    url: '/travel/productRoute/' + id,
    method: 'delete'
  })
}

// 导出产品路线
export function exportProductRoute(query) {
  return request({
    url: '/travel/productRoute/export',
    method: 'get',
    params: query
  })
}