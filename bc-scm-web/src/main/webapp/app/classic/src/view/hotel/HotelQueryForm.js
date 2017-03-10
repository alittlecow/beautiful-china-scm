/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 酒店管理查询界面
 * @author: dongjingjun
 * date: 2016-01-03
 */

Ext.define('app.view.hotel.HotelQueryForm', {
    extend: 'Ext.form.Panel',
    xtype: 'hotelqueryform',
    layout: {
        type: 'vbox',
        align: 'stretch'
    },
    height: 100,
    padding: '5 0 0 0',
    items: [{
        xtype: 'container',
        height: 60,
        layout: 'hbox',
        padding: '10 0 10 0',
        defaultType: 'container',
        items: [{
            flex:1,
            layout: 'anchor',
            defaultType: 'textfield',
            defaults: {
                labelAlign: 'right',
                anchor: '33%',
                labelWidth:150
            },
            items: [{
                bind: {fieldLabel: '{hotelName}'},
                name: 'hotelName'
            }]
        }]
    },
        {
            xtype: 'searchreset'
        }]
});