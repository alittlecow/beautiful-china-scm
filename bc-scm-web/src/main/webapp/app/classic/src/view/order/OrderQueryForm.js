/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 * @author: zhuhoufeng
 * date: 2016-01-20
 */


/**
 * 订单管理查询页面
 */
Ext.define('app.view.order.OrderQueryForm', {
    extend: 'Ext.form.Panel',
    xtype: 'orderqueryform',
    viewModel: {
        type: 'order'
    },
    layout: {
        type: 'vbox',
        align: 'stretch'
    },
    height: 100,
    padding: '5 0 0 0',
    items: [{
        xtype: 'container',
        height: 60,
        layout: 'hbox',
        padding: '10 0 10 0',
        defaultType: 'container',
        items: [{
            flex:1,
            layout: 'anchor',
            defaultType: 'textfield',
            defaults:{
                labelAlign:'right',
                anchor:'100%',
                labelWidth:120
            },
            items: [{
                bind: {
                    fieldLabel:'{ordOrderNo}'
                },
                name:'orderNo'
            }]
        },{
            flex:1,
            layout: 'anchor',
            defaultType: 'textfield',
            defaults:{
                labelAlign:'right',
                anchor:'100%',
                labelWidth:120
            },
            items: [{
                bind: {
                    fieldLabel:'{ordState}'
                },
                xtype:'combo',
                name: 'state',
                store: 'orderStatus',
                displayField: 'name',
                valueField: 'value'
            }]
        },{
            flex:2,
            layout: 'anchor',
            defaultType: 'textfield',
            defaults:{
                labelAlign:'right',
                anchor:'95%'
            },
            items: [
                {
                    xtype: 'container',
                    layout: 'hbox',
                    defaultType: 'textfield',
                    defaults: {
                        labelAlign: 'right'
                    },
                    items: [
                        {
                            xtype: 'datefield',
                            format:'Y-m-d',
                            bind: {
                                fieldLabel: '{ordPlacedTime}'
                            },
                            flex: 2,
                            name: 'placedFrom',
                            labelWidth: '50%'
                        },
                        {
                            xtype: 'displayfield',
                            value: '- - -'
                        },
                        {
                            xtype: 'datefield',
                            format:'Y-m-d',
                            flex: 1,
                            name: 'placedTo'
                        }
                    ]
                }
            ]
        }]
    },{
        xtype:'searchreset'
    }]
});