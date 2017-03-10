/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: dongjingjun
 * date: 2015-12-21
 */
/**
 * 属性管理控制器
 */

Ext.define('app.view.attribute.AttributeController', {
    extend: 'app.view.base.BaseController',
    alias: 'controller.attribute',
    init: function(view) {
        var viewmodel = view.getViewModel();
        this.getInternationalPro({config:'AttributeConfig'},viewmodel);
    },

    /**
     * 点击按钮,弹出新增属性窗口
     * @param btn
     */
    addAttribute:function(btn){
        var tree=btn.up('categorytree');
        var record=tree.getSelectionModel().getSelection();
        if(this.selectVali(record)){
            var addWindow=this.createWin('addattributewindow',{title:this.getData('addAttribute')},this).show();
            addWindow.down('form').loadRecord(record[0]);
        }

    },

    /**
     * 弹出编辑属性的窗口
     * @param btn
     */
    editAttribute:function(btn){
        var record=btn.getWidgetRecord();
        var editWindow=this.createWin('editattributewindow',{title:this.getData('editAttribute')},this).show();
        editWindow.down('form').loadRecord(record);

    },

    /**
     * 点击树上的节点,根据节点分类的id,重新生成属性表格
     * @param e
     * @param record
     */
    onItemClick:function(e,record){
        var categoryId=record.get('id');
        var store=Ext.getCmp('attributegrid').getStore();
        Ext.apply(store.proxy.extraParams, {"categoryId":categoryId});
        store.load();

    },

    /**
     * 弹出属性值编辑窗口
     * @param btn
     */
    editAttributeValue:function(btn){
        var record=btn.getWidgetRecord();
        var id=record.get('attributeId');
        this.createWin('attrvaluewindow',{title:this.getData('editAttributeValue'),stateId:id},this).show();
        var store=Ext.getCmp('attrvaluegrid').getStore();
        Ext.apply(store.proxy.extraParams, {id:id});
        store.load();
    },

    /**
     * 删除属性以及相关的属性值
     * @param btn
     */
    delete:function(btn){
        var grid = btn.up('attributegrid');
        var record=btn.getWidgetRecord();
        // TODO 所有提示框后期会重新封装
        Ext.MessageBox.confirm("", this.getData("mainMsg_100"), function (btn) {
            if ('yes' == btn) {
                grid.setLoading(true);
                App.Ajax.req({
                    url : basePath + "/attribute/delete",
                    method : 'POST',
                    params: {id:record.get('attributeId')},
                    success: function() {
                        grid.setLoading(false);
                        grid.getStore().reload();
                    }
                });
            }
        });
    },

    /**
     * 查询
     * @param v
     */
    query:function(v){

        // TODO 防止频繁点击刷新，禁用按钮
        var form = v.up('form');
        var grid = Ext.getCmp('attributegrid');
        var store = grid.getStore();
        var params = form.getForm().getValues();
        // 删除空值
        Ext.Object.each(params, function(key, value, myself) {
            if(Ext.Object.isEmpty(value)){
                delete params[key];
                delete store.proxy.extraParams[key];
            }
        });
        Ext.apply(store.proxy.extraParams, params);
        store.load();
    }




});