/**
 * Copyright @ 2016 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 定制线路管理表格
 * @author: 张宇
 * date: 2016-1-7
 */
Ext.define('app.view.customline.CustomlineGrid', {
  extend: 'app.view.base.BaseGrid',
  columnLines: true,
  xtype:'customlinegrid',
  storeName:'customlineGridStore',
  id:'customlinegrid',
  requires: [
    'app.view.customline.CustomlineViewModel'
  ],
  viewModel:{
    type:'customline'
  },
  selModel: {
    selType: 'checkboxmodel'
  },
  tbar : [ {
    xtype:'editbtn',
    handler: 'edit'
  }],
      columns: [
        {dataIndex: 'name', width:100,bind:{
          text:'{custName}'
        }},
        {dataIndex: 'email', width:200,bind:{
          text:'{custEmail}'
        }},
        {dataIndex: 'phone', width:100,bind:{
          text:'{custPhone}'
        }},

        {dataIndex: 'arriveTime', width:100,bind:{
          text:'{arriveTime}'
        }},
        {dataIndex: 'returnTime', width:200,bind:{
          text:'{returnTime}'
        }},{dataIndex: 'hotelLevel', width:100,bind:{
          text:'{hotelLevel}'
        }},
        {dataIndex: 'status', width:200,bind:{
          text:'{CustStatus}'
        }},
        {dataIndex: 'createTime', width:200,bind:{
          text:'{createTime}'
        }}
      ]

});