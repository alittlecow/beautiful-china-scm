/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 景点表格模型
 * @author: dongjingjun
 * date: 2016-01-05
 */
Ext.define('app.model.sights.SightsModel', {
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
            name: 'nameEn'
        },
        {
            type: 'string',
            name: 'nameFr'
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
            name: 'level'
        },
        {
            type: 'string',
            name: 'price'
        },
        {
            type: 'string',
            name: 'cityNameEn'
        },
        {
            type: 'string',
            name: 'cityNameFr'
        }
    ]
});