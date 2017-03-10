/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: zhuhoufeng
 * date: 2016-01-10
 */
/**
 * 角色管理控制器
 */
Ext.define('app.view.rolemanage.RoleController',{
    extend: 'app.view.base.BaseController',
    alias:'controller.role',
    init: function(view) {
        var viewmodel = view.getViewModel();
        this.getInternationalPro({config:'RoleManageConfig'},viewmodel);
        var tree=Ext.getCmp("rolemanagetree");
        tree.hide();
    },
    /**
     * 角色管理新增按钮
     */
    add:function(){
        Ext.widget('roleinfowindow',{title:this.getData('addRole')}).show();
    }
    ,
    /**
     * 角色管理修改按钮
     */
    edit:function(){
        var grid = Ext.getCmp('rolegrid');
        var record = grid.getSelectionModel().getSelection();
        if(this.oneSelectVali(record)){
            var menuWindow =Ext.widget('roleinfowindow', {title:this.getData('editRole'),stateId:'edit'}).show();
            menuWindow.down('form').loadRecord(record[0]);
            menuWindow.down('textfield[name=roleCode]').setEditable(false);
            var levelValue = record[0].get('roleLevel');
            var levelArr = [];
            for(var i=0;i<levelValue.length;i++){
                var c = levelValue.charAt(i);
                if(c =='1'){
                    levelArr.push((i+1)+'');
                }
            }
            menuWindow.down('checkboxgroup').setValue({roleLevel:levelArr});

        }
    },
    /**
     * 角色管理右选中表格行，显示右内容
     */
    show:function(e,record){
        Ext.getCmp('savebtn').setVisible(true);
        var tree = Ext.getCmp("rolemanagetree");
        tree.show();
        var nodes = tree.getChecked();
        //展开所有节点
        var moduleNodes = tree.getRootNode().childNodes;
        for(var i=0;i<moduleNodes.length;i++){
            moduleNodes[i].expand(true);
        }
        //清空
        for(var i=0;i<nodes.length;i++){
            nodes[i].set("checked",false);
        }


        var roleCode = record[0].get('roleCode');
        var treeNode = tree.getRootNode();
        //var menuNodes;
        App.Ajax.req({
            params: {roleCode:roleCode},
            url: basePath+'/rolemanage/showTree',
            success: function(response, opts) {
                var obj = Ext.JSON.decode(response.responseText);
                Ext.each(obj,function(o){
                    treeNode.findChild('id', o.code,true).set('checked',true);
                });
            }
        });
    }
    ,
    /**
     * 复选框选中事件
     * @param node
     * @param checked
     */
    onCheckboxChange:function(node, checked) {
        node.expand();
        node.checked = checked;
        node.eachChild(function (child) {
            if(node.getDepth()==2){
                child.set('checked', checked);
                this.fireEvent('checkchange', child, checked);
            }else{
                child.set('checked', checked);
                child.eachChild(function(children){
                    child.expand();
                    children.set('checked',checked);
                    this.fireEvent('checkchange', children, checked);
                });
            }

        });
    },

    /**
     * 菜单保存按钮
     * @param btn
     */
    save:function(){
        var grid = Ext.getCmp('rolegrid');
        var record = grid.getSelectionModel().getSelection();
        var roleCode=record[0].get('roleCode');
        var tree=Ext.getCmp("rolemanagetree");
        var nodes = tree.getChecked();
        var menuCodes=[];

        Ext.each(nodes,function(node){
            if(node.getDepth()==3){
                menuCodes.push(node.get('id'));
            }
        });

        if(menuCodes[0]==null||menuCodes[0]==""){
            Ext.MessageBox.alert("",this.getData("mainMsg_102"));
            return false;
        }
        App.Ajax.req({
            url : basePath + "/rolemanage/saveMenu",
            method : 'POST',
            async: false,
            params:{menuCodes:menuCodes,'roleCode':roleCode},
            success: function(response, options) {
                var result = Ext.JSON.decode(response.responseText);
                if(result.result==='ok'){
                    App.Msg.info('',result.msg);
                }else{
                    App.Msg.error('', result.msg);
                }
            }
        });
    }
});