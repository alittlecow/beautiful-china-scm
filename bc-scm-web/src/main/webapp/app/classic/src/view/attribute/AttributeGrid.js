/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 属性管理表格
 * @author: fengbaitong
 * date: 2015-12-25
 */
Ext.define('app.view.attribute.AttributeGrid', {
  extend: 'app.view.base.BaseGrid',
  columnLines: true,
  xtype:'attributegrid',
  storeName:'attributeGridStore',
  id:'attributegrid',
  selModel: {
    selType: 'rowmodel'
  },

      columns: [
        {dataIndex: 'categoryId',hidden:true
        },
        {dataIndex: 'attributeId',hidden:true
        },
        {dataIndex: 'categoryName',  width: 190,bind:{
          text:'{categoryName}'
        }},
        {dataIndex: 'attributeName',  width: 200,bind:{
          text:'{attributeName}'
        }},
        //{dataIndex: 'attributeNameFr',  width: 210,bind:{
        //  text:'{attributeNameFr}'
        //}},
        {dataIndex: 'attributeValue',  width: 190,bind:{
          text:'{attributeValue}'
        }},
        //{dataIndex: 'attributeValueFr', width: 190,bind:{
        //  text:'{attributeValueFr}'
        //}},
        {dataIndex: 'sort', width: 100,bind:{
          text:'{sort}'
        }},
        {
          xtype: 'widgetcolumn',
          width: 220,
          iconCls:'x-fa fa-power-off',
          widget: {
            xtype: 'button',
            width: 180,
            //iconCls:"x-fa fa-edit",
            bind: {
              text: '{editAttribute}'
            },
            handler: 'editAttribute'
          }
        },{
          xtype: 'widgetcolumn',
          width: 200,
          iconCls:'x-fa fa-power-off',
          widget: {
            width: 160,
            xtype: 'button',
            //iconCls:"x-fa fa-edit",
            bind: {
              text: '{editAttributeValue}'
            },
            handler: 'editAttributeValue'
          }
        },{
          xtype: 'widgetcolumn',
          width: 140,
          iconCls:'x-fa fa-power-off',
          widget: {
            xtype: 'button',
            width: 100,
            //iconCls:"x-fa fa-remove",
            bind: {
              text: '{deleteAttribute}'
            },
            handler: 'delete'
          }
        }
      ]

});