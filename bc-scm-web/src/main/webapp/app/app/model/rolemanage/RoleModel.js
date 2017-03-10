/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: dongjingjun
 * date: 2015-12-21
 */
/**
 * 角色管理表格数据模型
 */
Ext.define('app.model.rolemanage.RoleModel', {
    extend: 'Ext.data.Model',
    fields: [
        {
            type: 'string',
            name: 'roleCode'
        },
        {
            type: 'string',
            name: 'roleEnName'
        }, {
            type: 'string',
            name: 'roleFrName'
        }, {
            type: 'string',
            name: 'roleName'
        },
        {
            type: 'string',
            name: 'status'
        },
        {
            type: 'string',
            name: 'roleNotes'
        },
        {
            type: 'string',
            name: 'roleLevel'
        }
    ]
});
