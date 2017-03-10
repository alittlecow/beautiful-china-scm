/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: liufei
 * date: 2015-12-22
 */
Ext.define('app.store.option.OptionValueGridStore', {
    extend: 'Ext.data.Store',
    alias: 'store.optionvaluegridstore',
    autoLoad: false,
    //model:'app.model.option.OptionValueModel',
    fields:[
        'valueId',
        'optionId',
        'optionEnValue',
        'optionFrValue',
        'optionEnNotes',
        'optionFrNotes',
        'optionPrice'
    ],
    storeId:'optionValueGridStore',
    proxy : {
        type : 'ajax',
        url : basePath + '/option/queryValue',
        reader:{
            type:'json',
            method:'POST',
            rootProperty:'data',
            totalProperty:'total'
        }
    }
});