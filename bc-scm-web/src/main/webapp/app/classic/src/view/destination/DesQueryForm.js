/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 目的地管理查询页面
 * @author: dongjingjun
 * date: 2016-01-07
 */

Ext.define('app.view.destination.DesQueryForm', {
    extend: 'Ext.form.Panel',
    xtype: 'desqueryform',
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
        items: [{// 第一列
            flex: 1,
            layout: 'anchor',
            defaultType: 'textfield',
            defaults: {
                labelAlign: 'right',
                anchor: '33%',
                labelWidth:150
            },
            items: [{
                name: 'cityName',
                bind: {fieldLabel: '{destination}'}
            }]
        }]
    }, {
        xtype: 'searchreset'
    }]
});