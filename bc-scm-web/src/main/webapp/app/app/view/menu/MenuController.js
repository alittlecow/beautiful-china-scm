/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 菜单管理控制器
 * @author: chenghuanhuan
 * date: 2015-11-16
 */
Ext.define('app.view.menu.MenuController', {
    extend: 'app.view.base.BaseController',
    alias: 'controller.menu',
    init: function(view) {
        console.log("init MenuController");
        var viewmodel = view.getViewModel();
        this.getInternationalPro({config:'MenuConfig'},viewmodel);
    },

    /**
     * 删除
     * @param btn
     */
    delete:function(btn){
        var grid = btn.up('menugrid');
        // 获取选中的列
        var record = grid.getSelectionModel().getSelection();
        // 判断选中的行数是否大于0
        if (this.selectVali(record)) {
            Ext.MessageBox.confirm("", this.getData("mainMsg_100"), function (btn) {
                if ('yes' == btn) {

                   var codes = [];
                    for(var i=0;i<record.length;i++){
                        codes.push(record[i].data.code);
                    }
                    grid.setLoading(true);
                    App.Ajax.req({
                        url : basePath + "/menu/delete",
                        params: {codes:codes},
                        success: function(response, options) {

                            grid.setLoading(false);
                            grid.getStore().reload();
                        }
                    });
                }
            });
        }
    },

    /**
     * 添加按钮
     * @param btn
     */
    add:function(btn){

        this.createWin('menuinfowindow',{title:this.getData('addMenu')},this).show();
    },

    /**
     * 修改菜单信息
     * @param btn
     */
    edit:function(btn){

        var grid = btn.up('menugrid');
        // 获取选中的列
        var record = grid.getSelectionModel().getSelection();

        // 是否选择验证
        if(this.oneSelectVali(record)){
            var menuWindow =this.createWin('menuinfowindow',{title:this.getData('addMenu'),stateId:'edit'},this).show();
            // 将当前页面的配置参数加入window
            menuWindow.getViewModel().setData(this.getViewModel().getData());
            menuWindow.down('form').loadRecord(record[0]);
           /* var levelValue = record[0].get('level');
            var levelArr = [];
            for(var i=0;i<levelValue.length;i++){
                var c = levelValue.charAt(i);
                if(c =='1'){
                    levelArr.push((i+1)+'');
                }
            }*/
            //menuWindow.down('checkboxgroup').setValue({levels:levelArr});
        }

    },

    /**
    * 模板下拉框二级联动
    * @param e
    */
    onSelect:function(e) {
        var plateCode = e.getValue();
        var moduleCombox=Ext.getCmp('moduleComboByQueryMenu');
        moduleCombox.reset();
        moduleCombox.store.load({params: {plateCode: plateCode}});
    }
});