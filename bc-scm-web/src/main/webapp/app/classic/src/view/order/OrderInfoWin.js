/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 * @author: zhuhoufeng
 * date: 2016-01-20
 */


/**
 * 订单管理窗口
 */
Ext.define('app.view.order.OrderInfoWin', {
    extend: 'app.view.base.BaseWindow',
    xtype: 'orderinfowin',
    controller: 'orderwin',
    viewModel: {
        type: 'order'
    },
    width: 900,
    height: 450,
    buttons: [{
        xtype: 'savebtn',
        handler: 'save'
    }],
    items: [{
        xtype: 'form',
        layout: 'column',
        autoScroll: true,
        padding: '5 5 5 5',
        items: [
            {
                columnWidth: 0.9,
                border: false,
                layout: 'anchor',
                defaults: {
                    anchor: '100%'
                },
                items: [
                    {
                        xtype: 'panel',
                        margin: '0 0 10 50',
                        header: {
                            hidden: true
                        },
                        items: [
                            {
                                xtype: 'fieldset',
                                bind: {title: '{orderDetail}'},
                                collapsible: true,
                                style: {
                                    backgroundColor: 'white'
                                },
                                items: [{
                                    border: false,
                                    layout: 'column',
                                    defaultType: 'textfield',
                                    defaults: {
                                        padding: '5 5 5 5',
                                        labelWidth: 150,
                                        columnWidth: 0.5,
                                        labelAlign: 'right'
                                    },
                                    items: [{
                                        xtype: 'hiddenfield',
                                        name: 'userId'
                                    }, {
                                        xtype: 'hiddenfield',
                                        name: 'tourId',
                                        id:'ordTourId'
                                    },{
                                        bind: {
                                            fieldLabel: '{ordOrderNo}'
                                        },
                                        name: 'orderNo',
                                        id:'ordOrderNo',
                                        editable: false
                                    }, {
                                        bind: {
                                            fieldLabel: '{ordState}'
                                        },
                                        xtype: 'combo',
                                        autoLoad: true,
                                        readOnly: true,
                                        name: 'state',
                                        store: 'orderStatus',
                                        displayField: 'name',
                                        valueField: 'value',
                                        editable: false
                                    }, {
                                        bind: {
                                            fieldLabel: '{ordTourName}'
                                        },
                                        name: 'tourName',
                                        editable: false
                                    }, {
                                        bind: {
                                            fieldLabel: '{ordContact}'
                                        },
                                        name: 'contact'
                                    }, {
                                        bind: {
                                            fieldLabel: '{ordEmail}'
                                        },
                                        vtype: 'email',
                                        name: 'email'
                                    }, {
                                        bind: {
                                            fieldLabel: '{ordAdults}'
                                        },
                                        xtype: 'numberfield',
                                        minValue: 0,
                                        name: 'adults'
                                    }, {
                                        bind: {
                                            fieldLabel: '{ordDeparture}'
                                        },
                                        xtype: 'datefield',
                                        format: 'Y-m-d H:i:s',
                                        name: 'departure'
                                    }, {
                                        bind: {
                                            fieldLabel: '{ordUserName}'
                                        },
                                        name: 'userName',
                                        editable: false
                                    }, {
                                        bind: {
                                            fieldLabel: '{ordPlacedTime}'
                                        },
                                        xtype: 'datefield',
                                        format: 'Y-m-d H:i:s',
                                        name: 'placedTime'
                                    }, {
                                        bind: {
                                            fieldLabel: '{ordTotal}'
                                        },
                                        xtype: 'numberfield',
                                        minValue: 0,
                                        name: 'total',
                                        id:'ordTotal'
                                    }, {
                                        bind: {
                                            fieldLabel: '{ordTelephone}'
                                        },
                                        //vtype:'telephone',
                                        name: 'telephone'
                                    }, {
                                        bind: {
                                            fieldLabel: '{ordRoom}'
                                        },
                                        xtype: 'numberfield',
                                        minValue: 0,
                                        name: 'room'
                                    }, {
                                        bind: {
                                            fieldLabel: '{ordChildren}'
                                        },
                                        xtype: 'numberfield',
                                        minValue: 0,
                                        name: 'children'
                                    }]
                                }
                                ]
                            }]
                    }]
            }, {
                columnWidth: 0.9,
                border: false,
                layout: 'anchor',
                defaults: {
                    anchor: '100%',
                    labelAlign: 'right',
                    labelWidth: 150
                },
                margin: '0 0 10 50',
                items: [{
                    xtype: 'orderoptiongrid',
                    frame: true
                }]
            }]
    }]
});