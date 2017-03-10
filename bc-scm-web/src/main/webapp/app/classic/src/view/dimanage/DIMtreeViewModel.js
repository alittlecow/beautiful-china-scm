/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 * @author: dongjingjun
 * date: 2015-12-31
 */

Ext.define('app.view.dimanage.DIMTreeViewModel', {
    extend: 'app.view.base.BaseViewModel',
    alias: 'viewmodel.dimtree',

    requires: [
        'app.store.dimanage.DIMTreeStore'
    ],

    stores: {
        treeStore: {
            type: 'dimtreestore'
        }
    }
});