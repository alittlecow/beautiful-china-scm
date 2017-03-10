/**
 * Copyright @ 2016 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 供应商信息增加窗口
 * @author: zhangyu
 * date: 2016-2-3
 */
Ext.define('app.view.supplier.SupplierDetailInfoWindow', {
    extend: 'app.view.base.BaseWindow',
    xtype:'supplierdetailinfowin',
    controller:'supplierdetailwin',
    viewModel: {
        type: 'supplier'
    },
    width: 1024,
    height: 440,
    buttons: [{
        xtype:'savebtn',
        handler:'save'
    }],


    items:[{
        xtype:'form',
        layout:'column',
        padding:'5 5 5 5',
        items: [{
            columnWidth: 0.45,
            border: false,
            layout: 'anchor',
            defaultType: 'textfield',
            defaults:{
                anchor:'100%',
                labelAlign:'right',
                labelWidth:200
            },
            items: [
                {
                    xtype: 'hiddenfield',
                    name: 'id'
                },
                {
                    bind:{
                        fieldLabel:'{supplierCode}'
                    },
                    name: 'deptCode'
                },{
                    bind:{
                        fieldLabel:'{supplierNameEn}'
                    },
                    name: 'nameEn'

                },{
                    bind:{
                        fieldLabel:'{supplierNameFr}'
                    },
                    name: 'nameFr'

                },{

                    bind: {
                        fieldLabel: '{supplierTel}'
                    },

                    name: 'tel',
                    regex:/^[0-9]*$/
                },{
                    bind:{
                        fieldLabel:'{supplierTel2}'

                    },
                    name: 'tel2',
                    regex:/^[0-9]*$/
                }]
        },{
            columnWidth: 0.45,
            padding:'0 0 0 5',
            border:false,
            layout: 'anchor',
            defaultType: 'textfield',
            defaults:{
                anchor:'100%',
                labelAlign:'right',
                labelWidth:200
            },
            items: [
                {
                bind:{
                    fieldLabel: '{legal}'
                },
                name: 'legal'
            },{
                    bind:{
                        fieldLabel:'{email}'
                    },

                    name: 'email',
                    vtype:'email'
                },{
                    bind:{
                        fieldLabel:'{contact}'
                    },
                    name: 'contact'
                },{
                    bind:{
                        fieldLabel:'{license}'
                    },
                    name:'license'
                },{
                    bind:{
                        fieldLabel:'{website}'
                    },

                    name:'website'
                }]
        },{
            columnWidth: 1,
            border: false,
            layout: 'anchor',
            defaultType: 'textarea',
            defaults:{
                anchor:'100%',
                labelAlign:'right',
                margin:'0, 100, 15, 0',
                labelWidth:200
            },
            items:[{
                xtype:'textfield',
                bind:{
                    fieldLabel:'{supAddress}'
                },
                name: 'address'


            },{
                bind:{
                    fieldLabel:'{supDesc}'
                },
                name: 'supDesc',
                height:80

            }]
        }]
    }]

});
