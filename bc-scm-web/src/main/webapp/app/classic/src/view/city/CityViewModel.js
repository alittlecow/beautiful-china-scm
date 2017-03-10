/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 * @author: zhuhoufeng
 * date: 2016-01-06
 */

/**
 * 城市管理页面数据模型
 */
Ext.define('app.view.city.CityViewModel', {
    extend: 'app.view.base.BaseViewModel',
    alias: 'viewmodel.city',

    requires: [
        'app.store.city.CityGridStore'
    ],

    stores: {
        cityGridStore:{
            type:'citygridstore'
        }
    }
});