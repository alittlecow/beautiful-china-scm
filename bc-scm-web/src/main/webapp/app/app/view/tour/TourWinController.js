/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 旅游线路管理窗口控制器
 * @author: dongjingjun
 * date: 2015-12-28
 */

Ext.define('app.view.tour.TourWinController', {
        extend: 'app.view.base.BaseController',
        alias: 'controller.tourwin',
        /**
         * 新增一条数据
         * @param btn
         */
        addContainer: function (btn) {
            var fieldset = btn.up('panel').down('fieldset');
            var ens = fieldset.query('textfield[flag=en]');
            var frs = fieldset.query('textfield[flag=fr]');
            var num = ens.length;
            if (num > 0 && ens[num - 1].getValue() === '' && frs[num - 1].getValue() === '') {
                App.Msg.info('', this.getData('addItem'));
                return;
            }
            var fieldContainer = function () {
                return {
                    xtype: 'fieldcontainer',
                    defaultType: 'textfield',
                    defaults: {
                        labelWidth: 80,
                        labelAlign: 'right'
                    },
                    items: [
                        {
                            fieldLabel: arguments[0],
                            width: 500,
                            flag: arguments[1]
                        },
                        {
                            xtype: 'checkbox',
                            margin: '0 25',
                            hidden: arguments[2]
                        }
                    ]
                }
            };
            fieldset.add(fieldContainer(num + 1 + ':' + this.getData('english'), 'en', false));
            fieldset.add(fieldContainer(this.getData('france'), 'fr', true));
        },
        /**
         * 删除一条数据
         * @param btn
         */
        deleteContainer: function (btn) {
            var fieldSet = btn.up('panel').down('fieldset');
            var checkBox = fieldSet.query('checkbox[checked=true]');
            if (checkBox.length < 1) {
                App.Msg.info('', this.getData('deleteItem'));
                return;
            }
            var fieldConEn;
            var fieldConFr;
            for (var j = 0; j < checkBox.length; j++) {
                fieldConEn = checkBox[j].up('fieldcontainer');
                fieldConFr = fieldConEn.nextSibling();
                fieldSet.remove(fieldConEn);
                fieldSet.remove(fieldConFr);
            }
            var ens = fieldSet.query('textfield[flag=en]');
            for (var i = 0; i < ens.length; i++) {
                ens[i].setFieldLabel(i + 1 + ':' + this.getData('english'));
            }
        }
        ,
        /**
         * 加载选项
         * @param grid
         */
        loadOption: function (grid) {
            var win = grid.up('window');
            var tourId = win.tourId;
            if (!tourId) {
                return;
            }
            var store = grid.getStore();
            Ext.apply(store.proxy.extraParams, {"id": tourId});
            store.load();
        },
        /**
         * 添加选项
         * @param btn
         */
        addOption: function (btn) {
            var wins = btn.up('window');
            if (!this.isExist(wins)) {
                return;
            }
            var win = this.createWin('optionselectwin', {title: this.getData('addOption')}, this).show();
            win.down('grid[itemId=grid1]').getStore().removeAll();
            win.down('grid[itemId=grid2]').getStore().removeAll();
            win.tourId = wins.tourId;
            win.grid = btn.up('grid');
        },
        /**
             * 验证路线是否存在
             * @param win
             * @returns {boolean}
             */
            isExist: function (win) {
                if (!win.tourId) {
                    App.Msg.info('', this.getData('isExist_msg'));
                    return false;
                }
                return true;
        },
        /**
         * 修改选项
         * @param btn
         */
        editOption: function (btn) {
            var wins = btn.up('window');
            var grid = btn.up('grid');
            var record = grid.getSelectionModel().getSelection();
            if (!this.isExist(wins)) {
                return;
            }
            if (this.oneSelectVali(record)) {
                var win = this.createWin('optionselectwin', {
                    title: this.getData('editOption'),
                    stateId: 'edit'
                }, this).show();
                var optionId = record[0].data.optionId;
                win.down('combo').setValue(optionId).setHidden(true);
                win.tourId = wins.tourId;
                win.grid = grid;
                win.idList = record[0].data.idList;
                var store = win.down('grid[itemId=grid2]').getStore();
                store.setProxy({
                    extraParams: {"tourId": win.tourId, "optionId": optionId},
                    type: 'ajax',
                    url: basePath + '/tour/getExistOptionValueById',
                    reader: {
                        type: 'json'
                    }
                });
                store.load();
            }
        },
        /**
         * 删除选项
         * @param btn
         */
        deleteOption: function (btn) {
            var grid = btn.up('grid');
            var record = grid.getSelectionModel().getSelection();
            if (this.selectVali(record)) {
                Ext.MessageBox.confirm("", this.getData("mainMsg_100"), function (btn) {
                    if ('yes' == btn) {
                        var ids = [];
                        for (var i = 0; i < record.length; i++) {
                            ids = Ext.Array.merge(ids, record[i].data.idList);
                        }
                        grid.setLoading(true);
                        App.Ajax.req({
                            url: basePath + "/tour/deleteOption",
                            method: 'POST',
                            params: {ids: ids},
                            success: function () {
                                grid.setLoading(false);
                                grid.getStore().reload();
                            }
                        });
                    }
                });
            }
        },
        /**
         * 窗口关闭事件，用于删除用户数据库没有的图片
         */
        deltemp: function (e) {
            e.mainGrid.getStore().reload();
            App.Ajax.req({
                url: basePath + "/tour/deltemp"
            });
        },
        /**
         * 保存路线基本信息
         * @param btn
         */
        saveBaseInfo: function (btn) {
            var win = btn.up('window');
            var form = btn.up('form');
            var stateId = win.getStateId();
            var codeField = form.down('textfield[name=code]');

            if (false == form.getForm().isValid()) {
                return;
            }

            if (!form.tourCode && this.testCode(codeField)) {
                return;
            }

            if (form.tourCode && form.tourCode != codeField.getValue() && this.testCode(codeField)) {
                return;
            }


            //处理数据
            var include = this.getDatas(form, 'include');
            var exclude = this.getDatas(form, 'exclude');
            var desc = this.getDatas(form, 'desc');
            var term = this.getDatas(form, 'term');
            var important = this.getDatas(form, 'important');
            var triphint = this.getDatas(form, 'triphint');

            var values = form.getForm().getValues();

            values.includeEn = include.ens;
            values.includeFr = include.frs;
            values.excludeEn = exclude.ens;
            values.excludeFr = exclude.frs;
            values.descEn = desc.ens;
            values.descFr = desc.frs;
            values.termEn = term.ens;
            values.termFr = term.frs;
            values.importantEn = important.ens;
            values.importantFr = important.frs;
            values.triphintEn = triphint.ens;
            values.triphintFr = triphint.frs;

            var url = 'saveBaseInfo';
            if (stateId === 'edit') {
                url = 'editBaseInfo';
            }
            //提交数据提示
            this.waitBox(btn);
            App.Ajax.req({
                url: basePath + "/tour/" + url,
                method: 'POST',
                params: values,
                success: function (response, options) {
                    var result = Ext.JSON.decode(response.responseText);
                    if (result.result === 'ok') {
                        if (stateId !== 'edit') {
                            win.tourId = result.tourId;
                        }
                        App.Msg.info('', result.msg);
                    } else {
                        App.Msg.error('', result.msg);
                    }
                }
            });

        },
        /**
         * 验证表单填写路线代码
         * @param e
         * @returns {boolean}
         */
        testCode: function (e) {
            var me = this;
            var code = e.getValue();
            var flag = false;
            App.Ajax.req({
                url: basePath + "/tour/getCode",
                params: {code: code},
                async: false,
                success: function (response) {
                    var result = Ext.JSON.decode(response.responseText);
                    if (result.flag) {
                        App.Msg.error('', me.getData('codeMsg'));
                        e.markInvalid('');
                        flag = true;
                    }
                }
            });
            return flag;
        },
        /**
         * 设置数据
         */
        getDatas: function (form, itemId) {
            var fieldSet = form.down('fieldset[itemId=' + itemId + ']');
            var textFieldEn = fieldSet.query('textfield[flag=en]');
            var textFieldFr = fieldSet.query('textfield[flag=fr]');
            var ens = [];
            var frs = [];
            var len = textFieldEn.length;
            for (var m = 0; m < len; m++) {
                ens.push(textFieldEn[m].getValue());
                frs.push(textFieldFr[m].getValue());
                //textFieldEn[m].setDisabled(true);
                //textFieldFr[m].setDisabled(true);
            }
            if (len === 1) {
                return {ens: ens[0] + '(;)', frs: frs[0] + '(;)'};
            }
            return {ens: ens.join('(;)'), frs: frs.join('(;)')};
        },
        /**
         * 图片添加点击事件,添加图片
         * @param img
         */
        addImageClick: function (img) {
            var me = this;
            img.getEl().dom.onclick = function () {
                var mark = img.up('form').down('textfield[itemId=mark]').getValue();
                var winForm = img.up('form');
                var existImg = winForm.query('image').length - 1;//获取已存在图片数量
                var fileNumber = 15, fileSize = 1024 * 1024 * 3;//最多上传图片数量，限制图片大小3MB
                if (existImg >= fileNumber) {
                    App.Msg.info('', me.getData('numsMsg') + ' ' + fileNumber);
                    return;
                }
                var form = Ext.create('Ext.form.Panel', {
                    autoRender: true,
                    autoShow: true,
                    items: [{
                        xtype: 'filefield',
                        vtype: 'image',
                        listeners: {
                            change: function (filefield, value) {
                                var form = filefield.up('form');
                                var files = filefield.getEl().query('input')[1].files;
                                var len = files.length;
                                if (len > (fileNumber - existImg)) {
                                    App.Msg.info('', me.getData('numsMsg') + ' ' + fileNumber);
                                    return;
                                }
                                if (len > 0) {
                                    for (var i = len - 1; i >= 0; i--) {
                                        if (files[i].size > fileSize) {
                                            App.Msg.info('', me.getData('imageMaxSize') + '3MB');
                                            return;
                                        }
                                    }
                                }
                                var box = me.waitBox();
                                form.getForm().submit({
                                    url: basePath + '/tour/uploadImage',
                                    params: {text: mark},
                                    success: function (fp, o) {
                                        var result = o.result;
                                        var image = result.image;
                                        var len = image.length;
                                        if (result.result === 'ok' && len > 0) {
                                            var objs = [];
                                            var largeImage;
                                            for (var j = 0; j < len; j++) {
                                                largeImage = image[j];
                                                largeImage = largeImage.substring(0, largeImage.lastIndexOf("/") + 1) +
                                                    "large_" + largeImage.substring(largeImage.lastIndexOf("/") + 1);
                                                console.log(largeImage);
                                                var obj = {
                                                    xtype: 'container',
                                                    layout: 'hbox',
                                                    items: [
                                                        {
                                                            xtype: 'image',
                                                            alt: '0',
                                                            title: image[j],
                                                            width: 180,
                                                            height: 180,
                                                            src: largeImage
                                                        }, {
                                                            xtype: 'checkboxfield',
                                                            inputValue: image[j],
                                                            padding: '0 0 0 5',
                                                            width: 15,
                                                            name: 'image'
                                                        }
                                                    ]
                                                };
                                                objs.push(obj);
                                                box.close();
                                            }
                                            winForm.insert(0, objs);
                                        } else {
                                            App.Msg.error('', result.msg);
                                        }
                                    }
                                });
                            }
                        },
                        name: 'image'
                    }]
                });
                var input = form.down('filefield').getEl().query('input')[1];
                input.setAttribute("multiple", "multiple");
                input.click();
            };
        },
        /**
         * 加载图片
         */
        loadImage: function (form) {
            var win = form.up('window');
            if (!win.tourId) {
                return;
            }
            App.Ajax.req({
                url: basePath + "/tour/getImageByTourId",
                params: {id: win.tourId},
                success: function (response) {
                    var result = Ext.JSON.decode(response.responseText);
                    var image = result.image;
                    var len = image.length;
                    if (result.result === 'ok' && len > 0) {
                        var objs = [];
                        var largeImage;
                        for (var j = 0; j < len; j++) {
                            largeImage = image[j].image;
                            largeImage = largeImage.substring(0, largeImage.lastIndexOf("/") + 1) +
                                "large_" + largeImage.substring(largeImage.lastIndexOf("/") + 1);
                            var obj = {
                                xtype: 'container',
                                layout: 'hbox',
                                items: [
                                    {
                                        xtype: 'image',
                                        alt: '0',
                                        title: image[j].image,
                                        width: 180,
                                        height: 180,
                                        src: largeImage
                                    }, {
                                        xtype: 'checkboxfield',
                                        inputValue: image[j].image,
                                        padding: '0 0 0 5',
                                        width: 15,
                                        name: 'image'
                                    }
                                ]
                            };
                            if (image[j].cover === 1) {
                                (obj.items)[1].checked = true;
                            }
                            objs.push(obj);
                        }
                        form.insert(0, objs);
                    }
                }
            });
        },
        /**
         * 删除图片
         * @param btn
         */
        deleteImage: function (btn) {
            var form = btn.up('form');
            var checkbox = form.query('checkboxfield[checked=true]');
            //非空验证
            if (checkbox.length < 1) {
                App.Msg.error('', this.getData('nullNumMsg'));
                return;
            }
            //客户端删除图片
            Ext.MessageBox.confirm("", this.getData("mainMsg_100"), function (btn) {
                if ('yes' == btn) {
                    for (var i = 0; i < checkbox.length; i++) {
                        checkbox[i].up('container').destroy();
                    }
                }
            });
        },
        /**
         * 设置封面图片
         * @param btn
         */
        editImage: function (btn) {
            var form = btn.up('form');
            var checkbox = form.query('checkboxfield[checked=true]');
            //非空验证
            if (checkbox.length < 1) {
                App.Msg.error('', this.getData('nullNumMsg'));
                return;
            }
            //设置封面
            if (checkbox.length > 1) {
                App.Msg.error('', this.getData('oneNumMsg'));
                return;
            }
            //获取原封面
            var coverOld = form.down('image[alt=1]');
            if (coverOld) {
                coverOld.alt = '0';
            }
            checkbox[0].previousSibling().alt = '1';
            App.Msg.info('', this.getData('setMsg'));
        },
        /**
         * 保存图片
         */
        saveImage: function (btn) {
            var win = btn.up('window');
            var me = this;
            if (!me.isExist(win)) {
                return;
            }
            var images = btn.up('form').query('image[alt!=Image]');
            var len = images.length;
            if (len > 0) {
                var urls = [], covers = [];
                for (var i = 0; i < len; i++) {
                    urls.push(images[i].title);
                    covers.push(images[i].alt);
                }
                App.Ajax.req({
                    url: basePath + "/tour/saveImage",
                    method: 'POST',
                    params: {imageData: urls, cover: covers, id: win.tourId},
                    success: function (response) {
                        var result = Ext.JSON.decode(response.responseText);
                        if (result.result === 'ok') {
                            App.Msg.info('', result.msg);
                        } else {
                            App.Msg.error('', result.msg);
                        }
                    }
                });
            } else {
                App.Msg.info('', me.getData('uploadImageMsg'));
            }
        },
        /**
         * 编辑时加载表单数据
         * @param form
         */
        loadForm: function (form) {
            var me = this;
            var win = form.up('window');
            if (!win.getStateId()) {
                var buttons = form.query('button[handler=addContainer]');
                for (var i = 0, len = buttons.length; i < len; i++) {
                    this.addContainer(buttons[i]);
                }
            }
            if (!win.tourId) {
                return;
            }
            var tourId = win.tourId;
            var store = win.getViewModel().getStore('tourStore');
            Ext.apply(store.proxy.extraParams, {"id": tourId});
            //表单加载数据
            store.load(function (records) {
                form.getForm().loadRecord(records[0]);
                form.tourCode = records[0].data.code;
                //设置文本框
                var includeEn = records[0].data.includeEn.split('(;)');
                var includeFr = records[0].data.includeFr.split('(;)');
                me.setText(includeEn, includeFr, form, 'include');

                var excludeEn = records[0].data.excludeEn.split('(;)');
                var excludeFr = records[0].data.excludeFr.split('(;)');
                me.setText(excludeEn, excludeFr, form, 'exclude');

                var descEn = records[0].data.descEn.split('(;)');
                var descFr = records[0].data.descFr.split('(;)');
                me.setText(descEn, descFr, form, 'desc');

                var triphintEn = records[0].data.triphintEn.split('(;)');
                var triphintFr = records[0].data.triphintFr.split('(;)');
                me.setText(triphintEn, triphintFr, form, 'triphint');

                var importantEn = records[0].data.importantEn.split('(;)');
                var importantFr = records[0].data.importantFr.split('(;)');
                me.setText(importantEn, importantFr, form, 'important');

                var termEn = records[0].data.termEn.split('(;)');
                var termFr = records[0].data.termFr.split('(;)');
                me.setText(termEn, termFr, form, 'term');
            });
        },
        /**
         * 加载路线详情
         * @param grid
         */
        loadDetail: function (grid) {
            var win = grid.up('window');
            var tourId = win.tourId;
            if (!tourId) {
                return;
            }
            var store = grid.getStore();
            Ext.apply(store.proxy.extraParams, {"id": tourId});
            store.load();
        },
        /**
         * 加载路线出团信息
         * @param grid
         */
        loadTourDate: function (grid) {
            var win = grid.up('window');
            var tourId = win.tourId;
            if (!tourId) {
                return;
            }
            var store = grid.getStore();
            Ext.apply(store.proxy.extraParams, {"id": tourId});
            store.load();
        },
        /**
         * 新增线路出团信息
         * @param btn
         */
        addTourDate: function (btn) {
            var wins = btn.up('window');
            if (!this.isExist(wins)) {
                return;
            }
            var win = this.createWin('tourdateinfowin', {title: this.getData('addTourDate')}, this).show();
            win.tourId = wins.tourId;
            win.grid = btn.up('grid');
        }, /**
         * 删除
         * @param btn
         */
        deleteTourDate: function (btn) {
            var grid = btn.up('tourdategrid');
            // 获取选中的列
            var record = grid.getSelectionModel().getSelection();
            // 判断选中的行数是否大于0
            if (this.selectVali(record)) {
                Ext.MessageBox.confirm("", this.getData("mainMsg_100"), function (btn) {
                    if ('yes' == btn) {
                        var ids = [];
                        for (var i = 0; i < record.length; i++) {
                            ids.push(record[i].data.id);
                        }
                        grid.setLoading(true);
                        App.Ajax.req({
                            url: basePath + "/tourdate/delete",
                            method: 'POST',
                            params: {id: ids},
                            success: function (response, options) {
                                grid.setLoading(false);
                                grid.getStore().reload();
                            }
                        });
                    }
                });
            }
        },
        /**
         * 修改线路出团信息
         * @param btn
         */
        editTourDate: function (e, context) {
            var records = context.record;
            var inventory = records.get('inventory');
            var warn = records.get('warn');
            if (parseInt(warn) > parseInt(inventory)) {
                App.Msg.error('', this.getData('w_iMsg'));
                e.grid.getStore().reload();
                return;
            }
            var date = records.get('time');
            var time = Ext.Date.format(new Date(date), 'Y-m-d');
            App.Ajax.req({
                url: basePath + "/tourdate/update",
                method: 'POST',
                params: {
                    id: records.get('id'),
                    time: time,
                    price: records.get('price'),
                    inventory: inventory,
                    warn: warn
                },
                success: function (response, options) {
                    var result = Ext.JSON.decode(response.responseText);
                    if (result.result === 'ok') {
                        App.Msg.info('', result.msg);
                        e.grid.getStore().reload();
                    } else {
                        App.Msg.error('', result.msg);
                    }
                }
            })
        },
        /**
         * 根据条件搜索出团信息
         * @param btn
         */
        search: function (btn) {
            var form = btn.up('form');
            var values = form.getForm().getValues();
            //验证参数
            if (values.inventoryTo != '' && parseInt(values.inventoryFrom) > parseInt(values.inventoryTo)) {
                App.Msg.error('', this.getData('inventoryMsg'));
                return;
            }
            if (values.remainTo != '' && parseInt(values.remainFrom) > parseInt(values.remainTo)) {
                App.Msg.error('', this.getData('remainMsg'));
                return;
            }
            if (values.salesTo != '' && parseInt(values.salesFrom) > parseInt(values.salesTo)) {
                App.Msg.error('', this.getData('saleMsg'));
                return;
            }
            this.query(btn);
        },
        /**
         * 新增线路详情
         * @param btn
         */
        addDetail: function (btn) {
            var win = btn.up('window');
            if (!this.isExist(win)) {
                return;
            }
            var detailWin = this.createWin('tourdetailwin', {title: this.getData('addTourDetail')}, this).show();
            detailWin.tourId = win.tourId;
            detailWin.grid = btn.up('grid');
        },
        /**
         * 修改线路详情
         * @param btn
         */
        editDetail: function (btn) {
            var wins = btn.up('window');
            if (!this.isExist(wins)) {
                return;
            }
            var grid = btn.up('grid');
            // 获取选中的列
            var record = grid.getSelectionModel().getSelection();
            // 是否选择验证
            if (this.oneSelectVali(record)) {
                var win = this.createWin('tourdetailwin', {
                    title: this.getData('editTourDetail'),
                    stateId: 'edit'
                }, this).show();
                win.down('form').loadRecord(record[0]);
                win.grid = grid;
                win.tourId = wins.tourId;
            }
        },
        /**
         * 删除线路详情
         * @param btn
         */
        deleteDetail: function (btn) {
            var grid = btn.up('tourdetailgrid');
            // 获取选中的列
            var record = grid.getSelectionModel().getSelection();
            // 判断选中的行数是否大于0
            if (this.selectVali(record)) {
                Ext.MessageBox.confirm("", this.getData("mainMsg_100"), function (btn) {
                    if ('yes' == btn) {
                        var ids = [];
                        for (var i = 0; i < record.length; i++) {
                            ids.push(record[i].data.id);
                        }
                        grid.setLoading(true);
                        App.Ajax.req({
                            url: basePath + "/tour/deleteDetail",
                            params: {id: ids},
                            success: function () {
                                grid.setLoading(false);
                                grid.getStore().reload();
                            }
                        });
                    }
                });
            }
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
         * 设置文本框内容
         * @param textEn
         * @param textFr
         * @param tourEditWindow
         * @param itemId
         */
        setText: function (textEn, textFr, form, itemId) {
            var ens = [], frs = [];
            for (var j = 0, len = textEn.length; j < len; j++) {
                if (textEn[j] != '') {
                    ens.push(textEn[j]);
                    frs.push(textFr[j]);
                }
            }
            textEn = ens;
            textFr = frs;
            var fieldSet = form.down('fieldset[itemId=' + itemId + ']');
            var fieldContainer = function () {
                return {
                    xtype: 'fieldcontainer',
                    combineErrors: false,
                    defaultType: 'textfield',
                    defaults: {
                        labelWidth: 80,
                        labelAlign: 'right'
                    },
                    items: [
                        {
                            fieldLabel: arguments[0],
                            width: 500,
                            flag: arguments[1],
                            value: arguments[2]
                        },
                        {
                            xtype: 'checkbox',
                            margin: '0 25',
                            hidden: arguments[3]
                        }
                    ]
                }
            };
            for (var i = 0; i < textEn.length; i++) {
                fieldSet.add(fieldContainer(i + 1 + ':' + this.getData('english'), 'en', textEn[i], false));
                fieldSet.add(fieldContainer(this.getData('france'), 'fr', textFr[i], true));
            }
        }
    }
);