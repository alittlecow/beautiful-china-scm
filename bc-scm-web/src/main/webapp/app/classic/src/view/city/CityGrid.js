/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 * @author: zhuhoufeng
 * date: 2016-01-06
 */

/**
 * 城市管理表格
 */
Ext.define('app.view.city.CityGrid',{
    extend: 'app.view.base.BaseGrid',
    xtype:'citygrid',
    storeName:'cityGridStore',
    viewModel: {
        type: 'city'
    },
    selModel: {
        selType: 'checkboxmodel'
    },
    tbar : [ {
        xtype:'addbtn',
        handler: 'add'
    },{
        xtype:'delbtn',
        handler: 'delete'
    },{
        xtype:'editbtn',
        handler: 'edit'
    }],
    columns: [
        {dataIndex: 'cityName', flex: 2,bind:{
            text:'{cityName}'
        }},
        {dataIndex: 'cityId', flex: 2,bind:{
            text:'{address}'
            // , hidden: true
        }}

    ]
});