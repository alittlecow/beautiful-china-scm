/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: dongjingjun
 * date: 2015-12-21
 * 部门管理数据模型
 */
Ext.define('app.view.dlmanage.DLMViewModel', {
    extend: 'app.view.base.BaseViewModel',
    alias: 'viewmodel.dlm',

    requires: [
        'app.store.dlmanage.DLMGridStore',
        'app.store.dlmanage.DLMStore'
    ],
    stores: {
        dLMGridStore: {
            type: 'dlmgridstore'
        },
        dLMStore: {
            type: 'dlmstore'
        }
    }
});