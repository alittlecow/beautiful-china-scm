/**
 * 封装的Ajax,适用于本项目,传参类似于Ext.Ajax.request
 * 当我们需要处理failure回调方法时才传递failure回调函数,否则不需要传递此参数,框架统一处理
 * 例:
 *  App.Ajax.req({
            url : basePath + "/menu/"+url,
            method : 'POST',
            //async: false,
            params:values,
            success: function(response, options) {
                var result = Ext.JSON.decode(response.responseText);
                if(result.result==='ok'){
                    Ext.Msg.alert('提示', '保存成功!');
                    addWindow.close();
                    var grid = Ext.getCmp("center").down('menugrid').getStore().load();
                    //Ext.data.StoreManager.lookup('menuGridStore').load();
                }else{
                    Ext.Msg.alert('提示', '保存失败!');
                }
            }
            });
 */
Ext.define('app.view.common.Ajax', {
    extend: 'Ext.data.Connection',
    alternateClassName : ['App.Ajax'],
    singleton: true,
    autoAbort: false,
    method : 'POST',
    req: function(options) {
        options = options || {};
        if(!options.failure){
            options.failure = function(response, opts) {
                var result;
                try{
                    result =  eval("(" + response.responseText + ')');
                    if(result.rescode == 499){
                        eval(result.data);
                    }else if(result.msg!=""){
                        App.Msg.error('fail', result.msg);
                    }
                }catch(e){
                    App.Msg.error('fail',response.responseText);
                }
            }
        }

        this.request(options);
    }
});