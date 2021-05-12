import request from '@/utils/request'

// 查询财务信息列表
export function listFinanceBasic(query) {
  return request({
    url: '/travel/financeBasic/list',
    method: 'get',
    params: query
  })
}

// 查询财务信息详细
export function getFinanceBasic(id) {
  return request({
    url: '/travel/financeBasic/' + id,
    method: 'get'
  })
}

// 新增财务信息
export function addFinanceBasic(data) {
  return request({
    url: '/travel/financeBasic',
    method: 'post',
    data: data
  })
}

// 修改财务信息
export function updateFinanceBasic(data) {
  return request({
    url: '/travel/financeBasic',
    method: 'put',
    data: data
  })
}

// 删除财务信息
export function delFinanceBasic(id) {
  return request({
    url: '/travel/financeBasic/' + id,
    method: 'delete'
  })
}

// 导出财务信息
export function exportFinanceBasic(query) {
  return request({
    url: '/travel/financeBasic/export',
    method: 'get',
    params: query
  })
}