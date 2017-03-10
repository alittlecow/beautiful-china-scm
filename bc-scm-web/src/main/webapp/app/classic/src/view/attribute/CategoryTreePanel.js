/**
 * Created by Intellij IDEA 14.
 *User:fengbaitong
 *Date:2015/12/16
 *Time:10:58
 *Project:分类的树
 */

Ext.define('app.view.attribute.CategoryTreePanel', {
    extend: 'Ext.tree.Panel',
    xtype: 'categorytree',
    storeName:'treeStore',
    padding: '5 0 0 0',
    tbar : [{
        xtype:'button',
        bind:{
            text:'{addAttribute}'
        },
        handler: 'addAttribute'
    }],
    rootVisible: false,
    listeners: {
        itemclick: 'onItemClick'
    },
    initComponent: function() {
        var viewmodel = this.lookupViewModel(true);
        var store = viewmodel.getStore(this.storeName);
        Ext.apply(this, {
            store: store
        });
        this.callParent(arguments);
    }
});