/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 景点管理控制器
 * @author: dongjingjun
 * date: 2016-01-05
 */

Ext.define('app.view.sights.SightsController', {
    extend: 'app.view.base.BaseController',
    alias: 'controller.sights',
    init: function(view) {
        var viewmodel = view.getViewModel();
        this.getInternationalPro({config:'SightsConfig'},viewmodel);
    },
    /**
     * 添加按钮
     * @param btn
     */
    add: function (btn) {
        this.createWin('sightsinfowin', {title: this.getData('addSights')}, this).show();
    },
    /**
     * 修改按钮
     * @param btn
     */
    edit: function (btn) {
        var grid = btn.up('sightsgrid');
        // 获取选中的列
        var record = grid.getSelectionModel().getSelection();
        // 是否选择验证
        if (this.oneSelectVali(record)) {
            var window = this.createWin('sightsinfowin', {title: this.getData('editSights'), stateId: 'edit'}, this).show();
            // 将当前页面的配置参数加入window
            window.getViewModel().setData(this.getViewModel().getData());
            window.down('form').loadRecord(record[0]);
        }
    },
    /**
     * 删除
     * @param btn
     */
    delete: function (btn) {
        var grid = btn.up('sightsgrid');
        // 获取选中的列
        var record = grid.getSelectionModel().getSelection();
        // 判断选中的行数是否大于0
        if (this.selectVali(record)) {
            Ext.MessageBox.confirm("", this.getData("mainMsg_100"), function (btn) {
                if ('yes' == btn) {
                    var ids = [];
                    for (var i = 0; i < record.length; i++) {
                        ids.push(record[i].data.id);
                    }
                    grid.setLoading(true);
                    App.Ajax.req({
                        url: basePath + "/sights/delete",
                        method: 'POST',
                        params: {ids: ids},
                        success: function (response, options) {
                            grid.setLoading(false);
                            grid.getStore().reload();
                        }
                    });
                }
            });
        }
    }
});