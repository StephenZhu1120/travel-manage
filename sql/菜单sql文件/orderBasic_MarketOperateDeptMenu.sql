-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('订单市场计调', '2002', '1', 'orderBasic_MarketOperateDept', 'travel/orderBasic_MarketOperateDept/index', 1, 0, 'C', '0', '0', 'travel:orderBasic_MarketOperateDept:list', '#', 'admin', sysdate(), '', null, '订单市场计调菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('订单市场计调查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'travel:orderBasic_MarketOperateDept:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('订单市场计调新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'travel:orderBasic_MarketOperateDept:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('订单市场计调修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'travel:orderBasic_MarketOperateDept:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('订单市场计调删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'travel:orderBasic_MarketOperateDept:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('订单市场计调导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'travel:orderBasic_MarketOperateDept:export',       '#', 'admin', sysdate(), '', null, '');