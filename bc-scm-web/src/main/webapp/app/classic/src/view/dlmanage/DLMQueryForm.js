/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: dongjingjun
 * date: 2015-12-21
 * 部门管理查询页面
 */
Ext.define('app.view.dlmanage.DLMQueryForm', {
    extend: 'Ext.form.Panel',
    xtype: 'dlmqueryform',
    layout: {
        type: 'vbox',
        align: 'stretch'
    },
    padding: '5 0 0 0',
    height: 100,
    items: [{
        xtype: 'panel',
        height: 60,
        layout: {
            type: 'hbox'
        },
        padding: '10 0 10 0',
        defaultType: 'textfield',
        defaults: {
            labelAlign: 'right',
            labelWidth: 150
        },
        items: [{
            bind: {
                fieldLabel: '{dLCode}'
            },
            name: 'code',
            flex: 1
        },
            {
                bind: {
                    fieldLabel: '{dLName}'
                },
                name: 'name',
                flex: 1
            },{
                xtype:'displayfield',
                flex:1
            }]
    }, {
        xtype: 'panel',
        layout: {
            type: 'hbox',
            padding: '0 18 0 0',
            pack: 'end',
            align: 'middle'
        },
        items: [{
            xtype: 'searchreset'
        }]
    }]
});