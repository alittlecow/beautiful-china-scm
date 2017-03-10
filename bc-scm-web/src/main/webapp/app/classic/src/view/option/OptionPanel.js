/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 选项管理主页面
 * @author: liufei
 * date: 2015-12-22
 */
Ext.define('app.view.option.OptionPanel', {
    extend: 'Ext.container.Container',
    xtype: 'option',
    viewModel:{
        type:'option'
    },
    requires:[
       'app.view.option.OptionNameGrid',
       'app.view.option.OptionValueGrid',

        'app.view.option.OptionNameInfoWindow',
        'app.view.option.OptionValueInfoWindow',
        'app.view.option.OptionViewModel',

        'app.view.option.OptionController',
        'app.view.option.OptionWindowController'
    ],
    layout:{
        type:'hbox',
        align:'stretch'
    },
    items:[{
        xtype:'optionnamegrid',
        flex:1
    },{
        xtype:'optionvaluegrid',
        flex:1
    }]

});