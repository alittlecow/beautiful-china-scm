/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: dongjingjun
 * date: 2015-12-21
 */
/**
 *
 * 角色管理表格store
 */
Ext.define('app.store.rolemanage.RoleGridStore', {
    extend: 'app.store.base.BaseStore',
    alias: 'store.rolegridstore',
    autoLoad: false,
    model:'app.model.rolemanage.RoleModel',
    storeId:'roleGridStore',
    proxy : {
        url : basePath + '/rolemanage/query'
    }
});
