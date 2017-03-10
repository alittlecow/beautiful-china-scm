/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 目的地页面数据模型
 * @author: dongjingjun
 * date: 2016-01-07
 */

Ext.define('app.view.destination.DesViewModel', {
    extend: 'app.view.base.BaseViewModel',
    alias: 'viewmodel.des',

    requires: [
        'app.store.destination.DesGridStore'
    ],

    stores: {
        desGridStore: {
            type: 'desgridstore'
        }
    }
});