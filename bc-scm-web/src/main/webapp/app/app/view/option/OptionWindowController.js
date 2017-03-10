/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 选项管理控制器
 * @author: liufei
 * date: 2015-12-23
 */
Ext.define('app.view.option.OptionWindowController', {
    extend: 'app.view.base.BaseController',
    alias: 'controller.optionwindow',
    init:function(view){
        console.log(view.getViewModel());
        var viewmodel = view.getViewModel();
    },

    /**
     * 保存
     * @param btn
     */
    save:function(btn) {
        var addWindow = btn.up('window');
        var form = addWindow.down('form');
        if (false == form.getForm().isValid()) {
            return;
        }
        // 获取表单中的数据
        var values = form.getForm().getValues();

        App.Ajax.req({
            url: basePath + "/option/saveName",
            method: 'POST',
            params: values,
            success: function (response, options) {
                var result = Ext.JSON.decode(response.responseText);
                if (result.result === 'ok') {
                    App.Msg.info('', result.msg);
                    addWindow.close();
                    var grid = Ext.getCmp("center").down('optionnamegrid').getStore().load();
                } else {
                    App.Msg.error('', result.msg);
                }
            }
        });
    },
    /**
     * 保存
     * @param btn
     */
    saveValue:function(btn){
        var addWindow = btn.up('window');
        var form = addWindow.down('form');
        if (false == form.getForm().isValid()) {
            return;
        }
        // 获取表单中的数据
        var values = form.getForm().getValues();

        var url = 'saveValue';

        if(addWindow.getStateId()==='editValue'){
            url = 'updateValue';
        }

        App.Ajax.req({
            url : basePath + "/option/"+url,
            method : 'POST',
            params:values,
            success: function(response, options) {
                var result = Ext.JSON.decode(response.responseText);
                if(result.result==='ok'){
                    App.Msg.info('',result.msg);
                    addWindow.close();
                    var optionId = values["optionId"];
                    var grid = Ext.getCmp("center").down('optionvaluegrid').getStore().load({params:{optionId:optionId}});
                }else{
                    App.Msg.error('', result.msg);
                }
            }
        });
    }
});