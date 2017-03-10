/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 增加新的属性窗口
 * @author: fengbaitong
 * date: 2015-12-15
 */
Ext.define('app.view.attribute.AddAttributeWindow', {
    extend: 'app.view.base.BaseWindow',
    xtype:'addattributewindow',
    controller:'attributewin',
    viewModel: {
        type: 'attribute'
    },
    width:555,
    height:300,
    buttons:[{
        xtype:'savebtn',
        handler:'saveAttribute'
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
                name:'id',
                hidden:true
            },{
                bind:{
                    fieldLabel:'{category}'
                },
                name: 'text',
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