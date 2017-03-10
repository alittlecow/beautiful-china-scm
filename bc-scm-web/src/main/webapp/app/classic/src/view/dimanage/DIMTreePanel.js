/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: dongjingjun
 * date: 2015-12-21
 * 部门信息管理树
 */
Ext.define('app.view.dimanage.DIMTreePanel', {
    extend: 'Ext.tree.Panel',
    xtype: 'dimtree',
    viewModel: {
        type: 'dimtree'
    },
    padding: '5 0 0 0',
    tbar: [{
        xtype: 'addbtn',
        handler: 'add'
    }, {
        xtype: 'delbtn',
        handler: 'delete'
    }],
    rootVisible: false,
    listeners: {
        itemclick: 'onItemClick'
    },
    initComponent: function () {
        var store = this.getViewModel().getStore('treeStore');
        Ext.apply(this, {
            store: store
        });
        this.callParent(arguments);
    }
});