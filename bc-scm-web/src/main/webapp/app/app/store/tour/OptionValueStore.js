/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 * @author: dongjingjun
 * date: 2016-03-11
 */
Ext.define('app.store.tour.OptionValueStore', {
    extend: 'Ext.data.Store',
    alias: 'store.optionvaluestore',
    autoLoad: false,
    storeId: 'optionValueStore',
    model: 'app.model.tour.OptionValueModel',
    proxy: {
        type: 'ajax',
        url: basePath + '/tour/getOptionValueById',
        reader: {
            type: 'json'
        }
    }
});