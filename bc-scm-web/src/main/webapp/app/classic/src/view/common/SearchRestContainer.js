/**
 * Copyright @ 2015 南京网华信息科技有限公司.
 * All right reserved.
 * 搜索查询重置按钮
 * @author: chenghuanhuan
 * date: 15/12/18
 */
Ext.define('app.view.common.SearchRestContainer', {
    extend: 'Ext.container.Container',
    xtype: 'searchreset',
    //style: {borderColor:'#FF3030', borderStyle:'solid', borderWidth:'1px'},
    layout: {
        type: 'hbox',
        pack:'end',
        align:'middle'
    },
    padding:'0 18 0 0',
    items:[{
        xtype:'searchbtn',
        handler:'query'
    },{
        xtype: 'tbspacer',
        width:10
    },{
        xtype:'resetbtn',
        handler:'reset'
    }]
});