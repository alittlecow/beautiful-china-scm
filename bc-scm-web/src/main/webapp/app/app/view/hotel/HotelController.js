/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 酒店管理主界面控制器
 * @author: dongjingjun
 * date: 2016-01-03
 */

Ext.define('app.view.hotel.HotelController', {
    extend: 'app.view.base.BaseController',
    alias: 'controller.hotel',
    init: function(view) {
        var viewmodel = view.getViewModel();
        this.getInternationalPro({config:'HotelConfig'},viewmodel);
    },
    /**
     * 添加按钮
     * @param btn
     */
    add: function (btn) {
        this.createWin('hotelinfowin', {title: this.getData('addHotel')}, this).show();
    },

    /**
     * 删除
     * @param btn
     */
    delete: function (btn) {
        var grid = btn.up('hotelgrid');
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
                        url: basePath + "/hotel/delete",
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
     * 修改菜单信息
     * @param btn
     */
    edit: function (btn) {
        var grid = btn.up('hotelgrid');
        // 获取选中的列
        var record = grid.getSelectionModel().getSelection();
        // 是否选择验证
        if (this.oneSelectVali(record)) {
            var menuWindow = this.createWin('hotelinfowin', {title: this.getData('editHotel'), stateId: 'edit'}, this).show();
            // 将当前页面的配置参数加入window
            menuWindow.getViewModel().setData(this.getViewModel().getData());
            menuWindow.down('form').loadRecord(record[0]);
        }
    }

});