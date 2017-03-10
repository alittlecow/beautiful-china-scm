/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 菜单表格
 * @author: chenghuanhuan
 * date: 2015-11-16
 */
Ext.define('app.view.menu.MenuGrid', {
    extend: 'app.view.base.BaseGrid',
    xtype:'menugrid',
    storeName:'menuGridStore',
    bind:{
        store:'{menuGridStore}'
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
        //{xtype: 'rownumberer'},
        //{header: '代码', dataIndex: 'code',width: 1},
        {dataIndex: 'menuName',width:200,bind:{
            text:'{menuName}'
        }},
        {dataIndex: 'link',width:100,bind:{
            text:'{link}'
        }},
        {dataIndex: 'moduleName',width:200,bind:{
            text:'{module}'
        }},
        {dataIndex: 'plateName',width: 150,bind:{
            text:'{plate}'
        }},
        {dataIndex: 'sort',width: 100,bind:{
            text:'{sort}'
        }},
        {dataIndex: 'notes',width: 100,bind:{
            text:'{notes}'
        }},
        {dataIndex: 'status',width: 100,renderName:"normalStop",renderer: "render",bind:{
            text:'{status}'
        }}
    ]
});