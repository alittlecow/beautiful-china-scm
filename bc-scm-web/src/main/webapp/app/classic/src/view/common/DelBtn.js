/**
 * Copyright @ 2015 南京网华信息科技有限公司.
 * All right reserved.
 * 删除按钮
 * @author: chenghuanhuan
 * date: 15/12/17
 */
Ext.define('app.view.common.DelBtn', {
    extend: 'app.view.base.BaseBtn',
    xtype:'delbtn',
    iconCls:"x-fa fa-remove",
    bind:{
        text:'{delete}'
    }
});