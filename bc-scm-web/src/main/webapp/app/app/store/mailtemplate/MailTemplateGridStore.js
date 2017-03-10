/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 *
 * @author: fengbaitong
 * date: 2015-11-25
 *
 */
Ext.define('app.store.mailtemplate.MailTemplateGridStore', {
    extend: 'Ext.data.Store',
    alias: 'store.mailtemplategridstore',
    autoLoad: false,
    fields: [
        'name',
        'title_en',
        'title_fr'
    ],
    storeId:'mailTemplateGridStore',
    proxy : {
        type : 'ajax',
        url : basePath + '/mailtemplate/list',
        reader:{
            type:'json',
            rootProperty:'data',
            totalProperty:'total'
        }
    }
});