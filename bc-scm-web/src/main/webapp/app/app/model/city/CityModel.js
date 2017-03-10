/**
 * Created by ZHF on 2016/1/6.
 */


/**
 * 城市管理表格数据模型
 */
Ext.define('app.model.city.CityModel',{
    extend: 'Ext.data.Model',
    fields: [
    /**
     * 封装代码
     */
        {
            type: 'string',
            name: 'cityNameEn'
        },
    /**
     * 封装代码
     */
        {
            type: 'string',
            name: 'cityNameFr'
        },

        {
            type: 'string',
            name: 'cityIds'
        },
    /**
     * 封装descEn代码
     */
        {
            type: 'string',
            name: 'descEn'
        },

    /**
     * 封装descFr代码
     */
        {
            type: 'string',
            name: 'descFr'
        }
    ]
});