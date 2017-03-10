/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 行程详情窗口控制器
 * @author: dongjingjun
 * date: 2015-12-29
 */

Ext.define('app.view.tour.DetailWinController', {
    extend: 'app.view.base.BaseController',
    alias: 'controller.detailwin',
    /**
     * 保存按钮
     * @param btn
     */
    saveDetail: function (btn) {
        var addWindow = btn.up('window');
        var form = addWindow.down('form');
        var grid = btn.up('window').grid;
        if (false == form.getForm().isValid()) {
            return;
        }
        //处理编辑器内数据
        var imagedata = [];
        var cover = [];
        var htmlEditor = addWindow.query('myeditor');
        var str;
        for (var j = 0; j < htmlEditor.length; j++) {
            str += htmlEditor[j].value;
        }
        //获取编辑器内图片地址
        var files = this.getUrl(str);
        for (var k = 0; k < files.length; k++) {
            imagedata.push(files[k]);
            cover.push(-1);
        }
        // 获取表单中的数据
        var values = form.getForm().getValues();
        values.tourId = addWindow.tourId;
        values.imageData = imagedata;
        values.cover = cover;
        var url = 'updateDetail';
        if (addWindow.getStateId() !== 'edit') {
            url = 'saveDetail';
        }
        App.Ajax.req({
            url: basePath + "/tour/" + url,
            method: 'POST',
            params: values,
            success: function (response) {
                var result = Ext.JSON.decode(response.responseText);
                if (result.result === 'ok') {
                    App.Msg.info('', result.msg);
                    addWindow.close();
                    var store = grid.getStore();
                    Ext.apply(store.proxy.extraParams, {"id": addWindow.tourId});
                    store.load();
                } else {
                    App.Msg.error('', result.msg);
                }
            }
        });
    },
    /**
     * 获取字符串内图片地址
     * @param str
     * @returns {Array}
     */
    getUrl: function (str) {
        var x = 0;
        var y = 0;
        var files = [];
        while (x !== (-1)) {
            x = str.indexOf('src="', x + 5);
            if (x !== (-1)) {
                y = str.indexOf('"', x + 8);
                files.push(str.substring(x + 5, y));
            }
        }
        return files;
    }
});