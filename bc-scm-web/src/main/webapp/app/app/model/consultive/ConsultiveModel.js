/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 * @author: chengxuemin
 * date: 2016-01-11
 */

/**
 * 咨询管理表格数据模型
 */
Ext.define('app.model.category.CategoryModel',{
    extend: 'Ext.data.Model',
    fields: [
    /**
     * id代码
     */
        {
            type: 'int',
            name: 'id'
        },
    /**
     * 封装线路id代码
     */
        {
            type: 'int',
            name: 'tourId'
        },
    /**
     * 封装线路NAME代码
     */
        {
            type: 'string',
            name: 'tourName'
        },
    /**
     * 封装内容代码
     */
        {
            type: 'string',
            name: 'content'
        },
    /**
     * 封装QA状态代码
     */
        {
            type: 'string',
            name: 'status'
        },
    /**
     * 封装提问人email代码
     */
        {
            type: 'string',
            name: 'email'
        },
    /**
     * 封装提问时间代码
     */
        {
            type: 'string',
            name: 'time'
        },
    /**
     * 封装回复内容代码
     */
        {
            type: 'string',
            name: 'contentAn'
        },
    /**
     * 封装回复人类型代码
     */
        {
            type: 'string',
            name: 'type'
        }]
});