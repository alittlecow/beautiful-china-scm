/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: dongjingjun
 * date: 2015-12-21
 * 部门信息管理数据模型
 */

Ext.define('app.view.dimanage.DIMViewModel', {
    extend: 'app.view.base.BaseViewModel',
    alias: 'viewmodel.dim',

    requires: [
        'app.store.dimanage.DIMStore',
        'app.store.dimanage.DIMFormStore'
    ],

    stores: {
        dimStore: {
            type: 'dimstore'
        },
        dimFormStore: {
            type: 'dimformstore'
        }
    }
});
