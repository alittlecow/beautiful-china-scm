/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 景点管理查询页面
 * @author: dongjingjun
 * date: 2016-01-05
 */

Ext.define('app.view.sights.SightsQueryForm', {
    extend: 'Ext.form.Panel',
    xtype: 'sightsqueryform',
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
        items: [
            {// 第一列
                width: '33%',
                layout: 'anchor',
                defaultType: 'textfield',
                defaults: {
                    labelAlign: 'right',
                    anchor: '100%',
                    labelWidth:150
                },
                items: [{
                    name: 'cityName',
                    bind:{fieldLabel: '{destination}'}
                }]
            },
            {//第二列
                width: '33%',
                layout: 'anchor',
                defaultType: 'textfield',
                defaults: {
                    labelAlign: 'right',
                    anchor: '100%',
                    labelWidth:150
                },
                items: [{
                    name: 'name',
                    bind:{fieldLabel: '{sightsName}'}
                }]
            }]
    },
        {
            xtype: 'searchreset'
        }]
});