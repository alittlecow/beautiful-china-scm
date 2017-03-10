/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 邮件模板管理控制器
 * @author: fengbaitong
 * date: 2015-11-25
 */
Ext.define('app.view.mailtemplate.MailTemplateController', {
    extend: 'app.view.base.BaseController',
    alias: 'controller.mailtemplate',
    /**
     * 添加按钮
     * @param btn
     */
    add:function(btn){
        this.createWin('mailtemplateinfowindow',{title:this.getData('addMailTemplate')},this).show();
    },

    /**
     * 初始化按钮所绑定的中英文value
     */
    init: function(view) {
        console.log("init MailTemplateController");
        var viewmodel = view.getViewModel();
        console.log(viewmodel);
        this.getInternationalPro({config:'MailTemplateConfig'},viewmodel);
    },

    /**
     * 保存按钮
     * @param btn
     */
    save:function(btn){
        var addWindow = btn.up('window');
        var form = addWindow.down('form');
        if (false == form.getForm().isValid()) {
            return;
        }
        // 获取表单中的数据
        var values = form.getForm().getValues();

        var url = 'save';
        if(addWindow.getStateId()==='edit'){
            url = 'update';
        }

        Ext.Ajax.request({
            url : basePath + "/mailtemplate/"+url,
            method : 'POST',
            async: false,
            params:values,
            success: function(response, options) {
                var result = Ext.JSON.decode(response.responseText);
                if(result.result==='ok'){
                    App.Msg.info('',result.msg);
                    addWindow.close();
                    /**
                     * 刷新grid页面，从数据库从新获取数据
                     */
                    Ext.getCmp('mailtemplategrid').getStore().reload();
                    //Ext.data.StoreManager.lookup('menuGridStore').load();
                }else{
                    App.Msg.error('', result.msg);
                }
            },
            failure : function(response, options) {
                App.Msg.error('', result.msg);
            }
        });
    },

    /**
     * 修改按钮
     */
    edit:function(btn){
        var grid = btn.up('mailtemplategrid');
        // 获取选中的列
        var record = grid.getSelectionModel().getSelection();
        if(this.oneSelectVali(record)){
            var mailTemplateWindow = this.createWin('mailtemplateinfowindow',{title:this.getData('editMailTemplate'),stateId:'edit'},this).show();
            mailTemplateWindow.down('form').loadRecord(record[0]);

        }

    }


});