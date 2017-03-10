/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 * @author: dongjingjun
 * date: 2015-12-25
 */
/**
 * 旅游线路管理窗口
 */
Ext.define('app.view.tour.ImageFormPanel', {
    extend: 'Ext.form.Panel',
    xtype: 'imageformpanel',
    layout: 'column',
    padding: '5 5 5 5',
    autoScroll: true,
    listeners: {
        render: 'loadImage'
    },
    tbar: [{
        xtype: 'editbtn',
        bind: {text: '{cover}'},
        handler: 'editImage'
    }, {
        xtype: 'delbtn',
        handler: 'deleteImage'
    }, {
        xtype: 'savebtn',
        handler: 'saveImage'
    }, {
        xtype: 'textfield',
        labelWidth: 120,
        labelAlign: 'right',
        bind: {fieldLabel: '{textMark}'},
        itemId: 'mark'
    }],
    defaults: {
        margin: 5
    },
    items: [
        {
            xtype: 'addimage',
            width: 150,
            height: 150,
            listeners: {
                render: 'addImageClick'
            }
        }
    ]
});