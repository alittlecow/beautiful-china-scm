/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 * @author: dongjingjun
 * date: 2016-03-02
 */
Ext.define('app.view.display.CommonController', {
    extend: 'app.view.base.BaseController',
    init: function (view) {
        var viewmodel = view.getViewModel();
        this.getInternationalPro({config: 'DisplayConfig'}, viewmodel);
    },
    /**
     * 处理单行显示双条数据
     * @param e
     * @param r
     */
    transformData: function (e, r) {
        var data = [];
        if (e.type === 'displaybannerstore') {
            e.removeAll();
            var images = [];
            for (var i = 0, len = r.length; i < len; i++) {
                images.push(r[i].data.image.split('-'));
            }
            for (var j = 0; j < images.length; j++) {
                data.push({
                    'ids': r[j].data.ids,
                    'itemIds': r[j].data.itemIds,
                    'image1': images[j][0],
                    'image2': images[j][1],
                    'sort1': 1 + j * 2,
                    'sort2': 2 + j * 2
                });
            }
            e.add(data);
        }
    },
    overShadow: function (e, r, item) {
        item.style.backgroundColor = '#FFFFFF';
    },
    /**
     * 获取信息
     * @param comm
     */
    selectItemInfo: function (comm) {
        var me = this;
        var grid = comm.up('grid');
        var extraData = {
            id: '',
            itemId: '',
            image: '',
            sort: '',
            type: '',
            flag: false,
            scope: me,
            component: {comm: comm, win: null}
        };
        var xtype = grid.xtype;
        switch (xtype) {
            case 'displaybannergrid':
                extraData.type = 'banner';
                me.selectLocalImage(extraData);
                break;
            case 'displaytourgrid':
                extraData.type = 'popular';
                me.getExtraData(extraData);
                me.createTourWindow(extraData);
                break;
            case 'displaythemegrid':
                extraData.type = 'theme';
                me.getExtraData(extraData);
                me.createThemeWindow(extraData);
                break;
            //
            case 'displaycitygrid':
                extraData.type = 'city';
                me.getExtraData(extraData);
                me.createCityWindow(extraData);
                break;
            case 'displaytripgrid':
                extraData.type = 'firstTrip';
                me.getExtraData(extraData);
                me.createTourWindow(extraData);
                break;
            default:
                console.log('error');
        }
    },
    /**
     * 选择本地图片
     * @param extraData
     */
    selectLocalImage: function (extraData) {
        var me = this;
        var form = Ext.create('Ext.form.Panel', {
            autoRender: true,
            autoShow: true,
            items: [{
                xtype: 'filefield',
                vtype: 'image',
                extraData: extraData,
                listeners: {
                    change: me.uploadImage
                },
                name: 'image'
            }]
        });
        form.down('filefield').getEl().query('input')[1].click();
    },
    /**
     * 上传图片
     * @param filefield
     */
    uploadImage: function (filefield) {
        var form = filefield.up('form');
        //限制图片大小
        var fileSize = 1024 * 1024 * 3;
        var file = filefield.getEl().query('input')[1].files[0];
        var extraData = filefield.extraData;
        var me = extraData.scope;
        if (file && file.size > fileSize) {
            App.Msg.info('', me.getData('fileLimit') + ' 3 MB');
            return;
        }
        form.getForm().submit({
            url: basePath + '/display/saveimage',
            success: function (fp, o) {
                var result = o.result;
                if (result.result === 'ok') {
                    extraData.image = result.image;
                    me.setResult(extraData);
                }
            }
        });
    },
    /**
     * 处理返回结果
     * @param extraData
     */
    setResult: function (extraData) {
        var me = this;
        switch (extraData.type) {
            case 'banner':
                me.getExtraData(extraData);
                me.saveItemData(extraData);
                break;
            case 'theme':
                var imagesBox = extraData.component.win.down('container[itemId=imagesBox]');
                var obj = {
                    alt: 'error',
                    src: extraData.image
                };
                imagesBox.removeAll();
                imagesBox.add(obj);
                break;
            //
            case 'city':
                var imagesBoxCity = extraData.component.win.down('container[itemId=imagesBox]');
                var objCity = {
                    alt: 'error',
                    src: extraData.image
                };
                imagesBoxCity.removeAll();
                imagesBoxCity.add(objCity);
                break;
            default:
                console.log('error');
        }
    },
    /**
     * 获取保存数据
     * @param extraData
     */
    getExtraData: function (extraData) {
        var comm = extraData.component.comm;
        var sort = comm.tabIndex;
        var store = comm.up('grid').getStore();
        var rowData = (store.getRange())[Math.floor((sort - 1) / 2)].data;
        extraData.sort = sort;
        if (extraData.type === 'banner') {
            extraData.id = (rowData.ids.split('-'))[(sort + 1) % 2];
            extraData.itemId = (rowData.itemIds.split('-'))[(sort + 1) % 2];
        } else {
            extraData.id = (store.getRange())[sort - 1].data.ids;
            extraData.itemId = (store.getRange())[sort - 1].data.itemId;
        }
    },
    /**
     * 保存数据
     * @param extraData
     */
    saveItemData: function (extraData) {
        var store = extraData.component.comm.up('grid').getStore();
        var paraExtraData = {
            id: extraData.id,
            itemId: extraData.itemId,
            image: extraData.image,
            sort: extraData.sort,
            type: extraData.type
        };
        var me=this;
        App.Ajax.req({
            params: paraExtraData,
            async: false,
            url: basePath + '/display/saveItemData',
            success: function (response, opts) {
                var result = Ext.JSON.decode(response.responseText);
                if (result.result === 'ok') {
                    if (result.flag) {
                        App.Msg.info('', result.msg);
                        extraData.flag = true;
                        store.load();
                    } else {
                        App.Msg.info('', me.getData('existItem_msg'));
                    }
                } else {
                    App.Msg.error('', result.msg);
                }
            }
        });
        return extraData;
    },
    /**
     * 创建路线信息选择窗口
     * @param extraData
     */
    createTourWindow: function (extraData) {
        var tourWindow = Ext.create('widget.displaytourdatewin', {title: this.getData('addTourInfo_msg')}).show();
        extraData.component.win = tourWindow;
        tourWindow.itemId = extraData;
    },
    /**
     * 创建主题信息选择窗口
     * @param extraData
     */
    createThemeWindow: function (extraData) {
        var themeWindow = Ext.create('widget.displaythemewin', {title: this.getData('addThemeInfo_msg')}).show();
        extraData.component.win = themeWindow;
        var fileField = themeWindow.down('filefield[name=image]');
        fileField.extraData = extraData;
    },
    /**
     * 创建城市信息选择窗口
     * @param extraData
     */
    createCityWindow: function (extraData) {
        var cityWindow = Ext.create('widget.displaycitywin', {title: this.getData('addCityInfo_msg')}).show();
        extraData.component.win = cityWindow;
        var fileField = cityWindow.down('filefield[name=image]');
        fileField.extraData = extraData;
    },

    /**
     * 点击表格行获取远程图片
     * @param e
     * @param r
     */
    selectRemoteImage: function (e, r) {
        var id = {id: r.data.id};
        var me = this;
        var extraData = e.up('window').getItemId();
        var url = '/display/getTourImages';
        var images = me.getImageUrl(id, url);
        extraData.itemId = r.data.id;
        me.createRemoteImageWindow(images, extraData);
    },
    /**
     * 获取图片地址
     * @param para
     * @param url
     * @returns {*}
     */
    getImageUrl: function (para, url) {
        var result;
        App.Ajax.req({
            params: para,
            async: false,
            url: basePath + url,
            success: function (response) {
                result = Ext.JSON.decode(response.responseText);
            }
        });
        return result;
    },
    /**
     * 创建图片显示窗口
     * @param images
     */
    createRemoteImageWindow: function (images, extraData) {
        var imageListWin = Ext.create('widget.imagelistwin', {title: this.getData('selectImage_msg')}).show();
        imageListWin.itemId = extraData;
        var imagesBox = imageListWin.down('container[itemId=imagesBox]');
        if (images) {
            for (var i = 0, len = images.length; i < len; i++) {
                var obj = {
                    alt: 'error',
                    src: images[i]
                };
                imagesBox.add(obj);
                var checkbox = {
                    xtype: 'radiofield',
                    inputValue: images[i],
                    width: 25,
                    name: 'imageUrl'
                };
                imagesBox.add(checkbox);
            }
        }
    },
    /**
     * 图片显示窗口保存按钮
     * @param btn
     */
    saveTourImage: function (btn) {
        var win = btn.up('window');
        var form = win.down('form');
        var extraData = win.getItemId();
        var image = form.getForm().getValues().imageUrl;
        if (!image) {
            App.Msg.info('', this.getData('selectImageInfo_msg'));
            return;
        }
        extraData.image = image;
        var tourWin = extraData.component.win;
        this.saveItemData(extraData);
        if (extraData.flag) {
            win.close();
            tourWin.close();
        }
    },
    /**
     * 主题窗口保存按钮
     * @param btn
     */
    saveThemeImage: function (btn) {
        var win = btn.up('window');
        var form = win.down('form');
        if (false == form.getForm().isValid()) {
            return;
        }
        if (!form.down('image')) {
            App.Msg.info('', this.getData('addImage_msg'));
            return;
        }
        var extraData = win.down('filefield').extraData;
        extraData.itemId = form.down('combo').getValue();
        this.saveItemData(extraData);
        if (extraData.flag) {
            win.close();
        }
    },
    /**
     * 城市窗口保存按钮
     * @param btn
     */
    saveCityImage: function (btn) {
        var win = btn.up('window');
        var form = win.down('form');
        if (false == form.getForm().isValid()) {
            return;
        }
        if (!form.down('image')) {
            App.Msg.info('', this.getData('addImage_msg'));
            return;
        }
        var extraData = win.down('filefield').extraData;
        extraData.itemId = form.down('combo').getValue();
        this.saveItemData(extraData);
        if (extraData.flag) {
            win.close();
        }
    },
    /**
     * 处理未使用的图片
     */
    removeUnusedImages: function () {
        App.Ajax.req({
            url: basePath + '/display/removeUnusedImages'
        });
    }
});