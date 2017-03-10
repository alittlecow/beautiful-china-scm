/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: chengxuemin
 * date: 2015-12-11
 */

/**
 * 邮件历史记录查询页面
 */
Ext.define('app.view.mailhistory.MailHistoryQueryForm',{
    extend: 'Ext.form.Panel',
    xtype: 'mailhistoryqueryform',
    controller: 'mailhistory',
    viewModel: {
        type: 'mailhistory'
    },

    layout: {
        type: 'vbox',
        align: 'stretch'
    },
    height: 100,
    padding: '5 0 0 0',
    items: [{
        xtype: 'panel',
        height: 60,
        layout: 'hbox',
        padding: '10 0 10 0',
        items: [{
            flex: 1,
            border: false,
            layout: 'anchor',
            defaultType: 'textfield',
            defaults:{
                labelAlign:'right',
                anchor:'95%'
            },
            items: [{
                bind:{
                    fieldLabel: '{email}'
                },
                name: 'email',
                labelWidth:150
            }]
        }, {
            flex: 1,
            border: false,
            layout: 'anchor',
            defaultType: 'textfield',
            defaults:{
                labelAlign:'right',
                anchor:'95%'
            },
            items: [{
                bind:{
                    fieldLabel: '{orderNo}'
                },
                name: 'orderNo',
                labelWidth:150
            }]
        },{
            xtype:'displayfield',
            flex:1
        }]
    },{
        xtype:'searchreset'
    }]
});