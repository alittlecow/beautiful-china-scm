/**
 * Copyright @ 2016 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 定制线路目的地store
 * @author: zhangyu
 * date: 2016-1-11
 */


Ext.define('app.store.customline.CustomlineDetailGridStore', {
    extend: 'app.store.base.BaseStore',
    alias: 'store.customlinedetailgridstore',
    autoLoad: false,
    model:'app.model.customline.CustomlineDetailModel',
    storeId:'customlineDetailGridStore',
    proxy : {

        url : basePath + '/customline/listDay'

    }
});