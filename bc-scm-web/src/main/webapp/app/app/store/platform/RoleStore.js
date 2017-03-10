/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 角色下拉框Store
 * @author: fengbaitong
 * date: 2015-12-16
 *
 */
Ext.define('app.store.platform.RoleStore', {
    extend: 'Ext.data.Store',
    alias: 'store.rolestore',
    autoLoad: true,
    fields: [
        'roleCode',
        'roleName'
    ],
    storeId:'platformStore',
    proxy : {
        type : 'ajax',
        url : basePath + '/rolemanage/getAllRoleCodeAndName',
        reader:{
            type:'json',
            rootProperty:'data',
            totalProperty:'total'
        }
    }
});