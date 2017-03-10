/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 选项值表单窗口
 * @author: liufei
 * date: 2015-12-23
 */
Ext.define('app.view.option.OptionValueInfoWindow',{
    extend:'app.view.base.BaseWindow',
    xtype:'optionvalueinfowindow',
    controller:'optionwindow',
    viewModel:{
        type:'option'
    },
    width:670,
    height:380,
    layout:'fit',
    buttons:[{
        xtype:'savebtn',
        handler:'saveValue'
    }],
   items:[{
       xtype:'form',
       layout:'column',
       padding:'10 5 5 5',
       items:[{
           xtype:'hiddenfield',
           name: 'valueId'
       },{
           xtype:'hiddenfield',
           itemId:'optionId',
           name: 'optionId'
       },{
           columnWidth: 0.45,
           border: false,
           layout: 'anchor',
           defaultType: 'textfield',
           defaults: {
               anchor: '100%',
               labelAlign: 'right',
               allowBlank: false,
               labelWidth: 160
           },
           items: [
              {
               maxLength: 100,
               bind: {
                   fieldLabel: '{optionEnValue}'
               },
               name: 'optionEnValue'
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
               labelWidth: 160
           },
           items: [{
               bind: {
                   fieldLabel: '{optionFrValue}'
               },
               maxLength: 100,
               name: 'optionFrValue'
           }]

       },{
           columnWidth: 0.45,
           border: false,
           layout: 'anchor',
           defaultType: 'numberfield',
           defaults: {
               anchor: '100%',
               labelAlign: 'right',
               allowBlank: false,
               labelWidth: 160
           },
           items: [
               {
                   maxLength: 100,
                   minValue: 0,
                   bind: {fieldLabel: '{optionPrice}'},
                   name: 'optionPrice'
               }]
       }, {
           columnWidth: 0.9,
           border: false,
           layout: 'anchor',
           items: [{
               xtype: 'textareafield',
               labelAlign: 'right',
               bind: {
                   fieldLabel: '{optionEnNotes}'
               } ,
               name: 'optionEnNotes',
               labelWidth: 160,
               anchor: '100%'
           }]
       },{
           columnWidth: 0.9,
           border: false,
           layout: 'anchor',
           items: [{
               xtype: 'textareafield',
               labelAlign: 'right',
               bind: {
                   fieldLabel: '{optionFrNotes}'
               } ,
               name: 'optionFrNotes',
               labelWidth: 160,
               anchor: '100%'
           }]
           }]
       }]
});