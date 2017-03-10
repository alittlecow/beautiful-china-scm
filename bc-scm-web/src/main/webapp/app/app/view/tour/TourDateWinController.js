/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 窗口控制器
 * @author: dongjingjun
 * date: 2015-12-24
 */

Ext.define('app.view.tour.TourDateWinController', {
    extend: 'app.view.base.BaseController',
    alias: 'controller.tourdatewin',
    /**
     * 保存
     * @param btn
     */
    saveTourDate: function (btn) {
        var addWindow = btn.up('window');
        var form = addWindow.down('form');
        if (false == form.getForm().isValid()) {
            return;
        }
        // 获取表单中的数据
        var values = form.getForm().getValues();
        if ((values.type === 'week' || values.type === 'month') && !values.dateIndex) {
            App.Msg.error('', this.getData('dateMsg'));
            return;
        }
        //验证日期
        var startTime = new Date(values.startTime);
        var endTime = new Date(values.endTime);
        if (endTime < startTime) {
            App.Msg.error('', this.getData('timeMsg'));
            return;
        }
        //验证库存与预警值
        if (parseInt(values.inventory) <= parseInt(values.warn)) {
            App.Msg.error('', this.getData('w_iMsg'));
            return;
        }
        values.code = addWindow.tourId;
        var url = 'save';
        //提交数据提示
        this.waitBox(btn);
        App.Ajax.req({
            url: basePath + "/tourdate/" + url,
            method: 'POST',
            params: values,
            success: function (response, options) {
                var result = Ext.JSON.decode(response.responseText);
                if (result.result === 'ok') {
                    App.Msg.info('', result.msg);
                    addWindow.close();
                    var store = addWindow.grid.getStore();
                    Ext.apply(store.proxy.extraParams, {"id": addWindow.tourId});
                    store.load();
                } else {
                    App.Msg.error('', result.msg);
                }
            }
        });
    },
    checkdate: function (radio) {
        radio.checked = true;
        var type = radio.itemId;
        var weekdays = 7;
        var monthdays = 31;
        var win = radio.up('window');
        var checkbox = win.down('checkboxgroup[itemId=checkbox]').show();
        checkbox.removeAll();
        if (type === 'day') {
            checkbox.hide();
        }
        var i = 0;
        var obj = {};
        if (type === 'week') {
            for (; i < weekdays; i++) {
                obj = {
                    boxLabel: Ext.Date.getShortDayName(i),
                    inputValue: i + 1
                };
                checkbox.add(obj);
            }
        }
        if (type === 'month') {
            for (; i < monthdays; i++) {
                obj = {
                    boxLabel: i + 1,
                    inputValue: i + 1
                };
                if (obj.boxLabel < 10) {
                    obj.boxLabel = '0' + obj.boxLabel;
                }
                checkbox.add(obj);
            }
        }
    },
    /**
     * 保存提示框
     * @param btn
     */
    waitBox: function (btn) {
        Ext.MessageBox.show({
            msg: this.getData('saveMsg'),
            progressText: this.getData('saving'),
            width: 300,
            wait: {
                interval: 200
            },
            animateTarget: btn
        });
    }
});