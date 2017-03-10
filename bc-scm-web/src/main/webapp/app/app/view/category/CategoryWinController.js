/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 * @author: chengxuemin
 * date: 2015-12-22
 */

/**
 * 分类管理控制器
 */
Ext.define('app.view.category.CategoryWinController', {
    extend: 'app.view.base.BaseController',
    alias: 'controller.categorywin',
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
        if (false == form.getForm().isValid()) {
            return;
        }
        // 获取表单中的数据
        var values = form.getForm().getValues();

        if(addWindow.getStateId()==='edit'){
            url = 'update';
        }
        if(addWindow.getStateId()==='add'){
            //添加子类
            url = 'addASub';
        }

        App.Ajax.req({
            url : basePath + "/category/"+url,
            method : 'POST',
            params:values,
            success: function(response, options) {
                var result = Ext.JSON.decode(response.responseText);
                if(result.result==='ok'){
                    App.Msg.info('',result.msg);
                    addWindow.close();
                    var id= Ext.getCmp("parentid").getValue();
                    var param ={id:id};
                    var grid = Ext.getCmp("center").down('categorygrid').getStore().load(param);
                }else{
                    App.Msg.error('', result.msg);
                }
            }
        });
    }
});