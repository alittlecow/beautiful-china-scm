/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 目的地表格
 * @author: dongjingjun
 * date: 2016-01-07
 */

Ext.define('app.view.destination.DesGrid', {
    extend: 'app.view.base.BaseGrid',
    xtype: 'desgrid',
    storeName: 'desGridStore',
    tbar: [{
        xtype: 'addbtn',
        handler: 'add'
    }, {
        xtype: 'delbtn',
        handler: 'delete'
    }, {
        xtype: 'editbtn',
        handler: 'edit'
    }],
    columns: [
        {
            dataIndex: 'cityName', flex: 2, bind: {
            text: '{destination}'
        }
        }, {
            dataIndex: 'title', flex: 2, bind: {
                text: '{disTitle}'
            }
        }
    ]
});