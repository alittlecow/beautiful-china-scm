/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 * @author: zhuhoufeng
 * date: 2016-01-20
 */

/**
 * 订单管理控制器
 */
Ext.define('app.view.order.OrderController', {
    extend: 'app.view.base.BaseController',
    alias: 'controller.order',
    init: function(view) {
        var viewmodel = view.getViewModel();
        this.getInternationalPro({config:'OrderConfig'},viewmodel);
    },


    /**
     * 订单历史记录信息
     * @param btn
     */
    history:function(btn) {
        var grid = btn.up('ordergrid');
        // 获取选中的列
        var record = grid.getSelectionModel().getSelection();
        if (this.oneSelectVali(record)) {
            var orderNo=record[0].get('orderNo');
            this.createWin('orderhistorywin',{title:this.getData('orderHistory'), stateId: orderNo},this).show();
            var store=Ext.getCmp('orderhistorygrid').getStore();
            Ext.apply(store.proxy.extraParams, {orderNo:orderNo});
            store.load();
        }
    },


    /**
     * 修改订单信息
     * @param btn
     */
    detail:function(btn) {
        var grid = btn.up('ordergrid');
        // 获取选中的列
        var record = grid.getSelectionModel().getSelection();


        // 是否选择验证
        if (this.oneSelectVali(record)) {
            var orderWindow = this.createWin('orderinfowin', {
                title: this.getData('orderDetail'),
                stateId: 'edit'
            }, this);
            var form = orderWindow.down('form');

            // 将当前页面的配置参数加入window
            //orderWindow.getViewModel().setData(this.getViewModel().getData());
            var fieldContainer = function () {
                return {
                    columnWidth: 0.9,
                    border: false,
                    layout: 'anchor',
                    defaults: {
                        anchor: '100%'
                    },
                    items: [
                        {
                            xtype: 'panel',
                            margin: '0 0 10 50',
                            header: {
                                hidden: true
                            },
                            items: [
                                {
                                    xtype: 'fieldset',
                                    bind: {title: '{ordCustomer}'},
                                    collapsible: true,
                                    defaultType: 'textfield',
                                    defaults: {
                                        layout: 'column',
                                        labelWidth: 150,
                                        labelAlign: 'right'
                                    },
                                    items: [{
                                        bind: {
                                            fieldLabel: '{ordFullname}'
                                        },
                                        value: arguments[0],
                                        editable: false
                                    }, {
                                        xtype: 'combo',
                                        bind: {
                                            fieldLabel: '{ordSex}'
                                        },
                                        displayField: 'name',
                                        valueField: 'value',
                                        store: 'maleFemale',
                                        queryMode: 'local',
                                        editable: false,
                                        readOnly: true,
                                        value: arguments[1]
                                    }, {
                                        bind: {
                                            fieldLabel: '{ordNationality}'
                                        },
                                        value: arguments[2],
                                        editable: false
                                    }, {
                                        bind: {
                                            fieldLabel: '{ordPassport}'
                                        },
                                        value: arguments[3],
                                        editable: false
                                    }, {
                                        bind: {
                                            fieldLabel: '{ordPhone}'
                                        },
                                        value: arguments[4],
                                        editable: false
                                    }, {
                                        xtype: 'combo',
                                        bind: {
                                            fieldLabel: '{ordType}'
                                        },
                                        displayField: 'name',
                                        valueField: 'value',
                                        store: 'personType',
                                        queryMode: 'local',
                                        editable: false,
                                        readOnly: true,
                                        value: arguments[5]
                                    }]
                                }
                            ]
                        }]
                }
            };
            var values=record[0].data;
            App.Ajax.req({
                url : basePath + "/order/getPassenger",
                method : 'POST',
                params:values,
                success: function(response, options) {
                    var count =0;
                    var obj = Ext.JSON.decode(response.responseText);
                    Ext.each(obj,function(o) {
                        form.add(fieldContainer(o.fullname, o.sex, o.nationality, o.passport, o.phone, o.type));
                        count++;
                    });
                    orderWindow.count = count;
                }
            });
            orderWindow.tourId = record[0].data.tourId;
            orderWindow.orderNo = record[0].data.orderNo;
            orderWindow.down('form').loadRecord(record[0]);
            orderWindow.show();
        }
    },
    /**
     * 确认订单信息
     * @param btn
     */
    confirm:function(btn) {
        var grid = btn.up('ordergrid');
        // 获取选中的列
        var record = grid.getSelectionModel().getSelection();
        // 是否选择验证
        if (this.oneSelectVali(record)) {
            var state=record[0].data.state;
            var values=record[0].data;
            if(state!='P'){
                App.Msg.warn('',this.getData("orderMsg_100"));
                return false;
            }
            App.Ajax.req({
                url : basePath + "/order/confirm",
                method : 'POST',
                //async: false,
                params:values,
                success: function(response, options) {
                    var result = Ext.JSON.decode(response.responseText);
                    if(result.result==='ok'){
                        App.Msg.info('',result.msg);
                        grid.getStore().load();
                    }else{
                        App.Msg.error('', result.msg);
                    }
                }
            });
        }
    }
});