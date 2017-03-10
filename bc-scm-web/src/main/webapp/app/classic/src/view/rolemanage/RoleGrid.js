/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: dongjingjun
 * date: 2015-12-21
 * 角色表格
 */
Ext.define('app.view.rolemanage.RoleGrid', {
    extend: 'app.view.base.BaseGrid',
    xtype:'rolegrid',
    storeName:'roleGridStore',
    viewModel: {
        type: 'role'
    },
    selModel: {
        selType: 'checkboxmodel',
        mode : 'SINGLE'
    },
    border:true,
    listeners:{
        selectionchange: 'show'
    },
    columns: [
        //{bind: {text: '{No}'}, xtype: "rownumberer", flex: 1},
        {bind: {text: '{roleCode}'}, dataIndex: 'roleCode', flex: 1.5},
        {bind: {text: '{roleName}'}, dataIndex: 'roleName', flex: 2},
        {
            bind: {text: '{roleStatus}'}, dataIndex: 'status', align: 'center', flex: 1.5,renderName:"normalStop",renderer: "render"
        }
    ]

});