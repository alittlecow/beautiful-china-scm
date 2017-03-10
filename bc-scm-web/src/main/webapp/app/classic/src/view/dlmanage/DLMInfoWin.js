/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: dongjingjun
 * date: 2015-12-21
 * 添加部门管理窗口
 */
Ext.define('app.view.dlmanage.DLMInfoWin', {
    extend: 'app.view.base.BaseWindow',
    xtype: 'dlmwin',
    controller: 'dlmwin',
    viewModel: {
        type: 'dlm'
    },
    bind: {title: '{addDLM}'},
    closeAction: 'hide',
    width: 550,
    height: 300,
    buttons: [{
        xtype: 'savebtn',
        handler: 'save'
    }],
    items: [{
        xtype: 'form',
        layout: 'vbox',
        padding: '5 5 5 5',
        defaultType: 'textfield',
        defaults: {
            labelAlign: 'right',
            allowBlank: false,
            width: 500,
            labelWidth:250
        }
        ,
        items: [
            {
                maxLength: 30,
                bind: {
                    fieldLabel: '{dLCode}'
                },
                name: 'code'
            },
            {
                xtype: 'combo',
                displayField: 'supCode',
                valueField: 'supCode',
                editable: false,
                bind: {
                    store: '{dLMStore}',
                    fieldLabel: '{sDLCode}'
                },
                name: 'supCode'
            },
            {
                bind: {
                    fieldLabel: '{dLEnName}'
                },
                maxLength: 30,

                name: 'enName'
            },
            {
                maxLength: 30,
                bind: {
                    fieldLabel: '{dLFnName}'
                },
                name: 'fnName'

            }]
    }]
});