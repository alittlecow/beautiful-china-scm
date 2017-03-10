/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 系统配置管理控制器
 * @author: liufei
 * date: 2015-12-15
 *
 * chengxuemin 删除group_id，group_name，添加group_code
 * date: 2016-01-24
 */
Ext.define('app.view.syscfg.SysCfgWindowController', {
    extend: 'app.view.base.BaseController',
    alias: 'controller.syscfgwindow',
    init: function (view) {
        var viewmodel = view.getViewModel();
        this.getInternationalPro({config: 'SysCfgConfig'}, viewmodel);
    },
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
        // 获取表单信息
        var formValues = this.getFormValues(form);
        var url = 'save';
        if (addWindow.getStateId() === 'edit') {
            url = 'update';
        }
        App.Ajax.req({
            url: basePath + "/syscfg/" + url,
            method: 'POST',
            params: formValues,
            success: function (response) {
                var result = Ext.JSON.decode(response.responseText);
                if (result.result === 'ok') {
                    App.Msg.info('', result.msg);
                    addWindow.close();
                    Ext.getCmp("center").down('syscfggrid').getStore().reload();
                } else {
                    App.Msg.error('', result.msg);
                }
            }
        });
    }
});