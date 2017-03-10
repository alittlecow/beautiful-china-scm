/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 邮件模板表格
 * @author: fengbaitong
 * date: 2015-11-25
 */
Ext.define('app.view.mailtemplate.MailTemplateGrid', {
    extend: 'app.view.base.BaseGrid',
    xtype:'mailtemplategrid',
    storeName:'mailTemplateGridStore',
    id:'mailtemplategrid',

    /**
     * 增加，修改按钮
     */
    tbar : [ {
        xtype:'addbtn',
        handler: 'add'
    },{
        xtype:'editbtn',
        handler: 'edit'
    }],
    columns: [
        {dataIndex: 'name',flex: 2,bind:{text:'{templateName}'}},

        {dataIndex: 'title', flex: 2,bind:{text:'{mailTitle}'}}
    ]

});