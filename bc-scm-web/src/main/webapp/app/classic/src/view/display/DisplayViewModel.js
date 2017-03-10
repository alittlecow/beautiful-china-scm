/**
 * Copyright @ 2016 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 首页展示数据模型
 * @author: zhangyu
 * date: 2016-1-15
 */
Ext.define('app.view.display.DisplayViewModel', {
    extend: 'app.view.base.BaseViewModel',
    alias: 'viewmodel.display',
    requires: [
        'app.store.display.DisplayTourDateStore',
        'app.store.display.DisplayTripStore',
        'app.store.display.DisplayTourStore',
        'app.store.display.DisplayThemeStore',
        //
        'app.store.display.DisplayCityStore',
        'app.store.display.DisplayBannerStore',
        'app.store.tour.TourThemeStore',
        //
        'app.store.tour.TourCityStore'


    ],

    stores: {
        displayTourDateStore: {
            type: 'displaytourdatestore'
        },
        displayTripStore: {
            type: 'displaytripstore'
        },
        displayTourStore: {
            type: 'displaytourstore'
        },
        displayThemeStore: {
            type: 'displaythemestore'
        },
        //
        displayCityStore: {
            type: 'displaycitystore'
        },
        displayBannerStore: {
            type: 'displaybannerstore'
        },
        tourThemeStore: {
            type: 'tourthemestore'
        },
        //
        tourCityStore: {
            type: 'tourcitystore'
        }
    }
});
