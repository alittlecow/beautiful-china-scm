/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 系统配置页面数据模型
 * @author: liufei
 * date: 2015-12-10
 */
Ext.define('app.view.syscfg.SysCfgViewModel', {
    extend: 'app.view.base.BaseViewModel',
    alias: 'viewmodel.syscfg',
    requires: [
        'app.store.syscfg.SysCfgGridStore'
    ],
    stores: {
        syscfgGridStore: {
            type: 'syscfggridstore'
        }
    }
});