/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 平台用户页面数据模型
 * @author: fengbaitong
 * date: 2015-12-12
 */
Ext.define('app.view.platform.PlatformViewModel', {
    extend: 'app.view.base.BaseViewModel',
    alias: 'viewmodel.platform',
    requires: [
       'app.store.platform.PlatformGridStore',
        'app.store.platform.RoleStore',
        'app.store.platform.DeptStore'
    ],

    stores: {

        platformGridStore:{
            type:'platformgridstore'
        },
        roleStore:{
            type:'rolestore'
        },
        deptStore:{
            type:'deptstore'
        }
    }
});
