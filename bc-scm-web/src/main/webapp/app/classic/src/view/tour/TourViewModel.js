/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 旅游线路管路数据模型
 * @author: dongjingjun
 * date: 2015-12-25
 */

Ext.define('app.view.tour.TourViewModel', {
    extend: 'app.view.base.BaseViewModel',
    alias: 'viewmodel.tour',

    requires: [
        'app.store.tour.TourStore',
        'app.store.tour.TourGridStore',
        'app.store.tour.TourSupStore',
        'app.store.tour.TourThemeStore',
        'app.store.tour.TourCityStore',
        'app.store.tour.TourDetailGridStore',
        'app.store.tour.TourOptionGridStore',
        'app.store.tour.TourDateGridStore',
        'app.store.tour.TourDateTitleStore',
        'app.store.tour.OptionValueStore',
        'app.store.tour.OptionStore'
    ],

    stores: {
        tourGridStore: {
            type: 'tourgridstore'
        },
        tourStore: {
            type: 'tourstore'
        },
        tourSupStore: {
            type: 'toursupstore'
        },
        tourCityStore: {
            type: 'tourcitystore'
        },
        tourThemeStore: {
            type: 'tourthemestore'
        },
        tourDetailGridStore: {
            type: 'tourdetailgridstore'
        },
        tourOptionGridStore: {
            type: 'touroptiongridstore'
        },
        tourDateGridStore: {
            type: 'tourdategridstore'
        },
        titleStore: {
            type: 'titlestore'
        },
        optionStore: {
            type: 'optionstore'
        },
        optionValueStore: {
            type: 'optionvaluestore'
        }
    }
});