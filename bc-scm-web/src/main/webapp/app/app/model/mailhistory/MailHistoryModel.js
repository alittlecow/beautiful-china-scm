/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: chengxuemin
 * date: 2015-12-09
 */

/**
 * 邮件历史记录表格数据模型
 */
Ext.define('app.model.mailhistory.MailHistoryModel', {
    extend: 'Ext.data.Model',
    fields: [
        /**
         * 封装标题代码
         */
        {
            type: 'string',
            name: 'title'
        },
        /**
         * 封装邮件内容代码
         */
        {
            type: 'string',
            name: 'content'
        },
        /**
         * 封装收件人id代码
         */
        {
            type: 'string',
            name: 'userId'
        },
        /**
         * 封装收件人email代码
         */
        {
            type: 'string',
            name: 'email'
        },
        /**
         * 封装邮件类型代码
         */
        {
            type: 'string',
            name: 'type'
        },
        /**
         * 封装关联单号代码
         */
        {
            type: 'string',
            name: 'orderNo'
        },
        /**
         * 封装发送时间代码
         */
        {
            type: 'string',
            name: 'operateTime'
        }
    ]
});
