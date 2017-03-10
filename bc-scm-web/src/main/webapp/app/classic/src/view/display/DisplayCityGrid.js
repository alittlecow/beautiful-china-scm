/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 * @author: chengxuemin
 * date: 2016-04-07
 */

/**
 * 城市显示维护表格
 */
Ext.define( 'app.view.display.DisplayCityGrid', {
    extend: 'app.view.display.CommonGrid',
    xtype: 'displaycitygrid',
    storeName: 'displayCityStore',
    bind: {title: '{disCityTitle}'},
    columns: [
        {dataIndex: 'ids', hidden: true},
        {dataIndex: 'itemIds', hidden: true},
        {
            xtype: 'rownumberer',
            width: 140,
            bind: {text: '{No}'}
        },
        {
            flex: 3,
            bind: {text: '{image}'},
            xtype: 'widgetcolumn',
            dataIndex: 'image',
            widget: {
                xtype: 'image',
                width: 112,
                height: 80,
                alt: 'error',
                defaultBindProperty: 'src'
            }
        }, {
            flex: 5,
            dataIndex: 'name',
            bind: {text: '{city}'}
        }, {
            width: 120,
            bind: {text: '{operation}'},
            xtype: 'widgetcolumn',
            dataIndex: 'sort',
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