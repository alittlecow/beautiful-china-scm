/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: dongjingjun
 * date: 2015-12-21
 * 角色页面数据模型
 */
Ext.define('app.view.rolemanage.RoleViewModel', {
    extend: 'app.view.base.BaseViewModel',
    alias: 'viewmodel.role',
    stores: {
        roleGridStore:{
            type:'rolegridstore'
        }
        ,
        treeStore:{
            type:'treestore'
        },
        roleStore:{
            type:'rolestore'
        }
    }
});
