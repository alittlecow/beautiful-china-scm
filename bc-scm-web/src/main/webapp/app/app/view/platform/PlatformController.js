/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 平台用户管理控制器
 * @author: fengbaitong
 * date: 2015-12-12
 */
Ext.define('app.view.platform.PlatformController', {
    extend: 'app.view.base.BaseController',
    alias: 'controller.platform',

    /**
     * 初始化按钮所绑定的中英文value
     */
    init: function(view) {
        console.log("init PlatformController");
        var viewmodel = view.getViewModel();
        console.log(viewmodel);
         this.getInternationalPro({config:'PlatformConfig'},viewmodel);
    },

    /**
     *添加平台用户
     */
    add:function(){
        var platformAddWindow = this.createWin('platforminfowindow',{title:this.getData('addPlatform')},this);
        // 将当前页面的配置参数加入window
        platformAddWindow.getViewModel().setData(this.getViewModel().getData());
        platformAddWindow.show();
    },


    /**
     *删除平台用户
     */
    delete:function(btn){
        var grid = btn.up('platformgrid');
        // 获取选中的列
        var record = grid.getSelectionModel().getSelection();
        if (this.selectVali(record)) {
            // TODO 所有提示框后期会重新封装
            Ext.MessageBox.confirm("", this.getData("mainMsg_100"), function (btn) {
                if ('yes' == btn) {

                    var ids = [];
                    for(var i=0;i<record.length;i++){
                        ids.push(record[i].data.id);
                    }
                    grid.setLoading(true);
                    App.Ajax.req({
                        url : basePath + "/platform/delete",
                        method : 'POST',
                        params: {ids:ids.join(",")},
                        success: function() {
                            grid.setLoading(false);
                            grid.getStore().reload();
                        }
                    });
                }
            });
        }

    },

    /**
     *修改平台用户
     */
    edit:function(btn){
        var grid = btn.up('platformgrid');
        // 获取选中的列
        var record = grid.getSelectionModel().getSelection();
        if(this.oneSelectVali(record)){
            var platformWindow = this.createWin('platforminfowindow',{title:this.getData('editPlatform'),stateId:'edit'},this).show();
            // 将当前页面的配置参数加入window
            platformWindow.getViewModel().setData(this.getViewModel().getData());
            platformWindow.down('form').loadRecord(record[0]);
            //编辑用户时,登录名不可改变,不修改密码的时候,密码可以为空
            platformWindow.queryById('loginName').setReadOnly(true);
            platformWindow.queryById('password').allowBlank=true;
            platformWindow.queryById('confirmPwd').allowBlank=true;
        }
    }
});