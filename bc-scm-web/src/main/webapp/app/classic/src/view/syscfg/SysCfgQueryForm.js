/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 系统配置查询页面
 * @author: liufei
 * date: 2015-12-10
 *
 * chengxuemin 删除group_id，group_name，添加group_code
 * date: 2016-01-24
 */
Ext.define('app.view.syscfg.SysCfgQueryForm', {
    extend: 'Ext.form.Panel',
    xtype: 'syscfgqueryform',
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
            layout: 'anchor',
            defaultType: 'textfield',
            defaults: {
                labelAlign: 'right',
                anchor: '33%',
                labelWidth: 150
            },
            items: [{
                bind: {
                    fieldLabel: '{sysName}'
                },
                name: 'name'
            }]
        }]
    }, {
        xtype: 'searchreset'
    }]
});