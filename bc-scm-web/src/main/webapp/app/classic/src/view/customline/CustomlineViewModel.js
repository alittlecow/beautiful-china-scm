/**
 * Copyright @ 2016 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 定制线路数据模型
 * @author: zhangyu
 * date: 2016-1-7
 */
Ext.define('app.view.customline.CustomlineViewModel', {
    extend: 'app.view.base.BaseViewModel',
    alias: 'viewmodel.customline',
    requires: [
       'app.store.customline.CustomlineGridStore',
        'app.store.customline.CustomlineDetailGridStore',
        'app.store.customline.CustomlineCityStore'





    ],

    stores: {

        customlineGridStore:{
            type:'customlinegridstore'
        },

        customlineDetailGridStore:{
            type:'customlinedetailgridstore'
        },

        customlineCityStore:{
            type:'customlinecitystore'
        }

    }
});
