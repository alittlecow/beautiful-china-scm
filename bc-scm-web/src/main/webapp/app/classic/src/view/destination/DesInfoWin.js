/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 目的地增修窗口
 * @author: dongjingjun
 * date: 2016-01-07
 */

Ext.define('app.view.destination.DesInfoWin', {
    extend: 'app.view.base.BaseWindow',
    xtype: 'desinfowin',
    controller: 'deswin',
    viewModel: {
        type: 'des'
    },
    width: 945,
    height: 450,
    buttons: [
        {
            xtype: 'savebtn',
            handler: 'save'
        }],
    items: [
        {
            xtype: 'form',
            // 需要多语言字段配置
            multiLanguage: ['title','desc'],
            scrollable: true,
            layout: 'column',
            padding: '5 5 5 5',
            items: [{
                columnWidth: 0.75,
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
                    xtype: 'hiddenfield',
                    name: 'id'
                }, {
                    maxLength: 30,
                    bind: {
                        fieldLabel: '{titleEnName}'
                    },
                    name: 'title'
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
                        target: 'title',
                        margin: '0 0 0 10'
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
                    labelWidth: 120
                },
                items: [{
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
                }, {
                    bind: {
                        fieldLabel: '{destination}'
                    },
                    xtype: 'combo',
                    queryMode: 'remote',
                    displayField: 'city',
                    valueField: 'cityId',
                    editable: false,
                    autoLoadOnValue: true,
                    store: {
                        type: 'hotelcitystore'
                    },
                    name: 'cityId'
                }, {
                    xtype: 'language',
                    target: 'desc',
                    margin: '0 0 0 120',
                    anchor: '30%'
                }, {
                    xtype: 'htmleditor',
                    height: 200,
                    border: true,
                    frame: true,
                    bind: {
                        fieldLabel: '{descEn}'
                    },
                    name: 'desc'
                }]
            },
                {
                    columnWidth: 0.9,
                    border: false,
                    defaults: {padding: '5 0 5 0'},
                    items: [
                        {
                            layout: 'hbox',
                            defaultType: 'filefield',
                            defaults: {
                                labelAlign: 'right',
                                msgTarget: 'side',
                                labelWidth: 120,
                                width: '77%',
                                vtype: 'image',
                                buttonConfig: {
                                    bind: {text: '{selectImg}'}
                                }
                            },
                            items: [
                                {
                                    bind: {fieldLabel: '{photo1}'},
                                    name: 'photoOne',
                                    padding: "0 10 0 0"
                                },
                                {
                                    xtype: 'button',
                                    bind: {text: '{delete}'},
                                    width: 85,
                                    listeners: {
                                        click: 'remove'
                                    }
                                }
                                , {
                                    xtype: 'tbspacer',
                                    width: 10
                                },
                                {
                                    xtype: 'button',
                                    bind: {text: '{preview}'},
                                    width: 85,
                                    listeners: {
                                        click: 'preview'
                                    }
                                }
                            ]
                        }, {
                            layout: 'hbox',
                            defaultType: 'filefield',
                            defaults: {
                                labelAlign: 'right',
                                msgTarget: 'side',
                                labelWidth: 120,
                                width: '77%',
                                vtype: 'image',
                                buttonConfig: {
                                    bind: {text: '{selectImg}'}
                                }
                            },
                            items: [
                                {
                                    bind: {fieldLabel: '{photo2}'},
                                    name: 'photoTwo',
                                    padding: "0 10 0 0"
                                },
                                {
                                    xtype: 'button',
                                    bind: {text: '{delete}'},
                                    width: 85,
                                    listeners: {
                                        click: 'remove'
                                    }
                                }
                                , {
                                    xtype: 'tbspacer',
                                    width: 10
                                },
                                {
                                    xtype: 'button',
                                    bind: {text: '{preview}'},
                                    width: 85,
                                    listeners: {
                                        click: 'preview'
                                    }
                                }
                            ]
                        }, {
                            layout: 'hbox',
                            defaultType: 'filefield',
                            defaults: {
                                labelAlign: 'right',
                                msgTarget: 'side',
                                labelWidth: 120,
                                width: '77%',
                                vtype: 'image',
                                buttonConfig: {
                                    bind: {text: '{selectImg}'}
                                }
                            },
                            items: [
                                {
                                    bind: {fieldLabel: '{photo3}'},
                                    name: 'photoThree',
                                    padding: "0 10 0 0"
                                },
                                {
                                    xtype: 'button',
                                    bind: {text: '{delete}'},
                                    width: 85,
                                    listeners: {
                                        click: 'remove'
                                    }
                                }
                                , {
                                    xtype: 'tbspacer',
                                    width: 10
                                },
                                {
                                    xtype: 'button',
                                    bind: {text: '{preview}'},
                                    width: 85,
                                    listeners: {
                                        click: 'preview'
                                    }
                                }
                            ]
                        }, {
                            layout: 'hbox',
                            defaultType: 'filefield',
                            defaults: {
                                labelAlign: 'right',
                                msgTarget: 'side',
                                labelWidth: 120,
                                width: '77%',
                                vtype: 'image',
                                buttonConfig: {
                                    bind: {text: '{selectImg}'}
                                }
                            },
                            items: [
                                {
                                    bind: {fieldLabel: '{photo4}'},
                                    name: 'photoFour',
                                    padding: "0 10 0 0"
                                },
                                {
                                    xtype: 'button',
                                    bind: {text: '{delete}'},
                                    width: 85,
                                    listeners: {
                                        click: 'remove'
                                    }
                                }
                                , {
                                    xtype: 'tbspacer',
                                    width: 10
                                },
                                {
                                    xtype: 'button',
                                    bind: {text: '{preview}'},
                                    width: 85,
                                    listeners: {
                                        click: 'preview'
                                    }
                                }
                            ]
                        }, {
                            xtype: 'displayfield',
                            bind: {value: '{displayMsg}'},
                            margin: '0 120',
                            name: 'display',
                            fieldStyle: {
                                color: '#C0B6BE'
                            }
                        }
                    ]
                }]
        }]
});