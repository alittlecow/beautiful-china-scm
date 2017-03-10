/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 * @author: chengxuemin
 * date: 2016-01-18
 */

/**
 * 咨询投诉管理窗口
 */
Ext.define('app.view.consulting.ConsultingInfoWin', {
    extend: 'app.view.base.BaseWindow',
    xtype: 'consultinginfowin',
    controller:'consultingwin',
    viewModel: {
        type: 'consulting'
    },
    width:450,
    height:500,
    buttons: [{
        xtype:'submitbtn',
        handler: 'submit'
    }],
    items:[{
        xtype:'form',
        layout:'column',
        padding:'5 15 5 5',
        items: [{
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
                }, {
                    itemId:'content',
                    xtype: 'textareafield',
                    bind:{
                        fieldLabel:'{contentConCom}'
                    },
                    name:'content',
                    height:160
                },{
                    xtype: 'textareafield',
                    bind:{
                        fieldLabel:'{deal}'
                    },
                    name: 'deal',
                    height:200
                }]
        }]
    }]
});