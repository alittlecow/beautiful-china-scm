/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 目的地管理控制器
 * @author: dongjingjun
 * date: 2016-01-07
 */

Ext.define('app.view.destination.DesController', {
    extend: 'app.view.base.BaseController',
    alias: 'controller.des',
    init: function (view) {
        var viewmodel = view.getViewModel();
        this.getInternationalPro({config: 'DestinationConfig'}, viewmodel);
    },
    /**
     * 删除
     * @param btn
     */
    delete: function (btn) {
        var grid = btn.up('desgrid');
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
                        url: basePath + "/destination/delete",
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
    },

    /**
     * 添加按钮
     * @param btn
     */
    add: function (btn) {
        var win = this.createWin('desinfowin', {title: this.getData('addDestination')}, this).show();
        this.setFormValues(win.down('form'));
    },
    /**
     * 修改菜单信息
     * @param btn
     */
    edit: function (btn) {
        var grid = btn.up('desgrid');
        // 获取选中的列
        var record = grid.getSelectionModel().getSelection();
        // 是否选择验证
        if (this.oneSelectVali(record)) {
            var window = this.createWin('desinfowin', {
                title: this.getData('editDestination'),
                stateId: 'edit'
            }, this).show();
            var form = window.down('form');
            form.loadRecord(record[0]);
            this.getmultiLanguage(record[0].data.id, "/destination/getLanguageById", form);
            //设置窗口文件名
            var file = window.query('filefield');
            file[0].setRawValue(record[0].get('photoOne'));
            file[1].setRawValue(record[0].get('photoTwo'));
            file[2].setRawValue(record[0].get('photoThree'));
            file[3].setRawValue(record[0].get('photoFour'));
        }
    }
});