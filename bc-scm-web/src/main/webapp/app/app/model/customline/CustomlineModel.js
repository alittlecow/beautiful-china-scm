/**
 * Copyright @ 2016 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 用户表格数据模型
 * @author: zhangyu
 * date: 2016-1-7
 */
Ext.define('app.model.customline.CustomlineModel', {
    extend: 'Ext.data.Model',
    fields: [
        {
            type: 'int',
            name: 'id'
        },
        {
            type: 'string',
            name: 'name'
        },
        {
            type: 'string',
            name: 'sex'
        },
        {
            type: 'string',
            name: 'email'
        },
        {
            type: 'string',
            name: 'phone'
        },
        {
            type: 'int',
            name: 'person'
        },
        {
            type: 'string',
            name: 'arriveTime'
        },
        {
            type: 'string',
            name: 'returnTime'
        },
        {
            type: 'int',
            name: 'hotelLevel'
        },
        {
            type: 'string',
            name: 'otherRequirement'
        },
        {
            type: 'string',
            name: 'status'
        },
        {
            type: 'string',
            name: 'createTime'
        },{
            type:'string',
            name:'result'
        },
        {
            type:'int',
            name:'passId'
        },
        {
            type:'string',
            name:'passName'
        },
        {
            type:'string',
            name:'dealTime'
        }

    ]
});
