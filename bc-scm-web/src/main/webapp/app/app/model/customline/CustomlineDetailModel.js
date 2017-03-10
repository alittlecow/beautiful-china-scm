/**
 * Copyright @ 2016 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 用户表格数据模型
 * @author: zhangyu
 * date: 2016-1-11
 */
Ext.define('app.model.customline.CustomlineDetailModel', {
    extend: 'Ext.data.Model',
    fields: [
        {
            type: 'int',
            name: 'cstId'
        },
        {
            type: 'string',
            name: 'cityId'
        },
        {
            type: 'int',
            name: 'day'
        },{

            type: 'string',
            name: 'cityNameEn'
        },{

            type: 'string',
            name: 'cityName'
        }

    ]
});
