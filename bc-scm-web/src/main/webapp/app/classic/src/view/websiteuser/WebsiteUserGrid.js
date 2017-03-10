/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: chengxuemin
 * date: 2015-12-11
 */

/**
 * 网站用户管理表格
 */
Ext.define('app.view.websiteuser.WebsiteUserGrid', {
    extend: 'app.view.base.BaseGrid',
    xtype:'websiteusergrid',
    storeName:'websiteuserGridStore',
    viewModel: {
        type: 'websiteuser'
    },
    columns: [
        {
            dataIndex: 'id', width: 250, bind: {
            text: '{id}', hidden: true
        }
        },
        {
            dataIndex: 'name', width: 250, bind: {
            text: '{name}'
        }
        },
        {
            dataIndex: 'nickName', width: 250, bind: {
            text: '{nickName}'
        }
        },
        {
            dataIndex: 'email', width: 250, bind: {
            text: '{email}'
        }
        },
        {
            dataIndex: 'sex', width: 250, renderer: function (value) {
            var retValue = '';
            if (value === 'F') {
                retValue = 'woman';
            } else {
                retValue = 'man';
            }
            return retValue;
        }, bind: {
            text: '{sex}'
        }
        },
        {
            dataIndex: 'passport', width: 250, bind: {
            text: '{passport}'
        }
        },
        {
            dataIndex: 'status', width: 250, renderer: function (value) {
            var retValue = '';
            if (value === 'N') {
                retValue = 'normal';
            } else {
                retValue = 'suspend';
            }
            return retValue;
        }, bind: {
            text: '{status}'
        }
        },
        {
            dataIndex: 'point', width: 250, bind: {
            text: '{point}', hidden: true
        }
        },
        {
            dataIndex: 'usablePoint', width: 250, bind: {
            text: '{usablePoint}', hidden: true
        }
        },
        {
            dataIndex: 'type', width: 250, renderer: function (value) {
            var retValue = '';
            if (value === 'A') {
                retValue = 'agent';
            } else {
                retValue = 'domesticConsumer';
            }
            return retValue;
        }, bind: {
            text: '{type}'
        }
        },
        {
            dataIndex: 'faceBookName',  width: 250,bind: {
            text: '{faceBookName}'
        }
        },
        {
            dataIndex: 'lockTime', width: 250, bind: {
            text: '{lockTime}', hidden: true
        }
        },
        {
            dataIndex: 'lockReson',width: 250,  bind: {
            text: '{lockReson}', hidden: true
        }
        },
        {
            xtype: 'widgetcolumn',
            width: 140,
            widget: {
                width: 100,
                xtype: 'button',
                //iconCls:'x-fa fa-search-plus',
                bind: {
                    text: '{detail}'
                },
                handler: 'detail'
            }
        },
        {
            xtype: 'widgetcolumn',
            width: 140,
            widget: {
                width: 100,
                xtype: 'button',
                //iconCls:'x-fa fa-chain-broken',
                bind: {
                    text: '{freeze}'
                },
                handler: 'freeze'
            }
        }
    ]
});
