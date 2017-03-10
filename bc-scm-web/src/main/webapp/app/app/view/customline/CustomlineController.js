/**
 * Copyright @ 2016 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 定制线路管理控制器
 * @author: zhangyu
 * date: 2016-01-08
 */
Ext.define('app.view.customline.CustomlineController', {
    extend: 'app.view.base.BaseController',
    alias: 'controller.customline',

    /**
     * 初始化按钮所绑定的中英文value
     */
    init: function(view) {

        var viewmodel = view.getViewModel();

        this.getInternationalPro({config:'CustomlineConfig'},viewmodel);
    },

    /**
     *修改定制线路用户
     */
    edit:function(btn){

        var grid = btn.up('customlinegrid');
        // 获取选中的列
        var record = grid.getSelectionModel().getSelection();
        if(this.oneSelectVali(record)){
            var customlineWindow =this.createWin('customlineinfowindow',{title:this.getData('editcustomline'),stateId:'edit'},this).show();
            // 将当前页面的配置参数加入window
            customlineWindow.getViewModel().setData(this.getViewModel().getData());
            customlineWindow.down('form').loadRecord(record[0]);
        }

    }

});