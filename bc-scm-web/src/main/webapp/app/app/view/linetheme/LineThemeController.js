/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 * @author: chengxuemin
 * date: 2015-12-22
 */

/**
 * 线路主题管理控制器
 */
Ext.define('app.view.linetheme.LineThemeController', {
    extend: 'app.view.base.BaseController',
    alias: 'controller.linetheme',
    init: function(view) {
        var viewmodel = view.getViewModel();
        this.getInternationalPro({config:'LineThemeConfig'},viewmodel);
    },
    /**
     * 删除
     * @param btn
     */
    delete:function(btn){
        var grid = btn.up('linethemegrid');
        // 获取选中的行
        var record = grid.getSelectionModel().getSelection();
        // 判断选中的行数是否大于0
        if (this.selectVali(record)) {
            Ext.MessageBox.confirm("", this.getData("mainMsg_100"), function (btn) {
                if ('yes' == btn) {
                    var ids = [];
                    for(var i=0;i<record.length;i++){
                        ids.push(record[i].data.id);
                    }
                    grid.setLoading(true);
                    App.Ajax.req({
                        url : basePath + "/linetheme/delete",
                        method : 'POST',
                        params: {ids:ids.join(",")},
                        success: function(response, options) {
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
    add:function(btn){

        var linethemeAddWindow = Ext.create('app.view.linetheme.LineThemeInfoWin',{
            title:this.getData('addLineTheme')});
        // 将当前页面的配置参数加入window
        linethemeAddWindow.getViewModel().setData(this.getViewModel().getData());
        linethemeAddWindow.show();
    },

    /**
     * 修改线路主题信息
     * @param btn
     */
    edit:function(btn) {

        var grid = btn.up('linethemegrid');
        // 获取选中的列
        var record = grid.getSelectionModel().getSelection();

        // 是否选择验证
        if (this.oneSelectVali(record)) {
            // 将当前页面的配置参数加入window
            var window = this.createWin('linethemeinfowin',
                {title: this.getData('editLineTheme'), stateId: 'edit'}, this).show();
            window.down('form').loadRecord(record[0]);
            //设置窗口文件名
            var file = window.query('filefield');
            file[0].setRawValue(record[0].get('photoOne'));
            file[1].setRawValue(record[0].get('photoTwo'));
            file[2].setRawValue(record[0].get('photoThree'));
            file[3].setRawValue(record[0].get('photoFour'));
        }
    }
});