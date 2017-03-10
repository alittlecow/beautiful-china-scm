/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 * @author: dongjingjun
 * date: 2016-03-02
 */
Ext.define('app.view.display.CommonGrid', {
    extend: 'Ext.grid.Panel',
    columnLines: true,
    viewConfig: {
        stripeRows: false
    },
    listeners: {
        itemmouseenter: 'overShadow'
    },
    storeName: '',
    autoLoad: true,
    initComponent: function () {
        var viewModel = this.lookupViewModel(true);
        var store = viewModel.getStore(this.storeName);
        var columns = this.columns;
        var before = '<div style="margin-top: 25px;font-size: 18px">';
        var after = '</div>';
        switch (this.xtype != 'displaybannergrid') {
            case true:
                columns[2].renderer = function (value, data, record, row) {
                    return before + (row + 1) + after;
                };
                columns[4].renderer = function (value) {
                    return before + value + after;
                };
                break;
            case false:
                columns[2].renderer = function (value, data, record, row) {
                    return before + (1 + row * 2) + after;
                };
                columns[5].renderer = function (value, data, record, row) {
                    return before + (2 + row * 2) + after;
                };
                break;
            default:
                console.log('display grid error');
        }
        if (Ext.isArray(this.columns)) {
            columns = {};
            columns.defaults = {align: "center"};
            columns.items = this.columns;
        }
        Ext.apply(this, {
            store: store,
            columns: columns
        });
        this.callParent(arguments);
    }
});