/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 景点管理窗口
 * @author: dongjingjun
 * date: 2016-01-05
 */

Ext.define('app.view.sights.SightsInfoWin', {
    extend: 'app.view.base.BaseWindow',
    xtype: 'sightsinfowin',
    controller: 'sightswin',
    viewModel: {
        type: 'sights'
    },
    width: 780,
    height: 450,
    buttons: [{
        xtype: 'savebtn',
        handler: 'save'
    }],
    items: [
        {
            xtype: 'form',
            autoScroll: true,
            layout: 'column',
            padding: '5 20 5 20',
            items: [
                {
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
                    items: [
                        {xtype: 'hiddenfield', name: 'id'},
                        {
                            name: 'cityId',
                            xtype: 'combo',
                            bind: {
                                fieldLabel: '{destination}'
                            },
                            store: {
                                type: 'sightsdescitystore'
                            },
                            displayField: 'cityNameEn',
                            valueField: 'desCityId',
                            pageSize: 3,
                            minChars: 1,
                            queryMode: 'remote',
                            autoLoadOnValue: true,
                            editable: false
                        },
                        {
                            bind: {fieldLabel: '{sightsNameEn}'},
                            name: 'nameEn',
                            maxLength: 50
                        },
                        {
                            bind: {fieldLabel: '{sightsNameFr}'},
                            name: 'nameFr',
                            maxLength: 50
                        },
                        {
                            bind: {fieldLabel: '{price}'},
                            name: 'price',
                            xtype: 'numberfield',
                            minValue: 0
                        },
                        {
                            bind: {fieldLabel: '{descEn}'},
                            name: 'descEn',
                            xtype: 'htmleditor',
                            height: 200,
                            maxWidth: 670,
                            border: true,
                            frame: true
                        },
                        {
                            bind: {fieldLabel: '{descFr}'},
                            name: 'descFr',
                            xtype: 'htmleditor',
                            height: 200,
                            maxWidth: 670,
                            border: true,
                            frame: true
                        }
                    ]
                }
            ]
        }
    ]
});