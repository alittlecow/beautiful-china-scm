/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 * @author: chengxuemin
 * date: 2016-01-18
 */

/**
 * 咨询投诉管理表格数据模型
 */
Ext.define('app.model.consulting.ConsultingModel',{
    extend: 'Ext.data.Model',
    fields: [
    /**
     * 封装名称代码
     */
        {
            type: 'string',
            name: 'name'
        },
    /**
     * 封装类型代码
     */
        {
            type: 'string',
            name: 'type'
        },
    /**
     * 封装email代码
     */
        {
            type: 'string',
            name: 'email'
        },
    /**
     * 封装电话代码
     */
        {
            type: 'string',
            name: 'phone'
        },
    /**
     * 封装状态代码
     */
        {
            type: 'string',
            name: 'status'
        },
    /**
     * 封装创建时间代码
     */
        {
            type: 'string',
            name: 'createTime'
        },
    /**
     * 封装处理人员代码
     */
        {
            type: 'int',
            name: 'passId'
        },
    /**
     * 封装处理时间代码
     */
        {
            type: 'string',
            name: 'dealTime'
        },
    /**
     * 封装处理结果代码
     */
        {
            type: 'string',
            name: 'deal'
        },
    /**
     * 封装内容代码
     */
        {
            type: 'string',
            name: 'content'
        },
    /**
     * 封装id代码
     */
        {
            type: 'string',
            name: 'id'
        }
    ]
});