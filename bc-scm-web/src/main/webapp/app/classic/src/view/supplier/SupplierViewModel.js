/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 供应商管理数据模型
 * @author: fengbaitong
 * date: 2015-12-12
 */
Ext.define('app.view.supplier.SupplierViewModel', {
    extend: 'app.view.base.BaseViewModel',
    alias: 'viewmodel.supplier',
    requires: [
       'app.store.supplier.SupplierGridStore'
    ],

    stores: {
        supplierGridStore:{
            type:'suppliergridstore'
        }
    }
});
