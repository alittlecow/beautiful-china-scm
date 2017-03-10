/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 供应商管理控制器
 * @author: fengbaitong
 * date: 2015-12-12
 */
Ext.define('app.view.supplier.SupplierController', {
    extend: 'app.view.base.BaseController',
    alias: 'controller.supplier',

    /**
     * 初始化按钮所绑定的中英文value
     */
    init: function(view) {
        console.log("init SupplierController");
        var viewmodel = view.getViewModel();
        console.log(viewmodel);
        this.getInternationalPro({config:'SupplierConfig'},viewmodel);
    },

    /**
     * 点击审批按钮弹出窗口
     * @param btn
     */
    approve:function(btn){
        var grid = btn.up('suppliergrid');
        // 获取选中的列
        var record = grid.getSelectionModel().getSelection();
        if('N'===record[0].data.status){
            App.Msg.info('',  this.getData("approveMsg"));
            return;
        }
        if(this.selectVali(record)){
            var ids = [];
            for(var i=0;i<record.length;i++){
                ids.push(record[i].data.id);
            }
            ids=ids.join(',');
            var supplierWindow = this.createWin('supplierapprovewindow',{title:this.getData('approve'),stateId:ids},this).show();
            supplierWindow.getViewModel().setData(this.getViewModel().getData());

        }
    },

    /**
     * 详细按钮
     * @param btn
     */
    detail:function(btn){
        //获取选在的行
        var record = btn.getWidgetRecord();

        //title国际化
        var supplierWin = this.createWin('supplierinfowindow',{title:this.getData('supplierDetails')},this).show();
        supplierWin.getViewModel().setData(this.getViewModel().getData());
        supplierWin.down('form').loadRecord(record);
    },

    /**
     *编辑按钮
     */
    edit:function(btn){
        var grid = btn.up('suppliergrid');
        // 获取选中的列
        var record = grid.getSelectionModel().getSelection();
        if(this.oneSelectVali(record)){
            var displayWindow =this.createWin('supplierdetailinfowin',{title:this.getData('editSupplier'),stateId:'edit'},this).show();
            // 将当前页面的配置参数加入window
            displayWindow.getViewModel().setData(this.getViewModel().getData());
            displayWindow.down('form').loadRecord(record[0]);
        }

    },


    /**
     * 添加按钮
     * @param btn
     */
    add: function (btn) {
        var displayAddWin =this.createWin('supplierdetailinfowin',{title:this.getData('addSupplier'),stateId:'add'},this).show();
        // 将当前页面的配置参数加入window
        displayAddWin.getViewModel().setData(this.getViewModel().getData());
        var grid = displayAddWin.down('displaydetailgrid');
        //grid.setVisible(false);
        displayAddWin.show();

    }



});