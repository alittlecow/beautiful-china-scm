/**
 * Created by Intellij IDEA 14.
 *User:fengbaitong
 *Date:2015/12/25
 *Time:12:49
 *Project:bc-scm
 */

Ext.define('app.view.attribute.AttributePanel', {
    extend: 'Ext.container.Container',
    xtype: 'attributemanage',
    controller:'attribute',
    viewModel: {
        type: 'attribute'
    },
    requires: [
        'app.view.attribute.AttributeController',
        'app.view.attribute.AttributeWinController',
        'app.view.attribute.AttributeViewModel',
        'app.view.attribute.AttributeQueryForm',
        'app.view.attribute.CategoryTreePanel',
        'app.view.attribute.AttributeGrid'
    ],

    layout: {
        type: 'vbox',
        align: 'stretch'
    },



    items:[
        {
            xtype:'attributequeryform'
        },
        {   xtype:'container',
            flex:1,
            layout: {
                type: 'hbox',
                align: 'stretch'
            },
            items:[{
                xtype:'categorytree',
                flex:1
            },{
                xtype:'tbspacer',
                width:5
            },{
                flex:3,
                xtype:'attributegrid'
            }]
        }
    ]
});