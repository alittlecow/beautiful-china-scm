/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 菜单表格数据模型
 * @author: chenghuanhuan
 * date: 2015-11-16
 */
Ext.define('app.model.menu.MenuModel', {
    extend: 'Ext.data.Model',
    fields: [
        {
            type: 'string',
            name: 'moduleName'
        },
        {
            type: 'string',
            name: 'moduleFrName'
        },
        {
            type: 'string',
            name: 'moduleEnName'
        },
        {
            type: 'string',
            name: 'plateName'
        },
        {
            type: 'string',
            name: 'plateFrName'
        },
        {
            type: 'string',
            name: 'plateEnName'
        },
        {
            type: 'string',
            name: 'code'
        },
        {
            type: 'string',
            name: 'enName'
        },
        {
            type: 'string',
            name: 'frName'
        },
        {
            type: 'string',
            name: 'link'
        },
        {
            type: 'string',
            name: 'notes'
        },
        {
            type: 'string',
            name: 'menuStatus'
        },
        {
            type: 'int',
            name: 'sort'
        }
    ]
});
