/**
 * Copyright @ 2016 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 首页展示类型数据模型
 * @author: zhangyu
 * date: 2016-1-15
 */
Ext.define('app.model.display.DisplayModel', {
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
            name: 'titleEn'
        },
        {
            type: 'string',
            name: 'nameEn'
        },
        {
            type: 'number',
            name: 'trdPrice'
        },
        {
            type: 'string',
            name: 'supName'
        }
    ]
});
