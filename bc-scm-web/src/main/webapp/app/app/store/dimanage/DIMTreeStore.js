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

Ext.define('app.store.dimanage.DIMTreeStore', {
    extend: 'Ext.data.TreeStore',
    alias: 'store.dimtreestore',
    autoLoad: false,
    storeId: 'dimTreeStore',
    proxy: {
        type: 'ajax',
        actionMethods: {
            read: "POST"
        },
        url: basePath + '/deptinfo/getLevelTree',
        reader: {
            type: 'json'
        }
    }
    , root: {
        text: 'root',
        expanded: true
    }
});