/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 * @author: chengxuemin
 * date: 2016-01-11
 */

/**
 * 咨询管理控制器
 */
Ext.define('app.view.consultive.ConsultiveController', {
    extend: 'app.view.base.BaseController',
    alias: 'controller.consultive',
    init: function(view) {
        var viewmodel = view.getViewModel();
        this.getInternationalPro({config:'ConsultiveConfig'},viewmodel);
    },

    /**
     * 回复
     * @param btn
     */
    reply:function(btn){

        var record = btn.getWidgetRecord();

        var consultiveWin = Ext.create('app.view.consultive.ConsultiveInfoWin',
          {title:this.getData('replyContent'), stateId: 'reply'}).show();
         //将当前页面的配置参数加入window
        consultiveWin.down('form').loadRecord(record);
    },

    /**
     * 关闭
     * @param btn
     */
    close:function(btn){
        var record = btn.getWidgetRecord();

        /**
         * 请选择一条status为close的数据经行操作
         * @param record
         */
        if(record.get("status" ) === 'C'){
            //consultiveMsg_101 = 当前状态已为关闭!
            App.Msg.warn('', this.getData("consultiveMsg_101"));
            ret = false;
            return ret;
        }else{
            //mainMsg_100=确认要这么做吗?
            Ext.MessageBox.confirm("", this.getData("mainMsg_100"),function (btn) {
                if ('yes' == btn) {

                    var id = record.get("id" );
                    App.Ajax.req({
                        url: basePath + "/consultive/update",
                        method: 'POST',
                        params: {id:id},
                        success: function (response, options) {
                            var result = Ext.JSON.decode(response.responseText);
                            if (result.result === 'ok') {
                                App.Msg.info('', result.msg);
                                var grid = Ext.getCmp("center").down('consultivegrid').getStore().load();
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
     * 提交
     * @param btn
     */
    submit:function(btn) {
        var addWindow = btn.up('window');
        var form = addWindow.down('form');
        if (false == form.getForm().isValid()) {
            return;
        }
        // 获取表单中的数据
        var values = form.getForm().getValues();

        App.Ajax.req({
            url: basePath + "/consultive/submit",
            method: 'POST',
            //async: false,
            params: values,
            success: function (response, options) {
                var result = Ext.JSON.decode(response.responseText);
                if (result.result === 'ok') {
                    App.Msg.info('', result.msg);
                    addWindow.close();
                    var grid = Ext.getCmp("center").down('consultivegrid').getStore().load();
                } else {
                    App.Msg.error('', result.msg);
                }
            }
        });
    }

    ///**
    // * 保存
    // * @param btn
    // */
    //save:function(btn) {
    //    var addWindow = btn.up('window');
    //    var form = addWindow.down('form');
    //    if (false == form.getForm().isValid()) {
    //        return;
    //    }
    //    // 获取表单中的数据
    //    var values = form.getForm().getValues();
    //
    //    App.Ajax.req({
    //        url: basePath + "/consultive/update",
    //        method: 'POST',
    //        //async: false,
    //        params: values,
    //        success: function (response, options) {
    //            var result = Ext.JSON.decode(response.responseText);
    //            if (result.result === 'ok') {
    //                App.Msg.info('', result.msg);
    //                addWindow.close();
    //                var grid = Ext.getCmp("center").down('consultivegrid').getStore().load();
    //            } else {
    //                App.Msg.error('', result.msg);
    //            }
    //        }
    //    });
    //}
});