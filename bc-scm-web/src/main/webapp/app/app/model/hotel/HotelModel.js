/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 酒店表格数据模型
 * @author: dongjingjun
 * date: 2016-01-03
 */

Ext.define('app.model.hotel.HotelModel', {
    extend: 'Ext.data.Model',
    fields: [
        {
            type: 'string',
            name: 'descEn'
        },
        {
            type: 'string',
            name: 'descFr'
        },
        {
            type: 'string',
            name: 'typeNameEn'
        },
        {
            type: 'string',
            name: 'hotelNameCn'
        },
        {
            type: 'string',
            name: 'hotelNameEn'
        },
        {
            type: 'string',
            name: 'hotelNameFr'
        },
        {
            type: 'string',
            name: 'hotelTel'
        },
        {
            type: 'string',
            name: 'hotelFax'
        },
        {
            type: 'string',
            name: 'hotelCityEn'
        },{
            type: 'string',
            name: 'hotelCityFr'
        },
        {
            type: 'int',
            name: 'cityId'
        },
        {
            type: 'string',
            name: 'hotelStar'
        },
        {
            type: 'string',
            name: 'status'
        },
        {
            type: 'string',
            name: 'addressEn'
        },
        {
            type: 'string',
            name: 'addressFr'
        },
        {
            type: 'int',
            name: 'id'
        },
        {
            type: 'string',
            name: 'supDeptCode'
        }
    ]
});