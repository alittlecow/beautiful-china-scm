/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 * @author: fengbaitong
 * date: 2016-01-22
 */
Ext.define('app.view.tour.BigHtmlEditor', {
    extend: 'Ext.form.field.HtmlEditor',
    alias: 'widget.bigeditor',
    buttonTip: '插入图片',//编辑器按钮提示
    fileRegex: /\.([jJ][pP][gG]){1}$|\.([jJ][pP][eE][gG]){1}$|\.([gG][iI][fF]){1}$|\.([pP][nN][gG]){1}$|\.([bB][mM][pP]){1}$/,//文件格式
    url: 'upload',//上传的地址
    imageWidth: 460,//图片宽
    imageHeight: 300,//图片高,
    fileList: '',
    createToolbar: function () {
        var me = this;
        me.callParent(arguments);
        me.toolbar.insert(6, {
            xtype: 'button',
            iconCls: 'x-fa fa-photo',
            tooltip: me.buttonTip,
            handler: me.showImgUploader,
            scope: me
        });
        return me.toolbar;
    },
    showImgUploader: function () {
        var me = this;
        var form = Ext.create('Ext.form.Panel', {
            autoRender: true,
            autoShow: true,
            items: [{
                xtype: 'filefield',
                regex: me.fileRegex,
                editor: me,
                listeners: {
                    change: me.upload
                },
                name: 'image'
            }]
        });
        form.down('filefield').getEl().query('input')[1].click();
    },
    upload: function (f, v) {
        var htmlEditor = f.editor;
        var form = f.up('form');
        //限制图片大小
        var fileSize = 1024 * 1024 * 3;
        var file = f.getEl().query('input')[1].files[0];
        if (file && file.size > fileSize) {
            App.Msg.info('', 'Size of Image>3MB !');
            return;
        }
        form.getForm().submit({
            url:'/tour/uploadImage',
            success: function (fp, o) {
                var result = o.result;
                if (result.result === 'ok' && result.image !== '') {
                    htmlEditor.fileList += result.image;
                    var image = '<img title="pic" src="' + result.image + '" alt="fail"  width="340"'+
                        ' height="220" hspace="5" vspace="5"/>';
                    htmlEditor.setValue(htmlEditor.getValue() + image);
                }
                form.close();
            }
        });
    }

   });