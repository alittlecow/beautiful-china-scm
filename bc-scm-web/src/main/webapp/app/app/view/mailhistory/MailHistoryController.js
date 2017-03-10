/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: chengxuemin
 * date: 2015-12-09
 */

/**
 * 邮件历史记录控制器
 */
Ext.define('app.view.mailhistory.MailHistoryController', {
    extend: 'app.view.base.BaseController',
    alias: 'controller.mailhistory',
    init: function(view){
        var viewmodel = view.getViewModel();
        this.getInternationalPro({config:'MailHistoryConfig'},viewmodel);
    },
    /**
     * 查询邮件
     * @param v
     */
    query:function(v){

        // TODO 防止频繁点击刷新，禁用按钮
        var form = v.up('mailhistoryqueryform');

        if(true != form.isValid()){
            return;
        }
        var grid = form.nextSibling("mailhistorygrid");
        var store = grid.getStore();
        var params = form.getForm().getValues();
        Ext.apply(store.proxy.extraParams, params);
        store.load();
    },

    /**
     * 添加按钮
     * @param btn
     */
    add:function(btn){
        Ext.create('app.view.mailhistory.MailHistoryInfoWin').show();
    },

    /**
     * 查看
     * @param btn
     */
    check: function(btn){
        var grid = btn.up('mailhistorygrid');
        // 获取选中的列
        var record = grid.getSelectionModel().getSelection();
        if(this.oneSelectVali(record)){
            var mailhistoryWin = Ext.create('app.view.mailhistory.MailHistoryInfoWin',{title:this.getData('checkEmailContent'),stateId:'check'}).show();
            mailhistoryWin.down('form').loadRecord(record[0]);
        }
    }
});
