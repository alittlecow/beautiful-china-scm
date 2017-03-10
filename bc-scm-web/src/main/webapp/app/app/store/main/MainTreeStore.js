/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 主页树形菜单数据Store
 * @author: chenghuanhuan
 * date: 2015-11-16
 *
 */
Ext.define('app.store.main.MainTreeStore', {
    extend: 'Ext.data.TreeStore',
    alias: 'store.maintreestore',
    autoLoad: false,
    storeId:'mainTreeStore',
    proxy : {
        type : 'ajax',
        url : basePath + '/main/menus',
        reader:{
            type:'json',
            rootProperty:'treeList'
        }
    }
    ,root : {
        text : '',
        expanded:true,
        id:''
    }
});