/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 酒店管理表格
 * @author: dongjingjun
 * date: 2016-01-03
 */

Ext.define('app.view.hotel.HotelGrid', {
    extend: 'app.view.base.BaseGrid',
    xtype: 'hotelgrid',
    storeName: 'hotelGridStore',
    tbar: [{
        xtype: 'addbtn',
        handler: 'add'
    }, {
        xtype: 'delbtn',
        handler: 'delete'
    }, {
        xtype: 'editbtn',
        handler: 'edit'
    }],
    columns: [
        //{
        //    dataIndex: 'hotelNameEn', width: 200, bind: {
        //    text: '{hotelNameEn}'
        //}
        //},
        {
            dataIndex: 'hotelName', width: 200, bind: {
            text: '{hotelName}'
        }
        },
        //{
        //    dataIndex: 'typeNameEn', width: 200, bind: {
        //    text: '{typeNameEn}'
        //}
        //},
        //{
        //    dataIndex: 'typeNameFr', width: 200, bind: {
        //    text: '{typeNameFr}'
        //}
        //},
        {
            dataIndex: 'hotelTel', width: 200, bind: {
            text: '{hotelTel}'
        }
        },
        {
            dataIndex: 'hotelFax', width: 200, bind: {
            text: '{hotelFax}'
        }
        },
        //{
        //    dataIndex: 'hotelCityEn', width: 180, bind: {
        //    text: '{hotelCityEn}'
        //}
        //},
        {
            dataIndex: 'hotelCity', width: 200, bind: {
            text: '{hotelCity}'
        }
        },
        //{
        //    dataIndex: 'addressEn', width: 150, bind: {
        //    text: '{addressEn}'
        //}
        //},
        {
            dataIndex: 'address', width: 200, bind: {
            text: '{address}'
        }
        }
    ]
});