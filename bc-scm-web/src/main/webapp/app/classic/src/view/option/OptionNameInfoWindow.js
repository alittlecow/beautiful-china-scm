/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 选项表单窗口
 * @author: liufei
 * date: 2015-12-22
 */
Ext.define('app.view.option.OptionNameInfoWindow',{
    extend:'app.view.base.BaseWindow',
    xtype:'optionnameinfowindow',
    controller:'optionwindow',
    viewModel:{
        type:'option'
    },
    width:445,
    height:230,
    buttons:[{
        xtype:'savebtn',
        handler:'save'
    }],
   items:[{
       xtype:'form',
       layout:'column',
       padding:'25 5 20 5',
       items:[{
           columnWidth: 0.9,
           border: false,
           layout: 'anchor',
           defaultType: 'textfield',
           defaults: {
               anchor: '100%',
               labelAlign: 'right',
               allowBlank: false,
               labelWidth: 180
           },
           items:[{
               xtype: 'hiddenfield',
               name:'optionId'
           },{
               bind: {
                   fieldLabel: '{optionEnName}'
               },
               name: 'optionEnName',
               maxLength:100
           },{
               bind: {
                   fieldLabel: '{optionFrName}'
               },
               name: 'optionFrName',
               maxLength: 100
           }]
       }]
   }]
});