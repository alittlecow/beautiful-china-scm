/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 * @author: chengxuemin
 * date: 2015-12-22
 */

/**
 * 分类管理控制器
 */
Ext.define('app.view.category.CategoryController', {
    extend: 'app.view.base.BaseController',
    alias: 'controller.category',
    init: function(view) {
        var viewmodel = view.getViewModel();
        this.getInternationalPro({config:'CategoryConfig'},viewmodel);
    },
    //当页面加载完之后执行这个方法
    afterRender:function(thi, eOpts){
        App.Ajax.req({
            url : basePath + "/category/queryrootcategory",
            method : 'POST',
            success: function(response, options) {
                var result = Ext.JSON.decode(response.responseText);
                Ext.getCmp("parentnameEn").setValue(result.root);
            }
        });
    },
    /**
     * 删除
     * @param btn
     */
    delete:function(btn){
        var grid = btn.up('categorygrid');
        // 获取选中的列
        var record = grid.getSelectionModel().getSelection();
        var msg=this.getData('childMsg');
        // 判断选中的行数是否大于0
        if (this.selectVali(record)) {
            Ext.MessageBox.confirm("", this.getData("mainMsg_100"), function (btn) {
                if ('yes' == btn) {

                    var codes = [];
                    var ids=[];
                    for(var i=0;i<record.length;i++){
                        codes.push(record[i].data.code);
                        ids.push(record[i].data.id)
                    }
                    grid.setLoading(true);
                    App.Ajax.req({
                        url : basePath + "/category/delete",
                        method : 'POST',
                        params: {codes:codes.join(","),ids:ids},
                        success: function(response, options) {
                            var result = Ext.JSON.decode(response.responseText);
                            if(!result.flag){
                                grid.setLoading(false);
                                grid.getStore().remove(record);
                            }else{
                                App.Msg.error('', msg);
                                grid.setLoading(false);
                            }
                        }
                    });
                }
            });
        }
    },

    /**
     * 返回按钮
     * @param btn
     */
    returnBtn: function (btn) {
        var parentlevel = Ext.getCmp("parentlevel").getValue();
        if(parentlevel == 0){
            return;
        }
        var grid = btn.up("categorygrid");
        var store = grid.getStore();
        var parentid = Ext.getCmp("parentid").getValue();
        var param = {level:parentlevel,flag:"returnSub",id:parentid};
        parentlevel = parentlevel -1;
        Ext.getCmp("parentlevel").setValue(parentlevel);

        store.load({params:param,callback: function(records, operation, success) {
            var record = records[0];
            Ext.getCmp("parentid").setValue(record.data.parent);
            Ext.getCmp("parentnameEn").setValue(record.data.parentnameEn);
        }});
    },

    /**
     * 添加按钮
     * @param btn
     */
    add:function(btn){

        var categoryAddWindow = Ext.create('app.view.category.CategoryInfoWin', {
            title: this.getData('addCategory'),
            stateId: 'add'
        }).show();
        categoryAddWindow.queryById('ctgParent').setReadOnly(true);

        // 将当前页面的配置参数加入window
        categoryAddWindow.getViewModel().setData(this.getViewModel().getData());
        categoryAddWindow.show();

        var parentid = Ext.getCmp("parentid").getValue();
        categoryAddWindow.queryById('parentid').setValue(parentid);


        var parentnameEn = Ext.getCmp("parentnameEn").getValue();
        categoryAddWindow.queryById('ctgParent').setValue(parentnameEn);
    },

    /**
     * 修改分类管理信息
     * @param btn
     */
    edit:function(btn) {

        var grid = btn.up('categorygrid');
        // 获取选中的列
        var record = grid.getSelectionModel().getSelection();
        // 是否选择验证
        if (this.oneSelectVali(record)) {

            var categoryWindow = Ext.create('app.view.category.CategoryInfoWin', {
                title: this.getData('editCategory'),
                stateId: 'edit'
            }).show();
            // 将当前页面的配置参数加入window
            categoryWindow.getViewModel().setData(this.getViewModel().getData());
            categoryWindow.down('form').loadRecord(record[0]);
            categoryWindow.queryById('ctgParent').setReadOnly(true);
        }
    },

    /**
     * 进入子分类管理信息
     * @param btn
     */
    intoSub:function(btn) {
        //获取所在的行
        var record = btn.getWidgetRecord();
        var grid = btn.up('grid');
        var store = grid.getStore();
        var param ={id:record.get("id")};
        store.load({params:param});

        Ext.getCmp("parentid").setValue(record.get("id"));
        Ext.getCmp("parentnameEn").setValue(record.get("nameEn"));
        Ext.getCmp("parentlevel").setValue(record.get("level"));
    }
});