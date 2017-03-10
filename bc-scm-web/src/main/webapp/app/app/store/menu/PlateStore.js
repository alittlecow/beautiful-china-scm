/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 模板Store
 * @author: chenghuanhuan
 * date: 2015-11-16
 *
 */
Ext.define('app.store.menu.PlateStore', {
    extend: 'app.store.base.BaseStore',
    alias: 'store.platestore',
    autoLoad: true,
    fields: [
        'code',
        'frName',
        'enName'
    ],
    storeId:'plateStore',
    proxy : {
        url : basePath + '/menu/plates'
    }
});