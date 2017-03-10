/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 行程详情窗口控制器
 * @author: dongjingjun
 * date: 2015-12-29
 */

Ext.define('app.view.order.OrderSelectOptionWinController', {
    extend: 'app.view.base.BaseController',
    alias: 'controller.orderoptionselectwin',

    /**
     * 加载选项值表格
     * @param combo
     */
    loadOptionValue: function (grid) {
        var tourId =Ext.getCmp('ordTourId').getValue();
        var orderNo = Ext.getCmp('ordOrderNo').getValue();
        var store = grid.getStore();

        Ext.apply(store.proxy.extraParams, {"orderNo":orderNo, "tourId": tourId});
        store.load();
    },
    /**
     * 保存选项值
     * @param btn
     */
    saveOption: function (btn) {
        var win = btn.up('window');
        var grid = win.down('grid[itemId=grid2]');
        var data = grid.getStore().getRange();
        var optionValueIdList = [];
        var optionValuePriceList = [];
        var tourId = win.tourId;
        var len = data.length;
        if (len < 1) {
            App.Msg.info("", this.getData("mainMsg_102"));
            return;
        }
        for (var i = 0; i < len; i++) {
            var valueId = data[i].data.valueId;
            var price = data[i].data.price;
            optionValueIdList.push(valueId);
            optionValuePriceList.push(price);
        }
        App.Ajax.req({
            url: basePath + "/order/saveOption",
            params: {
                optionValueIdList: optionValueIdList,
                optionValuePriceList: optionValuePriceList,
                tourId: tourId,
                status: win.getStateId(),
                idList: win.idList,
                orderNo:win.orderNo,
                count:win.count
            },
            success: function (response) {
                var result = Ext.JSON.decode(response.responseText);
                if (result.result === 'ok') {
                    grid.getStore().removeAll();
                    grid.previousSibling().getStore().removeAll();
                    win.close();
                    Ext.getCmp('ordTotal').setValue(result.total);
                    var store = win.grid.getStore();
                    Ext.apply(store.proxy.extraParams, {"tourId": tourId,"orderNo":win.orderNo});
                    store.load();
                    App.Msg.info('', result.msg);
                } else {
                    App.Msg.error('', result.msg);
                }
            }
        });
    }
    //,
    ///**
    // * 根据已存在option获取未使用的valueuId
    // * @param combo
    // */
    //getUnusedOption: function (combo) {
    //    var store = combo.combo.up('window').grid.getStore();
    //    var records = store.getRange();
    //    var len = records.length;
    //    var tourId = combo.up('window').tourId;
    //    //alert(len);
    //    //    if (len > 0) {
    //    //        var optionIds = [];
    //    //        for (var i = 0; i < len; i++) {
    //    //            optionIds.push(records[i].getData().optionId);
    //    //        }
    //    //
    //    //}
    //    combo.optionId = records[0].getData().optionId;
    //    combo.tourId=tourId;
    //}

});