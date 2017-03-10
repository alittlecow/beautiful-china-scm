/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 属性管理查询页面
 * @author: fengbaitong
 * date: 2015-12-28
 */
Ext.define('app.view.attribute.AttributeQueryForm', {
    extend: 'Ext.form.Panel',
    xtype: 'attributequeryform',
    layout: {
        type: 'vbox',
        align: 'stretch'
    },
    height:95,
    padding:'5 0 0 0',
    items: [{
        xtype: 'container',
       // height:60,
        defaultType: 'container',
        padding: '10 0 0 0',
        items: [{
            flex:1,
            layout: 'anchor',
            defaultType: 'textfield',
            defaults:{
                labelAlign:'right',
                anchor:'33%'
            },
            items: [{
                layout:'anchor',
                bind:{
                    fieldLabel:'{attributeName}'
                },
                name: 'attributeNameEn',
                labelWidth:150,
                maxLength: 100
            },{
                name:'categoryId',
                hidden:true
            }]
        }]
    },{
        xtype:'container',
        layout: {
            type: 'hbox',
            pack:'end',
            align:'middle'
        },
        items:[
            {
                xtype:'searchreset'
            }
        ]
    }]
})
