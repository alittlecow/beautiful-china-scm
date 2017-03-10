/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 菜单表格数据模型
 * @author: chenghuanhuan
 * date: 2015-11-16
 */
Ext.define('app.model.common.InternationalModel', {
    extend: 'Ext.data.Model',
    idProperty: 'displayName',
    fields: [
        {
            type: 'string',
            name: 'displayName'
        },
        {
            type: 'string',
            name: 'displayValue'
        }
    ]
});
