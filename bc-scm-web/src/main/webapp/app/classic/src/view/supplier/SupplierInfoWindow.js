/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 供应商详细信息窗口
 * @author: fengbaitong
 * date: 2015-12-15
 */
Ext.define('app.view.supplier.SupplierInfoWindow', {
    extend: 'app.view.base.BaseWindow',
    xtype:'supplierinfowindow',
    controller:'supplierwindow',
    viewModel: {
        type: 'supplier'
    },
    width:900,
    height:600,

    items:[{
        xtype:'form',
        layout:'column',
        padding:'5 5 5 5',
        items: [{
            columnWidth: 0.5,
            border: false,
            layout: 'anchor',
            defaultType: 'textfield',
            defaults:{
                anchor:'100%',
                labelAlign:'right',
                readOnly:true,
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
                    fieldLabel:'{supplierTel}'
                },
                name: 'tel'
            },{
                bind:{
                    fieldLabel:'{legal}'
                },
                name: 'legal'
            },{
                bind:{
                    fieldLabel:'{license}'
                },
                name: 'license'
            },{
                bind:{
                    fieldLabel:'{email}'
                },
                name: 'email'
            },{
                bind:{
                    fieldLabel:'{approver}'
                },
                name: 'approver'
            }]
        },{
            columnWidth: 0.5,
            padding:'0 0 0 5',
            border:false,
            layout: 'anchor',
            defaultType: 'textfield',
            defaults:{
                anchor:'100%',
                labelAlign:'right',
                readOnly:true,
                labelWidth:200

            },
            items: [{
                bind:{
                    fieldLabel:'{supplierName}'
                },
                name: 'name'
            },{
                bind:{
                    fieldLabel:'{supplierTel2}'
                },
                name:'tel2'
            },{
                bind:{
                    fieldLabel:'{contact}'
                },
                name:'contact'
            },{
                bind:{
                    fieldLabel:'{status}'
                },
                xtype:'combo',
                store:"approve",
                displayField: 'name',
                valueField: 'value',
                editable: false,
                name: 'status'
            },{
                bind:{
                    fieldLabel:'{regTime}'
                },
                name: 'regTime'
            },{
                bind:{
                    fieldLabel:'{approveTime}'
                },
                name: 'approveTime'
            }]
        },{
            columnWidth: 1,
            border: false,
            layout: 'anchor',
            defaultType: 'textarea',
            defaults:{
                anchor:'100%',
                labelAlign:'right',
                labelWidth:200
            },
            items:[{
                xtype:'textfield',
                bind:{
                    fieldLabel:'{supAddress}'
                },
                name: 'address',
                readOnly:true

            },{
                bind:{
                    fieldLabel:'{supDesc}'
                },
                name: 'supDesc',
                height:80,
                readOnly:true
            }]
        }]
    }]
});