/**
 * Copyright @ 2015 南京网华信息科技有限公司.
 * All right reserved.
 * @author: chenghuanhuan
 * date: 15/12/17
 */
Ext.define('app.view.common.DetailBtn', {
    extend: 'app.view.base.BaseBtn',
    xtype:'detailbtn',
    iconCls:"x-fa fa-edit",
    bind:{
        text:'{detail}'
    }
});