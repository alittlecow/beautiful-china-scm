/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 * @author: dongjingjun
 * date: 2016-04-07
 */
/**
 * 多语言按钮
 */
Ext.define('app.view.language.Language', {
    extend: 'app.view.base.BaseBtn',
    xtype: 'language',
    controller: 'language',
    style: {
        background: 'white',
        fontcolor: 'black'
    }, border: false,
    listeners: {
        render: 'render',
        click: 'click'
    }
});