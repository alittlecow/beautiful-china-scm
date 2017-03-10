/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 目的地模型
 * @author: dongjingjun
 * date: 2016-01-07
 */

Ext.define('app.model.destination.DesModel', {
    extend: 'Ext.data.Model',
    fields: [
        {
            type: 'int',
            name: 'id'
        },
        {
            type: 'int',
            name: 'cityId'
        },
        {
            type: 'string',
            name: 'cityNameEn'
        },
        {
            type: 'string',
            name: 'cityNameFr'
        },
        {
            type: 'string',
            name: 'titleEn'
        },
        {
            type: 'string',
            name: 'titleFr'
        },
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
            name: 'status'
        },
        {
            type: 'string',
            name: 'photoOne'
        },
        {
            type: 'string',
            name: 'photoTwo'
        },
        {
            type: 'string',
            name: 'photoThree'
        },
        {
            type: 'string',
            name: 'photoFour'
        },
        {
            type: 'string',
            name: 'cityName'
        }
    ]
});