/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 * @author: chengxuemin
 * date: 2015-12-22
 */

/**
 * 分类管理查询页面
 */
Ext.define('app.view.category.CategoryQueryForm', {
    extend: 'Ext.form.Panel',
    xtype: 'categoryqueryform',
    viewModel: {
        type: 'category'
    },
    layout: {
        type: 'vbox',
        align: 'stretch'
    },
    height: 100,
    padding: '5 0 0 0',
    items: [{
        xtype: 'panel',
        height: 60,
        layout: 'hbox',
        padding: '10 0 10 0',
        items: [{
            flex: 1,
            border: false,
            layout: 'anchor',
            defaultType: 'textfield',
            defaults: {
                labelAlign: 'right',
                anchor: '33%'
            },
            items: [{
                bind:{
                    fieldLabel: '{ctgName}'
                },
                name: 'name',
                labelWidth:150
            }]
        },{
            xtype: 'hiddenfield',
            name: 'id',
            id:'parentid',
            value: '1'
        },{
            xtype: 'hiddenfield',
            name: 'parentnameEn',
            id:'parentnameEn',
            value: '1'
        },{
            xtype: 'hiddenfield',
            name: 'parentnameFr',
            id:'parentnameFr',
            value: '1'
        },{
            xtype: 'hiddenfield',
            name: 'parentlevel',
            id:'parentlevel',
            value: '0'
        }]
    },{
        xtype:'searchreset'
    }]
});