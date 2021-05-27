-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('订单门市部', '2002', '1', 'orderBasic_SaleDept', 'travel/orderBasic_SaleDept/index', 1, 0, 'C', '0', '0', 'travel:orderBasic_SaleDept:list', '#', 'admin', sysdate(), '', null, '订单门市部菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('订单门市部查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'travel:orderBasic_SaleDept:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('订单门市部新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'travel:orderBasic_SaleDept:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('订单门市部修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'travel:orderBasic_SaleDept:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('订单门市部删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'travel:orderBasic_SaleDept:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('订单门市部导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'travel:orderBasic_SaleDept:export',       '#', 'admin', sysdate(), '', null, '');