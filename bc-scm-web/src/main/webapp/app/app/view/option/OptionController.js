/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 选项管理控制器
 * @author: liufei
 * date: 2015-12-22
 */
Ext.define('app.view.option.OptionController', {
    extend: 'app.view.base.BaseController',
    alias: 'controller.option',
    init: function (view) {
        var viewmodel = view.getViewModel();
        this.getInternationalPro({config: 'OptionConfig'}, viewmodel);
    },

    /**
     * 添加选项按钮
     * @param btn
     */
    add:function(){
        var optionAddWindow = Ext.create('app.view.option.OptionNameInfoWindow',{title:this.getData('addOptionName')});
        // 将当前页面的配置参数加入window
        optionAddWindow.getViewModel().setData(this.getViewModel().getData());
        optionAddWindow.show();
    },

    /**
     * 添加选项值按钮
     * @param btn
     */
    addValue:function(btn){
        var optionAddWindow = Ext.create('app.view.option.OptionValueInfoWindow', {
                                 title: this.getData('addOptionValue'),
                                 stateId: 'addValue'
        });
        // 将当前页面的配置参数加入window
        optionAddWindow.getViewModel().setData(this.getViewModel().getData());
        var grid = btn.up('option').down('optionnamegrid');
        var nameRecord = grid.getSelectionModel().getSelection();
        if(this.oneSelectVali(nameRecord)){
            optionAddWindow.queryById("optionId").setValue(nameRecord[0].get("optionId"));
            optionAddWindow.show();
        }
    },

    /**
     * 修改选项值按钮
     * @param btn
     */
    editValue:function(btn){
        var grid = btn.up('optionvaluegrid');
        // 获取选中的列
        var record = grid.getSelectionModel().getSelection();
        // 是否选择验证
        if (this.oneSelectVali(record)) {
            var optionEditWindow = Ext.create('app.view.option.OptionValueInfoWindow', {
                title: this.getData('editOptionValue'),
                stateId: 'editValue'
            }).show();
            // 将当前页面的配置参数加入window
            optionEditWindow.getViewModel().setData(this.getViewModel().getData());
            optionEditWindow.down('form').loadRecord(record[0]);
        }
    },

    /**
     * 删除选项
     * @param btn
     */
    delete:function(btn){

        var grid = btn.up('optionnamegrid');
        // 获取选中的列
        var record = grid.getSelectionModel().getSelection();

        //// 判断选中的行数是否大于0
        if (this.oneSelectVali(record)) {

            Ext.MessageBox.confirm("", this.getData("mainMsg_100"), function (btn) {
                if ('yes' == btn) {
                    var codes ;
                    //for(var i=0;i<record.length;i++){
                        codes = record[0].data.optionId;
                    //}
                    grid.setLoading(true);
                    App.Ajax.req({
                        url : basePath + "/option/deleteName",
                        method : 'POST',
                        params: {codes:codes},
                        success: function(response, options) {

                            grid.setLoading(false);
                            grid.getStore().reload();
                            grid.nextSibling().getStore().reload();
                        }
                    });
                }
            });
        }
    },

    /**
     * 删除选项值
     * @param btn
     */
    deleteValue:function(btn){

        var grid = btn.up('optionvaluegrid');
        // 获取选中的列
        var record = grid.getSelectionModel().getSelection();

        // 判断选中的行数是否大于0
        if (this.selectVali(record)) {

            Ext.MessageBox.confirm("", this.getData("mainMsg_100"), function (btn) {
                if ('yes' == btn) {

                    var codes = [];
                    for(var i=0;i<record.length;i++){
                        codes.push(record[i].data.valueId);
                    }
                    grid.setLoading(true);
                    App.Ajax.req({
                        url : basePath + "/option/deleteValue",
                        method : 'POST',
                        params: {codes:codes.join(",")},
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
     * 选项名称表格单击事件
     * @param v
     * @param r
     */
    optionNameGridClick:function(v,r){
        var optionId = r.get('optionId');
        v.up('option').down("optionvaluegrid").getStore().load({params:{optionId:optionId}});
    }
});