/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 * @author: dongjingjun
 * date: 2016-03-06
 */
Ext.define('app.view.display.ImageListWin', {
    extend: 'app.view.base.BaseWindow',
    xtype: 'imagelistwin',
    controller: 'imagelistwin',
    viewModel: {
        type: 'display'
    },
    width: 680,
    height: 450,
    buttons: [{
        xtype: 'savebtn',
        handler: 'saveTourImage'
    }],
    items: [{
        xtype: 'form',
        scrollable: true,
        layout: 'column',
        padding: '5 5 5 5',
        items: [{
            columnWidth: 1,
            layout: 'column',
            xtype: 'container',
            itemId: 'imagesBox',
            defaultType: 'image',
            defaults: {
                width: 180,
                height: 120,
                padding: '2 2 5 2'
            }
        }]
    }]
});