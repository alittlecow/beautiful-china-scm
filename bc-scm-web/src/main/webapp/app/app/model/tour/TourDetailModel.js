/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 行程详情model
 * @author: dongjingjun
 * date: 2015-12-25
 */

Ext.define('app.model.tour.TourDetailModel', {
    extend: 'Ext.data.Model',
    fields: [
        {
            type: 'string',
            name: 'id'
        },
        {
            type: 'int',
            name: 'tourId'
        },
        {
            type: 'string',
            name: 'day'
        },
        {
            type: 'string',
            name: 'contentEn'
        },
        {
            type: 'string',
            name: 'contentFr'
        },
        {
            type: 'string',
            name: 'titleEn'
        },
        {
            type: 'string',
            name: 'titleFr'
        }
    ]
});