/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 菜单查询页面
 * @author: chenghuanhuan
 * date: 2015-11-16
 */
Ext.define('app.view.menu.MenuQueryForm', {
    extend: 'Ext.form.Panel',
    xtype:'menuqueryform',
    layout: {
        type:'vbox',
        align: 'stretch'
    },
    height:100,
    // 边距
    padding: '5 0 0 0',
    items: [{
        xtype: 'container',
        height:60,
        layout:'hbox',
        padding: '10 0 10 0',
        defaultType: 'container',
        items: [{// 第一列
            flex:1,
            layout: 'anchor',
            defaultType: 'textfield',
            defaults:{
                labelAlign:'right',
                anchor:'95%'
            },

            items: [{
                xtype:'combo',
                name: 'plateCode',
                queryMode:'local',
                bind: {
                    store: '{plateStore}',
                    fieldLabel:'{plate}'
                },
                displayField: 'plateName',
                valueField: 'code',
                listeners: {
                    select : 'onSelect'
                },
                editable:false
            }]
        },{//第二列
            flex:1,
            //border:false,
            layout: 'anchor',
            defaultType: 'textfield',
            defaults:{
                labelAlign:'right',
                anchor:'95%'
            },
            items: [{
                xtype:'combo',
                id:'moduleComboByQueryMenu',
                name: 'moduleCode',
                bind: {
                    store: '{moduleStore}',
                    fieldLabel:'{module}'
                },
                displayField: 'moduleName',
                valueField: 'moduleCode',
                queryMode:'local',
                editable:false
            }]
        },{//第三列
            flex:1,
            layout: 'anchor',
            defaultType: 'textfield',
            defaults:{
                labelAlign:'right',
                anchor:'95%'
            },
            items: [{
                bind:{
                    fieldLabel:'{menuName}'
                },
                name: 'enName'
            }]
        }]
    },{
        xtype:'searchreset'
    }]
});