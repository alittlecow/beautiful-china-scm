/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 * @author: chengxuemin
 * date: 2015-12-22
 */

/**
 * 分类管理窗口
 */
Ext.define('app.view.category.CategoryInfoWin', {
    extend: 'app.view.base.BaseWindow',
    xtype: 'categoryinfowin',
    controller:'categorywin',
    viewModel: {
        type: 'category'
    },
    width:445,
    height:300,
    buttons: [{
        xtype:'savebtn',
        handler:'save'
    }],
    items:[{
        xtype:'form',
        layout:{
            type: 'vbox',
            align: 'stretch'
        },
        padding:'5 5 5 5',
        items: [{
            border: false,
            layout: 'anchor',
            defaultType: 'textfield',
            defaults:{
                anchor:'90%',
                labelAlign:'right',
                allowBlank: false,
                labelWidth: 220
            },
            items: [{
                itemId:'id',
                xtype: 'hiddenfield',
                name:'id'
            },{
                itemId:'parentid',
                xtype: 'hiddenfield',
                name: 'parent'
            },{
                itemId:'ctgParent',
                bind:{
                    fieldLabel:'{ctgParent}'
                },
                id:'ctgParent',
                name:'parentnameEn'
            },{
                bind:{
                    fieldLabel:'{ctgNameEn}'
                },
                name: 'nameEn',
                maxLength: 50
            },{
                bind:{
                    fieldLabel:'{ctgNameFr}'
                },
                name: 'nameFr',
                maxLength: 50
            }]
        }]
    }]
});