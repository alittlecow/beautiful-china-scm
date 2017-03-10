/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: dongjingjun
 * date: 2015-12-21
 */
/**
 * 属性管理所有弹出窗口的控制器
 */

Ext.define('app.view.attribute.AttributeWinController', {
    extend: 'app.view.base.BaseController',
    alias: 'controller.attributewin',
    init: function(view) {
        var viewmodel = view.getViewModel();
        this.getInternationalPro({config:'AttributeConfig'},viewmodel);
    },

    /**
     * 保存属性
     * @param btn
     */
    saveAttribute:function(btn){
        var addWindow = btn.up('window');
        var form = addWindow.down('form');
        if (false == form.getForm().isValid()) {
            return;
        }
        // 获取表单中的数据
        var values = form.getForm().getValues();
        App.Ajax.req({
            url : basePath + "/attribute/saveAttribute",
            method : 'POST',
            params:values,
            success: function(response, options) {
                var result = Ext.JSON.decode(response.responseText);
                if(result.result==='ok'){
                    App.Msg.info('',result.msg);
                    addWindow.close();
                    Ext.getCmp("attributegrid").getStore().reload();
                }else{
                    App.Msg.error('', result.msg)
                }
            }
        });
    },

    /**
     * 点击save,更新属性
     * @param btn
     */
    editAttribute:function(btn){
        var eidtWindow = btn.up('window');
        var form = eidtWindow.down('form');
        if (false == form.getForm().isValid()) {
            return;
        }
        // 获取表单中的数据
        var values = form.getForm().getValues();
        App.Ajax.req({
            url : basePath + "/attribute/editAttribute",
            method : 'POST',
            params:values,
            success: function(response, options) {
                var result = Ext.JSON.decode(response.responseText);
                if(result.result==='ok'){
                    App.Msg.info('',result.msg);
                    eidtWindow.close();
                    Ext.getCmp("attributegrid").getStore().reload();
                }else{
                    App.Msg.error('', result.msg)
                }
            }
        });
    },

    /**
     * 弹出增加属性值的窗口,把属性ID通过stateId传到新窗口的stateId
     * @param btn
     */
    add:function(btn){
        var attrvaluewindow=btn.up('attrvaluewindow');
        var attrId=attrvaluewindow.getStateId();
        this.createWin('addattrvaluewindow',{title:this.getData('addAttributeValue'),stateId:attrId},this).show();

    },

    /**
     * 保存新增的属性值
     * @param btn
     */
    saveAttrValue:function(btn){
        var addWindow = btn.up('window');
        var attrId=addWindow.getStateId();
        var form = addWindow.down('form');
        if (false == form.getForm().isValid()) {
            return;
        }
        var values = form.getForm().getValues();
        var url='addAttrValue';
        if(attrId=='edit'){
            url='editAttrValue';
        }else{
            values.attrId=attrId;
        }

        App.Ajax.req({
            url : basePath + "/attribute/"+url,
            method : 'POST',
            params:values,
            success: function(response, options) {
                var result = Ext.JSON.decode(response.responseText);
                if(result.result==='ok'){
                    App.Msg.info('',result.msg);
                    addWindow.close();
                    Ext.getCmp("attrvaluegrid").getStore().reload();
                    Ext.getCmp("attributegrid").getStore().reload();
                }else{
                    App.Msg.error('', result.msg)
                }
            }
        });
    },

    /**
     * 弹出更新编辑属性值窗口
     * @param btn
     */
    edit:function(btn){
        var grid=btn.up('attrvaluegrid');
        var record=grid.getSelectionModel().getSelection();
        if(this.oneSelectVali(record)){
            var editWindow = this.createWin('addattrvaluewindow',{title:this.getData('editAttributeValue'),stateId:'edit'},this).show();
            editWindow.down('form').loadRecord(record[0]);
        }
    },

    /**
     * 删除属性值
     * @param btn
     */
    delete:function(btn){
        var grid = btn.up('attrvaluegrid');
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
                        url : basePath + "/attribute/deleteAttrValue",
                        method : 'POST',
                        params: {ids:ids.join(",")},
                        success: function() {
                            grid.setLoading(false);
                            grid.getStore().reload();
                            Ext.getCmp("attributegrid").getStore().reload();
                        }
                    });
                }
            });
        }

    }



});