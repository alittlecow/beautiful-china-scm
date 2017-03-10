/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 供应商信息审批窗口
 * @author: fengbaitong
 * date: 2015-12-15
 */
Ext.define('app.view.supplier.SupplierApproveWindow', {
    extend: 'app.view.base.BaseWindow',
    xtype:'supplierapprovewindow',
    controller:'supplierwindow',
    viewModel: {
        type: 'supplier'
    },
    width:650,
    height:300,
    layout:'anchor',
    buttons: [{
        bind:{
            text:'{pass}'
        },
        handler:'update',
        name:'pass'
    },{
        bind:{
            text:'{reject}'
        },
        handler:'update',
        name:'reject'
    }],
    items:[{
        xtype:'form',
        layout:'anchor',
        padding:'5 15 5 5',
        items: [{
            border: false,
            layout: 'anchor',
            defaultType: 'textarea',
            defaults:{
                anchor:'100%',
                labelAlign:'right'
            },
            items:[{
                bind:{
                    fieldLabel:'{rReason}'
                },
                name: 'rReason',
                height:200
            }]
        }]
    }]
});