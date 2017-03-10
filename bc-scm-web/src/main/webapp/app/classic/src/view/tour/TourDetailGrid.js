/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 *旅游行程详情表格
 * @author: dongjingjun
 * date: 2015-12-25
 */

Ext.define('app.view.tour.TourDetailGrid', {
    extend: 'app.view.base.BaseGrid',
    xtype: 'tourdetailgrid',
    storeName: 'tourDetailGridStore',
    autoLoad: false,
    listeners: {
        render: 'loadDetail'
    },
    tbar: [{
        xtype: 'addbtn',
        handler: 'addDetail'
    }, {
        xtype: 'editbtn',
        handler: 'editDetail'
    }, {
        xtype: 'delbtn',
        handler: 'deleteDetail'
    }],
    columns: [
        {
            dataIndex: 'day', align: 'center', width: 150, bind: {text: '{day}'}
        },
        {
            dataIndex: 'titleEn', align: 'center', flex: 1, bind: {text: '{routeName}'}
        }
    ]
});