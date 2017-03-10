/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 * @author: dongjingjun
 * date: 2016-04-11
 */

Ext.define('app.view.language.LanguageController', {
    extend: 'app.view.base.BaseController',
    alias: 'controller.language',
    init: function (view) {
        var viewmodel = view.getViewModel();
        this.getInternationalPro({config: 'LanguageConfig'}, viewmodel)
    },
    click: function (languageBtn) {
        var me = this, language = languageBtn.getStateId();
        var form = languageBtn.up('window').down('form'), formValues = form.formValues.multiLanguage;
        var keys = Ext.Object.getKeys(formValues);
        var field = form.down('*[name=' + languageBtn.target + ']'), xtype = field.getXType(), fieldName = field.getName(), extObjects = [];
        formValues[language][fieldName] = field.getValue();
        keys.forEach(function (item) {
            var extObject = {
                xtype: xtype,
                name: item,
                fieldLabel: me.getData(item),
                value: formValues[item][fieldName]
            };
            extObjects.push(extObject);
        });
        // 创建多语言选择窗口
        var win = Ext.create('Ext.window.Window', {
            title: field.getFieldLabel(),
            modal: true,
            autoScroll: true,
            width: 800,
            height: 500,
            buttons: [{
                xtype: 'surebtn',
                handler: function (saveBtn) {
                    var fields = saveBtn.up('window').query(xtype);
                    fields.forEach(function (newField) {
                        formValues[newField.getName()][field.getName()] = newField.getValue();
                    });
                    field.setValue(formValues[language][fieldName]);
                    win.close();
                }
            }],
            padding: '20 10 0 0',
            layout: 'anchor',
            defaults: {
                anchor: '100%',
                labelAlign: 'right',
                labelWidth: 120
            }
        }).show(languageBtn);
        win.add(extObjects);

    },
    render: function (languageBtn) {
        // //获取当前页面语言
        var country = getCookie("org.springframework.web.servlet.i18n.CookieLocaleResolver.LOCALE");
        var local = country.substring(0, country.indexOf('_'));
        // // 设置窗口多语言按钮属性
        languageBtn.setText('<a href="javascript:;"/>' + this.getData('multiLanguage'));
        languageBtn.stateId = local;
    }
});