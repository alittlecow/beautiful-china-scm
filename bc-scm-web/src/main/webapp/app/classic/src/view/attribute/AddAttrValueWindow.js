/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 增加新的属性值窗口
 * @author: fengbaitong
 * date: 2015-12-15
 */
Ext.define('app.view.attribute.AddAttrValueWindow', {
    extend: 'app.view.base.BaseWindow',
    xtype:'addattrvaluewindow',
    controller:'attributewin',
    viewModel: {
        type: 'attribute'
    },
    width:445,
    height:300,
    buttons:[{
        xtype:'savebtn',
        handler:'saveAttrValue'
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
                name: 'id',
                hidden:true
            },{
                name: 'attrId',
                hidden:true
            },{
                bind:{
                    fieldLabel:'{attributeValueEn}'
                },
                name: 'valueEn',
                allowBlank: false,
                maxLength: 100
            },{
                bind:{
                    fieldLabel:'{attributeValueFr}'
                },
                name: 'valueFr',
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