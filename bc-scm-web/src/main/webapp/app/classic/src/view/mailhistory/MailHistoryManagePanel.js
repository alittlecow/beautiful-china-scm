/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: chengxuemin
 * date: 2015-12-11
 */

/**
 * 邮件历史记录管理主页面
 */
Ext.define('app.view.mailhistory.MailHistoryManagePanel', {
    extend: 'Ext.panel.Panel',
    xtype: 'MailHistoryManage',
    controller:'mailhistory',
    viewModel: {
        type: 'mailhistory'
    },
    requires: [
        'app.view.mailhistory.MailHistoryQueryForm'
        , 'app.view.mailhistory.MailHistoryGrid'
        , 'app.view.mailhistory.MailHistoryInfoWin'

        , 'app.view.mailhistory.MailHistoryController'

        , 'app.view.mailhistory.MailHistoryViewModel'
    ],

    layout: {
        type: 'vbox',
        align: 'stretch'
    },
    items:[{
        xtype: 'mailhistoryqueryform'
    },{
        xtype: 'mailhistorygrid',
        flex: 1
    }]
});