/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 平台用户管理表格
 * @author: fengbaitong
 * date: 2015-12-10
 */
Ext.define('app.view.platform.PlatformGrid', {
  extend: 'app.view.base.BaseGrid',
  columnLines: true,
  xtype:'platformgrid',
  storeName:'platformGridStore',
  id:'platformgrid',
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
        {dataIndex: 'name', width: 100,bind:{
          text:'{name}'
        }},
        {dataIndex: 'loginName', width: 100,bind:{
          text:'{loginName}'
        }},
        {dataIndex: 'deptName', width: 180,bind:{
          text:'{supplier}'
        }},
        {dataIndex: 'roleNameEn', width: 100,bind:{
          text:'{role}'
        }},
        {dataIndex: 'loginTime', width: 180,bind:{
          text:'{lastLoginTime}'
        }},
        {dataIndex: 'loginIp', width: 160,bind:{
          text:'{lastLoginIp}'
        }},
        {dataIndex: 'status', width:100,renderName:"normalStop",renderer: "render",bind:{
          text:'{status}'
        }},
        {dataIndex: 'tel', width: 120,bind:{
          text:'{tel}'
        }},
        {dataIndex: 'tel2', width:120,bind:{
          text:'{tel2}'
        }}

      ]

});