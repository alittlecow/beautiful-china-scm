/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 平台用户查询界面
 * @author: fengbaitong
 * date: 2015-12-10
 */
Ext.define('app.view.platform.PlatformQueryForm', {
    extend: 'Ext.form.Panel',
    xtype: 'platformqueryform',
    layout: {
        type: 'vbox',
        align: 'stretch'
    },
    height:140,
    padding:'5 0 0 0',
    items: [{
        xtype: 'container',
        height:100,
        layout: {
            type: 'hbox',
            align: 'stretch'
        },
        padding: '10 0 0 0',
        defaultType: 'container',
        items: [{
            flex:1,
            layout: 'anchor',
            defaultType: 'textfield',
            defaults:{
                labelAlign:'right',
                anchor:'95%'
            },
            items: [{
                bind:{
                    fieldLabel:'{name}'
                },
                name: 'name'
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
            }]
        },{
            flex:1,
            //border:false,
            layout: 'anchor',
            defaultType: 'textfield',
            defaults:{
                labelAlign:'right',
                anchor:'95%'
            },
            items: [{
                bind:{
                    fieldLabel:'{loginName}'
                },
                name: 'loginName'
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
            }]
        },{
            xtype:'displayfield',
            flex:1,
            anchor:'95%'
        }]
    },{
        xtype:'searchreset'
    }]
});
