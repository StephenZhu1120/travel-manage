-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('账户市场计调财务', '2000', '1', 'userBasic_MarOpeFinanDept', 'travel/userBasic_MarOpeFinanDept/index', 1, 0, 'C', '0', '0', 'travel:userBasic_MarOpeFinanDept:list', '#', 'admin', sysdate(), '', null, '账户市场计调财务菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('账户市场计调财务查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'travel:userBasic_MarOpeFinanDept:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('账户市场计调财务新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'travel:userBasic_MarOpeFinanDept:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('账户市场计调财务修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'travel:userBasic_MarOpeFinanDept:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('账户市场计调财务删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'travel:userBasic_MarOpeFinanDept:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('账户市场计调财务导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'travel:userBasic_MarOpeFinanDept:export',       '#', 'admin', sysdate(), '', null, '');