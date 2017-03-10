/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 行程详情添加窗口
 * @author: dongjingjun
 * date: 2015-12-29
 */

Ext.define('app.view.tour.TourDetailInfoWin', {
    extend: 'app.view.base.BaseWindow',
    xtype: 'tourdetailwin',
    controller: 'detailwin',
    viewModel: {
        type: 'tour'
    },
    width: screen.width*0.8,
    height: 550,
    buttons: [{
        xtype: 'savebtn',
        handler: 'saveDetail'
    }],
    items: [{
        xtype: 'form',
        autoScroll: true,
        layout: 'column',
        padding: '5 5 5 5',
        items: [
            {
                columnWidth: 0.9,
                border: false,
                layout: 'anchor',
                defaultType: 'textareafield',
                defaults: {
                    anchor: '100%',
                    labelAlign: 'right',
                    labelWidth: 200
                },
                items: [
                    {
                        xtype: 'hiddenfield',
                        name: 'id'
                    },{
                        bind: {fieldLabel: '{day}'},
                        xtype: 'numberfield',
                        minValue: 1,
                        value: 1,
                        allowDecimals: false,
                        name: 'day'
                    }, {
                        xtype: 'textfield',
                        bind: {fieldLabel: '{titleEn}'},
                        name: 'titleEn',
                        maxLength: 50,
                        allowBlank: false
                    }, {
                        xtype: 'textfield',
                        bind: {fieldLabel: '{titleFr}'},
                        name: 'titleFr',
                        maxLength: 50,
                        allowBlank: false
                    }, {
                        bind: {fieldLabel: '{transportEn}'},
                        name: 'transportEn'
                    }, {
                        bind: {fieldLabel: '{transportFr}'},
                        name: 'transportFr'
                    }, {
                        bind: {fieldLabel: '{mealsEn}'},
                        name: 'mealsEn'
                    }, {
                        bind: {fieldLabel: '{mealsFr}'},
                        name: 'mealsFr'
                    }]
            },
            {
                columnWidth: 0.9,
                border: false,
                layout: 'anchor',
                defaultType: 'myeditor',
                defaults: {
                    url: basePath + '/tour/uploadImage',
                    imageWidth: 340,
                    imageHeight: 220,
                    buttonTip: 'Add Image',
                    labelAlign: 'right',
                    anchor: '100%',
                    labelWidth: 200,
                    height: 200
                },
                items: [
                    {
                        bind: {fieldLabel: '{contentEn}'},
                        name: 'contentEn'
                    }, {
                        bind: {fieldLabel: '{contentFr}'},
                        name: 'contentFr'
                    }, {
                        bind: {fieldLabel: '{destinationEn}'},
                        name: 'destinationEn'
                    }, {
                        bind: {fieldLabel: '{destinationFr}'},
                        name: 'destinationFr'
                    }, {
                        bind: {fieldLabel: '{hotelEn}'},
                        name: 'hotelEn'
                    }, {
                        bind: {fieldLabel: '{hotelFr}'},
                        name: 'hotelFr'
                    }]
            }
        ]
    }]
});