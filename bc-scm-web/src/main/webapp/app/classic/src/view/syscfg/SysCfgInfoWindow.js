/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 系统配置表单窗口
 * @author: liufei
 * date: 2015-12-14
 *
 * chengxuemin 删除group_id，group_name，添加group_code
 * date: 2016-01-24
 */
Ext.define('app.view.syscfg.SysCfgInfoWindow', {
    extend: 'app.view.base.BaseWindow',
    xtype: 'syscfginfowindow',
    controller: 'syscfgwindow',
    viewModel: {
        type: 'syscfg'
    },
    width: 645,
    height: 400,
    layout: 'fit',
    modal: true,
    buttons: [{
        xtype: 'savebtn',
        handler: 'save'
    }],
    items: [{
        xtype: 'form',
        // 需要多语言字段配置
        multiLanguage: ['name', 'value'],
        layout: 'column',
        padding: '10 5 5 5',
        items: [{
            columnWidth: 0.75,
            border: false,
            layout: 'anchor',
            defaultType: 'textfield',
            defaults: {
                anchor: '100%',
                labelAlign: 'right',
                allowBlank: false,
                labelWidth: 180
            },
            items: [
                {
                    xtype: 'hiddenfield',
                    name: 'id'
                },
                {
                    bind: {
                        fieldLabel: '{enName}'
                    },
                    name: 'name',
                    maxLength: 50
                }]
        }, {
            columnWidth: 0.15,
            layout: 'anchor',
            defaults: {
                anchor: '100%'
            },
            items: [
                {
                    xtype: 'language',
                    target: 'name',
                    margin:'0 0 0 10'
                }]
        }, {
            columnWidth: 0.9,
            border: false,
            layout: 'anchor',
            defaultType: 'textfield',
            defaults: {
                anchor: '100%',
                labelAlign: 'right',
                allowBlank: false,
                labelWidth: 180
            },
            items: [{
                xtype: 'language',
                target: 'value',
                margin:'0 0 0 200',
                anchor: '50%'
            }, {
                xtype: 'htmleditor',
                bind: {
                    fieldLabel: '{enValue}'
                },
                height: 150,
                maxLength: 50,
                name: 'value'

            }, {
                itemId: 'groupCode',
                bind: {
                    fieldLabel: '{groupCode}'
                },
                maxLength: 30,
                name: 'groupCode'
            }]
        }]
    }]
});
