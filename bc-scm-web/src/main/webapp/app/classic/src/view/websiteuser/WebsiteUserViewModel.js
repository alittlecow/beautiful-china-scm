/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: chengxuemin
 * date: 2015-12-11
 */

/**
 * 网站用户管理页面数据模型
 */
Ext.define('app.view.websiteuser.WebsiteUserViewModel', {
    extend: 'app.view.base.BaseViewModel',
    alias: 'viewmodel.websiteuser',

    requires: [
        'app.store.websiteuser.WebsiteUserGridStore'
    ],

    stores: {
        websiteuserGridStore: {
            type: 'websiteusergridstore'
        }
    }
});
