/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: chengxuemin
 * date: 2015-12-12
 */

/**
 * 网站用户管理控制器
 */
Ext.define('app.view.websiteuser.WebsiteUserController', {
    extend: 'app.view.base.BaseController',
    alias: 'controller.websiteuser',
    init: function(view) {
        var viewmodel = view.getViewModel();
        this.getInternationalPro({config:'WebsiteUserConfig'},viewmodel);
    },

    /**
     * 详细按钮
     * @param btn
     */
    detail:function(btn){
        //获取选在的行
        var record = btn.getWidgetRecord();
        //Ext.Msg.alert('详细', button.getWidgetRecord().get('name'));

         //title国际化
        var websiteuserWin = Ext.create('app.view.websiteuser.WebsiteUserInfoWin',
            {title:this.getData('WebsiteUserDetails'),stateId:'detail'})
            .show();
        //console.log(record.data.sex);
        //console.log(record.data.status);
        //console.log(record.data.type);

        if (record.data.sex === 'F') {
            record.data.sex=this.getData('woman');
        } else {
            record.data.sex=this.getData('man');
        }

        if (record.data.status === 'N') {
            record.data.status=this.getData('normal');
        } else {
            record.data.status=this.getData('suspend');
        }

        if (record.data.type === 'A') {
            record.data.type=this.getData('agent');
        } else {
            record.data.type=this.getData('domesticConsumer');
        }
        websiteuserWin.down('form').loadRecord(record);
    },

    /**
     * 冻结按钮
     * @param btn
     */
    freeze:function(btn){
        //获取选在的行
        var record = btn.getWidgetRecord();

        var websiteuserFreWin = Ext.create('app.view.websiteuser.WebsiteUserFreInfoWin',
            {title:this.getData('FreezeWebsiteUserInformation'),stateId:'freeze'}).show();
        // 将当前页面的配置参数加入window
        websiteuserFreWin.down('form').loadRecord(record);
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

        App.Ajax.req({
            url : basePath + "/websiteuser/update",
            method : 'POST',
            //async: false,
            params:values,
            success: function(response, options) {
                var result = Ext.JSON.decode(response.responseText);
                if(result.result==='ok'){
                    App.Msg.info('',result.msg);
                    addWindow.close();
                    var grid = Ext.getCmp("center").down('websiteusergrid').getStore().load();
                }else{
                    App.Msg.error('', result.msg);
                }
            }
        });
    }
});

