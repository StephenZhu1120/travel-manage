import request from '@/utils/request'

// 查询账户管理列表
export function listUserBasic(query) {
  return request({
    url: '/travel/userBasic/list',
    method: 'get',
    params: query
  })
}

// 查询账户管理详细
export function getUserBasic(id) {
  return request({
    url: '/travel/userBasic/' + id,
    method: 'get'
  })
}

// 新增账户管理
export function addUserBasic(data) {
  return request({
    url: '/travel/userBasic',
    method: 'post',
    data: data
  })
}

// 修改账户管理
export function updateUserBasic(data) {
  return request({
    url: '/travel/userBasic',
    method: 'put',
    data: data
  })
}

// 删除账户管理
export function delUserBasic(id) {
  return request({
    url: '/travel/userBasic/' + id,
    method: 'delete'
  })
}

// 导出账户管理
export function exportUserBasic(query) {
  return request({
    url: '/travel/userBasic/export',
    method: 'get',
    params: query
  })
}