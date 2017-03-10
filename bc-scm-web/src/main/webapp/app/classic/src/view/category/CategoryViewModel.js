/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 * @author: chengxuemin
 * date: 2015-12-22
 */

/**
 * 分类管理页面数据模型
 */
Ext.define('app.view.category.CategoryViewModel', {
    extend: 'app.view.base.BaseViewModel',
    alias: 'viewmodel.category',

    requires: [
        'app.store.category.CategoryGridStore'
    ],

    stores: {
        categoryGridStore:{
            type:'categorygridstore'
        }
    }
});