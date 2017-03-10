/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 系统配置控制器
 * @author: liufei
 * date: 2015-12-10
 *
 * chengxuemin 删除group_id，group_name，添加group_code
 * date: 2016-01-24
 */
Ext.define('app.view.syscfg.SysCfgController', {
    extend: 'app.view.base.BaseController',
    alias: 'controller.syscfg',
    init: function (view) {
        var viewmodel = view.getViewModel();
        this.getInternationalPro({config: 'SysCfgConfig'}, viewmodel)
    },
    /**
     * 添加按钮
     * @param btn
     */
    add: function (btn) {

        var syscfgAddWindow = Ext.create('app.view.syscfg.SysCfgInfoWindow', {
            title: this.getData('addSysCfg'),
            stateId: 'add'
        }).show();
        this.setFormValues(syscfgAddWindow.down('form'));
        // 将当前页面的配置参数加入window
        syscfgAddWindow.getViewModel().setData(this.getViewModel().getData());
    },

    /**
     * 修改系统配置信息
     * @param btn
     */
    edit: function (btn) {
        var grid = btn.up('syscfggrid');
        // 获取选中的列
        var record = grid.getSelectionModel().getSelection();

        // 是否选择验证
        if (this.oneSelectVali(record)) {
            var syscfgWindow = Ext.create('app.view.syscfg.SysCfgInfoWindow', {
                title: this.getData('editSysCfg'),
                stateId: 'edit'
            }).show();
            var form = syscfgWindow.down('form');
            // 将当前页面的配置参数加入window
            syscfgWindow.getViewModel().setData(this.getViewModel().getData());
            form.loadRecord(record[0]);
            // 设置多语言数据
            this.getmultiLanguage(record[0].data.id, "/syscfg/getLanguageById", form);
            syscfgWindow.down('textfield[itemId="groupCode"]').setReadOnly(true);
        }
    },
    /**
     *  删除
     *  @param btn
     */
    delete: function (btn) {
        var grid = btn.up('syscfggrid');
        // 获取选中的列
        var record = grid.getSelectionModel().getSelection();
        // 判断选中的行数是否大于0
        if (this.selectVali(record)) {
            Ext.MessageBox.confirm("", this.getData("mainMsg_100"), function (btn) {
                if ('yes' == btn) {
                    var codes = [];
                    for (var i = 0; i < record.length; i++) {
                        codes.push(record[i].data.id);
                    }
                    grid.setLoading(true);
                    App.Ajax.req({
                        url: basePath + "/syscfg/delete",
                        method: 'POST',
                        params: {codes: codes.join(",")},
                        success: function () {
                            grid.setLoading(false);
                            grid.getStore().reload();
                        }
                    });
                }
            });
        }
    }
});




