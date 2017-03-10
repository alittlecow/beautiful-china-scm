/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: chengxuemin
 * date: 2015-12-11
 */

/**
 * 邮件历史记录页面数据模型
 */
Ext.define('app.view.mailhistory.MailHistoryViewModel', {
  extend: 'Ext.app.ViewModel',
  alias: 'viewmodel.mailhistory',

  requires: [
       'app.store.mailhistory.MailHistoryGridStore'
  ],

  stores: {
       mailhistoryGridStore: {
          type: 'mailhistorygridstore'
       }
  }
});
