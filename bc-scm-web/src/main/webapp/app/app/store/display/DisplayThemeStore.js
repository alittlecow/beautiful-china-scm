/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 * @author: dongjingjun
 * date: 2016-03-02
 */
Ext.define('app.store.display.DisplayThemeStore', {
    extend: 'app.store.display.CommonStore',
    alias: 'store.displaythemestore',
    storeId: 'displayThemeStore',
    proxy: {
        url: basePath + '/display/getDisplayTheme'
    }
});