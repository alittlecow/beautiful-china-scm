/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 * @author: chengxuemin
 * date: 2015-12-22
 */

/**
 * 城市管理窗口
 */
Ext.define('app.view.city.CityInfoWin', {
    extend: 'app.view.base.BaseWindow',
    xtype: 'cityinfowin',
    controller:'citywin',
    viewModel: {
        type: 'city'
    },
    width: 890,
    height: 500,
    buttons: [{
        xtype:'savebtn',
        handler:'save'
    }],
    items:[{
        xtype:'form',
        scrollable: true,
        layout:'column',
        padding:'5 5 5 5',
        items: [{
            columnWidth: 0.9,
            border: false,
            items: [{
                border: false,
                layout: 'anchor',
                defaultType: 'textfield',
                defaults:{
                    anchor:'100%',
                    labelAlign:'right',
                    padding: '5 0 5 0',
                    allowBlank: false,
                    labelWidth:150
            },
                items: [{
                    xtype: 'hiddenfield',
                    name: 'cityId'
                },{
                    bind:{
                        fieldLabel:'{cityNameEn}'
                    },
                    name: 'cityNameEn',
                    maxLength: 100
                },{
                    bind:{
                        fieldLabel:'{cityNameFr}'
                    },
                    name: 'cityNameFr',
                    maxLength: 100
                }]
            },{
                columnWidth: 0.9,
                border: false,
                layout: 'anchor',
                defaultType: 'htmleditor',
                defaults: {
                    labelAlign: 'right',
                    anchor: '100%',
                    labelWidth: 150,
                    height: 200,
                    //maxWidth: 750,
                    border: true,
                    frame: true
                },
                items: [{
                    bind: {
                        fieldLabel: '{cityDescEn}'
                    },
                    name: 'descEn'
                }, {
                    bind: {
                        fieldLabel: '{cityDescFr}'
                    },
                    name: 'descFr'
                }]
            },
                {
                    layout: 'hbox',
                    defaultType: 'filefield',
                    padding: '10 10 10 0',
                    defaults: {
                        msgTarget: 'side',
                        // padding:'10 10 10 10',
                        width: '77%',
                        labelAlign: 'right',
                        labelWidth: 150,
                        vtype: 'image',
                        buttonConfig: {
                            iconCls: 'x-fa fa-photo',
                            bind: {text: '{browse}'}
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
                            //iconCls: 'x-fa fa-remove',
                            width: 85,
                            listeners: {
                                click: 'remove'
                            }
                        },
                        {
                            xtype: 'tbspacer',
                            width: 10
                        },
                        {
                            xtype: 'button',
                            bind: {text: '{preview}'},
                            itemId: 'photoOne',
                            //iconCls:'x-fa fa-search',
                            width: 75,
                            listeners: {
                                click: 'preview'
                            }
                        }
                    ]
                }, {
                    layout: 'hbox',
                    defaultType: 'filefield',
                    padding: '10 10 10 0',
                    defaults: {
                        msgTarget: 'side',
                        labelAlign: 'right',
                        labelWidth: 150,
                        width: '77%',
                        vtype: 'image',
                        buttonConfig: {
                            iconCls: 'x-fa fa-photo',
                            bind: {text: '{browse}'}
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
                            //iconCls: 'x-fa fa-remove',
                            width: 85,
                            listeners: {
                                click: 'remove'
                            }
                        },
                        {
                            xtype: 'tbspacer',
                            width: 10
                        },
                        {
                            xtype: 'button',
                            bind: {text: '{preview}'},
                            // itemId: 'photoTwo',
                            //iconCls:'x-fa fa-search',
                            width: 75,
                            listeners: {
                                click: 'preview'
                            }
                        }
                    ]
                }, {
                    layout: 'hbox',
                    defaultType: 'filefield',
                    padding: '10 10 10 0',
                    defaults: {
                        msgTarget: 'side',
                        labelAlign: 'right',
                        labelWidth: 150,
                        width: '77%',
                        vtype: 'image',
                        buttonConfig: {
                            iconCls: 'x-fa fa-photo',
                            bind: {text: '{browse}'}
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
                            //iconCls: 'x-fa fa-remove',
                            width: 85,
                            listeners: {
                                click: 'remove'
                            }
                        },
                        {
                            xtype: 'tbspacer',
                            width: 10
                        },
                        {
                            xtype: 'button',
                            bind: {text: '{preview}'},
                            //iconCls:'x-fa fa-search',
                            width: 75,
                            listeners: {
                                click: 'preview'
                            }
                        }
                    ]
                }, {
                    layout: 'hbox',
                    defaultType: 'filefield',
                    padding: '10 10 10 0',
                    defaults: {
                        msgTarget: 'side',
                        labelAlign: 'right',
                        labelWidth: 150,
                        width: '77%',
                        vtype: 'image',
                        buttonConfig: {
                            iconCls: 'x-fa fa-photo',
                            bind: {text: '{browse}'}
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
                            //iconCls: 'x-fa fa-remove',
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
                            itemId: 'photoFour',
                            //iconCls:'x-fa fa-search',
                            width: 75,
                            listeners: {
                                click: 'preview'
                            }
                        }
                    ]
                }, {
                    xtype: 'displayfield',
                    bind: {value: '{displayMsg}'},
                    margin: '0 150',
                    fieldStyle: {
                        color: '#C0B6BE'
                    }
                }]
        }]
    }]
});