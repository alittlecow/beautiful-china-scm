/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 * @author: chengxuemin
 * date: 2016-01-11
 */

/**
 * 咨询管理表格
 */
Ext.define('app.view.consultive.ConsultiveGrid',{
    extend: 'app.view.base.BaseGrid',
    xtype:'consultivegrid',
    id:'consultivegrid',
    storeName:'consultiveGridStore',
    columns: [
        {
            dataIndex: 'id', flex: 1, bind: {
            text: '{id}'
            , hidden: true
        }},{
            xtype:'widgetcolumn',
            flex: 0.7,
            widget: {
                xtype: 'button',
                iconCls:"x-fa fa-close",
                bind:{
                    tooltip: '{close}'
                },
                handler: 'close'

            }
        } ,{
            xtype:'widgetcolumn',
            flex: 0.7,
            widget:{
                xtype: 'button',
                iconCls:"x-fa fa-edit",
                bind:{
                    tooltip: '{reply}'
                },
                handler: 'reply'
            }
        } ,
        {dataIndex: 'tourName', flex: 2,bind:{
            text:'{tourName}'
        }},
        {dataIndex: 'content', flex: 2.5,bind:{
            text:'{contentCon}'
        }},
        {dataIndex: 'status', flex: 1, renderer: function (value) {
            var retValue = '';
            if (value === 'O') {
                retValue = 'open';
            } else {
                retValue = 'close';
            }
            return retValue;
        }, bind: {
            text: '{status}'
        }
        },
        {dataIndex: 'email', flex: 2,bind:{
            text:'{userId}'
        }},
        {dataIndex: 'time',  flex: 2, bind:{
            text:'{timeCon}'
        }}

    ]
});