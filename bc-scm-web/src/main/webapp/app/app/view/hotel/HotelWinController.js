/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 酒店管理窗口控制器
 * @author: dongjingjun
 * date: 2016-01-04
 */

Ext.define('app.view.hotel.HotelWinController', {
    extend: 'app.view.base.BaseController',
    alias: 'controller.hotelwin',
    /**
     * 保存
     * @param btn
     */
    save: function (btn) {
        var addWindow = btn.up('window');
        var form = addWindow.down('form');
        if (false == form.getForm().isValid()) {
            return;
        }
        // 获取表单中的数据
        var values = form.getForm().getValues();
        var url = 'save';
        if (addWindow.getStateId() === 'edit') {
            url = 'update';
        }
        App.Ajax.req({
            url: basePath + "/hotel/" + url,
            method: 'POST',
            params: values,
            success: function (response, options) {
                var result = Ext.JSON.decode(response.responseText);
                if (result.result === 'ok') {
                    App.Msg.info('', result.msg);
                    addWindow.close();
                    Ext.getCmp("center").down('hotelgrid').getStore().load();
                } else {
                    App.Msg.error('', result.msg);
                }
            }
        });
    }
});