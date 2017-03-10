/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: dongjingjun
 * date: 2015-12-21
 * 角色管理面板
 */
Ext.define('app.view.rolemanage.RoleManagePanel', {
    extend: 'Ext.container.Container',
    xtype: 'rolemanage',
    controller:'role',
    viewModel: {
        type: 'role'
    },
    requires: [
        'app.view.rolemanage.RoleTreePanel',
        'app.view.rolemanage.RoleCCSBtnContainer',
        'app.view.rolemanage.RoleAEBtnContainer',
        'app.view.rolemanage.RoleInfoWindow',
        'app.view.rolemanage.RoleGrid',

        'app.model.rolemanage.RoleModel',

        'app.store.rolemanage.RoleGridStore',
        'app.store.rolemanage.RoleTreeStore',

        'app.view.rolemanage.RoleViewModel',

        'app.view.rolemanage.RoleController',
        'app.view.rolemanage.RoleWindowController'


    ],
    layout: {
        type: 'hbox',
        align: 'stretch',
        pack: 'start',
        margin: '20 0 0 5'
    },
    items: [
        {
            xtype: 'container',
            padding: '5 0 0 0',
            flex: 2,
            layout: {
                type: 'vbox',
                align: 'stretch'
                //pack: 'start'
            },
            items: [
                {
                    xtype: 'rolemodifybtn'
                },
                {
                    xtype: 'rolegrid',
                    id: 'rolegrid',
                    flex: 1
                }
            ]
        },
        {
            xtype: 'container',
            padding: '5 0 0 0',
            flex: 1,
            layout: {
                type: 'vbox',
                align: 'stretch'
            },
            items: [
                {
                    xtype: 'rolesavebtn',
                    id: 'savebtn',
                    hidden: true
                },
                {
                    xtype:'rolemanagetree',
                    id:'rolemanagetree',
                    flex:1
                }
            ]

        }
    ]
});