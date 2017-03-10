/**
 * Created by ZHF on 2016/3/24.
 */

/**
 * 旅游线路管理窗口
 */
Ext.define('app.view.order.OptionSelectWin', {
    extend: 'app.view.base.BaseWindow',
    xtype: 'orderoptionwin',
    controller: 'orderoptionselectwin',
    viewModel: {
        type: 'order'
    },
    width: 900,
    height: 600,
    buttons: [{
        xtype:'savebtn',
        handler:'saveOption'
    }],
    layout: 'column',
    items: [
        //{
        //    columnWidth: 0.9,
        //    padding: '20 0 10 0',
        //    xtype: 'combo',
        //    bind: {
        //        fieldLabel: '{ordOption}',
        //        store: 'orderoptionStore'
        //    },
        //    listeners: {
        //        change: 'loadOptionValue',
        //        beforequery: 'getUnusedOption'
        //
        //    },
        //    autoLoadOnValue: true,
        //    labelWidth: 120,
        //    labelAlign: 'right',
        //    displayField: 'name',
        //    valueField: 'id',
        //    editable: false,
        //    name: 'optionId'
        //}
        //,
        {
            columnWidth: 0.5,
            frame: true,
            itemId: 'grid1',
            xtype: 'grid',
            height: 350,
            multiSelect: true,
            listeners: {
                     render: 'loadOptionValue'
            },
            viewConfig: {
                plugins: {
                    ptype: 'gridviewdragdrop',
                    containerScroll: true,
                    dragGroup: 'group1',
                    dropGroup: 'group2'
                }
            },
            autoLoad: false,
            store: Ext.create('store.orderoptionvaluestore'),
            columns: [{
                bind: {text: '{ordOptionValue}'},
                align: 'center',
                flex: 1,
                sortable: true,
                dataIndex: 'name'
            }, {
                bind: {text: '{ordDifferential}'},
                align: 'center',
                flex: 1,
                sortable: true,
                dataIndex: 'price'
            }],
            bind: {title: '{ordUnChecked}'},
            margin: '30 20 0 20'
        }, {
            columnWidth: 0.5,
            height: 350,
            frame: true,
            itemId: 'grid2',
            xtype: 'grid',
            plugins: [{
                ptype: 'cellediting',
                clicksToMoveEditor: 1,
                autoCancel: false
            }],
            flag: [],
            index: -1,
            viewConfig: {
                plugins: {
                    ptype: 'gridviewdragdrop',
                    containerScroll: true,
                    dragGroup: 'group2',
                    dropGroup: 'group1'
                }
            },
            store: new Ext.data.Store({
                model: Ext.create('app.model.order.OrderOptionModel')
            }),
            columns: [{
                xtype: 'hidden',
                name: 'valueId'
            }, {
                bind: {text: '{ordOptionValue}'},
                align: 'center',
                flex: 3,
                sortable: true,
                dataIndex: 'name'
            }, {
                bind: {text: '{ordDifferential}'},
                align: 'center',
                flex: 3,
                sortable: true,
                dataIndex: 'price',
                editor: {allowBlank: false, xtype: 'numberfield', allowDecimals: true, minValue: 0}
            }
            //    ,{
            //    bind: {text: '{ordDefaults}'},
            //    xtype: 'widgetcolumn',
            //    align: 'right',
            //    width: 110,
            //    dataIndex: 'id',
            //    widget: {
            //        defaultBindProperty: 'session',
            //        xtype: 'checkbox',
            //        index: -2,
            //        margin: '0 30',
            //        width: 10,
            //        listeners: {
            //            change: function () {
            //                if (this.checked) {
            //                    this.index = ++this.up('grid').index;
            //                    this.up('grid').flag.push((this.session.initialConfig.split('-'))[0]);
            //                } else {
            //                    this.up('grid').flag.splice(this.index, 1);
            //                    this.up('grid').flag.splice(this.index, 0, -1);
            //                }
            //            }
            //        }
            //    }
            //}
            ],
            stripeRows: true,
            bind: {title: '{ordChecked}'},
            margin: '30 20 0 20'
        },
        {
            columnWidth: 0.9,
            padding: '10 0 0 0',
            xtype: 'displayfield',
            bind: {value: '{ordDrop}'},
            margin: '0 120',
            fieldStyle: {
                color: 'blue'
            }
        }
    ]
});