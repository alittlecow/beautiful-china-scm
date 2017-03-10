/**
 * Copyright @ 2015 南京网华信息科技有限公司.
 * All right reserved.
 * @author: chenghuanhuan
 * date: 15/12/28
 */
/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 平台用户表格数据模型
 * @author: fengbaitong
 * date: 2015-11-16
 */
Ext.define('app.model.supplier.SupplierModel', {
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
            name: 'name'
        },
        {
            type: 'string',
            name: 'address'
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
            name: 'legal'
        },
        {
            type: 'string',
            name: 'supDesc'
        },
        {
            type: 'string',
            name: 'license'
        },
        {
            type: 'string',
            name: 'contact'
        },
        {
            type: 'string',
            name: 'email'
        },{
            type: 'string',
            name: 'website'
        },{
            type: 'string',
            name: 'status'
        },{
            type: 'string',
            name: 'sRemark'
        },{
            type: 'string',
            name: 'rReason'
        },{
            type: 'string',
            name: 'regTime'
        },{
            type: 'string',
            name: 'approver'
        },{
            type: 'string',
            name: 'approveTime'
        },{
            type:'string',
            name:'limit'
        },{
            type:'string',
            name:'start'
        }

    ]
});
