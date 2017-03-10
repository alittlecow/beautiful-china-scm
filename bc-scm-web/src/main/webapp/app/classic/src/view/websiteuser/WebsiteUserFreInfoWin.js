/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 网站用户管理表单窗口
 * @author: chengxuemin
 * date: 2015-12-12
 */
Ext.define('app.view.websiteuser.WebsiteUserFreInfoWin', {
    extend: 'app.view.base.BaseWindow',
    xtype:'websiteuserfreinfowin',
    controller:'websiteuser',
    viewModel: {
        type: 'websiteuser'
    },
    title:'FreezeWebsiteUserInformation',
    width:380,
    height:200,
    buttons: [{
        xtype:'savebtn',
        handler:'save'
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
                items: [{
                    xtype: 'hiddenfield',
                    name: 'id'
                    },
                    {
                        bind:{
                              fieldLabel: '{status}'
                        },
                        xtype:'combo',
                        store:"normalStop",
                        displayField: 'name',
                        valueField: 'value',
                        queryMode:'local',
                        editable: false,
                        value:'N',
                        name: 'status'
                    },
                   {
                        bind:{
                            fieldLabel: '{lockReason}'
                        },
                        name: 'lockReson'
                    }]
            }
        ]}]
});