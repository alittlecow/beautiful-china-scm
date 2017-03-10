/**
 * Copyright @ 2016 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 定制线路表单窗口
 * @author: zhangyu
 * date: 2016-1-7
 */
Ext.define('app.view.customline.CustomlineInfoWindow', {
    extend: 'app.view.base.BaseWindow',
    xtype:'customlineinfowindow',
    controller:'customlinewindow',
    viewModel: {
        type: 'customline'
    },
    width: 1024,
    height: 580,
    buttons: [{
        xtype:'savebtn',
        handler:'update'
    }],
    items:[{
        xtype:'form',
        layout:'column',
        autoScroll:true,
        padding:'5 5 5 5',
        items: [{
            columnWidth: 0.3,
            border: false,
            layout: 'anchor',
            defaultType: 'textfield',
            defaults:{
                anchor:'100%',
                labelAlign:'right',
                labelWidth: 150
            },
            items: [
                {
                    xtype: 'hiddenfield',
                    name: 'id'
                },
                {
                    xtype: 'hiddenfield',
                    name: 'passId'
                },
                {
                    bind:{
                        fieldLabel:'{custName}'
                    },
                    name: 'name'
                },{
                    bind:{
                        fieldLabel:'{custEmail}'
                    },
                    name: 'email',
                    vtype:'email'
                },{
                  readOnly:true,
                    bind: {
                        fieldLabel: '{arriveTime}'
                    },

                    name: 'arriveTime'
                }]
        },{
            columnWidth: 0.3,
            padding:'0 0 0 5',
            border: false,
            layout: 'anchor',
            defaultType: 'textfield',
            defaults:{
                anchor:'100%',
                labelAlign:'right',
                labelWidth: 150
            },
            items: [{
                xtype:'combo',
                bind:{
                    fieldLabel: '{custSex}'
                },
                displayField: 'name',
                valueField: 'value',
                store:'maleFemale',
                queryMode:'local',
                editable: false,
                name: 'sex'
                },{
                    bind:{
                        fieldLabel:'{custPhone}'

                    },
                    name: 'phone',
                    regex:/^[0-9]*$/
                },{
                    bind:{
                        fieldLabel:'{returnTime}'
                    },
                       editable: false,
                       name: 'returnTime'
                }]
        },{
            columnWidth: 0.35,
            padding:'0 0 0 5',
            border: false,
            layout: 'anchor',
            defaultType: 'textfield',
            defaults:{
                anchor:'100%',
                labelAlign:'right',
                labelWidth: 150,
                editable: false
            },
            items: [{
                bind:{
                    fieldLabel:'{custPerson}'
                },
                name: 'person'
            },{
                bind:{
                    fieldLabel:'{hotelLevel}'
                },
                name:'hotelLevel'
            },{
                bind:{
                    fieldLabel:'{createTime}'
                },
                xtype: 'datefield',
                format: 'Y-m-d H:i:s',
                name:'createTime'
            }
            ]

        }, {
                columnWidth: 1,
                border: false,
                layout: 'anchor',
                defaultType: 'textarea',
                defaults:{
                    anchor:'100%',
                    labelAlign:'right',
                    labelWidth:150
                },
                padding:'0 20 0 0',
            items:[{
                    xtype: 'customlinedetailgrid',
                    id: 'customlinedetailgrid',
                    padding:'0 30 20 20',
                    margin:'0 0 0 136'

            }, {
                bind:{
                    fieldLabel:'{otherrequirement}'
                },
                name: 'otherRequirement',
                labelWidth:150,
                padding:'0 30 0 0'
            }]
        },{
                columnWidth: 0.5,
                padding:'0 20 0 0',
                border: false,
                layout: 'anchor',
                defaultType: 'textfield',
                defaults:{
                    anchor:'100%',
                    labelAlign:'right',
                    labelWidth:150
                },
                items: [{
                    bind:{
                        fieldLabel:'{passName}'
                    },
                    name: 'passName'
                }]
            },{
                columnWidth: 0.5,
                padding:'0 48 0 0',
                border: false,
                layout: 'anchor',
                defaultType: 'textfield',
                defaults:{
                    anchor:'100%',
                    labelAlign:'right',
                    labelWidth:150
                },
                items: [{
                    bind:{
                        fieldLabel:'{dealTime}'
                    },
                    xtype: 'datefield',
                    format: 'Y-m-d H:i:s',
                    name: 'dealTime'

                }]
            },{
                columnWidth: 1,
                padding:'0 48 0 0',
                border: false,
                layout: 'anchor',
                defaultType: 'textarea',
                defaults:{
                    anchor:'100%',
                    labelAlign:'right',
                    labelWidth:150
                },
                items:[{
                    bind:{
                        fieldLabel:'{custResult}'
                    },
                    name: 'result'
                }]
            }]
    }]
});
