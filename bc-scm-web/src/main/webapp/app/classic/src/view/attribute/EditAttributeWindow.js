/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 属性编辑窗口
 * @author: fengbaitong
 * date: 2015-12-15
 */
Ext.define('app.view.attribute.EditAttributeWindow', {
    extend: 'app.view.base.BaseWindow',
    xtype:'editattributewindow',
    controller:'attributewin',
    viewModel: {
        type: 'attribute'
    },
    width:555,
    height:300,
    buttons:[{
        xtype:'savebtn',
        handler:'editAttribute'
    }],
    items:[{
        xtype: 'form',
        layout: {
            type: 'vbox',
            align: 'stretch'
        },
        padding: '5 5 5 5',
        items: [{
            border: false,
            layout: 'anchor',
            defaultType: 'textfield',
            defaults: {
                anchor: '90%',
                labelAlign: 'right',
                labelWidth: 200
            },
            items:[{
                name:'attributeId',
                hidden:true
            },{
                bind:{
                    fieldLabel:'{category}'
                },
                name: 'categoryNameEn',
                readOnly:true
            },{
                bind:{
                    fieldLabel:'{attributeNameEn}'
                },
                name: 'attributeNameEn',
                allowBlank: false,
                maxLength: 100
            },{
                bind:{
                    fieldLabel:'{attributeNameFr}'
                },
                name: 'attributeNameFr',
                allowBlank: false,
                maxLength: 100
            },{
                bind:{
                    fieldLabel:'{sort}'
                },
                name: 'sort',
                allowBlank: false,
                xtype: 'numberfield',
                minValue: 0,
                allowDecimals: false
            }]
        }]
    }]
});