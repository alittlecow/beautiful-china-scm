/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 * @author: dongjingjun
 * date: 2016-03-02
 */
Ext.define('app.store.display.DisplayBannerStore', {
    extend: 'app.store.display.CommonStore',
    alias: 'store.displaybannerstore',
    storeId: 'displayBannerStore',
    proxy: {
        url: basePath + '/display/getDisplayBanner'
    }
});