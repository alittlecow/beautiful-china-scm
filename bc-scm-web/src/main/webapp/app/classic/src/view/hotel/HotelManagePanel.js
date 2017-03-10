/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 酒店管理主界面
 * @author: dongjingjun
 * date: 2016-01-03
 */

Ext.define('app.view.hotel.HotelManagePanel', {
    extend: 'Ext.container.Container',
    xtype: 'hotelmanage',
    controller:'hotel',
    viewModel: {
        type: 'hotel'
    },
    requires: [
        'app.view.hotel.HotelWinController',
        'app.view.hotel.HotelController',

        'app.view.hotel.HotelViewModel',

        'app.view.hotel.HotelInfoWin',
        'app.view.hotel.HotelGrid',
        'app.view.hotel.HotelQueryForm'
    ],

    layout: {
        type: 'vbox',
        align: 'stretch'
    },
    items:[{
        xtype:'hotelqueryform'
    },{
        xtype:'hotelgrid',
        flex:1
    }]
});