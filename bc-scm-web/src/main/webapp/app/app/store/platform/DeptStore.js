/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 部门下拉框Store
 * @author: fengbaitong
 * date: 2015-12-16
 *
 */
Ext.define('app.store.platform.DeptStore', {
    extend: 'Ext.data.Store',
    alias: 'store.deptstore',
    autoLoad: true,
    fields: [
        'deptCode',
        'deptName'
    ],
    proxy : {
        type : 'ajax',
        url : basePath + '/deptinfo/getAllDeptCodeAndDeptName',
        reader:{
            type:'json',
            rootProperty:'data'
        }
    }
});