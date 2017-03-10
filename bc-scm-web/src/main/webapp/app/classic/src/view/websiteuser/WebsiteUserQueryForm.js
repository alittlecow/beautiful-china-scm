/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: chengxuemin
 * date: 2015-12-11
 */

/**
 * 网站用户管理查询页面
 */
Ext.define('app.view.websiteuser.WebsiteUserQueryForm', {
    extend: 'Ext.form.Panel',
    xtype: 'websiteuserqueryform',
    controller: 'websiteuser',
    viewModel: {
        type: 'websiteuser'
    },

    layout: {
        type: 'vbox',
        align: 'stretch'
    },
    height: 100,
    padding: '5 0 0 0',
    items: [{
        xtype: 'panel',
        height:60,
        layout:'hbox',
        padding: '10 0 10 0',
        items: [{
            flex:1,
            layout: 'anchor',
            defaultType: 'textfield',
            defaults:{
                labelAlign:'right',
                anchor:'95%'
            },
            items: [{
                bind:{
                    fieldLabel:'{name}'
                },
                name: 'name'
            }],
            border:false
        },{
            flex:1,
            border:false,
            layout: 'anchor',
            defaultType: 'textfield',
            defaults:{
                labelAlign:'right',
                anchor:'95%'
            },
            items: [{
                bind:{
                    fieldLabel:'{nickName}'
                },
                name: 'nickName'
            }]
        },{
            flex:1,
            border:false,
            layout: 'anchor',
            defaultType: 'textfield',
            defaults:{
                labelAlign:'right',
                anchor:'95%'
            },
            items: [{
                bind:{
                    fieldLabel:'{status}'
                },
                xtype:'combo',
                store:"normalStop",
                displayField: 'name',
                valueField: 'value',
                editable: false,
                value: 'N',
                name: 'status'
            }]
        }]
    },{
        xtype:'searchreset'
    }]
});