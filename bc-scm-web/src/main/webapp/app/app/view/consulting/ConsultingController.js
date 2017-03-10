/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 * @author: chengxuemin
 * date: 2016-01-18
 */

/**
 * 咨询投诉管理控制器
 */
Ext.define('app.view.consulting.ConsultingController', {
    extend: 'app.view.base.BaseController',
    alias: 'controller.consulting',
    init: function(view) {
        var viewmodel = view.getViewModel();
        this.getInternationalPro({config:'ConsultingConfig'},viewmodel);
    },

    /**
     * 处理
     * @param btn
     */
    deal:function(btn){

        var grid = btn.up('consultinggrid');
        // 获取选中的列
        var record = grid.getSelectionModel().getSelection();

        // 是否选择验证
        if(this.oneSelectVali(record)){
            var consultingWin = Ext.create('app.view.consulting.ConsultingInfoWin', {
                title:　this.getData('dealPage'),
                stateId: 'deal'
            }).show();
            // 将当前页面的配置参数加入window
            consultingWin.getViewModel().setData(this.getViewModel().getData());
            consultingWin.down('form').loadRecord(record[0]);
            consultingWin.queryById('content').setReadOnly(true);
        }
    }
});