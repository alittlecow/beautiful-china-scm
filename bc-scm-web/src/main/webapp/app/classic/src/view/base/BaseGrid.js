/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 基础表格
 * @author: chenghuanhuan
 * date: 2015-12-11
 */
Ext.define('app.view.base.BaseGrid', {
    extend: 'Ext.grid.Panel',
    columnLines: true,
    xtype:'basegrid',
   // controller:'base',
    //padding:'0 5 0 5',
    padding: '5 0 0 0',
    scrollable:true,
    height: 400,
    pageSize: 20,
    storeName:'',
    autoLoad:true,
    viewModel: {
        type: 'base'
    },
    selModel: {
        selType: 'checkboxmodel'
    },
    initComponent: function() {

        // 创建一个store
        var viewmodel = this.lookupViewModel(true);
        var store = viewmodel.getStore(this.storeName);
        var dockedItems = [];
        if(this.pageSize !== 0){
            dockedItems=[
                {
                    xtype: 'pagingtoolbar',
                    dock: 'bottom',
                    displayInfo: true,
                    store:store
                }
            ];
        }
        var columns = this.columns;
        if(Ext.isArray(this.columns)){
            columns ={};
            columns.defaults={align:"center"};
            columns.items = this.columns;
        }
        //是否显示分页工具条
        Ext.apply(this, {
            store: store,
            // 给grid创建底部bbar
            dockedItems: dockedItems,
            columns:columns
        });
        this.callParent(arguments);
    }
});