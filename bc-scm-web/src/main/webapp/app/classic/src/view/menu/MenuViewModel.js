/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 菜单页面数据模型
 * @author: chenghuanhuan
 * date: 2015-11-16
 */
Ext.define('app.view.menu.MenuViewModel', {
    extend: 'app.view.base.BaseViewModel',
    alias: 'viewmodel.menu',

    requires: [
        'app.store.menu.ModuleStore',
        'app.store.menu.MenuGridStore',
        'app.store.menu.PlateStore'
    ],

    stores: {
        plateStore: {
            type: 'platestore'
        },

        moduleStore: {
            type: 'modulestore'
        },
        menuGridStore:{
            type:'menugridstore'
        }
    }
});
