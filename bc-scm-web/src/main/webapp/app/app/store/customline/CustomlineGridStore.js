/**
 * Copyright @ 2016 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 定制线路管理store
 * @author: zhangyu
 * date: 2016-1-7
 */

Ext.define('app.store.customline.CustomlineGridStore', {
    extend: 'app.store.base.BaseStore',
    alias: 'store.customlinegridstore',
    autoLoad: false,
    model:'app.model.customline.CustomlineModel',
    storeId:'customlineGridStore',
    proxy : {
        url : basePath + '/customline/list'
    }
});