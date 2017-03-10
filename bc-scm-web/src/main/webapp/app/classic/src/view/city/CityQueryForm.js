/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 * @author: zhuhoufeng
 * date: 2016-01-06
 */

/**
 * 城市管理管理查询页面
 */
Ext.define('app.view.city.CityQueryForm', {
    extend: 'Ext.form.Panel',
    xtype: 'cityqueryform',
    viewModel: {
        type: 'city'
    },
    layout: {
        type: 'vbox',
        align: 'stretch'
    },
    height: 100,
    padding: '5 0 0 0',
    items: [{
        xtype: 'panel',
        height: 60,
        layout: 'hbox',
        padding: '10 0 10 0',
        items: [{
            flex: 1,
            border: false,
            layout: 'anchor',
            defaultType: 'textfield',
            defaults: {
                labelAlign: 'right',
                anchor: '33%',
                labelWidth:150
            },
            items: [{
                bind:{
                    fieldLabel: '{cityName}'
                },
                name: 'cityName'
            }]
        }]
    },{
        xtype:'searchreset'
    }]
});