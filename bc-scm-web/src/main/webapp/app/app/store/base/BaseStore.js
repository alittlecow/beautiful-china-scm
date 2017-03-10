/**
 * Copyright @ 2015 南京网华信息科技有限公司.
 * All right reserved.
 * @author: chenghuanhuan
 * date: 16/1/15
 */
Ext.define('app.store.base.BaseStore', {
    extend: 'Ext.data.Store',
    alias: 'store.basestore',
    autoLoad: false,
    model:'app.model.category.CategoryModel',
    storeId:'baseStore',

    constructor: function (config) {
        var proxy = this.config.proxy;
        if(proxy){
            Ext.apply(this.config,{
                proxy:{
                    type : 'ajax',
                    url : proxy.url,
                    reader:{
                        type:'json',
                        rootProperty:'data',
                        totalProperty:'total'
                    }
                }
            });
        }
        this.callParent([config]);
    }
});