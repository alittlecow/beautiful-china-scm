/**
 * The main application class. An instance of this class is created by app.js when it
 * calls Ext.application(). This is the ideal place to handle application launch and
 * initialization details.
 */

var gViewModel = null;// 全局存放国际化资源文件
Ext.define('app.Application', {
    extend: 'Ext.app.Application',
    
    name: 'app',

    stores: [
        'app.store.base.BaseStore'
    ],
    views:[
        'Ext.toolbar.Spacer',
        'app.view.base.BaseField',
        'app.view.common.CustomMessageBox',
        'app.view.common.Ajax',
        'app.view.base.BaseBtn',
        'app.view.common.AddBtn',
        'app.view.common.CheckBtn',
        'app.view.common.DelBtn',
        'app.view.common.EditBtn',
        'app.view.common.ResetBtn',
        'app.view.common.SaveBtn',
        'app.view.common.SearchBtn',
        'app.view.common.DetailBtn',
        'app.view.common.HistoryBtn',
        //chengxuemin
        'app.view.common.SubmitBtn',
        'app.view.common.ReturnBtn',
        'app.view.common.DealBtn',

        'app.view.common.SearchRestContainer',
        'app.view.common.CustomVTypes'
    ],
    launch: function () {
        var locale = getCookie("org.springframework.web.servlet.i18n.CookieLocaleResolver.LOCALE");
        console.log("--------"+locale+"--------------");
        if(locale==="fr_FR"){
            loadjscssfile("/app/classic/src/view/common/ext-locale-fr_CA.js","js");
        }else if(locale==="zh_CN"){
            loadjscssfile("/app/classic/src/view/common/ext-locale-zh_CN.js","js");
        }
        Ext.require('app.view.common.Util');
    },

    onAppUpdate: function () {
        window.location.reload();
        /*Ext.Msg.confirm('Application Update', 'This application has an update, reload?',
            function (choice) {
                if (choice === 'yes') {
                    window.location.reload();
                }
            }
        );*/
    }
});
