Ext.define('app.view.example.HtmlEditorPanel', {
    extend: 'Ext.panel.Panel',
    xtype: 'htmleditorpanel',
    layout:'fit',
    items:[
        {
            xtype:'form',
            layout:'fit',
            items:[
                {
                    xtype:'htmleditor',
                    title:'编辑器',
                    height:200,
                    //anchor: '100%',
                    maxWidth:900,
                    name:'html',
                    //margin:'10 10 10 10',
                    //style: {borderColor:'#000000', borderStyle:'solid', borderWidth:'1px'},
                    border:true,
                    frame: true
                }
            ],
            buttons: [
                {
                    text: '保存' ,
                    handler:function(b){
                       var values =  b.up('form').down('htmleditor').getSubmitData();
                       /* b.up('form').getForm().submit({
                            url: '/first/htmleditor',
                            params: {
                                newStatus: 'delivered'
                            },
                            success: function(form, action) {

                            },
                            failure: function(form, action) {

                            }
                        });*/
                        Ext.Ajax.request({
                            url : basePath + "/first/htmleditor",
                            method : 'POST',
                            //async: false,
                            params:values,
                            success: function(response, options) {
                                var result = Ext.JSON.decode(response.responseText);
                                if(result.result==='ok'){

                                }else{

                                }
                            },
                            failure : function(response, options) {
                                Ext.Msg.alert('提示', '保存失败!');
                            }
                        });

                    }
                }
            ]
        }
    ]
});