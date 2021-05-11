import request from '@/utils/request'

// 查询测试功能列表
export function listTestTravel(query) {
  return request({
    url: '/travel/testTravel/list',
    method: 'get',
    params: query
  })
}

// 查询测试功能详细
export function getTestTravel(id) {
  return request({
    url: '/travel/testTravel/' + id,
    method: 'get'
  })
}

// 新增测试功能
export function addTestTravel(data) {
  return request({
    url: '/travel/testTravel',
    method: 'post',
    data: data
  })
}

// 修改测试功能
export function updateTestTravel(data) {
  return request({
    url: '/travel/testTravel',
    method: 'put',
    data: data
  })
}

// 删除测试功能
export function delTestTravel(id) {
  return request({
    url: '/travel/testTravel/' + id,
    method: 'delete'
  })
}

// 导出测试功能
export function exportTestTravel(query) {
  return request({
    url: '/travel/testTravel/export',
    method: 'get',
    params: query
  })
}