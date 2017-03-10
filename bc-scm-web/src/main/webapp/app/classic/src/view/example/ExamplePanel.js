Ext.define('app.view.example.ExamplePanel', {
    extend: 'Ext.panel.Panel',
    xtype: 'example',
    /* controller:'base',
     viewModel: {
     type: 'base'
     },*/
    requires: [

    ],

    layout: {
        type: 'vbox',
        align: 'stretch'
    },
    items:[{
        xtype:'button',
        text:'error',
        handler:function(){
            App.Msg.error('提示', '注册失败！');
        }
    },{
        xtype:'button',
        text:'question',
        handler:function(){
            App.Msg.question('退出', '你真的要退出系统吗?', function(btn) {
                if ('yes' == btn) {

                }
            });
        }
    },{
        xtype:'button',
        text:'info',
        handler:function(){
            App.Msg.info('提示',"你好!");
        }
    },{
        xtype:'button',
        text:'alert',
        handler:function(){
            App.Msg.alert("到期通知","服务时间已经到期！");
        }
    },{
        xtype:'button',
        text:'warn',
        handler:function(){
            App.Msg.warn("到期通知","服务时间已经到期！");
        }
    },{
        xtype:'combo',
        name: 'moduleCode',
        queryMode:'remote',
        displayField: 'cityName',
        valueField: 'cityId',
        fieldLabel:'查询',
        hideLabel: true,
        //hideTrigger:true,
        pageSize:3,
        minChars:1,
        //editable:false
        store:{
            type:'citystore'
        }

    }]
});