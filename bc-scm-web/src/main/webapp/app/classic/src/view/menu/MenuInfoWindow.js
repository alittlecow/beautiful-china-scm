/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 菜单表单窗口
 * @author: chenghuanhuan
 * date: 2015-11-16
 */
Ext.define('app.view.menu.MenuInfoWindow', {
    extend: 'app.view.base.BaseWindow',
    xtype:'menuinfowindow',
    controller:'menuwindow',
    viewModel: {
        type: 'base'
    },
    width:820,
    height:395,
    layout: 'fit',
    buttons: [{
        xtype:'savebtn',
        handler:'save'
    }],
    items:[{
        xtype:'form',
        layout:'column',
        padding:'5 5 5 5',
        items: [{
            columnWidth: 0.45,
            //style: {borderColor:'#000000', borderStyle:'solid', borderWidth:'1px'},
            border: false,
            layout: 'anchor',
            defaultType: 'textfield',
            defaults:{
                anchor:'100%',
                labelAlign:'right',
                allowBlank: false,
                labelWidth:150
            },
            items: [{
                xtype: 'hiddenfield',
                name: 'code'
            },{
                maxLength:50,
                bind:{
                    fieldLabel:'{menuEnName}'
                },
                name: 'enName'
            },{
                bind:{
                    fieldLabel:'{status}'
                },
                xtype:'combo',
                store:"normalStop",
                displayField: 'name',
                valueField: 'value',
                queryMode:'local',
                editable: false,
                value:'N',
                name: 'status'
            }, {
                xtype: 'combo',
                name: 'plateCode',
                bind: {
                    store: '{plateStore}',
                    fieldLabel:'{plate}'
                },
                listeners: {
                    select:'onSelectItem'
                },
                displayField: 'plateName',
                valueField: 'code',
                queryMode:'local',
                editable: false
            }]
        },{
            columnWidth: 0.45,
            //style: {borderColor:'#000000', borderStyle:'solid', borderWidth:'1px'},
            padding:'0 0 0 5',
            border:false,
            layout: 'anchor',
            defaultType: 'textfield',
            defaults:{
                anchor:'100%',
                allowBlank: false,
                labelAlign:'right',
                labelWidth:180
            },
            items: [{
                //fieldLabel:'菜单名称(法语)',
                bind:{
                    fieldLabel:'{menuFrName}'
                },
                maxLength:50,
                name: 'frName'
            },{
                //fieldLabel: '顺序',
                bind:{
                    fieldLabel:'{sort}'
                },
                xtype:'numberfield',
                maxValue: 99,
                minValue: 0,
                name: 'sort'
            },{
                //fieldLabel: '所属模块',
                xtype:'combo',
                id:'moduleComboByInfoMenu',
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
        },{
            columnWidth:0.9,
            border:false,
            layout: 'anchor',
            defaults:{
                anchor:'100%',
                labelAlign:'right',
                labelWidth:150
            },
            items:[{
                xtype:'textfield',
                bind:{
                    fieldLabel:'{link}'
                },
                maxLength:50,
                name: 'link'
            }]
        },{
            columnWidth: 0.9,
            border:false,
            layout: 'anchor',
            defaults:{
                anchor:'100%',
                labelAlign:'right',
                labelWidth:150
            },
            items:[{
                xtype:'textareafield',
                labelAlign:'right',
                bind:{
                    fieldLabel:'{notes}'
                },
                name:'notes'
            }]
        }]
    }]
});