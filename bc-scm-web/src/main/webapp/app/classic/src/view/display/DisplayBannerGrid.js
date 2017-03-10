/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 * @author: dongjingjun
 * date: 2016-03-02
 */
Ext.define('app.view.display.DisplayBannerGrid', {
    extend: 'app.view.display.CommonGrid',
    xtype: 'displaybannergrid',
    storeName: 'displayBannerStore',
    bind: {title: '{disBannerTitle}'},
    columns: [
        {dataIndex: 'ids', hidden: true},
        {dataIndex: 'itemIds', hidden: true},
        {
            xtype: 'rownumberer',
            width: 140,
            bind: {text: '{No}'}
        },
        {
            flex: 1,
            bind: {text: '{image}'},
            xtype: 'widgetcolumn',
            dataIndex: 'image1',
            widget: {
                xtype: 'image',
                width: 206,
                height: 80,
                alt: 'error',
                defaultBindProperty: 'src'
            }
        }, {
            width: 120,
            bind: {text: '{operation}'},
            xtype: 'widgetcolumn',
            dataIndex: 'sort1',
            widget: {
                xtype: 'button',
                margin: '25 0',
                bind: {text: '{select}'},
                width: 80,
                defaultBindProperty: 'tabIndex',
                handler: 'selectItemInfo'
            }
        }
        ,
        {
            xtype: 'rownumberer',
            width: 140,
            bind: {text: '{No}'}
        }, {
            flex: 1,
            bind: {text: '{image}'},
            xtype: 'widgetcolumn',
            dataIndex: 'image2',
            widget: {
                xtype: 'image',
                width: 206,
                height: 80,
                alt: 'error',
                defaultBindProperty: 'src'
            }
        }, {
            width: 120,
            bind: {text: '{operation}'},
            xtype: 'widgetcolumn',
            dataIndex: 'sort2',
            widget: {
                xtype: 'button',
                margin: '25 0',
                bind: {text: '{select}'},
                width: 80,
                defaultBindProperty: 'tabIndex',
                handler: 'selectItemInfo'
            }
        }
    ]
});