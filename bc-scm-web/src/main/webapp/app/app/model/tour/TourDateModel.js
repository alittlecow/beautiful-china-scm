/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 线路出发管理表格model
 * @author: dongjingjun
 * date: 2015-12-23
 */

Ext.define('app.model.tour.TourDateModel', {
    extend: 'Ext.data.Model',
    fields: [
        {
            type: 'string',
            name: 'id'
        },
        {
            type: 'string',
            name: 'code'
        },
        {
            type: 'string',
            name: 'time'
        },
        {
            type: 'string',
            name: 'price'
        },
        {
            type: 'string',
            name: 'inventory'
        },
        {
            type: 'string',
            name: 'sales'
        },
        {
            type: 'string',
            name: 'pending'
        },
        {
            type: 'string',
            name: 'remain'
        },
        {
            type: 'string',
            name: 'warn'
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