/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: zhuhoufeng
 * date: 2016-01-10
 */
/**
 * 角色管理树Store
 */
Ext.define('app.store.rolemanage.RoleTreeStore', {
    extend: 'Ext.data.TreeStore',
    alias: 'store.treestore',
    autoLoad: false,
    storeId:'treeStore',
    proxy : {
        type : 'ajax',
        actionMethods:{
            create: "POST", read: "POST", update: "POST", destroy: "POST"
        },
        url : basePath + '/rolemanage/tree',
        reader:{
            type:'json'
        }
    }
    ,
    root : {
        text : 'root',
        expanded:true,
        id:'',
        checked: false
    }
});