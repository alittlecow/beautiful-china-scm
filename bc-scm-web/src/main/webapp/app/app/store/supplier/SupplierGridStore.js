/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 *
 * @author: fengbaitong
 * date: 2015-12-12
 *
 */
Ext.define('app.store.supplier.SupplierGridStore', {
    extend: 'Ext.data.Store',
    alias: 'store.suppliergridstore',
    autoLoad: false,
    model:'app.model.supplier.SupplierModel',
    proxy : {
        type : 'ajax',
        url : basePath + '/supplier/list',
        reader:{
            type:'json',
            method:'POST',
            rootProperty:'data',
            totalProperty:'total'
        }
    }
});