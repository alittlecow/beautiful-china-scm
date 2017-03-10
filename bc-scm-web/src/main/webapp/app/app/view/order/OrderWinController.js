/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 * @author: chengxuemin
 * date: 2015-12-22
 */

/**
 * 城市管理控制器
 */
Ext.define('app.view.order.OrderWinController', {
    extend: 'app.view.base.BaseController',
    alias: 'controller.orderwin',
    init: function(view) {
        var viewmodel = view.getViewModel();

    },

    /**
     * 保存
     * @param btn
     */
    save:function(btn){
        var addWindow = btn.up('window');
        var form = addWindow.down('form');
        if (false == form.getForm().isValid()) {
            return;
        }
        // 获取表单中的数据
        var values = form.getForm().getValues();

        App.Ajax.req({
            url : basePath + "/order/update",
            method : 'POST',
            //async: false,
            params:values,
            success: function(response, options) {
                var result = Ext.JSON.decode(response.responseText);
                if(result.result==='ok'){
                    App.Msg.info('',result.msg);
                    addWindow.close();
                    var grid = Ext.getCmp("center").down('ordergrid').getStore().load();

                }else{
                    App.Msg.error('', result.msg);
                }
            }
        });
    },
    /**
     * 加载选项
     * @param grid
     */
    loadOption: function (grid) {
        var win = grid.up('window');
        var tourId = win.tourId;
        var orderNo = win.orderNo;
        if (!tourId) {
            return;
        }
        var store = grid.getStore();
        Ext.apply(store.proxy.extraParams, {"tourId": tourId,"orderNo":orderNo});
        store.load();
    }, /**
     * 修改选项
     * @param btn
     */
    editOption: function (btn) {
        var wins = btn.up('window');
        var grid = btn.up('grid');
        var record = grid.getSelectionModel().getSelection();

        if (this.oneSelectVali(record)) {
            var win = this.createWin('orderoptionwin', {
                title: this.getData('ordEditOption'),
                stateId: 'edit'
            }, this).show();
            var optionId = record[0].data.optionId;


            win.tourId = wins.tourId;
            win.orderNo = wins.orderNo;
            win.grid = grid;
            win.window= wins;
            win.idList = record[0].data.idList;
            win.count = wins.count;
            var store = win.down('grid[itemId=grid2]').getStore();
            store.setProxy({
                extraParams: {"tourId": win.tourId, "optionId": optionId,"orderNo":win.orderNo},
                type: 'ajax',
                url: basePath + '/tour/getExistOptionValueByOrderNo',
                reader: {
                    type: 'json'
                }
            });
            store.load();
        }
    }


});