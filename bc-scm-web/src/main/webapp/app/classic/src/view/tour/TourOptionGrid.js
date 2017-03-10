/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 旅游线路管理表格
 * @author: dongjingjun
 * date: 2015-12-25
 */

Ext.define('app.view.tour.TourOptionGrid', {
    extend: 'app.view.base.BaseGrid',
    xtype: 'touroptiongrid',
    storeName: 'tourOptionGridStore',
    autoLoad: false,
    listeners: {
        render: 'loadOption'
    },
    tbar: [{
        xtype: 'addbtn',
        handler: 'addOption'
    }, {
        xtype: 'editbtn',
        handler: 'editOption'
    }, {
        xtype: 'delbtn',
        handler: 'deleteOption'
    }],
    columns: [
        {dataIndex: 'optionName', flex: 1, bind: {text: '{option}'}},
        {dataIndex: 'optionValueName', flex: 1, bind: {text: '{optionValue}'}},
        {dataIndex: 'price', width: 200, bind: {text: '{differential}'}},
        {dataIndex: 'defaults', width: 100, bind: {text: '{defaults}'}}
    ]
});