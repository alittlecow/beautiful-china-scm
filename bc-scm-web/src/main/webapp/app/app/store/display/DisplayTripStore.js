/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 * @author: dongjingjun
 * date: 2016-03-02
 */
Ext.define('app.store.display.DisplayTripStore', {
    extend: 'app.store.display.CommonStore',
    alias: 'store.displaytripstore',
    storeId: 'displayTripStore',
    proxy: {
        url: basePath + '/display/getDisplayTrip'
    }
});