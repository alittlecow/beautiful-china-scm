/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 * @author: chengxuemin
 * date: 2016-01-11
 */

/**
 * 咨询管理查询页面
 */
Ext.define('app.view.consultive.ConsultiveQueryForm', {
    extend: 'Ext.form.Panel',
    xtype: 'consultivequeryform',
    //controller: 'consultive',
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
                anchor: '95%'
            },
            items: [{
                bind:{
                    fieldLabel: '{tourName}'
                },
                name: 'tourName',
                labelWidth:120
            }]
        },{
            flex:1,
            border:false,
            layout: 'anchor',
            defaultType: 'textfield',
            defaults:{
                labelAlign:'right',
                anchor:'95%'
            },
            items: [{
                bind:{
                    fieldLabel:'{status}'
                },
                xtype:'combo',
                store:"openClose",
                displayField: 'name',
                valueField: 'value',
                //queryMode:'local',
                editable: false,
                value:'O',
                name: 'status'
            }]
        },{
            flex:1
        }]
    },{
        xtype:'searchreset'
    }]
});