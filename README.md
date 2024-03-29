## 开发背景
旅行社电子信息化，设计并开发一套供中小旅行社使用的线上营销系统（一个前台商城+一个后台管理平台+一个后端服务器）。

本项目服务端代码包括ruoyi-admin、ruoyi-common、ruoyi-framework、ruoyi-generator、ruoyi-quartz和ruoyi-system，基于Ruoyi框架进行开发，相关内容可以到 README-RuoYi.md中查看。

## 技术选型
Vue + SpringBoot + MyBatis + SpringSecurity + MySQL

## 实现功能
- 旅行社内：部门管理、成员管理、角色管理、权限管理
- 业务逻辑：客户账户管理、旅游产品管理、订单管理、财务管理、客户下单、订单定时任务

## 其他说明
- 所有数据库建表文件都在`/sql`中
- 系统原有后端代码在`/ruoyi-admin`和`/ruoyi-system`中
- 后端管理系统逻辑代码在`/ruoyi-system`中
- 商城部分Controller代码在`/ruoyi-admin`中
- 定时任务相关代码在`/ruoyi-quartz`中
- 前台商城页面前端代码文件夹为`/travel-mall-frontend`
- 后台管理页面前端代码文件夹为`/travel-manage-frontend`