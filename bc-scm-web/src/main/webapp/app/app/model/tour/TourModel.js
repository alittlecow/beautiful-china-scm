/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 旅游线路model
 * @author: dongjingjun
 * date: 2015-12-25
 */

Ext.define('app.model.tour.TourModel', {
    extend: 'Ext.data.Model',
    fields: [
        {
            type: 'int',
            name: 'id'
        },
        {
            type: 'string',
            name: 'code'
        },
        {
            type: 'string',
            name: 'startCityEn'
        },
        {
            type: 'string',
            name: 'endCityEn'
        },
        {
            type: 'string',
            name: 'startCityFr'
        },
        {
            type: 'string',
            name: 'endCityFr'
        },
        {
            type: 'string',
            name: 'days'
        },
        {
            type: 'string',
            name: 'status'
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
            name: 'deptCode'
        },
        {
            type: 'string',
            name: 'rating'
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
            name: 'includeEn'
        },
        {
            type: 'string',
            name: 'includeFr'
        },
        {
            type: 'string',
            name: 'excludeEn'
        },
        {
            type: 'string',
            name: 'excludeFr'
        },
        {
            type: 'string',
            name: 'importantEn'
        },
        {
            type: 'string',
            name: 'importantFr'
        },
        {
            type: 'string',
            name: 'triphintEn'
        },
        {
            type: 'string',
            name: 'triphintFr'
        },
        {
            type: 'string',
            name: 'termEn'
        },
        {
            type: 'string',
            name: 'termFr'
        },
        {
            type: 'string',
            name: 'theme'
        },
        {
            type: 'string',
            name: 'advanceDays'
        },
        {
            type: 'string',
            name: 'subTitleEn'
        },
        {
            type: 'string',
            name: 'subTitleFr'
        }
    ]
});