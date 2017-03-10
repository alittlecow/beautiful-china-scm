/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 邮件模板页面数据模型
 * @author: fengbaitong
 * date: 2015-11-25
 */
Ext.define('app.view.mailtemplate.MailTemplateViewModel', {
    extend: 'app.view.base.BaseViewModel',
    alias: 'viewmodel.mailtemplate',
    id:'mailTemplateViewModel',
    requires: [
       'app.store.mailtemplate.MailTemplateGridStore'
    ],

    stores: {

        mailTemplateGridStore:{
            type:'mailtemplategridstore'
        }
    }
});
