/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 *
 * @author: fengbaitong
 * date: 2015-12-12
 *
 */
Ext.define('app.store.platform.PlatformGridStore', {
    extend: 'Ext.data.Store',
    alias: 'store.platformgridstore',
    autoLoad: false,
    model:'app.model.platform.PlatformModel',
    proxy : {
        type : 'ajax',
        url : basePath + '/platform/list',
        reader:{
            type:'json',
            method:'POST',
            rootProperty:'data',
            totalProperty:'total'
        }
    }
});