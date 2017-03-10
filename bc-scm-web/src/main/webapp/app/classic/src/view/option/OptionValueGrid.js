/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 选项值表格
 * @author: liufei
 * date: 2015-12-22
 */
Ext.define('app.view.option.OptionValueGrid', {
    extend: 'app.view.base.BaseGrid',
    xtype:'optionvaluegrid',
    padding:'5 0 0 2.5',
    storeName:'optionValueGridStore',
    //选项值列表
    bind: {title: '{theOptionValueList}'},
    selModel: {
        selType: 'checkboxmodel',
        mode : 'SINGLE'
    },
    controller:'option',
    viewModel:{
        type:'option'
    },
    tbar : [{
        xtype:'addbtn',
        handler: 'addValue'
    },{
        xtype:'delbtn',
        handler: 'deleteValue'
    },{
        xtype:'editbtn',
        handler: 'editValue'
    }],
    columns:[
        {dataIndex:'optionValue',align:'center',width:180,bind:{
            text:'{optionName}'
        }},
        //{dataIndex:'optionFrValue',align:'center',width:180,bind:{
        //    text:'{optionFrName}'
        //}},
        //{dataIndex:'optionEnNotes',align:'center',width:170,bind:{
        //    text:'{optionEnNotes}'
        //}},
        {dataIndex:'optionNotes',align:'center',width:170,bind:{
            text:'{optionNotes}'
        }},
        {dataIndex:'optionPrice',align:'center',width:170,bind:{
            text:'{optionPrice}'
        }}
    ]
});