/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 * @author: dongjingjun
 * date: 2015-12-25
 */
/**
 * 旅游线路管理窗口
 */
Ext.define('app.view.tour.TourInfoWin', {
    extend: 'app.view.base.BaseWindow',
    xtype: 'tourinfowin',
    controller: 'tourwin',
    viewModel: {
        type: 'tour'
    },
    width: 1000,
    height: 600,
    resizable: false,
    listeners: {
        close: 'deltemp'
    },
    items: [
        {
            xtype: 'tabpanel',
            layout: 'fit',
            padding: '5 0 0 0',
            tabPosition: 'left',
            tabBar: {
                style: 'background:#7098D4;'
            },
            tabRotation: 0,
            bodyStyle: 'background:#ffc; padding:5px;',
            defaults: {
                layout: {
                    type: 'vbox',
                    align: 'stretch'
                }
            },
            items: [
                {
                    bind: {title: '{tourBaseInfo}'},
                    plugins: {
                        ptype: 'lazyitems',
                        items: [
                            {
                                xtype: 'baseinfoformpanel',
                                flex: 1
                            }
                        ]
                    }
                }, {
                    bind: {title: '{tourImage}'},
                    flex: 1,
                    autoScroll: true,
                    plugins: {
                        ptype: 'lazyitems',
                        items: [
                            {
                                xtype: 'imageformpanel'
                            }
                        ]
                    }
                }, {
                    bind: {title: '{tourDetail}'},
                    plugins: {
                        ptype: 'lazyitems',
                        items: [
                            {
                                xtype: 'tourdetailgrid',
                                flex: 1
                            }
                        ]
                    }
                }, {
                    bind: {title: '{tourDate}'},
                    plugins: {
                        ptype: 'lazyitems',
                        items: [
                            {
                                xtype: 'tourdatequeryform'
                            },
                            {
                                xtype: 'tourdategrid',
                                flex: 1
                            }
                        ]
                    }
                }, {
                    bind: {title: '{tourOption}'},
                    plugins: {
                        ptype: 'lazyitems',
                        items: [
                            {
                                xtype: 'touroptiongrid',
                                flex: 1
                            }
                        ]
                    }
                }
            ]
        }]
});