/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 * @author: zhuhoufeng
 * date: 2016-01-06
 */

/**
 * 城市管理控制器
 */
Ext.define('app.view.city.CityController', {
    extend: 'app.view.base.BaseController',
    alias: 'controller.city',
    init: function(view) {
        var viewmodel = view.getViewModel();
        this.getInternationalPro({config:'CityConfig'},viewmodel);
    },
    /**
     * 删除
     * @param btn
     */
    delete:function(btn){
        var grid = btn.up('citygrid');
        // 获取选中的列
        var record = grid.getSelectionModel().getSelection();
        // 判断选中的行数是否大于0
        if (this.selectVali(record)) {
            Ext.MessageBox.confirm("", this.getData("mainMsg_100"), function (btn) {
                if ('yes' == btn) {

                    var cityIds = [];
                    for(var i=0;i<record.length;i++){
                        cityIds.push(record[i].data.cityId);
                    }
                    grid.setLoading(true);
                    App.Ajax.req({
                        url : basePath + "/city/delete",
                        method : 'POST',
                        params: {cityIds:cityIds.join(",")},
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
        var cityAddWindow = Ext.create('app.view.city.CityInfoWin',{title:this.getData('addCity')});
        // 将当前页面的配置参数加入window
        cityAddWindow.getViewModel().setData(this.getViewModel().getData());
        cityAddWindow.show();
    },

    /**
     * 修改城市信息
     * @param btn
     */
    edit:function(btn) {

        var grid = btn.up('citygrid');
        // 获取选中的列
        var record = grid.getSelectionModel().getSelection();

        // 是否选择验证
        if (this.oneSelectVali(record)) {
            // 将当前页面的配置参数加入window
            var cityWindow = this.createWin('cityinfowin',
                {title: this.getData('editCity'), stateId: 'edit'}, this).show();
            cityWindow.down('form').loadRecord(record[0]);
            //设置窗口文件名
            var file = cityWindow.query('filefield');
            file[0].setRawValue(record[0].get('photoOne'));
            file[1].setRawValue(record[0].get('photoTwo'));
            file[2].setRawValue(record[0].get('photoThree'));
            file[3].setRawValue(record[0].get('photoFour'));
        }
    }
});