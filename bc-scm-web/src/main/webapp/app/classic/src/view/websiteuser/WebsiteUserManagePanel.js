/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: chengxuemin
 * date: 2015-12-11
 */

/**
 * 网站用户管理管理主页面
 */
Ext.define('app.view.websiteuser.WebsiteUserManagePanel',{
    extend: 'Ext.container.Container',
    xtype: 'WebsiteUserManagement',
    controller: 'websiteuser',
    viewModel: {
        type: 'websiteuser'
    },
    requires: [
        'app.view.websiteuser.WebsiteUserQueryForm',
        'app.view.websiteuser.WebsiteUserGrid',
        'app.view.websiteuser.WebsiteUserInfoWin',

        'app.view.websiteuser.WebsiteUserController',

        'app.view.websiteuser.WebsiteUserViewModel'
    ],


    layout: {
        type: 'vbox',
        align: 'stretch'
    },
    items: [{
        xtype: 'websiteuserqueryform'
    },{
        xtype: 'websiteusergrid',
        flex: 1
    }]
});