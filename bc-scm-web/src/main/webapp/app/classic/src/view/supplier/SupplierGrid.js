/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 供应商管理表格
 * @author: fengbaitong
 * date: 2015-12-10
 */
Ext.define('app.view.supplier.SupplierGrid', {
  extend: 'app.view.base.BaseGrid',
  xtype:'suppliergrid',
  storeName:'supplierGridStore',
  id:'suppliergrid',
  tbar : [ {
    bind:{
      text:'{approve}'
    },
    handler: 'approve'
  },{
    xtype: 'addbtn',
    handler: 'add'
  }, {
    xtype: 'editbtn',
    handler: 'edit'
  }],
      columns: [
        {dataIndex: 'deptCode', width: 150,bind:{
          text:'{supplierCode}'
        }},
        {dataIndex: 'name', width:180,bind:{
          text:'{supplierName}'
        }},
        {dataIndex: 'tel', width:100,bind:{
          text:'{supplierTel}'
        }},
        {dataIndex: 'tel2', width: 100,bind:{
          text:'{supplierTel2}'
        }},
        {dataIndex: 'legal', width: 150,bind:{
          text:'{legal}'
        }},
        {dataIndex: 'status', width: 100,renderName:"approve",renderer: "render"
          ,bind:{
          text:'{status}'
        }},
        {dataIndex: 'contact', width:150,bind:{
          text:'{contact}'
        }},
        {dataIndex: 'regTime', width:150,bind:{
          text:'{regTime}'
        }},
        {dataIndex: 'approver', width: 100,bind:{
          text:'{approver}'
        }},
        {dataIndex: 'approveTime', width: 150,bind:{
          text:'{approveTime}'
        }},
        {
          xtype: 'widgetcolumn',
          width: 120,
          widget: {
            xtype: 'button',
            width: 80,
            bind: {
              text: '{detail}'
            },
            handler: 'detail'
          }
        }
      ]

});