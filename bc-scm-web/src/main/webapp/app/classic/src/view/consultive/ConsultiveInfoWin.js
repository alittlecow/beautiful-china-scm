/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 * @author: chengxuemin
 * date: 2016-01-11
 */

/**
 * 咨询管理窗口
 */
Ext.define('app.view.consultive.ConsultiveInfoWin', {
    extend: 'app.view.base.BaseWindow',
    xtype:'consultiveinfowin',
    controller:'consultive',
    viewModel: {
        type: 'consultive'
    },
    title: 'replyContent',
    width:450,
    height:500,
    buttons : [{
        xtype:'submitbtn',
        handler: 'submit'
    }],
    items:[{
        xtype:'form',
        layout:'column',
        padding:'5 5 5 5',
        items: [
            {
                columnWidth: 1,
                border: false,
                layout: 'anchor',
                defaultType: 'textfield',
                defaults:{
                    anchor:'100%',
                    labelAlign:'right',
                    allowBlank: false
                },
                items: [
                {
                    xtype: 'hiddenfield',
                    name: 'id'
                },{
                        height:330,
                        xtype: 'textareafield',
                        bind:{
                            fieldLabel: '{replyContent}'
                        },
                        name: 'contentAn'
                }]
            }
        ]
    }]
});