/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 景点表格
 * @author: dongjingjun
 * date: 2016-01-05
 */

Ext.define('app.view.sights.SightsGrid', {
    extend: 'app.view.base.BaseGrid',
    xtype: 'sightsgrid',
    storeName: 'sightsGridStore',
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
            dataIndex: 'name', flex: 2, bind: {text: '{sightsName}'}
        },
        {
            dataIndex: 'cityName', flex: 2, bind: {text: '{destination}'}
        },
        {
            dataIndex: 'price', flex: 2, bind: {text: '{price}'}
        }
    ]
});