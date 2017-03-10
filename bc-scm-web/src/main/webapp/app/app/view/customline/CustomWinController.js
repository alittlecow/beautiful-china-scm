/**
 * Copyright @ 2016 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 供应商window控制器
 * @author: zhangyu
 * date: 2016-1-8
 */
Ext.define('app.view.customline.CustomlineWinController', {
    extend: 'app.view.base.BaseController',
    alias: 'controller.customlinewindow',

    /**
     * 初始化按钮所绑定的中英文value
     */
    init: function(view) {
        var viewmodel = view.getViewModel();
    },

    /**
     * 修改定制线路目的
     * @param btn
     */
    update:function(btn){
        var addWindow = btn.up('window');
        var form = addWindow.down('form');
        if (false == form.getForm().isValid()) {
            return;
        }
        // 获取表单中的数据
        var values = form.getForm().getValues();
        App.Ajax.req({
            url : basePath + "/customline/update",
            method : 'POST',
            params:values,
            success: function(response, options) {
                var result = Ext.JSON.decode(response.responseText);
                if(result.result==='ok'){
                    App.Msg.info('',result.msg);
                    addWindow.close();
                    var grid = Ext.getCmp("center").down('customlinegrid').getStore().load();
                }else{
                    App.Msg.error('', result.msg)
                }
            }
        });
    },



        /**
         * 删除城市列表和旅游天数
         * @param btn
         */
        delete:function(btn){
            var grid = btn.up('customlinedetailgrid');
            // 获取选中的列
            var record = grid.getSelectionModel().getSelection();
            // 判断选中的行数是否大于0
            if (this.selectVali(record)) {
                Ext.MessageBox.confirm("", this.getData("mainMsg_100"), function (btn) {
                    if ('yes' == btn) {

                        var codes = [];
                        for(var i=0;i<record.length;i++){
                            codes.push(record[i].data.cstId);
                        }
                        grid.setLoading(true);
                        App.Ajax.req({
                            url : basePath + "/customline/deleteDay",
                            method : 'POST',
                            params: {ids:codes.join(",")},
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
     *修改城市列表和旅游天数
     */
    edit:function(btn){
        var grid = btn.up('customlinedetailgrid');
        // 获取选中的列
        var record = grid.getSelectionModel().getSelection();
        if(this.oneSelectVali(record)){
            var customlineWindow =this.createWin('customlinedetailwin',{title:this.getData('editCity'),stateId:'edit'},this).show();
            // 将当前页面的配置参数加入window
            customlineWindow.getViewModel().setData(this.getViewModel().getData());
            customlineWindow.down('form').loadRecord(record[0]);
        }
    },
    /**
     *添加城市列表和旅游天数
     */
    add:function(){
        var customlineAddWindow = this.createWin('customlinedetailwin',{title:this.getData('addCity'),stateId:'add'},this).show();
        // 将当前页面的配置参数加入window
        customlineAddWindow.getViewModel().setData(this.getViewModel().getData());
        customlineAddWindow.show();
    }
});