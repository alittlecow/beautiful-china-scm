/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 旅游线路管理表格
 * @author: dongjingjun
 * date: 2015-12-25
 */

Ext.define('app.view.tour.TourGrid', {
    extend: 'app.view.base.BaseGrid',
    xtype: 'tourgrid',
    storeName: 'tourGridStore',
    tbar: [{
        xtype: 'addbtn',
        handler: 'addTour'
    }, {
        xtype: 'delbtn',
        handler: 'deleteTour'
    }, {
        xtype: 'editbtn',
        handler: 'editTour'
    }, {
        xtype: 'checkbtn',
        handler: 'checkTour'
    }],
    columns: [
        {dataIndex: 'code', align: 'center', width: 120, bind: {text: '{code}'}},
        {dataIndex: 'title', align: 'center', width: 250, bind: {text: '{routeName}'}},
        {dataIndex: 'startCityName', align: 'center', width: 250, bind: {text: '{startCity}'}},
        {dataIndex: 'endCityName', align: 'center', width: 250, bind: {text: '{endCity}'}},
        {dataIndex: 'days', align: 'center', width: 100, bind: {text: '{days}'}},
        {
            dataIndex: 'status', align: 'center', width: 100,
            renderName: "normalStop", renderer: "render", bind: {text: '{status}'}
        },
        {
            dataIndex: 'owner', align: 'center', width: 100,
            renderName: "tourOwner", renderer: "render", bind: {text: '{owner}'}
        }
    ]
});