/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 目的地管理窗口控制器
 * @author: dongjingjun
 * date: 2016-01-07
 */

Ext.define('app.view.destination.DesWinController', {
    extend: 'app.view.base.BaseController',
    alias: 'controller.deswin',
    /**
     * 保存
     * @param btn
     */
    save: function (btn) {
        var fileField = btn.up('window').query('filefield');
        //图片大小限制3M
        var flag = false;
        var flag1 = false;
        var fileSize = 1024 * 1024 * 3;
        for (var i = 0; i < fileField.length; i++) {
            if (fileField[i].getValue() != null && fileField[i].getValue() != '') {
                flag1 = true;
            }
            var file = fileField[i].getEl().query('input')[1].files[0];
            if (file && file.size > fileSize) {
                fileField[i].reset();
                flag = true;
            }
        }
        if (flag) {
            App.Msg.info('', this.getData('fileLimit') + ' 3MB');
            return;
        }
        if (!flag1) {
            App.Msg.info("", this.getData("mainMsg_105"));
            return;
        }
        var addWindow = btn.up('window');
        var form = addWindow.down('form');
        if (false == form.getForm().isValid()) {
            return;
        }
        var formValues = this.getFormValues(form);
        var url = 'save';
        if (addWindow.getStateId() === 'edit') {
            url = 'update';
        }
        var box = this.waitBox();
        form.getForm().submit({
            url: basePath + '/destination/' + url,
            params: {multiLanguage: formValues.multiLanguage},
            success: function (fp, o) {
                box.close();
                var result = o.result;
                if (result.result === 'ok') {
                    App.Msg.info('', result.msg);
                    addWindow.close();
                    Ext.getCmp("center").down('desgrid').getStore().load();
                } else {
                    App.Msg.error('', result.msg);
                }
            }
        });
    },
    /**
     * 保存提示框
     * @param btn
     */
    waitBox: function () {
        return Ext.MessageBox.show({
            msg: this.getData('saveMsg'),
            progressText: this.getData('saving'),
            width: 300,
            wait: {
                interval: 200
            }
        });
    },
    /**
     * 预览图片
     * @param btn
     */
    preview: function (btn) {
        var fileField = btn.previousSibling('filefield');
        var path = fileField.getValue();
        if (path == '' || path == null) {
            App.Msg.info('', this.getData('noData'));
            return;
        }
        var file = fileField.getEl().query('input')[1].files[0];
        var win = Ext.create('widget.boxwin', {title: this.getData('preview')});
        var box = win.down('box');
        win.show();
        if (!file) {
            //设置预览图片数据
            box.getEl().dom.src = imageServer + path;
        } else {
            var reader = new FileReader();
            reader.readAsDataURL(file);
            reader.onload = function (evt) {
                //设置预览图片数据
                box.getEl().dom.src = evt.target.result;
            };
        }
    },
    /**
     * 删除图片
     * @param btn
     */
    remove: function (btn) {
        var window = btn.up('window');
        var fileField = btn.previousSibling('filefield');
        var savePath = fileField.getValue();
        if (savePath == '' || savePath == null) {
            App.Msg.info('', this.getData('noData'));
            return;
        }
        Ext.MessageBox.confirm("", this.getData("mainMsg_100"), function (btn) {
            if ('yes' == btn) {
                var file = fileField.getEl().query('input')[1].files[0];
                if (file) {
                    fileField.reset();
                    return;
                }
                var id = window.down('form').getForm().getValues().id;
                var photoName = fileField.name;
                App.Ajax.req({
                    url: basePath + "/destination/remove",
                    params: {savePath: savePath, id: id, photoName: photoName},
                    success: function (response, options) {
                        var result = Ext.JSON.decode(response.responseText);
                        if (result.result === 'ok') {
                            App.Msg.info('', result.msg);
                            fileField.setRawValue('');
                            Ext.getCmp("center").down('desgrid').getStore().reload();
                        } else {
                            App.Msg.error('', result.msg);
                        }
                    }
                });
            }
        });
    }
});