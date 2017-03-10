/**
 * Copyright @ 2016 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 选择线路窗口
 * @author: zhangyu
 * date: 2016-1-23
 */

Ext.define('app.view.display.DisplayTourDateWin', {
    extend: 'app.view.base.BaseWindow',
    xtype: 'displaytourdatewin',
    controller:'displaytourdatewin',
    viewModel: {
        type: 'display'
    },
    width: 850,
    height: 450,
    layout: {
        type:'vbox',
        align:'stretch'
    },
    items:[
        {
            xtype:'displaytourdatequeryform',
            padding:'0 0 5 0'
        },
        {
            xtype:'displaytourdategrid',
            flex:1
        }

    ]


});