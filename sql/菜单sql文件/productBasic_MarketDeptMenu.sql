-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('产品信息市场部', '2001', '1', 'productBasic_MarketDept', 'travel/productBasic_MarketDept/index', 1, 0, 'C', '0', '0', 'travel:productBasic_MarketDept:list', '#', 'admin', sysdate(), '', null, '产品信息市场部菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('产品信息市场部查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'travel:productBasic_MarketDept:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('产品信息市场部新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'travel:productBasic_MarketDept:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('产品信息市场部修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'travel:productBasic_MarketDept:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('产品信息市场部删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'travel:productBasic_MarketDept:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('产品信息市场部导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'travel:productBasic_MarketDept:export',       '#', 'admin', sysdate(), '', null, '');