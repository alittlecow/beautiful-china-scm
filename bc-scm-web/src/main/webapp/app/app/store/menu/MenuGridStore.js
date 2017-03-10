/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 *
 * @author: chenghuanhuan
 * date: 2015-11-16
 *
 */
Ext.define('app.store.menu.MenuGridStore', {
    extend: 'app.store.base.BaseStore',
    alias: 'store.menugridstore',
    autoLoad: false,
    model:'app.model.menu.MenuModel',
    storeId:'menuGridStore',
    proxy : {
        url : basePath + '/menu/query'
    }
});