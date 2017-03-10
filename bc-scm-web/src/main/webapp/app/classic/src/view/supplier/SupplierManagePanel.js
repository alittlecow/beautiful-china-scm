/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 供应商管理主页面
 * @author: fengbaitong
 * date: 2015-12-12
 */


Ext.define('app.view.supplier.SupplierManagePanel',{
    extend: 'Ext.container.Container',
    xtype: 'suppliermanage',
    controller:'supplier',
    viewModel:'supplier',
    requires: [
        'app.view.supplier.SupplierQueryForm',
        'app.view.supplier.SupplierGrid',
        'app.view.supplier.SupplierController',
        'app.view.supplier.SupplierInfoWindow',
        'app.view.supplier.SupplierApproveWindow',
        'app.view.supplier.SupplierWinController',
        'app.view.supplier.SupplierViewModel'

    ],

    layout: {
        type:'vbox',
        align:'stretch'
    },
    items:[
        {
            xtype:'supplierqueryform'
        },
        {
            xtype:'suppliergrid',
            flex:1
        }
    ]
});