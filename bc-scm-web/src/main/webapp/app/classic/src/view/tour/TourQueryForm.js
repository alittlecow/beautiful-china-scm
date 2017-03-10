/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 线路管理查询表单
 * @author: dongjingjun
 * date: 2015-12-25
 */

Ext.define('app.view.tour.TourQueryForm', {
    extend: 'Ext.form.Panel',
    xtype: 'tourqueryform',
    layout: {
        type: 'vbox',
        align: 'stretch'
    },
    height: 185,
    // 边距
    padding: '5 0 0 0',
    items: [{
        xtype: 'container',
        height: 140,
        layout: 'hbox',
        padding: '10 0 10 0',
        defaultType: 'container',
        items: [{// 第一列
            flex: 1,
            layout: 'anchor',
            defaultType: 'textfield',
            defaults: {
                labelAlign: 'right',
                anchor: '100%',
                maxLength: 50,
                labelWidth:150
            },
            items: [
                {
                    bind: {fieldLabel: '{code}'},
                    name: 'code'
                },
                {
                    bind: {fieldLabel: '{startCity}'},
                    name: 'startCityEn'
                },
                {
                    bind: {fieldLabel: '{owner}'},//线路是网站自营,还是供应商代理
                    name: 'owner',
                    xtype: 'combo',
                    store: "tourOwner",
                    displayField: 'name',
                    valueField: 'value',
                    editable: false,
                    itemId:'owner'
                }
            ]
        }, {//第二列
            flex: 1,
            layout: 'anchor',
            defaultType: 'textfield',
            defaults: {
                labelAlign: 'right',
                anchor: '100%',
                labelWidth:150
            },
            items: [
                {
                    bind: {fieldLabel: '{routeName}'},
                    name: 'title'
                },
                {
                    bind: {fieldLabel: '{endCity}'},
                    name: 'endCityEn'
                }
            ]
        }, {// 第三列
            flex: 1,
            layout: 'anchor',
            defaults: {
                labelAlign: 'right',
                anchor: '95%',
                labelWidth:150
            },
            items: [
                {
                    xtype: 'numberfield',
                    minValue: 0,
                    allowDecimals: false,
                    bind: {fieldLabel: '{days}'},
                    name: 'days'
                },
                {
                    bind: {fieldLabel: '{status}'},
                    xtype: 'combo',
                    store: "normalStop",
                    displayField: 'name',
                    valueField: 'value',
                    editable: false,
                    name: 'status'
                }
            ]
        }]
    }, {
        xtype: 'searchreset'
    }]
});