/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: dongjingjun
 * date: 2015-12-21
 * 角色菜单树
 */
Ext.define('app.view.rolemanage.RoleTreePanel', {
    extend: 'Ext.tree.Panel',
    xtype: 'rolemanagetree',
    enableAllCheck:true,
    viewModel: {
        type: 'role'
    },
    rootVisible: false,

    listeners: {
        checkchange:'onCheckboxChange'
        //itemclick: 'onItemClick'
    },

    initComponent: function() {
        var store = this.getViewModel().getStore('treeStore');
        Ext.apply(this, {
            store: store
        });
        this.callParent(arguments);
    }
});