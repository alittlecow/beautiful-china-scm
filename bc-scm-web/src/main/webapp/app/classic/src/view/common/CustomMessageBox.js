/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 扩展MessageBox
 * @author: chenghuanhuan
 * date: 2015-11-16
 */
Ext.define('app.view.common.CustomMessageBox', {
                extend : 'Ext.window.MessageBox',
                alternateClassName : ['App.Msg'],
                initComponent : function() {
                    
                    var me = this;
                    
                    /* 覆盖默认配置 */
                    Ext.applyIf(me, {
                                // 简单的提示框
                                alert : function(cfg, msg, fn, scope) {
                                    if (Ext.isString(cfg)) {
                                        cfg = {
                                            title : cfg===''?this.titleText.prompt:cfg,
                                            msg : msg,
                                            buttons : Ext.MessageBox.OK,
                                            fn : fn,
                                            scope : scope,
                                            minWidth : Ext.MessageBox.minWidth
                                        };
                                        return Ext.MessageBox.show(cfg);
                                    }
                                },
                                    
                                // 警示提示
                                info : function(cfg, msg, fn, scope) {
                                    if (Ext.isString(cfg)) {
                                        cfg = {
                                            title : cfg===''?this.titleText.prompt:cfg,
                                            msg : msg,
                                            buttons : Ext.MessageBox.OK,
                                            fn : fn,
                                            scope : scope,
                                            minWidth : Ext.MessageBox.minWidth,
                                            icon : Ext.MessageBox.INFO
                                        };
                                        return Ext.MessageBox.show(cfg);
                                    }
                                },

                                // 疑问提示
                                question : function(cfg, msg, fn, scope) {
                                    if (Ext.isString(cfg)) {
                                        cfg = {
                                            title : cfg===''?this.titleText.prompt:cfg,
                                            msg : msg,
                                            buttons : Ext.MessageBox.YESNO,
                                            fn : fn,
                                            scope : scope,
                                            minWidth : Ext.MessageBox.minWidth,
                                            icon : Ext.MessageBox.QUESTION
                                        };
                                        return Ext.MessageBox.show(cfg);
                                    }
                                },

                                // 警告提示
                                warn : function(cfg, msg, fn, scope) {
                                    if (Ext.isString(cfg)) {
                                        cfg = {
                                            title : cfg===''?this.titleText.prompt:cfg,
                                            msg : msg,
                                            buttons : Ext.MessageBox.OKCANCEL,
                                            fn : fn,
                                            scope : scope,
                                            minWidth : Ext.MessageBox.minWidth,
                                            icon : Ext.MessageBox.WARNING
                                        };
                                        return Ext.MessageBox.show(cfg);
                                    }
                                },
                                
                                // 错误提示
                                error : function(cfg, msg, fn, scope) {
                                    if (Ext.isString(cfg)) {
                                        cfg = {
                                            title : cfg===''?this.titleText.prompt:cfg,
                                            msg : msg,
                                            buttons : Ext.MessageBox.OK,
                                            fn : fn,
                                            scope : scope,
                                            minWidth : Ext.MessageBox.minWidth,
                                            icon : Ext.MessageBox.ERROR
                                        };
                                        return Ext.MessageBox.show(cfg);
                                    }
                                }
                            });

                    me.callParent(arguments);
                }
            },function(){
                app.view.common.CustomMessageBox = App.Msg = new this();
});
