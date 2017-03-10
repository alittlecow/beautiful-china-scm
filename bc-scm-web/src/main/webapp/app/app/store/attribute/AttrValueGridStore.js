/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 * @author: fengbaitong
 * date: 2015-12-22
 */
/**
 *
 * 属性值管理表格的store
 */
Ext.define('app.store.attribute.AttrValueGridStore', {
    extend: 'Ext.data.Store',
    alias: 'store.attrvaluegridstore',
    autoLoad: false,
    fields:[
          'attributeValueId',
          'attributeValueEn',
          'attributeValueFr',
          'sort'
    ],
    proxy : {
        type : 'ajax',
        url : basePath + '/attribute/getAttrValueList',
        reader:{
            type:'json',
            method:'POST',
            rootProperty:'data',
            totalProperty:'total'
        }
    }
});