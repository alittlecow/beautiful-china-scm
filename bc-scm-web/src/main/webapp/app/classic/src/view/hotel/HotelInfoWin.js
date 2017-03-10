/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 酒店管理增改窗口
 * @author: dongjingjun
 * date: 2016-01-03
 */

Ext.define('app.view.hotel.HotelInfoWin', {
    extend: 'app.view.base.BaseWindow',
    xtype: 'hotelinfowin',
    controller: 'hotelwin',
    viewModel: {
        type: 'hotel'
    },
    width: 835,
    height: 395,
    buttons: [
        {
            xtype: 'savebtn',
            handler: 'save'
        }
    ],
    items: [
        {
            xtype: 'form',
            autoScroll: true,
            layout: 'column',
            padding: '5 5 5 5',
            items: [
                {
                    columnWidth: 0.45,
                    border: false,
                    layout: 'anchor',
                    defaultType: 'textfield',
                    defaults: {
                        anchor: '100%',
                        labelAlign: 'right',
                        allowBlank: false,
                        labelWidth: 200,
                        maxLength: 30
                    },
                    items: [
                        {
                            xtype: 'hiddenfield',
                            name: 'id'
                        },
                        {
                            bind: {
                                fieldLabel: '{hotelNameEn}'
                            },
                            name: 'hotelNameEn'
                        },
                        {
                            bind: {
                                fieldLabel: '{hotelNameFr}'
                            },
                            name: 'hotelNameFr'
                        },
                        {
                            bind: {
                                store: '{hotelSupStore}',
                                fieldLabel: '{supDeptCode}'
                            },
                            xtype: 'combo',
                            autoLoadOnValue: true,
                            displayField: 'supName',
                            valueField: 'deptCode',
                            editable: false,
                            name: 'supDeptCode'
                        },
                        //{
                        //    bind: {
                        //        store: '{hotelStarStore}',
                        //        fieldLabel: '酒店星级'
                        //    },
                        //    xtype: 'combo',
                        //    displayField: 'star',
                        //    valueField: 'id',
                        //    editable: false,
                        //    name: 'hotelStar'
                        //},
                        //{
                        //    bind: {
                        //        store: '{hotelTypeStore}',
                        //        fieldLabel: '酒店类型'
                        //    },
                        //    xtype: 'combo',
                        //    displayField: 'type',
                        //    valueField: 'id',
                        //    editable: false,
                        //    name: 'hotelTypeEn'
                        //},
                        {
                            bind: {
                                fieldLabel: '{hotelTel}'
                            },
                            name: 'hotelTel',
                            regex: /^((\d{3,4}-)*\d{7,8}(-\d{3,4})*|13\d{9})$/
                        }
                    ]
                }, {
                    columnWidth: 0.45,
                    padding: '0 0 0 5',
                    border: false,
                    layout: 'anchor',
                    defaultType: 'textfield',
                    defaults: {
                        anchor: '100%',
                        allowBlank: false,
                        labelAlign: 'right',
                        labelWidth: 200,
                        maxLength: 30
                    },
                    items: [
                        {
                            bind: {
                                fieldLabel: '{hotelNameCn}'
                            },
                            name: 'hotelNameCn'
                        },
                        {
                            bind: {
                                store: '{hotelCityStore}',
                                fieldLabel: '{cityName}'
                            },
                            xtype: 'combo',
                            displayField: 'city',
                            autoLoadOnValue: true,
                            valueField: 'cityId',
                            editable: false,
                            name: 'cityId'
                        },
                        {
                            bind: {
                                fieldLabel: '{status}'
                            },
                            xtype: 'combo',
                            store: "normalStop",
                            displayField: 'name',
                            valueField: 'value',
                            queryMode: 'local',
                            editable: false,
                            value: 'N',
                            name: 'status'
                        },
                        {
                            bind: {
                                fieldLabel: '{hotelFax}'
                            },
                            name: 'hotelFax'
                        }
                    ]
                },
                {
                    columnWidth: 0.9,
                    border: false,
                    layout: 'anchor',
                    defaultType: 'textareafield',
                    defaults: {
                        anchor: '100%',
                        labelAlign: 'right',
                        allowBlank: false,
                        labelWidth: 200,
                        maxLength: 50
                    },
                    items: [
                        {
                            bind: {
                                fieldLabel: '{addressCn}'
                            },
                            name: 'addressCn'
                        },
                        {
                            bind: {
                                fieldLabel: '{addressEn}'
                            },
                            name: 'addressEn'
                        },
                        {
                            bind: {
                                fieldLabel: '{addressFr}'
                            },
                            name: 'addressFr'
                        }
                    ]
                },
                {
                    columnWidth: 0.9,
                    border: false,
                    layout: 'anchor',
                    defaultType: 'textareafield',
                    defaults: {
                        labelAlign: 'right',
                        anchor: '100%',
                        labelWidth: 200,
                        maxLength: 50

                    },
                    items: [
                        {
                            bind: {
                                fieldLabel: '{descEn}'
                            },
                            name: 'descEn'
                        },
                        {
                            bind: {
                                fieldLabel: '{descFr}'
                            },
                            name: 'descFr'
                        }
                    ]
                }]
        }]
});