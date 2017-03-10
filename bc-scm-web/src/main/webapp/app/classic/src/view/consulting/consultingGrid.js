/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 * @author: chengxuemin
 * date: 2016-01-18
 */

/**
 * 咨询投诉管理表格
 */
Ext.define('app.view.consulting.ConsultingGrid',{
    extend: 'app.view.base.BaseGrid',
    xtype:'consultinggrid',
    id:'consultinggrid',
    storeName:'consultingGridStore',
    viewModel: {
        type: 'consulting'
    },
    selModel: {
        selType: 'checkboxmodel'
    },
    tbar : [{
        xtype:'dealbtn',
        handler: 'deal'
    }],
    columns: [
        {dataIndex: 'name', flex: 2,bind:{
            text:'{nameCon}'
        }},
        {dataIndex: 'type', flex: 2,renderer: function (value) {
            var retValue = '';
            if (value === 'A') {
                retValue = 'advisory';
            } else {
                retValue = 'complain';
            }
            return retValue;
        },bind:{
            text:'{typeCon}'
        }},
        {dataIndex: 'email', flex: 2,bind:{
            text:'{emailCon}'
        }},
        {dataIndex: 'phone',  flex: 2, bind:{
            text:'{phone}'
        }},
        {dataIndex: 'status', flex: 2,renderer: function (value) {
            var retValue = '';
            if (value === 'N') {
                retValue = 'untreated';
            } else {
                retValue = 'treated';
            }
            return retValue;
        },bind:{
            text:'{status}'
        }},
        {dataIndex: 'createTime',  flex: 2, bind:{
            text:'{createTime}'
        }},
        {dataIndex: 'passId', flex: 2,bind:{
            text:'{passId}'
        }},
        {dataIndex: 'dealTime',  flex: 2, bind:{
            text:'{dealTime}'
        }},
        {
            dataIndex: 'deal', flex: 1, bind: {
            text: '{deal}'
            , hidden: true
        }},
        {
            dataIndex: 'content', flex: 1, bind: {
            text: '{contentConCom}'
            , hidden: true
        }},
        {
            dataIndex: 'id', flex: 1, bind: {
            text: '{id}'
            , hidden: true
        }}
    ]
});