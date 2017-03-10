/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 * @author: chengxuemin
 * date: 2016-04-07
 */

/**
 * 城市显示维护
 */
Ext.define('app.store.display.DisplayCityStore',{
    extend: 'app.store.display.CommonStore',
    alias: 'store.displaycitystore',
    storeId: 'displayCityStore',
    proxy: {
        url: basePath + '/display/getDisplayCity'
    }
});