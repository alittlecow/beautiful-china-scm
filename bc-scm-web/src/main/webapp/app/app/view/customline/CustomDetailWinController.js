/**
 * Copyright @ 2016 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 * @author: zhangyu
 * date: 2016-1-12
 */

/**
 * 线路主题管理控制器
 */
Ext.define('app.view.customline.CustomDetailWinController', {
    extend: 'app.view.base.BaseController',
    alias: 'controller.customDetailWinController',
  /**
     * 保存
     * @param btn
     */
    save:function(btn){
        var addWindow = btn.up('window');
        var grid = Ext.getCmp('customlinedetailgrid');

      var form = addWindow.down('form');
        if (false == form.getForm().isValid()) {
            return;
        }
        // 获取表单中的数据
        var values = form.getForm().getValues();

      var url = 'saveCity';
      if(addWindow.getStateId()==='edit'){
          url = 'updateDay';
      }
        App.Ajax.req({
            url : basePath + "/customline/"+url,
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