/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: chengxuemin
 * date: 2015-12-11
 */

/**
 * 邮件历史记录表格
 */
Ext.define('app.view.mailhistory.MailHistoryGrid',{
    extend: 'app.view.base.BaseGrid',
    xtype:'mailhistorygrid',
    storeName:'mailhistoryGridStore',
    viewModel: {
        type: 'mailhistory'
    },
    selModel: {
        selType: 'checkboxmodel'
    },
    tbar : [ {
        xtype:'checkbtn',
        handler: 'check'
    }],
    columns: [
        {
            dataIndex: 'title', flex: 2, bind: {
            text: '{title}'
        }
        },
        {
            dataIndex: 'operateTime', flex: 2.5, bind: {
            text: '{operateTime}'
        }
        },
        {
            dataIndex: 'email', flex: 2, bind: {
            text: '{email}'
        }
        },
        {
            dataIndex: 'type', flex: 2, bind: {
            text: '{type}'
        }
        },
        {
            dataIndex: 'orderNo', flex: 2, bind: {
            text: '{orderNo}'
        }
        },
        {
            dataIndex: 'content', bind: {
            text: '{content}', hidden: true
        }
        }
    ]
});

