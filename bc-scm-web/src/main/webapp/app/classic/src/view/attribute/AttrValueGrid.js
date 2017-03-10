/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 属性值管理表格
 * @author: fengbaitong
 * date: 2015-12-25
 */
Ext.define('app.view.attribute.AttrValueGrid', {
  extend: 'Ext.grid.Panel',
  xtype:'attrvaluegrid',
  storeName:'attrValueGridStore',
  columnLines: true,
  scrollable:true,
  autoLoad:true,
  height: 400,
  selModel: {
    selType: 'checkboxmodel'
  },
  id:'attrvaluegrid',
  viewModel:{
    type:'attribute'
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
        {dataIndex: 'id',hidden:true
        },
        {dataIndex: 'attrId',hidden:true
        },
        {dataIndex: 'value', flex: 2,bind:{
          text:'{attributeValue}'
        }},
        {dataIndex: 'sort',  flex: 2,bind:{
          text:'{sort}'
        }}

      ],
  initComponent: function() {

    // 创建一个store
    var viewmodel = this.lookupViewModel(true);
    var store = viewmodel.getStore(this.storeName);
    var columns = this.columns;
    if(Ext.isArray(this.columns)){
      columns ={};
      columns.defaults={align:"center"};
      columns.items = this.columns;
    }
    Ext.apply(this, {
      store: store,
      columns:columns
    });
    this.callParent(arguments);
  }
});