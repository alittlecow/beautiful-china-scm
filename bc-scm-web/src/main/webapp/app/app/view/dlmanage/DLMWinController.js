/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: dongjingjun
 * date: 2015-12-21
 */
/**
 * 部门等级管理保存窗口控制器
 */
Ext.define('app.view.dlmanage.DLMWinController', {
    extend: 'app.view.base.BaseController',
    alias: 'controller.dlmwin',
    /**
     * 窗体保存按钮
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
        App.Ajax.req({
            url: basePath + "/departmentlevelmanage/" + url,
            method: 'POST',
            params: values,
            success: function (response, options) {
                var result = Ext.JSON.decode(response.responseText);
                if (result.result === 'ok') {
                    App.Msg.info('', result.msg);
                    addWindow.close();
                    Ext.getCmp("center").down('dlmgrid').getStore().load();
                } else {
                    App.Msg.error('', result.msg);
                }
            }
        });
    }
});