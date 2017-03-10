/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 * @author: chengxuemin
 * date: 2015-12-22
 */

/**
 * 分类管理表格
 */
Ext.define('app.view.category.CategoryGrid',{
    extend: 'app.view.base.BaseGrid',
    xtype:'categorygrid',
    id:'categorygrid',
    storeName:'categoryGridStore',
    viewModel: {
        type: 'category'
    },
    selModel: {
        selType: 'checkboxmodel'
    },
    tbar : [{
        xtype:'addbtn',
        handler: 'add'
    },{
        xtype:'delbtn',
        handler: 'delete'
    },{
        xtype:'editbtn',
        handler: 'edit'
    },{
        xtype:'returnbtn',
        handler: 'returnBtn'
    }],
    columns: [
        {dataIndex: 'name', flex: 2,bind:{
            text:'{ctgName}'
        }},
        /*{dataIndex: 'id', flex: 2,bind:{
            text:'{ctgId}', hidden: true
        }},*/
        /*{dataIndex: 'nameFr', flex: 2,bind:{
            text:'{ctgNameFr}'
        }},*/
        {dataIndex: 'code', flex: 2,bind:{
            text:'{ctgCode}'
          }},
        {dataIndex: 'level',  flex: 2, bind:{
                text:'{ctgLevel}'
        }},
        {
            xtype: 'widgetcolumn',
            width: 240,
            widget: {
                xtype: 'button',
                width: 200,
                //iconCls:'x-fa fa-search-plus',
                bind: {
                    text: '{intoSub}'
                },
                handler: 'intoSub'
            }
        }
    ]
});