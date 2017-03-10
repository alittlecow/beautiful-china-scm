/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: dongjingjun
 * date: 2015-12-21
 * 部门等级管理表格
 */
Ext.define('app.view.dlmanage.DLMGrid', {
    extend: 'app.view.base.BaseGrid',
    xtype: 'dlmgrid',
    storeName: 'dLMGridStore',
    plugins: [{
        ptype: 'rowediting',
        clicksToMoveEditor: 1,
        autoCancel: false
    }],
    listeners: {
        edit: 'update'
    },
    tbar: [{
        xtype: 'addbtn',
        handler: 'add'
    }, {
        xtype: 'delbtn',
        handler: 'delete'
    }],

    columns: [
        //{
        //    xtype: 'rownumberer', flex: 0.5, bind: {
        //    text: '{No}'
        //}
        //},
        {
            dataIndex: 'code', width:200, bind: {
            text: '{dLCode}'
        }
        },
        {
            dataIndex: 'supCode', width:250, bind: {
            text: '{sDLCode}'
        }
        },
        {
            dataIndex: 'name', width:250, bind: {
            text: '{dLName}'
        }, editor: {allowBlank: false}
        },
        {
            dataIndex: 'operateTime', width:200, bind: {
            text: '{operateTime}'
        }
        },
        {
            dataIndex: 'operating', width:120, bind: {
            text: '{operating}'
        }
        }
    ]
});