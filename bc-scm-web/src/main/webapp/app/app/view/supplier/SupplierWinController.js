/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 供应商window控制器
 * @author: fengbaitong
 * date: 2015-12-12
 */
Ext.define('app.view.supplier.SupplierWinController', {
    extend: 'app.view.base.BaseController',
    alias: 'controller.supplierwindow',

    /**
     * 初始化按钮所绑定的中英文value
     */
    init: function(view) {
        var viewmodel = view.getViewModel();
    },

    /**
     * 处理审批请求
     * @param btn
     */
    update:function(btn){
        var addWindow = btn.up('window');
        var ids=addWindow.getStateId();
        var form = addWindow.down('form');

        // 获取表单中的数据
        var values = form.getForm().getValues();
        var name=btn.name;
        var rReason=values.rReason;
        var status='';
        if(name=='pass'){
            status='N';
        }else if(name=='reject'&&rReason!=null&&rReason!=''){
            status='R';
        }else{
            App.Msg.error('',  this.getData("mainMsg_104"));
            return;
        }
        /**
         * 获取当前登录的用户
         */
        var userStr = window.localStorage.getItem("user");
        var user = Ext.JSON.decode(userStr);

        App.Ajax.req({
            url : basePath + "/supplier/update",
            method : 'POST',
            params:{ids:ids,rReason:rReason,status:status,approver:user.name},
            success: function(response, options) {
                var result = Ext.JSON.decode(response.responseText);
                if(result.result==='ok'){
                    App.Msg.info('',result.msg);
                    addWindow.close();
                    Ext.getCmp("suppliergrid").getStore().reload();
                }else{
                    App.Msg.error('', result.msg)
                }
            }
        });
    }
});