/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 景点管理主页面数据模型
 * @author: dongjingjun
 * date: 2016-01-05
 */

Ext.define('app.view.sights.SightsViewModel', {
    extend: 'app.view.base.BaseViewModel',
    alias: 'viewmodel.sights',

    requires: [
        'app.store.sights.SightsDesCityStore',
        'app.store.sights.SightsGridStore'
    ],

    stores: {
        sightsGridStore: {
            type: 'sightsgridstore'
        },
        sightsDesCityStore: {
            type: 'sightsdescitystore'
        }
    }
});