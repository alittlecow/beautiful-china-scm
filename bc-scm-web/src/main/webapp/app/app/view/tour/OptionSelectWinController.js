/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 行程详情窗口控制器
 * @author: dongjingjun
 * date: 2015-12-29
 */

Ext.define('app.view.tour.OptionSelectWinController', {
    extend: 'app.view.base.BaseController',
    alias: 'controller.optionselectwin',
    /**
     * 加载选项值表格
     * @param combo
     */
    loadOptionValue: function (combo) {
        var store = combo.nextSibling().getStore(),
            tourId = combo.up('window').tourId;
        Ext.apply(store.proxy.extraParams, {"id": combo.getValue(), "tourId": tourId});
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
            App.Msg.info('', this.getData('selectOneItem'));
            return;
        }
        for (var i = 0; i < len; i++) {
            var id = (data[i].data.id.split('-'))[0];
            var price = data[i].data.price;
            optionValueIdList.push(id);
            optionValuePriceList.push(price);
        }
        var flag = grid.flag, flags = [], lens = flag.length;
        for (var k = 0; k < lens; k++) {
            if (flag[k] !== (-1)) {
                flags.push(flag[k]);
            }
        }
        if (flags.length < 1) {
            App.Msg.info('', this.getData('setDefault'));
            return;
        }
        App.Ajax.req({
            url: basePath + "/tour/saveOption",
            params: {
                optionValueIdList: optionValueIdList,
                optionValuePriceList: optionValuePriceList,
                tourId: tourId,
                status: win.getStateId(),
                idList: win.idList,
                defaults: flags,
                count:win.count
            },
            success: function (response) {
                var result = Ext.JSON.decode(response.responseText);
                if (result.result === 'ok') {
                    grid.getStore().removeAll();
                    grid.previousSibling().getStore().removeAll();
                    flag.splice(0, lens);
                    win.close();
                    var store = win.grid.getStore();
                    Ext.apply(store.proxy.extraParams, {"id": tourId});
                    store.load();
                    App.Msg.info('', result.msg);
                } else {
                    App.Msg.error('', result.msg);
                }
            }
        });
    },
    /**
     * 根据已存在option获取未使用的option
     * @param combo
     */
    getUnusedOption: function (combo) {
        var store = combo.combo.up('window').grid.getStore();
        var records = store.getRange();
        var len = records.length;
        if (len > 0) {
            var optionIds = [];
            for (var i = 0; i < len; i++) {
                optionIds.push(records[i].getData().optionId);
            }
            combo.query = optionIds;
        }
    }
});