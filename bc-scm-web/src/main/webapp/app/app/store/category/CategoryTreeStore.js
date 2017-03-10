/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 * @author: dongjingjun
 * date: 2015-12-22
 */
/**
 *
 * 部门信息管理tree store
 */

Ext.define('app.store.category.CategoryTreeStore', {
    extend: 'Ext.data.TreeStore',
    alias: 'store.categorytreestore',
    autoLoad: false,
    proxy : {
        type : 'ajax',
        actionMethods:{
            create: "POST", read: "POST", update: "POST", destroy: "POST"
        },
        url : basePath + '/category/tree',
        reader:{
            type:'json'
        }
    }
    ,root : {
        text : 'root',
        expanded:true,
        id:''
    }
});