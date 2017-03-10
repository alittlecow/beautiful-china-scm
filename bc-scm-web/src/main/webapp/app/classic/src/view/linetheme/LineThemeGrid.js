/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 * @author: chengxuemin
 * date: 2015-12-22
 */

/**
 * 线路主题管理表格
 */
Ext.define('app.view.linetheme.LineThemeGrid',{
    extend: 'app.view.base.BaseGrid',
    xtype:'linethemegrid',
    storeName:'linethemeGridStore',
    viewModel: {
        type: 'linetheme'
    },
    selModel: {
        selType: 'checkboxmodel'
    },
    tbar : [ {
        xtype:'addbtn',
        handler: 'add'
    },{
        xtype:'delbtn',
        handler: 'delete'
    },{
        xtype:'editbtn',
        handler: 'edit'
    }],
    columns: [
        {dataIndex: 'id', flex: 2,bind:{
            text:'{thmId}',hidden:true
        }},
        {dataIndex: 'title', flex: 2,bind:{
            text:'{thmTitle}'
        }}
    ]
});