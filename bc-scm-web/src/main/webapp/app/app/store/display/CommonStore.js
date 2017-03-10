/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 * @author: dongjingjun
 * date: 2016-03-02
 */
Ext.define('app.store.display.CommonStore', {
    extend: 'Ext.data.Store',
    autoLoad: false,
    listeners: {
        load: 'transformData'
    },
    proxy: {
        type: 'ajax',
        reader: {
            type: 'json'
        }
    }
});