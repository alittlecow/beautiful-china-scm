/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: dongjingjun
 * date: 2015-12-21
 */
/**
 * 部门信息管理控制器
 */

Ext.define('app.view.dimanage.DIMController', {
    extend: 'app.view.base.BaseController',
    alias: 'controller.dim',
    init: function (view) {
        var viewmodel = view.getViewModel();
        this.getInternationalPro({config: 'DeptInfoConfig'}, viewmodel);
    },
    getSup: function (e) {
        var form = e.combo.up('form');
        var store = this.getViewModel().getStore('dimFormStore');
        Ext.apply(store.proxy.extraParams,
            {
                levelCode: form.down('textfield[name=levelCode]').getValue(),
                id: form.down('textfield[name=id]').getValue()
            });
        store.load();
    },
    onItemClick: function (e, record) {
        var form = e.up().nextSibling();
        var root = e.up('treepanel').getRootNode();
        if (!root.child().contains(record)) {
            return;
        }
        if (!root.child().child().contains(record) && record.get('id') < 0) {
            if (record.child()) {
                record.removeAll();
                record.collapse();
            }
            App.Ajax.req({
                url: basePath + "/deptinfo/tree",
                async: false,
                params: {code: record.get('code')},
                success: function (response, options) {
                    var obj = Ext.decode(response.responseText);
                    record.appendChild(obj);
                    record.expand();
                }
            });
        } else {
            var store = this.getViewModel().getStore('dimStore');
            form.setHidden(false);
            Ext.apply(store.proxy.extraParams, {"id": record.get('id')});
            store.load(function (records, operation, success) {
                form.getForm().loadRecord(records[0]);
            });
        }
    },
    /**
     * 删除按钮
     * @param btn
     */
    delete: function (btn) {
        var tree = btn.up('dimtree');
        var record = tree.getSelectionModel().getSelection();
        if (this.selectVali(record)) {
            if (record[0].id < 0) {
                return;
            }
            Ext.MessageBox.confirm("", this.getData("mainMsg_100"), function (btn) {
                if ('yes' == btn) {
                    var id = record[0].id;
                    App.Ajax.req({
                        url: basePath + "/deptinfo/delDept",
                        method: 'POST',
                        params: {id: id},
                        success: function (response, options) {
                            var result = Ext.JSON.decode(response.responseText);
                            if (result.result === 'ok') {
                                App.Msg.info('', result.msg);
                                record[0].remove();
                            } else {
                                App.Msg.error('', result.msg);
                            }
                        }
                    });
                }
            })
        }
    },
    /**
     * 新增按钮
     * @param btn
     */
    add: function (btn) {
        var tree = btn.up('dimtree');
        var record = tree.getSelectionModel().getSelection();
        if (this.selectVali(record)) {
            if (record[0].data.code === 'BEAUTIFULCHINA') {
                return;
            }
            var form = tree.up().down('formpanel');
            form.setHidden(false);
            var code = form.down('textfield[name=levelCode]').getValue();
            form.getForm().reset();
            if (record[0].id < 0) {
                form.down('textfield[name=levelCode]').setValue(record[0].data.code);
            } else {
                form.down('textfield[name=levelCode]').setValue(code);
            }
        }
    },
    /**
     * 表单保存按钮
     * @param btn
     */
    save: function (btn) {
        var form = btn.up('formpanel');
        var tree = form.up().down('dimtree');
        /*获取上级部门下拉框store*/
        var store = this.getViewModel().getStore('dimFormStore');
        if (false == form.getForm().isValid()) {
            return;
        }
        var values = form.getForm().getValues();
        if (values.deptCode == values.supDept) {
            App.Msg.error('', this.getData('nameMsg'));
            return;
        }
        var url = 'editDept';
        if (values.id == '') {
            url = 'addDept';
        }
        App.Ajax.req({
            url: basePath + "/deptinfo/" + url,
            method: 'POST',
            params: values,
            success: function (response, options) {
                var result = Ext.JSON.decode(response.responseText);
                if (result.result === 'ok') {
                    App.Msg.info('', result.msg);
                    tree.getStore().reload();
                    store.reload();
                } else {
                    App.Msg.error('', result.msg);
                }
            }
        });

    }
});