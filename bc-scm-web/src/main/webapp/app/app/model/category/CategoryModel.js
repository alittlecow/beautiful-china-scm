/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 * @author: chengxuemin
 * date: 2015-12-22
 */

/**
 * 分类管理表格数据模型
 */
Ext.define('app.model.category.CategoryModel',{
    extend: 'Ext.data.Model',
    fields: [
    /**
     * 封装分类名称英文代码
     */
        {
            type: 'string',
            name: 'nameEn'
        },
    /**
     * 封装分类名称法语代码
     */
        {
            type: 'string',
            name: 'nameFr'
        },
    /**
     * 封装分类编号代码
     */
        {
            type: 'string',
            name: 'code'
        },
    /**
     * 封装级别代码
     */
        {
            type: 'string',
            name: 'level'
        },
    /**
     * 封装父级分类id代码
     */
        {
            type: 'string',
            name: 'parent'
        }
    ]
});