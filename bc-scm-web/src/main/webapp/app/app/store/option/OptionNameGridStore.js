/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: liufei
 * date: 2015-12-22
 */
Ext.define('app.store.option.OptionNameGridStore', {
    extend: 'Ext.data.Store',
    alias: 'store.optionnamegridstore',
    autoLoad: false,
    model:'app.model.option.OptionNameModel',
    storeId:'optionNameGridStore',
    proxy : {
        type : 'ajax',
        url : basePath + '/option/queryName',
        reader:{
            type:'json',
            rootProperty:'data',
            totalProperty:'total'
        }
    }
});
