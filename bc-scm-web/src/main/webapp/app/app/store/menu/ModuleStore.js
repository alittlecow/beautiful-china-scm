/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 模块Store
 * @author: chenghuanhuan
 * date: 2015-11-16
 *
 */
Ext.define('app.store.menu.ModuleStore', {
    extend: 'app.store.base.BaseStore',
    alias: 'store.modulestore',
    autoLoad: true,
    fields: [
        'moduleCode',
        'moduleEnName'
    ],
    storeId:'moduleStore',
    proxy : {
        url : basePath + '/menu/getModuleByPlateCode'
    }
});