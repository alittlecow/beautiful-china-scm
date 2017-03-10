/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: dongjingjun
 * date: 2015-12-21
 */
/**
 * 部门等级管理表格数据模型
 */
Ext.define('app.model.dlmanage.DLMModel', {
    extend: 'Ext.data.Model',
    fields: [
        {
            type: 'string',
            name: 'code'
        },
        {
            type: 'string',
            name: 'name'
        },
        {
            type: 'string',
            name: 'supCode'
        },
        {
            type: 'string',
            name: 'enName'
        },
        {
            type: 'string',
            name: 'fnName'
        },
        {
            type: 'string',
            name: 'operateTime'
        },
        {
            type: 'string',
            name: 'operating'
        }
    ]
});
