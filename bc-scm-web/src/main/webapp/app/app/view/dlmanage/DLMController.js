/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: dongjingjun
 * date: 2015-12-21
 */
/**
 * 部门等级管理控制器
 */
Ext.define('app.view.dlmanage.DLMController', {
    extend: 'app.view.base.BaseController',
    alias: 'controller.dlm',
    init: function (view) {
        var viewmodel = view.getViewModel();
        this.getInternationalPro({config: 'DLManageConfig'}, viewmodel);
    },
    /**
     * 删除按钮
     * @param btn
     */
    delete: function (btn) {
        var grid = btn.up('dlmgrid');
        var record = grid.getSelectionModel().getSelection();
        if (this.selectVali(record)) {
            Ext.MessageBox.confirm("", this.getData("mainMsg_100"), function (btn) {
                if ('yes' == btn) {
                    var codes = [];
                    for (var i = 0; i < record.length; i++) {
                        codes.push(record[i].data.code);
                    }
                    grid.setLoading(true);
                    App.Ajax.req({
                        url: basePath + "/departmentlevelmanage/delete",
                        method: 'POST',
                        params: {code: codes.join(",")},
                        success: function (response, options) {
                            var result = Ext.JSON.decode(response.responseText);
                            if (result.result === 'ok') {
                                App.Msg.info('', result.msg);
                                grid.setLoading(false);
                                grid.getStore().reload();
                            } else {
                                App.Msg.error('', result.msg);
                            }
                        }
                    });
                }
            });
        }
    },
    /**
     * 添加按钮
     * @param btn
     */
    add: function (btn) {
        var menuAddWindow = Ext.create('widget.dlmwin');
        menuAddWindow.getViewModel().setData(this.getViewModel().getData());
        menuAddWindow.show();
    },
    /**
     * 可编辑表格更新按钮
     *
     */
    update: function (editor, e) {
        App.Ajax.req({
            url: basePath + "/departmentlevelmanage/update",
            method: 'POST',
            params: {
                code: e.record.get('code'),
                enName: e.record.get('enName'),
                fnName: e.record.get('fnName')
            },
            success: function (response, options) {
                var result = Ext.JSON.decode(response.responseText);
                if (result.result === 'ok') {
                    App.Msg.info('', result.msg);
                    e.grid.getStore().reload();
                } else {
                    App.Msg.error('', result.msg);
                }
            }
        })
    }
});