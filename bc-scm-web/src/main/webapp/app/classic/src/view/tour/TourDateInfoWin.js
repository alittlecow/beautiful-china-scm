/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 线路出发管理添加窗口
 * @author: dongjingjun
 * date: 2015-12-23
 */

Ext.define('app.view.tour.TourDateInfoWin', {
    extend: 'app.view.base.BaseWindow',
    xtype: 'tourdateinfowin',
    controller: 'tourdatewin',
    viewModel: {
        type: 'tour'
    },
    width: 625,
    height: 560,
    buttons: [{
        xtype: 'savebtn',
        handler: 'saveTourDate'
    }],
    items: [
        {
            xtype: 'form',
            layout: 'column',
            autoScroll: true,
            padding: '5 0 5 0',
            items: [
                //{
                //    columnWidth: 0.9,
                //    border: false,
                //    layout: 'anchor',
                //    defaultType: 'textfield',
                //    defaults: {
                //        anchor: '100%',
                //        labelAlign: 'right',
                //        allowBlank: false,
                //        labelWidth: 120
                //    },
                //    items: [
                //        {
                //            xtype: 'combo',
                //            bind: {
                //                fieldLabel: '路线名',
                //                store: '{titleStore}'
                //            },
                //            displayField: 'titleEn',
                //            valueField: 'id',
                //            editable: false,
                //            //queryMode: 'local',
                //            name: 'code'
                //        }
                //
                //    ]
                //},
                {
                    columnWidth: 0.45,
                    border: false,
                    layout: 'anchor',
                    defaultType: 'textfield',
                    defaults: {
                        anchor: '100%',
                        labelAlign: 'right',
                        allowBlank: false,
                        labelWidth: 120
                    },
                    items: [
                        {
                            xtype: 'datefield',
                            editable: false,
                            format: 'Y-m-d',
                            bind: {
                                fieldLabel: '{startTime}'
                            },
                            name: 'startTime',
                            minValue: new Date()
                        }]
                },
                {
                    columnWidth: 0.45,
                    border: false,
                    layout: 'anchor',
                    defaultType: 'textfield',
                    defaults: {
                        anchor: '100%',
                        labelAlign: 'right',
                        allowBlank: false,
                        labelWidth: 120
                    },
                    items: [{
                        xtype: 'datefield',
                        editable: false,
                        format: 'Y-m-d',
                        bind: {
                            fieldLabel: '{endTime}'
                        },
                        name: 'endTime',
                        minValue: new Date()
                    }]
                },
                {
                    columnWidth: 0.9,
                    border: false,
                    layout: 'anchor',
                    defaultType: 'textfield',
                    defaults: {
                        anchor: '100%',
                        labelAlign: 'right',
                        allowBlank: false,
                        labelWidth: 120
                    },
                    items: [
                        {
                            xtype: 'checkboxgroup',
                            bind: {
                                fieldLabel: '{types}'
                            },
                            defaultType: 'radio',
                            defaults: {
                                //boxLabelAlign: 'after',
                                margin: '0 15 0 0',
                                name: 'type',
                                listeners: {
                                    focus: 'checkdate'
                                }
                            },
                            layout: {
                                type: 'column'
                            },
                            items: [
                                {
                                    bind: {boxLabel: '{byday}'},
                                    itemId: 'day',
                                    checked: true,
                                    inputValue: 'day'
                                },
                                {
                                    bind: {boxLabel: '{week}'},
                                    itemId: 'week',
                                    inputValue: 'week'
                                },
                                {
                                    bind: {boxLabel: '{month}'},
                                    itemId: 'month',
                                    inputValue: 'month'
                                }
                            ]
                        },
                        {
                            xtype: 'checkboxgroup',
                            itemId: 'checkbox',
                            hidden: true,
                            allowBlank: true,
                            bind: {
                                fieldLabel: '{date}'
                            },
                            defaultType: 'checkboxfield',
                            defaults: {
                                margin: '0 25 0 0',
                                width: '10%',
                                name: 'dateIndex'
                            },
                            layout: {
                                type: 'column',
                                align: 'left'
                            }
                        },
                        {
                            bind: {
                                fieldLabel: '{price}'
                            },
                            xtype: 'numberfield',
                            minValue: 0,
                            name: 'price'
                        },
                        {
                            xtype: 'numberfield',
                            bind: {
                                fieldLabel: '{inventory}'
                            },
                            minValue: 0,
                            allowDecimals: false,
                            name: 'inventory'
                        },
                        {
                            xtype: 'numberfield',
                            bind: {
                                fieldLabel: '{warn}'
                            },
                            minValue: 0,
                            allowDecimals: false,
                            name: 'warn'
                        }]
                }
            ]
        }
    ]
});