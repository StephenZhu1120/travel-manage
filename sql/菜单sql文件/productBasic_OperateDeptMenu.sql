-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('产品信息计调部', '2001', '1', 'productBasic_OperateDept', 'travel/productBasic_OperateDept/index', 1, 0, 'C', '0', '0', 'travel:productBasic_OperateDept:list', '#', 'admin', sysdate(), '', null, '产品信息计调部菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('产品信息计调部查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'travel:productBasic_OperateDept:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('产品信息计调部新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'travel:productBasic_OperateDept:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('产品信息计调部修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'travel:productBasic_OperateDept:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('产品信息计调部删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'travel:productBasic_OperateDept:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('产品信息计调部导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'travel:productBasic_OperateDept:export',       '#', 'admin', sysdate(), '', null, '');