/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 * @author: zhuhoufeng
 * date: 2016-01-20
 */


/**
 * 订单管理窗口
 */
Ext.define('app.view.order.OrderHistoryWin', {
    extend: 'app.view.base.BaseWindow',
    xtype: 'orderhistorywin',
    viewModel: {
        type: 'order'
    },
    width:1200,
    height:500,
    items:[{
        items: [
            {
                xtype: 'orderhistorygrid',
                id: 'orderhistorygrid'
            }
        ]
    }]
});