/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: chengxuemin
 * date: 2015-12-11
 */

/**
 * 邮件历史记录表单窗口
 */
Ext.define('app.view.mailhistory.MailHistoryInfoWin', {
    extend: 'app.view.base.BaseWindow',
    xtype:'mailhistoryinfowin',
    controller:'mailhistory',
    viewModel: {
        type: 'mailhistory'
    },
    title: 'checkEmailContent',
    width:650,
    height:600,
    //layout:'fit',
    //modal: true,
    items:[{
        xtype:'form',
        layout:'column',
        padding:'5 5 5 5',
            items: [
                {
                    columnWidth: 1,
                    border: false,
                    layout: 'anchor',
                    items: [{
                        height:500,
                        xtype: 'textareafield',
                        labelAlign: 'right',
                        margin:'20 0 0 0',
                        bind:{
                            fieldLabel: '{content}'
                        },
                        name: 'content',
                        anchor: '95%'
                    }]
                }
            ]
        }]
});
