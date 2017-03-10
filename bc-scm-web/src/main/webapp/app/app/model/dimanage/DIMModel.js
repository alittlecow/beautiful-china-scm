/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: dongjingjun
 * date: 2015-12-21
 */
/**
 * 部门信息管理表格数据模型
 */

Ext.define('app.model.dimanage.DIMModel', {
    extend: 'Ext.data.Model',
    fields: [
        {
            type: 'string',
            name: 'id'
        },
        {
            type: 'string',
            name: 'deptCode'
        },
        {
            type: 'string',
            name: 'levelCode'
        },
        {
            type: 'string',
            name: 'deptName'
        },
        {
            type: 'string',
            name: 'deptNameEn'
        },
        {
            type: 'string',
            name: 'deptNameFr'
        },
        {
            type: 'string',
            name: 'supDept'
        },
        {
            type: 'string',
            name: 'status'
        },
        {
            type: 'string',
            name: 'operateTime'
        },
        {
            type: 'string',
            name: 'operator'
        }
    ]
});