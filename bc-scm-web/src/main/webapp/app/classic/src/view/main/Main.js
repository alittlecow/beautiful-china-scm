/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 首页框架
 * @author: chenghuanhuan
 * date: 2015-11-16
 */
Ext.define('app.view.main.Main', {
    extend: 'Ext.container.Viewport',
    controller:'main',
    viewModel: {
        type: 'main'
    },
    layout: {
        type: 'hbox',
        align: 'stretch'
    },
    requires: [
        // view
        'app.view.base.BaseGrid',
        'app.view.main.MainTreePanel',
        'app.view.main.HomePagePanel',
        'app.view.menu.MenuManagePanel',
        'app.view.platform.PlatformManagePanel',
        'app.view.mailtemplate.MailTemplateManagePanel',
        'app.view.supplier.SupplierManagePanel',
         'app.view.attribute.AttributePanel',
        'app.view.common.Ajax',
        //邮件历史记录
        'app.view.mailhistory.MailHistoryManagePanel',
        //网站用户管理
        'app.view.websiteuser.WebsiteUserManagePanel',
        //线路主题管理
        'app.view.linetheme.LineThemeManagePanel',
        //线路管理
        'app.view.customline.CustomlineManagePanel',
        //分类管理
        'app.view.category.CategoryManagePanel',
        //咨询管理
        'app.view.consultive.ConsultiveManagePanel',
        //咨询投诉管理
        'app.view.consulting.ConsultingQueryForm',
        //首页展示类型
        'app.view.display.DisplayManagePanel',



        'app.view.example.ExamplePanel',
        'app.view.example.HtmlEditorPanel',
        //角色管理
        'app.view.rolemanage.RoleManagePanel',
        //系统配置
        'app.view.syscfg.SysCfgPanel',
        //旅游线路管理
       'app.view.tour.TourManagePanel',
        //部门等级管理
        'app.view.dlmanage.DLMPanel',
        //部门信息管理
        'app.view.dimanage.DIMPanel',
        //酒店管理
        'app.view.hotel.HotelManagePanel',
        //景点管理
        'app.view.sights.SightsManagePanel',
        //目的地管理
        'app.view.destination.DesManagePanel',
        'app.view.option.OptionPanel',
        //城市信息管理
        'app.view.city.CityManagePanel',
        // 订单管理
        'app.view.order.OrderManagePanel',
        // 咨询投诉管理
        'app.view.consulting.ConsultingManagePanel',
        // controller
        'app.view.main.MainController',


        // viewmodel
        'app.view.base.BaseViewModel',
        'app.view.main.MainViewModel'


    ],
    items: [{
        xtype:'container',
        width:250,
        id:'west',
        //style: {borderColor:'#000000', borderStyle:'solid', borderWidth:'1px'},
        layout: {
            type: 'vbox',
            align: 'stretch'
        },
        items:[{
            xtype: 'container',
            height: 94,
            style: {color: '#FFFFFF', backgroundColor:'#157FCC'},
            items:[{
                xtype: 'image',
                //src: basePath+'/app/resources/images/sencha-logo.png',
                alt:'  ',
                height: 50
            }]
        },{
            xtype:'panel',
            layout:'accordion',
            id:'modulepanel',
            flex:1
        }]
    },{
        xtype:'container',
        flex:1,
        //style: {borderColor:'#000000', borderStyle:'solid', borderWidth:'1px'},
        layout: {
            type: 'vbox',
            align: 'stretch'
        },
        items:[{
            xtype: 'toolbar',
            style: {color: '#FFFFFF', backgroundColor:'#157FCC'},
            height: 50,
            itemId: 'headerBar',
            items: [
                {
                    xtype: 'tbspacer',
                    flex: 1
                },
                {
                    cls: 'delete-focus-bg',
                    iconCls:'x-fa fa-envelope',
                    href: '#email',
                    hrefTarget: '_self',
                    bind:{
                        tooltip:"{emailTooltip}"
                    }
                },
                {
                    cls: 'delete-focus-bg',
                    iconCls:'x-fa fa-bell',
                    bind:{
                        tooltip:"{emailTooltip}"
                    }
                },
                {
                    cls: 'delete-focus-bg',
                    iconCls:'x-fa fa-power-off',
                    bind:{
                        tooltip:"{exit}"
                    },
                    handler: 'exit'
                },
                {
                    cls: 'delete-focus-bg',
                    iconCls:'x-fa fa-flag',
                    bind:{
                        tooltip:"{languageTooltip}"
                    },
                    itemId:'language',
                    menu: [{
                        text: 'United Kingdom',
                        cls: 'delete-focus-bg',
                        iconCls:'toolbar-overflow-en_US',
                        listeners:{
                            click:"setLanguage"
                        }
                    }, {
                        text: 'France',
                        cls: 'delete-focus-bg',
                        iconCls:'toolbar-overflow-fr_FR',
                        listeners:{
                            click:"setLanguage"
                        }
                    },{
                        text:'Chinese',
                        cls: 'delete-focus-bg',
                        iconCls:'toolbar-overflow-zh_CN',
                        listeners:{
                            click:"setLanguage"
                        }
                    }]
                },
                {
                    xtype: 'tbtext',
                    cls: 'top-user-name',
                    itemId:'name'
                },
                {
                    xtype: 'image',
                    itemId:'photo',
                    cls: 'header-right-profile-image',
                    height: 35,
                    width: 35,
                    alt:'current user image'//,
                   // src: '/app/resources/images/2.png',
                }
            ]
        },{
            xtype: 'tabpanel',
            flex:1,
            id:'center',
            activeTab: 0,
            layout:'fit',
            //style: {borderColor:'#FF3030', borderStyle:'solid', borderWidth:'5px'},
            loader: {
                renderer: 'component',
                url: basePath+'/main/plates',
                autoLoad: true
            },
            listeners:{
                tabchange:'mainTabChange'
            }
        }]
    }],
    listeners:{
        afterrender:'initDisplayInfo'
    }
});