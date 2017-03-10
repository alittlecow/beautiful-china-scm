/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 菜单树
 * @author: chenghuanhuan
 * date: 2015-11-16
 */
Ext.define('app.view.main.MainTreePanel', {
    extend: 'Ext.tree.Panel',
    title: 'Simple Tree',
    xtype: 'maintree',
    viewModel: {
        type: 'main'
    },
    rootVisible: false,
    listeners: {
        itemclick: 'onItemClick'
    },
    initComponent: function() {
        var store = this.getViewModel().getStore('treeStore');
        //var store = Ext.create("app.store.main.MainTreeStore",{proxy:{extraParams:{moduleId:this.itemId}}});
        store.load({params:{moduleId:this.itemId}});
        //store.load({params:{moduleId:this.itemId}});
        Ext.apply(this, {
            store: store
        });
        this.callParent(arguments);
    }
});