/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 平台用户编辑窗口控制器
 * @author: fengbaitong
 * date: 2015-12-12
 */
Ext.define('app.view.platform.PlatformWinController', {
    extend: 'app.view.base.BaseController',
    alias: 'controller.platformwindow',

    /**
     * 初始化按钮所绑定的中英文value
     */
    init: function(view) {
        console.log("init PlatformWinController");
        var viewmodel = view.getViewModel();
        console.log(viewmodel);
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

        var url = 'save';
        if(addWindow.getStateId()==='edit'){
            url = 'update';
        }
        var password = values.password;
        if(Ext.String.trim(password)!==""){
            var key = new RSAKeyPair(
                "22c29d5bda305e5daa0920b86cd410844a7aead043cfc3f78af2166e86e26eb", "",
                "102e05ea9849d82b2630523751c1cd1984e92d3b45bf8d1ba0d67b55b0119eb9"
            );
            var newpwd = encryptedString(key, password + App.Util.randomStr(10));
            values.password = newpwd;
        }else {
            delete values.password
        }

        App.Ajax.req({
            url : basePath + "/platform/"+url,
            method : 'POST',
            params:values,
            success: function(response, options) {
                var result = Ext.JSON.decode(response.responseText);
                if(result.result==='ok'){
                    App.Msg.info('',result.msg);
                    addWindow.close();
                    Ext.getCmp("platformgrid").getStore().reload();
                }else{
                    App.Msg.error('', result.msg)
                }
            }
        });
    }
});