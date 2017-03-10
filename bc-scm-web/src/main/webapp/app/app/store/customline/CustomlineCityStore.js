/**
 * Copyright @ 2016 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 旅游线路城市store
 * @author: zhangyu
 * date: 2016-1-13
 */

Ext.define('app.store.customline.CustomlineCityStore', {
    extend: 'app.store.base.BaseStore',
    alias: 'store.customlinecitystore',
    autoLoad: false,
    storeId:'customlineCityStore',
    fields:[
        'city',
        'id'
    ],
    proxy : {

        url : basePath + '/customline/getCity'

    }

});