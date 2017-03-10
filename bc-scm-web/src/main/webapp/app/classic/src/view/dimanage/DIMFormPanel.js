/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: dongjingjun
 * date: 2015-12-21
 * 部门信息管理表单
 */

Ext.define('app.view.dimanage.DIMFormPanel', {
    extend: 'Ext.form.Panel',
    xtype: 'formpanel',
    layout: {
        type: 'vbox',
        align: 'center'
    },
    padding: '5 0 0 0',
    defaultType: 'textfield',
    defaults: {
        padding: '10 30 0 30',
        width: '80%',
        labelWidth: 250,
        labelAlign: 'right',
        maxLength: 50
    },
    items: [
        {
            name: 'id',
            hidden: true
        },
        {
            bind: {
                fieldLabel: '{deptCode}'
            },
            name: 'deptCode',
            allowBlank: false
        },
        {
            bind: {
                fieldLabel: '{levelCode}'
            },
            name: 'levelCode',
            editable: false
        },
        {
            bind: {
                fieldLabel: '{deptNameEn}'
            },
            name: 'deptNameEn',
            allowBlank: false
        },
        {
            bind: {
                fieldLabel: '{deptNameFr}'
            },
            name: 'deptNameFr',
            allowBlank: false
        },
        {
            xtype: 'combo',
            displayField: 'deptName',
            valueField: 'deptCode',
            editable: false,
            value: null,
            bind: {
                store: '{dimFormStore}',
                fieldLabel: '{supDept}'
            },
            autoLoadOnValue: true,
            name: 'supDept',
            listeners:{
                beforequery:'getSup'
            }
        },
        {
            bind: {
                fieldLabel: '{status}'
            },
            xtype: 'combo',
            store: "normalStop",
            displayField: 'name',
            valueField: 'value',
            editable: false,
            value: 'N',
            name: 'status'
        },
        {
            bind: {
                fieldLabel: '{operator}'
            },
            readOnly: true,
            name: 'operator',
            hidden:true
        },
        {
            bind: {
                fieldLabel: '{operateTime}'
            },
            editable: false,
            name: 'operateTime',
            hidden:true
        }, {
            xtype: 'panel',
            layout: {
                type: 'hbox',
                padding: '0 18 0 0',
                pack: 'end',
                align: 'middle'
            },
            items: [{
                xtype: 'savebtn',
                handler: 'save'
            }]
        }
    ]
});