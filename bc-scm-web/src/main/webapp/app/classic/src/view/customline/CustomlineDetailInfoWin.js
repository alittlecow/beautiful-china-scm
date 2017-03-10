/**
 * Copyright @ 2016 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 修改定制线路窗口
 * @author: zhangyu
 * date: 2016-1-12
 */

Ext.define('app.view.customline.customlineDetailInfoWin', {
    extend: 'app.view.base.BaseWindow',
    xtype: 'customlinedetailwin',
    controller:'customDetailWinController',
    viewModel: {
        type: 'customline'
    },
    width: 300,
    height: 250,
    buttons: [{
        xtype: 'savebtn',
        handler: 'save'
    }],
    items: [{
        xtype: 'form',
        layout: 'column',
        padding: '5 5 5 5',
        items: [
            {
                columnWidth: 1,
                border: false,
                layout: 'anchor',
                defaultType: 'textfield',
                defaults: {
                    anchor: '100%',
                    labelAlign: 'right',
                    labelWidth: 100
                },
                items: [
                    {
                        xtype: 'hiddenfield',
                        name: 'cstId'
                    },

                    {
                        xtype:'combo',
                        autoLoadOnValue: true,
                        bind:{
                            store:'{customlineCityStore}',
                            fieldLabel: '{cityNameEn}'
                        },
                        displayField: 'city',
                        valueField: 'id',
                        editable: false,
                        name: 'cityId'
                    },
                      {
                          xtype:'numberfield',
                        bind:{fieldLabel: '{desDay}'},
                          name: 'day'
                   }]
            }
        ]
    }]
});