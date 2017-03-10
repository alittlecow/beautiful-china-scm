/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 网站用户管理表单窗口
 * @author: chenghuanhuan
 * date: 2015-12-12
 */
Ext.define('app.view.websiteuser.WebsiteUserInfoWin', {
    extend: 'app.view.base.BaseWindow',
    xtype:'websiteuserinfowin',
    controller:'websiteuser',
    viewModel: {
        type: 'websiteuser'
    },
    title:'WebsiteUserDetails',
    width:780,
    height:380,
    items:[{
        xtype:'form',
        layout:'column',
        padding:'5 5 5 5',
        items: [
            {
                columnWidth: 0.5,
                border: false,
                layout: 'anchor',
                defaultType: 'textfield',
                defaults:{
                    anchor:'100%',
                    labelAlign:'right',
                    editable: false,
                    labelWidth:150
                },
                items: [
               {
                    bind:{
                        fieldLabel: '{name}'
                    },
                    name: 'name'
                },{
                    bind:{
                        fieldLabel: '{nickName}'
                    },
                    name: 'nickName'
                },{
                    bind:{
                        fieldLabel: '{email}'
                    },
                    name: 'email'
                },{
                    bind:{
                        fieldLabel: '{sex}'
                    },
                    name: 'sex'
                },{
                    bind:{
                        fieldLabel: '{passport}'
                    },
                    name: 'passport'
                },{
                   bind:{
                        fieldLabel: '{status}'
                    },
                    name: 'status'
                },{
                    bind:{
                        fieldLabel: '{regTime}'
                    },
                    name: 'regTime'
                }]

    },{
                columnWidth: 0.5,
                border: false,
                layout: 'anchor',
                defaultType: 'textfield',
                defaults:{
                    anchor:'100%',
                    labelAlign:'right',
                    editable:false,
                    labelWidth:150
                },
                items: [
                    {
                        bind:{
                            fieldLabel: '{point}'
                        },
                        name: 'point'
                    },{
                        bind:{
                            fieldLabel: '{usablePoint}'
                        },
                        name: 'usablePoint'
                    },{
                         bind:{
                            fieldLabel: '{type}'
                        },
                        name: 'type'
                    },{
                        bind:{
                            fieldLabel: '{faceBookName}'
                        },
                        name: 'faceBookName'
                    },{
                        bind: {
                            fieldLabel: '{ip}'
                        },
                        name: 'ip'
                    },{
                        bind:{
                            fieldLabel: '{lockTime}'
                        },
                        name: 'lockTime'
                    },{
                        bind:{
                            fieldLabel:'{lockReason}'
                        },
                        name: 'lockReson'
                    }]

            }
        ]}]
});