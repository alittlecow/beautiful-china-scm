/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 邮件模板管理主页面
 * @author: fengbaitong
 * date: 2015-11-25
 */


Ext.define('app.view.mailtemplate.MailTemplateManagePanel', {
    extend: 'Ext.container.Container',
    xtype: 'mailtemplatemanage',
    controller:'mailtemplate',
    viewModel: {
        type: 'mailtemplate'
    },
    requires: [
       'app.view.mailtemplate.MailTemplateGrid',
        'app.view.mailtemplate.MailTemplateInfoWindow',
        'app.view.mailtemplate.MailTemplateController',
        'app.view.mailtemplate.MailTemplateViewModel'
    ],

    layout: {
        type:'vbox',
        align:'stretch'
    },
    items:[
        {
            flex:1,
            xtype:'mailtemplategrid'
        }
    ]
});