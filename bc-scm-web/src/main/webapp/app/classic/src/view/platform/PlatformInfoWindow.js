/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 平台用户表单窗口
 * @author: fengbaitong
 * date: 2015-12-15
 */
Ext.define('app.view.platform.PlatformInfoWindow', {
    extend: 'app.view.base.BaseWindow',
    xtype:'platforminfowindow',
    controller:'platformwindow',
    viewModel: {
        type: 'platform'
    },
    width:800,
    height:395,
    buttons: [{
        xtype:'savebtn',
        handler:'save'
    }],
    items:[{
        xtype:'form',
        layout:'column',
        padding:'5 5 5 5',
        items: [{
            columnWidth: 0.45,
            border: false,
            layout: 'anchor',
            defaultType: 'textfield',
            defaults:{
                anchor:'95%',
                labelAlign:'right',
                allowBlank: false,
                labelWidth:150
            },
            items: [
                {
                xtype: 'hiddenfield',
                name: 'id'
                },
                {
                maxLength:20,
                minLength:3,
                //regex:/^[a-zA-Z][a-zA-Z0-9_]*$/,
                bind:{
                    fieldLabel:'{name}'
                },
                name: 'name'
            },{
                maxLength:40,
                bind:{
                    fieldLabel:'{pwd}'
                },
                name: 'password',
                minLength:6,
                inputType: 'password',
                itemId:'password',
                listeners: {
                    validitychange: 'validateField',
                    blur: 'validateField'
                }
            },{
                    xtype:'combo',
                    name: 'deptCode',
                    bind:{
                        fieldLabel:'{dept}',
                        store: '{deptStore}'
                    },
                    displayField: 'deptName',
                    valueField: 'deptCode',
                    editable: false
            },{
                maxLength:20,
                bind:{
                    fieldLabel:'{tel}'
                },
                name: 'tel',
                regex:/^[0-9]*$/
            },{
                maxLength:30,
                bind:{
                    fieldLabel:'{email}'
                },
                name: 'email',
                vtype:'email'

            }]
        },{
            columnWidth: 0.45,
            padding:'0 0 0 5',
            border:false,
            layout: 'anchor',
            defaultType: 'textfield',
            defaults:{
                anchor:'95%',
                allowBlank: false,
                labelAlign:'right',
                labelWidth:150
            },
            items: [{
                bind:{
                    fieldLabel:'{loginName}'
                },
                maxLength:30,
                minLength:3,
                regex:/^[a-zA-Z][a-zA-Z0-9_]*$/,
                name: 'loginName',
                itemId: 'loginName'
            },{
                bind:{
                    fieldLabel:'{confirmPwd}'
                },
                inputType: 'password',
                maxLength:30,
                minLength:6,
                vtype: 'password',
                initialPassField: 'password',
                itemId:'confirmPwd'
            },{
                xtype:'combo',
                name: 'roleCode',
                bind:{
                    fieldLabel:'{role}',
                    store: '{roleStore}'
                },
                displayField: 'roleName',
                valueField: 'roleCode',
                editable: false
            },{
                maxLength:20,
                bind:{
                    fieldLabel:'{tel2}'
                },
                name: 'tel2',
                regex:/^[0-9]*$/
            },{
                bind:{
                    fieldLabel:'{status}'
                },
                xtype:'combo',
                store:"normalStop",
                displayField: 'name',
                valueField: 'value',
                editable: false,
                value:'N',
                name: 'status'
            }]
        }]
    }]
});
