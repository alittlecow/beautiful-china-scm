/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 * @author: chengxuemin
 * date: 2015-12-22
 */

/**
 * 分类管理查询页面
 */
Ext.define('app.view.category.CategoryManagePanel', {
    extend: 'Ext.container.Container',
    xtype: 'categoryManage',
    controller: 'category',
    viewModel: {
        type: 'category'
    },
    requires: [
        'app.view.category.CategoryQueryForm',
        'app.view.category.CategoryGrid',
        'app.view.category.CategoryInfoWin',


        'app.view.category.CategoryController',
        'app.view.category.CategoryWinController',

        'app.view.category.CategoryViewModel'
    ],

    layout: {
        type: 'vbox',
        align: 'stretch'
    },
    items: [{
        xtype: 'categoryqueryform'
    },{
        xtype: 'categorygrid',
        flex: 1
    }]
});