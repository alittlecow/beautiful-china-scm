/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 * @author: chengxuemin
 * date: 2016-01-18
 */

/**
 * 咨询投诉管理控制器
 */
Ext.define('app.view.consulting.ConsultingWinController', {
    extend: 'app.view.base.BaseController',
    alias: 'controller.consultingwin',
    init: function(view) {
        var viewmodel = view.getViewModel();
        this.getInternationalPro({config:'ConsultingConfig'},viewmodel);
    },

    /**
     * 提交
     * @param btn
     */
    submit:function(btn){
        var addWindow = btn.up('window');
        var form = addWindow.down('form');
        if (false == form.getForm().isValid()) {
            return;
        }
        // 获取表单中的数据
        var values = form.getForm().getValues();

        App.Ajax.req({
            url: basePath + "/consulting/submit",
            method: 'POST',
            //async: false,
            params: values,
            success: function (response, options) {
                var result = Ext.JSON.decode(response.responseText);
                if (result.result === 'ok') {
                    App.Msg.info('', result.msg);
                    addWindow.close();
                    var grid = Ext.getCmp("center").down('consultinggrid').getStore().load();
                } else {
                    App.Msg.error('', result.msg);
                }
            }
        });
    }
});