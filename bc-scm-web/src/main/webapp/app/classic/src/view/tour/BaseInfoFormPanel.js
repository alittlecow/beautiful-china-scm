/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 * @author: dongjingjun
 * date: 2015-12-25
 */
/**
 * 旅游线路管理窗口
 */
Ext.define('app.view.tour.BaseInfoFormPanel', {
    extend: 'Ext.form.Panel',
    xtype: 'baseinfoformpanel',
    layout: 'column',
    padding: '5 5 5 5',
    autoScroll: true,
    tbar: [{
        xtype: 'savebtn',
        handler: 'saveBaseInfo'
    }],
    listeners: {
        render: 'loadForm'
    },
    items: [{
        columnWidth: 0.45,
        border: false,
        layout: 'anchor',
        defaultType: 'textfield',
        defaults: {
            anchor: '100%',
            labelAlign: 'right',
            allowBlank: false,
            labelWidth: 200,
            maxLength: 50
        },
        items: [
            {
                xtype: 'hiddenfield',
                name: 'id'
            }, {
                bind: {fieldLabel: '{code}'},
                name: 'code'
            }, {
                bind: {fieldLabel: '{titleEn}'},
                name: 'titleEn'
            }, {
                bind: {fieldLabel: '{subTitleEn}'},
                name: 'subTitleEn'
            }, {
                xtype: 'numberfield',
                allowDecimals: false,
                minValue: 0,
                bind: {fieldLabel: '{day}'},
                name: 'days'
            }, {
                xtype: 'combo',
                store: "normalStop",
                displayField: 'name',
                valueField: 'value',
                editable: false,
                value: 'N',
                bind: {fieldLabel: '{status}'},
                name: 'status'
            }, {
                xtype: 'combo',
                queryMode: 'remote',
                displayField: 'city',
                valueField: 'cityId',
                editable: false,
                autoLoadOnValue: true,
                store: {
                    type: 'hotelcitystore'
                },
                bind: {
                    fieldLabel: '{startCity}'
                },
                name: 'startCity'
            }]
    }, {
        columnWidth: 0.45,
        border: false,
        layout: 'anchor',
        defaultType: 'textfield',
        defaults: {
            anchor: '100%',
            allowBlank: false,
            labelAlign: 'right',
            labelWidth: 200,
            maxLength: 50
        },
        items: [{
            xtype: 'combo',
            bind: {
                store: '{tourThemeStore}',
                fieldLabel: '{theme}'
            },
            displayField: 'name',
            autoLoadOnValue: true,
            valueField: 'id',
            editable: false,
            name: 'theme'
        }, {
            bind: {fieldLabel: '{titleFr}'},
            name: 'titleFr'
        }, {
            bind: {fieldLabel: '{subTitleFr}'},
            name: 'subTitleFr'
        }, {
            xtype: 'numberfield',
            allowDecimals: false,
            minValue: 0,
            bind: {fieldLabel: '{advanceDays}'},
            name: 'advanceDays'
        },
            {
                xtype: 'numberfield',
                allowDecimals: false,
                minValue: 0,
                maxValue: 5,
                bind: {fieldLabel: '{rating}'},
                name: 'rating'
            }, {
                xtype: 'combo',
                queryMode: 'remote',
                displayField: 'city',
                valueField: 'cityId',
                editable: false,
                autoLoadOnValue: true,
                store: {
                    type: 'hotelcitystore'
                },
                bind: {
                    fieldLabel: '{endCity}'
                },
                name: 'endCity'
            }]
    },
        {
            columnWidth: 0.9,
            padding: '0 0 10 0',
            xtype: 'tagfield',
            labelWidth: 200,
            labelAlign: 'right',
            bind: {fieldLabel: '{wayCity}'},
            store: {
                type: 'hotelcitystore'
            },
            displayField: 'city',
            valueField: 'cityId',
            filterPickList: true,
            publishes: 'value',
            name: 'wayCity'
        }, {
            columnWidth: 0.9,
            padding: '0 0 10 0',
            xtype: 'tagfield',
            labelWidth: 200,
            labelAlign: 'right',
            bind: {fieldLabel: '{destination}'},
            store: {
                type: 'sightsdescitystore'
            },
            displayField: 'cityNameEn',
            valueField: 'desCityId',
            filterPickList: true,
            publishes: 'value',
            name: 'destination'
        },
        {
            columnWidth: 0.9,
            border: false,
            layout: 'anchor',
            defaultType: 'panel',
            defaults: {
                anchor: '100%',
                margin: '0 0 10 150',
                header: {
                    hidden: true
                },
                buttons: [{
                    bind: {text: '{add}'},
                    handler: 'addContainer'
                }, {
                    bind: {text: '{delete}'},
                    handler: 'deleteContainer'
                }]
            },
            items: [
                {
                    items: [
                        {
                            xtype: 'fieldset',
                            itemId: 'include',
                            bind: {title: '{include}'},
                            collapsible: true,
                            defaults: {
                                labelWidth: 90,
                                anchor: '100%',
                                layout: 'hbox'
                            }
                        }
                    ]
                },
                {
                    items: [
                        {
                            xtype: 'fieldset',
                            itemId: 'exclude',
                            bind: {title: '{exclude}'},
                            collapsible: true,
                            defaults: {
                                labelWidth: 90,
                                anchor: '100%',
                                layout: 'hbox'
                            }
                        }
                    ]
                }, {
                    items: [
                        {
                            xtype: 'fieldset',
                            itemId: 'desc',
                            bind: {title: '{desc}'},
                            collapsible: true,
                            defaults: {
                                labelWidth: 90,
                                anchor: '100%',
                                layout: 'hbox'
                            }
                        }
                    ]
                }, {
                    items: [
                        {
                            xtype: 'fieldset',
                            itemId: 'important',
                            bind: {title: '{important}'},
                            collapsible: true,
                            defaults: {
                                labelWidth: 90,
                                anchor: '100%',
                                layout: 'hbox'
                            }
                        }
                    ]
                }, {
                    items: [
                        {
                            xtype: 'fieldset',
                            itemId: 'triphint',
                            bind: {title: '{triphint}'},
                            collapsible: true,
                            defaults: {
                                labelWidth: 90,
                                anchor: '100%',
                                layout: 'hbox'
                            }
                        }
                    ]
                }, {
                    items: [
                        {
                            xtype: 'fieldset',
                            itemId: 'term',
                            bind: {title: '{term}'},
                            collapsible: true,
                            defaults: {
                                labelWidth: 90,
                                anchor: '100%',
                                layout: 'hbox'
                            }
                        }
                    ]
                }
            ]
        }]
});