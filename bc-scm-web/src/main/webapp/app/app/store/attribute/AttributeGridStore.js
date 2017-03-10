/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 * @author: fengbaitong
 * date: 2015-12-22
 */
/**
 *
 * 属性管理表格的store
 */
Ext.define('app.store.attribute.AttributeGridStore', {
    extend: 'Ext.data.Store',
    alias: 'store.attributegridstore',
    autoLoad: false,
    fields:[
          'id',
          'attributeId',
          'attributeValueId',
          'categoryNameEn',
          'attributeNameEn',
          'attributeNameFr',
          'attributeValueEn',
          'attributeValueFr',
          'sort'
    ],
    proxy : {
        type : 'ajax',
        url : basePath + '/attribute/list?'+Math.random(),
        reader:{
            type:'json',
            method:'POST',
            rootProperty:'data',
            totalProperty:'total'
        }
    }
});