/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 选项表格数据模型
 * @author: liufei
 * date: 2015-12-22
 */
Ext.define('app.model.option.OptionNameModel', {
    extend: 'Ext.data.Model',
    fields: [
        {
            type:'int',
            name:'optionId'
        },{
            type:'int',
            name:'valueId'
        },{
            type:'string',
            name:'optionEnName'
        },{
            type:'string',
            name:'optionFrName'
        }
    ]
});
