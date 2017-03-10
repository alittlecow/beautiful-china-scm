/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 菜单管理控制器
 * @author: chenghuanhuan
 * date: 2015-11-16
 */
Ext.define('app.view.menu.MenuWindowController', {
    extend: 'app.view.base.BaseController',
    alias: 'controller.menuwindow',
    init: function(view) {
        console.log("init MenuWindowController");
        console.log(view.getViewModel());
        var viewmodel = view.getViewModel();
    },

    /**
     * 模板下拉框二级联动
     * @param e
     */
    onSelectItem:function(e){
       var plateCode=e.getValue();
        var moduleCombox=Ext.getCmp('moduleComboByInfoMenu');
        moduleCombox.reset();
        moduleCombox.store.load({params:{plateCode:plateCode}});

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
       /* if(!addWindow.down('checkboxgroup').getValue().levels){
            App.Msg.warn('', '请选择管理级别!');
            return;
        }*/
        // 获取表单中的数据
        var values = form.getForm().getValues();

        var url = 'save';
        if(addWindow.getStateId()==='edit'){
            url = 'update';
        }

        App.Ajax.req({
            url : basePath + "/menu/"+url,
            params:values,
            success: function(response, options) {
                var result = Ext.JSON.decode(response.responseText);
                if(result.result==='ok'){
                    App.Msg.info('',result.msg);
                    addWindow.close();
                    var grid = Ext.getCmp("center").down('menugrid').getStore().load();
                    //Ext.data.StoreManager.lookup('menuGridStore').load();
                }else{
                    App.Msg.error('', result.msg);
                }
            }
        });
    }
});