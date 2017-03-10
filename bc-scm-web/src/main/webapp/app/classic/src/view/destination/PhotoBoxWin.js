/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 预览窗口
 * @author: dongjingjun
 * date: 2016-01-10
 */

Ext.define('app.view.destination.PhotoBoxWin', {
    extend: 'app.view.base.BaseWindow',
    xtype: 'boxwin',
    viewModel: {
        type: 'des'
    },
    width: 800,
    height: 430,
    items: [
        {
            xtype: 'box',
            autoEl: {
                tag: 'img',
                type: 'image',
                src: Ext.BLANK_IMAGE_URL,
                style: 'filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale);',
                complete: 'off'
            }
        }
    ]
});