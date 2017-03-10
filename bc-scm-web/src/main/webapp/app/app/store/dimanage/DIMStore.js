/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 * @author: dongjingjun
 * date: 2015-12-22
 */
/**
 *
 * 部门信息管理store
 */
Ext.define('app.store.dimanage.DIMStore', {
    extend: 'Ext.data.Store',
    alias: 'store.dimstore',
    autoLoad: false,
    storeId: 'dimStore',
    model: 'app.model.dimanage.DIMModel',
    proxy: {
        type: 'ajax',
        actionMethods: {
            read: "POST"
        },
        url: basePath + '/deptinfo/form',
        reader: {
            type: 'json'
        }
    }
});