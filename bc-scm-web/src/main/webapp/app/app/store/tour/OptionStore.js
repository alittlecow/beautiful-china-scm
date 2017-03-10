/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 * @author: dongjingjun
 * date: 2016-03-11
 */
Ext.define('app.store.tour.OptionStore', {
    extend: 'Ext.data.Store',
    alias: 'store.optionstore',
    autoLoad: false,
    storeId: 'optionStore',
    fields: [
        'name', 'id'
    ],
    proxy: {
        type: 'ajax',
        url: basePath + '/tour/getOption',
        reader: {
            type: 'json'
        }
    }
});