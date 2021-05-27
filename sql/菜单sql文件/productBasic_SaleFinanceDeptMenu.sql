-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('产品信息门市部财务部', '2001', '1', 'productBasic_SaleFinanceDept', 'travel/productBasic_SaleFinanceDept/index', 1, 0, 'C', '0', '0', 'travel:productBasic_SaleFinanceDept:list', '#', 'admin', sysdate(), '', null, '产品信息门市部财务部菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('产品信息门市部财务部查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'travel:productBasic_SaleFinanceDept:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('产品信息门市部财务部新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'travel:productBasic_SaleFinanceDept:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('产品信息门市部财务部修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'travel:productBasic_SaleFinanceDept:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('产品信息门市部财务部删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'travel:productBasic_SaleFinanceDept:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('产品信息门市部财务部导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'travel:productBasic_SaleFinanceDept:export',       '#', 'admin', sysdate(), '', null, '');