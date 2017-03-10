/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 旅游线路管理主页面控制器
 * @author: dongjingjun
 * date: 2015-12-25
 */

Ext.define('app.view.tour.TourController', {
    extend: 'app.view.tour.TourWinController',
    alias: 'controller.tour',
    init: function (view) {
        var viewmodel = view.getViewModel();
        this.getInternationalPro({config: 'TourConfig'}, viewmodel);
        var userStr = window.localStorage.getItem("user");
        var user = Ext.JSON.decode(userStr);
        if(user.deptInfoBO.levelCode=="SUPPLIER"){
            view.queryById("owner").setHidden(true);
            view.down("tourqueryform").setHeight(140);
            view.down("tourqueryform").down("container").setHeight(100);
            view.down("tourgrid").getColumns()[6].setHidden(true);
        }
    },
    /**
     * 删除
     * @param btn
     */
    deleteTour: function (btn) {
        var grid = btn.up('tourgrid');
        var record = grid.getSelectionModel().getSelection();
        if (this.selectVali(record)) {
            Ext.MessageBox.confirm("", this.getData("mainMsg_100"), function (btn) {
                if ('yes' == btn) {
                    var ids = [];
                    for (var i = 0; i < record.length; i++) {
                        ids.push(record[i].data.id);
                    }
                    grid.setLoading(true);
                    App.Ajax.req({
                        url: basePath + "/tour/deleteTour",
                        method: 'POST',
                        params: {id: ids},
                        success: function () {
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
    addTour: function (btn) {
        var win = this.createWin('tourinfowin', {title: this.getData('addTour')}, this).show(btn);
        win.mainGrid = btn.up('grid');

    },
    /**
     * 修改按钮
     * @param btn
     */
    editTour: function (btn) {
        var grid = btn.up('tourgrid');
        // 获取选中的列
        var record = grid.getSelectionModel().getSelection();
        // 是否选择验证
        if (this.oneSelectVali(record)) {
            var tourEditWindow = this.createWin('tourinfowin', {
                title: this.getData('editTour'),
                stateId: 'edit'
            }, this);
            tourEditWindow.tourId = record[0].data.id;
            tourEditWindow.show();
            tourEditWindow.mainGrid = btn.up('grid');
        }
    },
    checkTour: function (btn) {
        var grid = btn.up('tourgrid');
        // 获取选中的列
        var record = grid.getSelectionModel().getSelection();
        // 判断选中的行数是否大于0
        if (this.selectVali(record)) {
            var id = record[0].data.id;
            App.Ajax.req({
                url: basePath + "/tour/check",
                method: 'POST',
                params: {id: id},
                success: function (response) {
                    var hrefUrl = Ext.decode(response.responseText);
                    window.open(hrefUrl, 'mywindow', 'width=' + (window.screen.availWidth - 10) + ',height=' + (window.screen.availHeight - 30) + ',top=0,left=0,toolbar=no,menubar=yes,scrollbars=yes, resizable=no,location=no, status=no');
                }
            });
        }
    }
});