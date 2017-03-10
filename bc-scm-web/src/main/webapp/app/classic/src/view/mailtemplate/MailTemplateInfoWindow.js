/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 邮件模板表单窗口
 * @author: fengbaitong
 * date: 2015-11-25
 */
Ext.define('app.view.mailtemplate.MailTemplateInfoWindow', {
    extend: 'app.view.base.BaseWindow',
    xtype: 'mailtemplateinfowindow',
    controller: 'mailtemplate',
    viewModel: {
        type: 'mailtemplate'
    },
    defaults: {
        anchor: '100%',
        labelAlign: 'right',
        allowBlank: false
    },
    closeAction: 'hide',
    width: 999,
    height: 650,
    buttons: [{
        xtype:'savebtn',
        handler:'save'
    }],
    items: [{
        xtype: 'form',
        layout: 'column',
        padding: '5 5 5 5',
        items: [{
            columnWidth: 0.33,
            border: false,
            padding: '0 25 0 0',
            layout: 'anchor',
            defaultType: 'textfield',
            defaults: {
                anchor: '95%',
                labelAlign: 'top',
                allowBlank: false
            },
            items: [{
                xtype: 'numberfield',
                name: 'id',
                value: 1,
                hidden: true
            }, {
                bind: {
                    fieldLabel: '{templateName}'
                },
                name: 'name',
                maxLength: 50
            }]

        },
        {
            columnWidth: 0.33,
            padding: '0 25 0 0',
            border: false,
            layout: 'anchor',
            defaultType: 'textfield',
            defaults: {
                anchor: '95%',
                labelAlign: 'top',
                allowBlank: false
            },
            items: [{
                bind: {
                    fieldLabel: '{mailTitleEn}'
                },
                name: 'titleEn',
                maxLength: 50
            }]
        },
        {
            columnWidth: 0.33,
            padding: '0 25 0 0',
            border: false,
            layout: 'anchor',
            defaultType: 'textfield',
            defaults: {
                anchor: '95%',
                labelAlign: 'top',
                allowBlank: false
            },
            items: [{
                bind: {
                    fieldLabel: '{mailTitleFr}'
                },
                name: 'titleFr',
                maxLength: 50
            }]
        },
        {
            columnWidth: 1,
            border: false,
            layout: 'anchor',
            defaults: {
                anchor: '95%',
                labelAlign: 'top',
                allowBlank: false,
                labelWidth:200,
                xtype: 'htmleditor'
            },
            items: [{
                    bind: {fieldLabel: '{mailContentEn}'},
                    height: 200,
                    name: 'contentEn',
                    border: true,
                    frame: true,
                    maxLength: 1000
            }
             ,{
                      bind: {fieldLabel: '{mailContentFr}'},
                      height: 200,
                      name: 'contentFr',
                      border: true,
                      frame: true,
                      maxLength: 1000
             }]
        }]
    }]
});