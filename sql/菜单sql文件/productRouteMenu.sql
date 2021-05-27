-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('产品路线', '2001', '1', 'productRoute', 'travel/productRoute/index', 1, 0, 'C', '0', '0', 'travel:productRoute:list', '#', 'admin', sysdate(), '', null, '产品路线菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('产品路线查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'travel:productRoute:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('产品路线新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'travel:productRoute:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('产品路线修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'travel:productRoute:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('产品路线删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'travel:productRoute:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('产品路线导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'travel:productRoute:export',       '#', 'admin', sysdate(), '', null, '');