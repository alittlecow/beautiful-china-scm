/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: chengxuemin
 * date: 2015-12-11
 */

/**
 * 网站用户管理表格数据存储
 */
Ext.define('app.store.websiteuser.WebsiteUserGridStore', {
    extend: 'Ext.data.Store',
    alias: 'store.websiteusergridstore',
    autoLoad: false,
    model:'app.model.websiteuser.WebsiteUserModel',
    storeId:'websiteuserGridStore',
    proxy : {
        type : 'ajax',
        url : basePath + '/websiteuser/query',
        reader:{
            type:'json',
            rootProperty:'data',
            totalProperty:'total'
        }
    }
});
