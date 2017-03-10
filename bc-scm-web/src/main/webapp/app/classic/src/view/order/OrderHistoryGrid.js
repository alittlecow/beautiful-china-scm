/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 * @author: zhuhoufeng
 * date: 2016-01-20
 */

/**
 * 订单管理表格
 */
Ext.define('app.view.order.OrderHistoryGrid',{
    extend: 'app.view.base.BaseGrid',
    xtype:'orderhistorygrid',
    id:'orderhistorygrid',
    storeName:'orderHistoryGridStore',


    columns: [
        {dataIndex: 'orderNo',width:200,bind:{
            text:'{ordOrderNo}'
        }},
        {dataIndex: 'tourName',width:120,bind:{
            text:'{ordTourName}'
        }},{dataIndex: 'contact',width:100,bind:{
            text:'{ordContact}'
        }},{dataIndex: 'email',width:250,bind:{
            text:'{ordEmail}'
        }},{dataIndex: 'telephone', width:180,bind:{
            text:'{ordTelephone}'
        }},{dataIndex: 'adults',width:120,bind:{
            text:'{ordAdults}'
        }},{dataIndex: 'children',width:140,bind:{
            text:'{ordChildren}'
        }},{dataIndex: 'room',width:140, bind:{
            text:'{ordRoom}'
        }},{dataIndex: 'departure',width:150,bind:{
            text:'{ordDeparture}'
        }},
        {dataIndex: 'state', width:100,renderName:"orderStatus",renderer: "render",bind:{
            text:'{ordState}'
        }},
        {dataIndex: 'total',width:100,bind:{
            text:'{ordTotal}'
        }},
        {dataIndex: 'placedTime',width:150,bind:{
            text:'{ordPlacedTime}'
        }},
        {dataIndex: 'operateTime', width: 150,bind:{
            text:'{ordOperateTime}'
        }},
        {dataIndex: 'operator', width: 150,bind:{
            text:'{ordOperator}'
        }}
    ]
});