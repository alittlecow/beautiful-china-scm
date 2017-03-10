/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 选项表格
 * @author: liufei
 * date: 2015-12-22
 */
Ext.define('app.view.option.OptionNameGrid', {
    extend: 'app.view.base.BaseGrid',
    xtype:'optionnamegrid',
    storeName:'optionNameGridStore',
    padding:'5 2.5 0 0',
    //选项列表
    bind: {title: '{optionList}'},
    selModel: {
        selType: 'checkboxmodel',
        mode : 'SINGLE'
    },
    controller:'option',
    viewModel:{
        type:'option'
    },
    listeners: {
        itemclick: 'optionNameGridClick'
    },
    tbar : [{
        xtype:'addbtn',
        handler: 'add'
    },{
        xtype:'delbtn',
        handler: 'delete'
    }],
    columns:[
        {dataIndex:'optionId',flex:1,bind:{
            text:'{optionId}',hidden: true
        }},
        //{dataIndex:'optionEnName',flex:2,bind:{
        //    text:'{optionEnName}'
        //}},
        {dataIndex:'optionName',flex:2,bind:{
            text:'{optionName}'
        }}
    ]
});