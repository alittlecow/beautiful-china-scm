/**
 * Copyright @ 2016 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 线路选择表格
 * @author: 张宇
 * date: 2016-1-18
 */
Ext.define('app.view.display.DisplayTourDateGrid', {
  extend: 'app.view.base.BaseGrid',
  xtype:'displaytourdategrid',
  storeName:'displayTourDateStore',
  viewModel:{
    type:'display'
  },
  frame:true,
  selModel: {},
  listeners:{
    itemclick:'selectRemoteImage'
  },
      columns: [
        {dataIndex: 'id',hidden:true},

        {dataIndex: 'titleEn', flex: 2,bind:{
          text:'{name}'
        }},
        {dataIndex: 'code', flex: 2,bind:{
          text:'{code}'
        }},
        {dataIndex: 'supName', flex: 2,bind:{
          text:'{supplierName}'
        }},
        {dataIndex: 'trdPrice', flex: 2,bind:{
          text:'{disPrice}'
        }}
      ]

});