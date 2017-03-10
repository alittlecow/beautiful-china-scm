/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 景点管理窗口控制器
 * @author: dongjingjun
 * date: 2016-01-06
 */

Ext.define('app.view.sights.SightsWinController', {
    extend: 'app.view.base.BaseController',
    alias: 'controller.sightswin',
    /**
     * 保存
     * @param btn
     */
    save: function (btn) {
        var window = btn.up('window');
        var form = window.down('form');
        if (false == form.getForm().isValid()) {
            return;
        }
        // 获取表单中的数据
        var values = form.getForm().getValues();
        if (values.descFr.length > 2000) {
            App.Msg.info('info', this.getData('descLimitFrMsg'));
            return;
        }
        if (values.descEn.length > 2000) {
            App.Msg.info('info', this.getData('descLimitEnMsg'));
            return;
        }
        var url = 'save';
        if (window.getStateId() === 'edit') {
            url = 'update';
        }
        App.Ajax.req({
            url: basePath + "/sights/" + url,
            method: 'POST',
            params: values,
            success: function (response, options) {
                var result = Ext.JSON.decode(response.responseText);
                if (result.result === 'ok') {
                    App.Msg.info('', result.msg);
                    window.close();
                    Ext.getCmp("center").down('sightsgrid').getStore().load();
                } else {
                    App.Msg.error('', result.msg);
                }
            }
        });
    }
});