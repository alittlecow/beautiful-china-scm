/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 系统配置表格数据模型
 * @author: liufei
 * date: 2015-12-10
 *
 * chengxuemin 删除group_id，group_name，添加group_code
 * date: 2016-01-24
 */
Ext.define('app.model.syscfg.SysCfgModel', {
    extend: 'Ext.data.Model',
    fields: [
        {
            type:'string',
            name:'id'
        },
        {
            type: 'string',
            name: 'enName'
        },
        {
            type: 'string',
            name: 'enValue'
        },
        {
            type: 'string',
            name: 'groupCode'
        }
    ]
});
