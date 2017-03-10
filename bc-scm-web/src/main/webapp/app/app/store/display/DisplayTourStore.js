/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 * @author: dongjingjun
 * date: 2016-03-02
 */
Ext.define('app.store.display.DisplayTourStore', {
    extend: 'app.store.display.CommonStore',
    alias: 'store.displaytourstore',
    storeId: 'displayTourStore',
    proxy: {
        url: basePath + '/display/getDisplayTour'
    }
});