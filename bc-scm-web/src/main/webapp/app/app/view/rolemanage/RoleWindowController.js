/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: dongjingjun
 * date: 2015-12-21
 */
/**
 * 角色管理新增，修改弹框控制器
 */
Ext.define('app.view.rolemanage.RoleWindowController', {
    extend: 'app.view.base.BaseController',
    alias: 'controller.rolewindow',
    init: function (view) {
        var viewmodel = view.getViewModel();
        this.getInternationalPro({config: 'RoleManageWindowConfig'}, viewmodel);
    },
    /**
     * 弹窗保存按钮
     * @param btn
     */
    save: function (btn) {
        var addWindow = btn.up('window');
        var form = addWindow.down('form');
        if (false == form.getForm().isValid()) {
            return;
        }
        if (!addWindow.down('checkboxgroup').getValue().roleLevel) {
            App.Msg.warn('', this.getData('checkMsg'));
            return;
        }
        var grid = Ext.getCmp("center").down('rolegrid');
        var values = form.getForm().getValues();
        var url = 'save';
        if (addWindow.getStateId() === 'edit') {
            url = 'update';
        }
        grid.setLoading(true);
        App.Ajax.req({
            url: basePath + "/rolemanage/" + url,
            method: 'POST',
            async: false,
            params: values,
            success: function (response, options) {
                var result = Ext.JSON.decode(response.responseText);
                if (result.result === 'ok') {
                    App.Msg.info('', result.msg);
                    addWindow.close();
                    grid.setLoading(false);
                    grid.getStore().load();
                } else {
                    App.Msg.error('', result.msg);
                }
            }
        });
    }
});