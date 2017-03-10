/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 窗口名称store
 * @author: dongjingjun
 * date: 2015-12-23
 */

Ext.define('app.store.tour.TourDateTitleStore', {
    extend: 'Ext.data.Store',
    alias: 'store.titlestore',
    autoLoad: false,
    fields: [
        'id',
        'titleEn'
    ],
    storeId: 'titleStore',
    proxy: {
        type: 'ajax',
        url: basePath + '/tourdate/title',
        reader: {
            type: 'json',
            rootProperty: 'data',
            totalProperty: 'total'
        }
    }
});