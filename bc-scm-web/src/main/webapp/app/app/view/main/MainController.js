/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 主页管理控制器
 * @author: chenghuanhuan
 * date: 2015-11-16
 */
Ext.define('app.view.main.MainController', {
    extend: 'app.view.base.BaseController',
    alias: 'controller.main',
    initViewModel:function(view){

    },
    init: function(view) {
        //console.log("init MainController");
        var viewmodel = view.getViewModel();
        //console.log(viewmodel);
        // 获取全局配置参数
        var params = {config:"MainConfig"};
        this.getInternationalPro(params,viewmodel);

    },
    /**
     * 菜单点击事件
     * @param e
     */
    onItemClick:function(e,record){
        // 菜单链接验证
        var xtype = record.get('cls');
        if(!xtype || Ext.ClassManager.getNameByAlias('widget.'+xtype)===""){
            Ext.Msg.alert('提示', '菜单链接未定义!');
            return;
        }

          var center = Ext.getCmp("center");
          var activeTab =  center.getActiveTab();
              //activeTab.removeAll();
          var childTab = activeTab.down('tabpanel');

        // 创建子tab
        if(!childTab){
              childTab = activeTab.add(
                          {
                              xtype:'tabpanel',
                              padding:'5 5 5 5',
                              style: {background:"#f6f6f6"},
                              layout:'fit'
                          }
              );
        }
        var itemId = record.get('cls')+"_center";
        var childPanel = childTab.getComponent(itemId)
        if(!childPanel){
            childPanel = childTab.add({
                xtype:xtype,
                title:record.get('text'),
                itemId:itemId,
                style: {background:"#f6f6f6"},
                closable:true
            });
        }
        //Ext.widget('button')
        // 设置活动panel
        childTab.setActiveTab(childPanel);

    },

    /**
     * 模块改变时的事件
     * @param tabPanel
     * @param newCard
     * @param oldCard
     * @param eOpts
     */
    mainTabChange:function(tabPanel, newCard, oldCard, eOpts ){
       //console.log(newCard);
        var itemId = newCard.getItemId();
        var modulePanel = Ext.getCmp("modulepanel");
        modulePanel.removeAll();
        App.Ajax.req({
            params:{plateId:itemId},
            url: basePath+'/main/modules',
            success: function(response, opts) {
                var obj = Ext.decode(response.responseText);
                //modulePanel.setPlateId(itemId);
                modulePanel.add(obj);
            }
        });
    },

    /**
     * 初始化用户信息显示
     * @param view
     */
    initDisplayInfo:function(view){
        // 获取用户信息
        var userStr = window.localStorage.getItem("user");
        var user = Ext.JSON.decode(userStr);
        view.queryById("name").setText(user.name);
        view.queryById("photo").setSrc(user.photo);
        // 获取当前页面语言
        var locale = getCookie("org.springframework.web.servlet.i18n.CookieLocaleResolver.LOCALE");
        view.queryById("language").setIconCls('toolbar-overflow-'+locale);
    },

    /**
     * 设置页面当前语言
     */
    setLanguage:function(e){
        var locale = e.iconCls.replace('toolbar-overflow-','');
        var url = "/main/"+locale;
        App.Ajax.req({
            url: basePath+url,
            success: function(response, opts) {
                var obj = Ext.decode(response.responseText);
                if(obj.result =="ok"){
                    window.location.reload();
                }
            }
        });
    },

    /**
     * 退出当前用户
     */
    exit:function(btn){
        Ext.MessageBox.confirm("", this.getData("mainMsg_103"), function (btn) {
            if('yes'==btn){
                App.Ajax.req({
                    url: basePath+"/main/exit",
                    success: function(response, opts) {
                        var obj = Ext.decode(response.responseText);
                        if(obj.result =="ok"){
                            window.location.href=basePath+"/login";
                        }
                    }
                });
            }
        });
    }
});

