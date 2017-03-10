/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 旅游线路管理表格
 * @author: dongjingjun
 * date: 2015-12-25
 */

Ext.define('app.view.order.OrderOptionGrid', {
    extend: 'app.view.base.BaseGrid',
    xtype: 'orderoptiongrid',
    storeName: 'orderOptionGridStore',
    autoLoad: false,
    listeners: {
        render: 'loadOption'
    },
    tbar: [
    //   {
        // xtype: 'addbtn'
    //},
        {
        xtype: 'editbtn',
        handler: 'editOption'

        }
    //    , {
    //    xtype: 'delbtn'
    //}
    ],
    columns: [
        {dataIndex: 'optionName', flex: 1, bind: {text: '{ordOption}'}},
        {dataIndex: 'optionValueName', flex: 1, bind: {text: '{ordOptionValue}'}},
        {dataIndex: 'price', width: 200, bind: {text: '{ordDifferential}'}}
    ]
});