/**
 * Copyright @ 2016 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 线路选择store
 * @author: zhangyu
 * date: 2016-1-22
 */


Ext.define('app.store.display.DisplayTourDateStore', {
    extend: 'app.store.base.BaseStore',
    alias: 'store.displaytourdatestore',
    autoLoad: false,
    model:'app.model.display.DisplayModel',
    storeId:'displayTourDateStore',
    proxy : {
        url : basePath + '/display/getTourDate'
    }
});