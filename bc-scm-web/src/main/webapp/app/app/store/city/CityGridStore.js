/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 * @author: zhuhoufeng
 * date: 2016-01-06
 */

/**
 * 城市管理管理表格数据存储
 */
Ext.define('app.store.city.CityGridStore', {
    extend: 'app.store.base.BaseStore',
    alias: 'store.citygridstore',
    autoLoad: false,
    model:'app.model.city.CityModel',
    storeId:'cityGridStore',

    proxy : {
        type : 'ajax',
        url : basePath + '/city/query',
        reader:{
            type:'json',
            rootProperty:'data',
            totalProperty:'total'
        }
    }
});