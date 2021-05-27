-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('产品路线计调部', '2001', '1', 'productRoute_OperateDept', 'travel/productRoute_OperateDept/index', 1, 0, 'C', '0', '0', 'travel:productRoute_OperateDept:list', '#', 'admin', sysdate(), '', null, '产品路线计调部菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('产品路线计调部查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'travel:productRoute_OperateDept:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('产品路线计调部新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'travel:productRoute_OperateDept:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('产品路线计调部修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'travel:productRoute_OperateDept:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('产品路线计调部删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'travel:productRoute_OperateDept:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('产品路线计调部导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'travel:productRoute_OperateDept:export',       '#', 'admin', sysdate(), '', null, '');