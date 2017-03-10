/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: dongjingjun
 * date: 2015-12-21
 * 角色新增，修改弹出框
 */
Ext.define('app.view.rolemanage.RoleInfoWindow', {
    extend: 'app.view.base.BaseWindow',
    xtype: 'roleinfowindow',
    controller: 'rolewindow',
    viewModel: {
        type: 'role'
    },
    bind:{title: '{addRole}'},
    closeAction: 'hide',
    width: 750,
    height: 350,
    layout: 'fit',
    modal: true,
    buttons: [{
        bind: {
            text: '{save}'
        },
        handler:'save'
    }],
    items: [{
        xtype: 'form',
        layout: 'column',
        padding: '5 5 5 5',
        items: [{
            columnWidth: 0.45,
            border: false,
            layout: 'anchor',
            defaultType: 'textfield',
            defaults: {
                anchor: '100%',
                labelAlign: 'right',
                allowBlank: false,
                labelWidth:100
            },
            items: [
                {
                    maxLength: 30,
                    bind: {
                        fieldLabel: '{roleCode}'
                    },
                    name: 'roleCode'
                }, {
                    bind: {
                        fieldLabel: '{roleStatus}'
                    },
                    xtype: 'combo',
                    store: "normalStop",
                    displayField: 'name',
                    valueField: 'value',
                    editable: false,
                    value: 'N',
                    name: 'status'
                }]
        }, {
            columnWidth: 0.45,
            padding: '0 0 0 5',
            border: false,
            layout: 'anchor',
            defaultType: 'textfield',
            defaults: {
                anchor: '100%',
                allowBlank: false,
                labelAlign: 'right',
                maxLength: 30,
                labelWidth:180
            },
            items: [
                {
                    bind: {
                        fieldLabel: '{roleFrName}'
                    },
                    name: 'roleFrName'
                },
                {
                    bind: {
                        fieldLabel: '{roleEnName}'
                    },
                    name: 'roleEnName'
                }]
        }, {
            columnWidth: 1,
            border: false,
            layout: 'anchor',
            defaults: {
                labelAlign: 'right'
            },
            items: [{
                xtype: 'checkboxgroup',
                bind: {
                    fieldLabel: '{level}'
                }
                ,
                defaultType: 'checkboxfield',
                layout: {
                    type: 'hbox',
                    allowBlank: false,
                    align: 'stretch'
                },
                items: [
                    {
                        bind: {boxLabel: '{sAdmin}'},
                        name: 'roleLevel',
                        inputValue: '1'
                    }, {
                        bind: {boxLabel: '{pManage}'},
                        name: 'roleLevel',
                        inputValue: '2'
                    }, {
                        bind: {boxLabel: '{supplier}'},
                        name: 'roleLevel',
                        inputValue: '4'
                    }
                ]
            }]
        }, {
            columnWidth: 0.9,
            border: false,
            layout: 'anchor',
            items: [{
                xtype: 'textareafield',
                labelAlign: 'right',
                bind: {
                    fieldLabel: '{notes}'
                }
                ,
                name: 'roleNotes',
                anchor: '100%'
            }]
        }]
    }]
});