/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 * @author: chengxuemin
 * date: 2015-12-22
 */

/**
 * 线路主题管理表格数据模型
 */
Ext.define('app.model.linetheme.LineThemeModel',{
    extend: 'Ext.data.Model',
    fields: [
    /**
     * 封装code代码
     */
        {
            type: 'string',
            name: 'id'
        },
    /**
     * 封装titleEn代码
     */
        {
            type: 'string',
            name: 'titleEn'
        },
    /**
     * 封装titleFr代码
     */
        {
            type: 'string',
            name: 'titleFr'
        },
    /**
     * 封装titleDescEn代码
     */
        {
            type: 'string',
            name: 'descEn'
        },

    /**
     * 封装titleDescFr代码
     */
        {
            type: 'string',
            name: 'descFr'
        }
    ]
});