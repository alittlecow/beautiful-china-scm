/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 * @author: dongjingjun
 * date: 2015-12-31
 */

Ext.define('app.view.rolemanage.RoleTreeViewModel', {
    extend: 'app.view.base.BaseViewModel',
    alias: 'viewmodel.roletree',
    requires: [
        'app.store.rolemanage.RoleTreeStore'
    ],
    stores: {
        treeStore: {
            type: 'treestore'
        }
    }
});