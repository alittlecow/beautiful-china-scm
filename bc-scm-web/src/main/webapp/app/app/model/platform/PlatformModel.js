/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 平台用户表格数据模型
 * @author: fengbaitong
 * date: 2015-11-16
 */
Ext.define('app.model.platform.PlatformModel', {
    extend: 'Ext.data.Model',
    fields: [
        {
            type: 'string',
            name: 'name'
        },
        {
            type: 'string',
            name: 'loginName'
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
            name: 'deptCode'
        },
        {
            type: 'string',
            name: 'roleCode'
        },
        {
            type: 'string',
            name: 'loginTime'
        },
        {
            type: 'string',
            name: 'loginIp'
        },
        {
            type: 'string',
            name: 'status'
        },
        {
            type: 'string',
            name: 'tel'
        },
        {
            type: 'string',
            name: 'tel2'
        },
        {
            type: 'string',
            name: 'id'
        },{
            type:'string',
            name:'limit'
        },
        {
            type:'string',
            name:'start'
        }

    ]
});
