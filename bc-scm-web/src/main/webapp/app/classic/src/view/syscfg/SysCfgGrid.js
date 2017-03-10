/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 系统配置表格
 * @author: liufei
 * date: 2015-12-10
 *
 * chengxuemin 删除group_id，group_name，添加group_code
 * date: 2016-01-24
 */
Ext.define('app.view.syscfg.SysCfgGrid', {
    extend: 'app.view.base.BaseGrid',
    xtype: 'syscfggrid',
    storeName: 'syscfgGridStore',
    viewModel: {
        type: 'syscfg'
    },
    tbar: [{
        xtype: 'addbtn',
        handler: 'add'
    }, {
        xtype: 'delbtn',
        handler: 'delete'
    }
        , {
            xtype: 'editbtn',
            handler: 'edit'
        }],
    columns: [
        {
            dataIndex: 'id', flex: 2, bind: {
            text: '{id}', hidden: true
        }
        },
        {
            dataIndex: 'name', align: 'center', flex: 2, bind: {
            text: '{name}'
        }
        },
        {
            dataIndex: 'value', align: 'center', flex: 2, bind: {
            text: '{value}'
        }
        },
        {
            dataIndex: 'groupCode', align: 'center', flex: 2, bind: {
            text: '{groupCode}'
        }
        }
    ]
});
