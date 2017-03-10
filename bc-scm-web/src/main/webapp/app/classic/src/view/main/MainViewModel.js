/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 主页数据模型
 * @author: chenghuanhuan
 * date: 2015-11-16
 */
Ext.define('app.view.main.MainViewModel', {
    extend: 'app.view.base.BaseViewModel',
    alias: 'viewmodel.main',

    requires: [
        'app.store.main.MainTreeStore'
    ],

    stores: {
        treeStore: {
            type: 'maintreestore'
        }
    }
});
