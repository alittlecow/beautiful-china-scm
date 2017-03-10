/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 * @author: dongjingjun
 * date: 2016-03-06
 */
Ext.define('app.view.display.DisplayThemeWin', {
    extend: 'app.view.base.BaseWindow',
    xtype: 'displaythemewin',
    controller: 'displaythemewin',
    viewModel: {
        type: 'display'
    },
    width: 445,
    height: 385,
    buttons: [{
        xtype: 'savebtn',
        handler: 'saveThemeImage'
    }],
    items: [{
        xtype: 'form',
        layout: 'column',
        padding: '5 5 5 5',
        items: [{
            columnWidth: 0.9,
            border: false,
            layout: 'anchor',
            defaults: {
                anchor: '100%',
                labelAlign: 'right',
                allowBlank: false,
                labelWidth: 100
            },
            items: [{
                xtype: 'combo',
                bind: {
                    store: '{tourThemeStore}',
                    fieldLabel: '{theme}'
                },
                displayField: 'name',
                valueField: 'id',
                editable: false,
                name: 'theme'
            }]
        }, {
            columnWidth: 0.9,
            xtype: 'form',
            layout: 'anchor',
            style: {
                'margin-bottom': '20px'
            },
            defaults: {
                anchor: '100%'
            },
            items: [{
                xtype: 'filefield',
                vtype: 'image',
                listeners: {
                    change: 'uploadImage'
                },
                bind:{fieldLabel: '{image}'},
                name: 'image',
                labelAlign: 'right',
                labelWidth: 100,
                buttonConfig: {
                    iconCls: 'x-fa fa-photo',
                    bind: {text: 'selectImg'}
                }
            }]

        }, {
            columnWidth: 0.9,
            layout: 'column',
            padding:'0 0 0 90',
            xtype: 'container',
            itemId: 'imagesBox',
            defaultType: 'image',
            defaults: {
                width: 260,
                height: 170
            }
        }]
    }]
});