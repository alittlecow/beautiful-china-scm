/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 线路出发查询页面
 * @author: dongjingjun
 * date: 2015-12-23
 */

Ext.define('app.view.tour.TourDateQueryForm', {
    extend: 'Ext.form.Panel',
    xtype: 'tourdatequeryform',
    layout: {
        type: 'vbox',
        align: 'stretch'
    },
    height: 170,
    padding: '5 0 0 0',
    items: [{
        xtype: 'container',
        height: 130,
        layout: 'hbox',
        padding: '10 0 10 0',
        defaultType: 'container',
        items: [{//第1列
            flex: 1,
            layout: 'anchor',
            defaultType: 'textfield',
            defaults: {
                labelWidth:200,
                labelAlign: 'right',
                anchor: '100%'
            },
            items: [
                {
                    bind: {

                        fieldLabel: '{routeName}'
                    },
                    name: 'title',
                    maxLength: 50
                },

                {
                    xtype: 'combo',
                    store: "yesNo",
                    displayField: 'name',
                    valueField: 'value',
                    editable: false,
                    bind: {
                        fieldLabel: '{warning}'
                    },
                    name: 'warning'
                }
            ]
        }, {// 第2列
            flex: 1,
            layout: 'anchor',
            defaultType: 'textfield',
            defaults: {
                labelAlign: 'right',
                anchor: '97%'
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
                            xtype: 'numberfield',
                            minValue: 0,
                            bind: {
                                fieldLabel: '{remain}'
                            },
                            flex: 2,
                            name: 'remainFrom',
                            value: 0,
                            labelWidth: '50%'
                        },
                        {
                            xtype: 'displayfield',
                            value: '- - -'
                        },
                        {
                            xtype: 'numberfield',
                            minValue: 0,
                            flex: 1,
                            name: 'remainTo'
                        }
                    ]
                },
                {
                    xtype: 'container',
                    layout: 'hbox',
                    defaultType: 'textfield',
                    defaults: {
                        labelAlign: 'right'
                    },
                    items: [
                        {
                            xtype: 'numberfield',
                            minValue: 0,
                            bind: {
                                fieldLabel: '{inventory}'
                            },
                            flex: 2,
                            name: 'inventoryFrom',
                            value: 0,
                            labelWidth: '50%'
                        }, {
                            xtype: 'displayfield',
                            value: '- - -'
                        },
                        {
                            xtype: 'numberfield',
                            minValue: 0,
                            flex: 1,
                            name: 'inventoryTo'
                        }
                    ]
                },
                {
                    xtype: 'container',
                    layout: 'hbox',
                    defaultType: 'textfield',
                    defaults: {
                        labelAlign: 'right'
                    },
                    items: [
                        {
                            xtype: 'numberfield',
                            minValue: 0,
                            bind: {
                                fieldLabel: '{sales}'
                            },
                            flex: 2,
                            name: 'salesFrom',
                            value: 0,
                            labelWidth: '50%'
                        }, {
                            xtype: 'displayfield',
                            value: '- - -'
                        },
                        {
                            xtype: 'numberfield',
                            minValue: 0,
                            flex: 1,
                            name: 'salesTo'
                        }
                    ]
                }
            ]
        }]
    }, {
        xtype: 'container',
        layout: {
            type: 'hbox',
            pack: 'end',
            align: 'middle'
        },
        padding: '0 18 0 0',
        items: [{
            xtype: 'searchbtn',
            handler: 'search'
        }, {
            xtype: 'tbspacer',
            width: 10
        }, {
            xtype: 'resetbtn',
            handler: 'reset'
        }]
    }]
});
