/**
 * Copyright @ 2016 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 线路查询条件
 * @author: zhangyu
 * date: 2016-1-20
 */
Ext.define('app.view.display.DisplayTourDateQueryForm', {
    extend: 'Ext.form.Panel',
    xtype: 'displaytourdatequeryform',
    layout: {
        type:'vbox',
        align: 'stretch'
    },
    items: [{
        xtype: 'container',
        height:100,
        layout: {
            type: 'hbox',
            align: 'stretch'
        },
        padding: '10 0 0 0',
        defaultType: 'container',
        items: [{
            flex:1,
            layout: 'anchor',
            defaultType: 'textfield',
            defaults:{
                labelAlign:'right',
                anchor:'95%',
                labelWidth:150
            },
            items: [{
                bind:{
                    fieldLabel:'{name}'
                },
                name: 'titleEn'
            }]
        },{
            flex:1,
            layout: 'anchor',
            defaultType: 'textfield',
            defaults:{
                labelAlign:'right',
                anchor:'95%',
                labelWidth:150
            },
            items: [
                {
                    bind:{
                        fieldLabel:'{code}'

                    },
                    name: 'code'

                }
            ]
        },{
            flex:1,
            layout: 'anchor',
            defaultType: 'textfield',
            defaults:{
                labelAlign:'right',
                anchor:'95%',
                labelWidth:150
            },
            items: [
                {
                    bind:{
                        fieldLabel:'{supplierName}'

                    },
                    name: 'supName'

                }
            ]
        }]
    },{
        xtype:'searchreset'
    }]
});
