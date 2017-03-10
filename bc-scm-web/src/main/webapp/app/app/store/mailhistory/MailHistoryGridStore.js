/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: chengxuemin
 * date: 2015-12-09
 */

/**
 * 邮件历史记录表格数据存储
 */
Ext.define('app.store.mailhistory.MailHistoryGridStore', {
  extend: 'Ext.data.Store',
  alias: 'store.mailhistorygridstore',
  autoLoad: false,
  model:'app.model.mailhistory.MailHistoryModel',
  storeId:'mailhistoryGridStore',
  proxy : {
    type : 'ajax',
    url : basePath + '/mailhistory/query',
    method:'POST',
    reader:{
      type:'json',
      rootProperty:'data',
      totalProperty:'total'
    }
  }
});
