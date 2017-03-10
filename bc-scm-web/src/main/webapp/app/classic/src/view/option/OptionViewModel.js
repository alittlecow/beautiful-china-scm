/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 选项页面数据模型
 * @author: liufei
 * date: 2015-12-22
 */
Ext.define('app.view.option.OptionViewModel', {
    extend: 'app.view.base.BaseViewModel',
    alias: 'viewmodel.option',
    requires: [
        'app.store.option.OptionNameGridStore',
        'app.store.option.OptionValueGridStore'
    ],
    stores: {
        optionNameGridStore:{
            type:'optionnamegridstore'
        },
        optionValueGridStore:{
            type:'optionvaluegridstore'
        }
    }
});