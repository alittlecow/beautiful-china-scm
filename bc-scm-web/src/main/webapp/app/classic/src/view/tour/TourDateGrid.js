/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 线路出发管理表格
 * @author: dongjingjun
 * date: 2015-12-23
 */

Ext.define('app.view.tour.TourDateGrid', {
    extend: 'app.view.base.BaseGrid',
    xtype: 'tourdategrid',
    storeName: 'tourDateGridStore',
    autoLoad: false,
    plugins: [{
        ptype: 'rowediting',
        clicksToMoveEditor: 1,
        autoCancel: false
    }],
    listeners: {
        edit: 'editTourDate',
        render: 'loadTourDate'
    },
    tbar: [{
        xtype: 'addbtn',
        handler: 'addTourDate'
    }, {
        xtype: 'delbtn',
        handler: 'deleteTourDate'
    }],
    columns: [
        {
            dataIndex: 'title', align: 'center', width: 200, bind: {text: '{routeName}'}
        },

        {
            dataIndex: 'time', align: 'center', width: 120, bind: {text: '{time}'}
            , editor: {allowBlank: false, xtype: 'datefield', format: 'Y-m-d H:i:s', editable: false}
        },
        {
            dataIndex: 'price', align: 'center', width: 120, bind: {text: '{price}'}
            , editor: {allowBlank: false, xtype: 'numberfield', minValue: 0}
        },
        {
            dataIndex: 'inventory', align: 'center', width: 120, bind: {text: '{inventory}'}
            , editor: {allowBlank: false, xtype: 'numberfield', allowDecimals: false, minValue: 0}
        },
        {
            dataIndex: 'sales', align: 'center', width: 150, bind: {text: '{sales}'}
        },
        {
            dataIndex: 'pending', align: 'center', width: 100, bind: {text: '{pending}'}
        },
        {
            dataIndex: 'remain', align: 'center', width: 100, bind: {text: '{remain}'}
        },
        {
            dataIndex: 'warn', align: 'center', width: 150, bind: {text: '{warning}'},
            editor: {allowBlank: false, xtype: 'numberfield', allowDecimals: false, minValue: 0}
        }
    ]
});