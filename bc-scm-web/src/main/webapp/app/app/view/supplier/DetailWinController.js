/**
 * Copyright @ 2016 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 供应商管理window控制器
 * @author: zhangyu
 * date: 2016-2-3
 */
Ext.define('app.view.supplier.DetailWinController', {
    extend: 'app.view.base.BaseController',
    alias: 'controller.supplierdetailwin',

    /**
     * 初始化按钮所绑定的中英文value
     */
    init: function(view) {
        var viewmodel = view.getViewModel();
    },

    /**
     * 保存
     * @param btn
     */
    save:function(btn){
        var addWindow = btn.up('window');
        var form = addWindow.down('form');
        var grid = Ext.getCmp('suppliergrid');
        if (false == form.getForm().isValid()) {
            return;
        }
        // 获取表单中的数据

        var values = form.getForm().getValues();

        if(addWindow.getStateId()==='edit'){
            url = 'updateSupplier';
        }
        if(addWindow.getStateId()==='add'){

            url = 'add';
        }

        App.Ajax.req({
            url : basePath + "/supplier/"+url,

            method : 'POST',

            params:values,

            success: function(response, options) {
                var result = Ext.JSON.decode(response.responseText);
                if(result.result==='ok'){
                    App.Msg.info('',result.msg);
                    addWindow.close();
                   grid.getStore().reload();
                }else{
                    App.Msg.error('', result.msg);
                }
            }
        });
    }


});