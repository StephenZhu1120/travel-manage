-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('财务信息财务部', '2003', '1', 'financeBasic_FinanceDept', 'travel/financeBasic_FinanceDept/index', 1, 0, 'C', '0', '0', 'travel:financeBasic_FinanceDept:list', '#', 'admin', sysdate(), '', null, '财务信息财务部菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('财务信息财务部查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'travel:financeBasic_FinanceDept:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('财务信息财务部新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'travel:financeBasic_FinanceDept:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('财务信息财务部修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'travel:financeBasic_FinanceDept:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('财务信息财务部删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'travel:financeBasic_FinanceDept:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('财务信息财务部导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'travel:financeBasic_FinanceDept:export',       '#', 'admin', sysdate(), '', null, '');