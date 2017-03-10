
/**
 * Copyright @ 2016 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 定制线路表格
 * @author: zhangyu
 * date: 2016-01-08
 */


Ext.define('app.view.customline.CustomlineDetailGrid',{
    extend: 'app.view.base.BaseGrid',
    xtype:'customlinedetailgrid',
    storeName:'customlineDetailGridStore',
    border: true,

    viewModel: {
        type: 'customline'
    },
    selModel: {
        selType: 'checkboxmodel'
    },
    tbar : [ {
        xtype:'addbtn',
        handler: 'add'

    },{
        xtype:'editbtn',
        handler: 'edit'

    },{
        xtype:'delbtn',
        handler: 'delete'
    }],
    columns: [

        {dataIndex: 'cityNameEn', flex: 1,bind:{
            text:'{cityNameEn}'
        }},
        {dataIndex: 'day', flex: 1,bind:{
            text:'{desDay}'
        }}

    ]
});