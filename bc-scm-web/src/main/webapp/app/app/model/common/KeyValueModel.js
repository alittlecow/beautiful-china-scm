/**
 * Copyright @ 2015 南京网华信息科技有限公司.
 * All right reserved.
 * @author: chenghuanhuan
 * date: 15/12/24
 */
Ext.define('app.model.common.KeyValueModel', {
    extend: 'Ext.data.Model',
    idProperty: 'name',
    fields: [
       'name','value'
    ]
});