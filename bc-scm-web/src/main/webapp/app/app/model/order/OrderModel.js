/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: zhuhoufeng
 * date: 2016-01-20
 */

/**
 * 订单管理表格数据模型
 */
Ext.define('app.model.order.OrderModel',{
    extend: 'Ext.data.Model',
    fields: [
        {
            type: 'int',
            name: 'id'
        },
        {
            type: 'string',
            name: 'orderNo'
        },
        {
            type: 'int',
            name: 'tourId'
        },
        {
            type: 'string',
            name: 'tourName'
        },

        {
            type: 'string',
            name: 'contact'
        },

        {
            type: 'string',
            name: 'email'
        },

        {
            type: 'string',
            name: 'telephone'
        },

        {
            type: 'int',
            name: 'adults'
        },

        {
            type: 'int',
            name: 'children'
        },

        {
            type: 'int',
            name: 'room'
        },

        {
            type: 'string',
            name: 'departure'
        },

        {
            type: 'string',
            name: 'state'
        },

        {
            type: 'number',
            name: 'total'
        },

        {
            type:'string',
            name:'placedTime'
        },
        {
            type:'string',
            name:'operateTime'
        },
        {
            type:'string',
            name:'operator'
        },
        {
            type:'string',
            name:'fullname'
        },{
            type:'string',
            name:'sex'
        },{
            type:'string',
            name:'nationality'
        },{
            type:'string',
            name:'passport'
        },{
            type:'string',
            name:'phone'
        },{
            type:'string',
            name:'type'
        },{
            type:'string',
            name:'optioName'
        },{
            type:'number',
            name:'price'
        },{
            type:'int',
            name:'valueId'
        },{
            type:'string',
            name:'optionValueName'
        },{
            type:'int',
            name:'optionId'
        }
    ]
});