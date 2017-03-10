/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 * @author: chengxuemin
 * date: 2016-01-18
 */

/**
 * 咨询投诉管理查询页面
 */
Ext.define('app.view.consulting.ConsultingQueryForm', {
    extend: 'Ext.form.Panel',
    xtype: 'consultingqueryform',
    viewModel: {
        type: 'consulting'
    },
    layout: {
        type: 'vbox',
        align: 'stretch'
    },
    height: 135,
    padding: '5 0 0 0',
    items:[{
            xtype: 'container',
            layout: 'hbox',
            padding: '10 10 10 10',
            defaultType: 'textfield',
            defaults: {
                labelAlign: 'top'
            },
            items: [
                {
                    flex:1,
                    padding: '0 20 0 10',
                    bind:{
                        fieldLabel:'{typeCon}'
                    },
                    xtype:'combo',
                    store:Ext.create('Ext.data.Store', {
                        fields: ['value', 'name'],
                        data : [
                            //咨询
                            {"value":"A", "name":"advisory"},
                            //投诉
                            {"value":"C", "name":"complain"}
                        ]
                    }),
                    displayField: 'name',
                    valueField: 'value',
                    editable: false,
                    name: 'type'
                },{
                    flex:1,
                    padding: '0 20 0 10',
                    bind:{
                        fieldLabel:'{status}'
                    },
                    xtype:'combo',
                    store:Ext.create('Ext.data.Store', {
                        fields: ['value', 'name'],
                        data : [
                            //未处理
                            {"value":"N", "name":"untreated"},
                            //处理完成，关闭
                            {"value":"S", "name":"treated"}
                        ]
                    }),
                    displayField: 'name',
                    valueField: 'value',
                    editable: false,
                    name: 'status'
                }, {
                    flex:2,
                    //padding: '0 0 0 10',
                    xtype: 'container',
                    layout: 'hbox',
                    defaultType: 'textfield',
                    defaults: {
                        labelAlign: 'top'
                    },
                    items: [
                        {
                            xtype: 'datefield',
                            editable: false,
                            format: 'Y-m-d',
                            bind: {
                                fieldLabel: '{submitTime}'
                            },
                            name: 'submitTime'
                        }, {
                            xtype: 'displayfield',
                            value: '- - -',
                            padding:'27 0 0 0'
                        },
                        {
                            xtype: 'datefield',
                            editable: false,
                            format: 'Y-m-d',
                            name: 'submitTime',
                            padding:'29 10 0 0'
                        }
                    ]
                }]
            },{
        xtype:'searchreset'
    }]
});