/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 供应商查询界面
 * @author: fengbaitong
 * date: 2015-12-10
 */
Ext.define('app.view.supplier.SupplierQueryForm', {
    extend: 'Ext.form.Panel',
    xtype: 'supplierqueryform',
    layout: {
        type: 'vbox',
        align: 'stretch'
    },
    height:125,
    padding:'5 0 0 0',
    items:[{
        xtype: 'form',
        layout:'hbox',
        defaults:{
            labelAlign:'top',
            padding:'10 20 0 10'
        },
        defaultType: 'textfield',
        items:[{
            bind:{
                fieldLabel:'{supplierCode}'
            },
            name: 'deptCode',
            maxLength:20,
            flex:1
        },{
            bind:{
                fieldLabel:'{supplierName}'
            },
            name: 'name',
            maxLength:50,
            flex:1
        },{
            bind:{
                fieldLabel:'{status}'
            },
            xtype:'combo',
            store:"approve",
            displayField: 'name',
            valueField: 'value',
            editable: false,
            name: 'status',
            flex:1
        }]
    },{
        xtype:'tbspacer',
        height:10
    },
        {
        xtype: 'searchreset'
    }]


})
