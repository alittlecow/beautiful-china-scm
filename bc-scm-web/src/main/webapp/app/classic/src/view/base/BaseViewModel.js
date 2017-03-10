/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 基础视图模型
 * @author: chenghuanhuan
 * date: 2015-11-16
 */
Ext.define('app.view.base.BaseViewModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.base',

    requires: [
        'app.store.common.CityStore'
    ]//,

   /* data:{
        buttons: {
            search: 'search',// 查询
            reset: 'reset',// 重置
            add: 'add',// 添加
            edit: 'edit',// 修改
            delete: 'delete',// 删除
            save:'save',// 保存
            cancel:'cancel'// 取消
        }
    },*/
    /*stores:{
        cityStore:{
            type: 'citystore'
        }
    }*/
});