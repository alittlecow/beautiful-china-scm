/**
 * Copyright @ 2016 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 定制线路查询界面
 * @author: zhangyu
 * date: 2016-1-7
 */
Ext.define('app.view.customline.CustomlineQueryForm', {
    extend: 'Ext.form.Panel',
    xtype: 'customlinequeryform',
    layout: {
        type: 'vbox',
        align: 'stretch'
    },
    height:140,
    padding:'5 0 0 0',
    items: [{
            xtype: 'container',
            padding: '10 0 10 0',
            layout: {
                type: 'hbox',
                align: 'stretch'
            },
            defaultType: 'textfield',
            defaults:{
                labelAlign:'right',
                anchor:'95%'
            },
            items: [{
                bind:{
                    fieldLabel:'{custName}'
                },
                name: 'name',
                labelWidth:150
                ,flex:1
            },{


                bind:{
                    fieldLabel:'{custEmail}'
                },
                name: 'email',
                labelWidth:150
                ,flex:1
            },{
                bind:{
                    fieldLabel:'{custPhone}'

                },
                labelWidth:150,
                name: 'phone'
                ,flex:1

            }]
    },{
        xtype: 'container',
        layout: 'hbox',
        defaults: {
            labelAlign: 'right',
            anchor:'95%'
        },
        items: [
            {
                xtype: 'datefield',
                format: 'Y-m-d H:i:s',
                editable: false,
                bind: {
                    fieldLabel: '{createTime}'
                },
                name: 'createTimeSmall',
                labelWidth:150
            }, {
                xtype: 'displayfield',
                value: '- - -'
            },
            {
                xtype: 'datefield',
                format: 'Y-m-d H:i:s',
                editable: false,
                name: 'createTimeBig'
            }]
    },{
        xtype:'searchreset'
    }]
})
