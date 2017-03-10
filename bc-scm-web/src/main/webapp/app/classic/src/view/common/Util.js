/**
 * Copyright @ 2015 南京网华信息科技有限公司.
 * All right reserved.
 * 工具类
 * @author: chenghuanhuan
 * date: 15/12/29
 */
Ext.define('app.view.common.Util', {
    alternateClassName : ['App.Util'],
    singleton: true,

    /**
     * 生成随机字符串(可能会重复)
     * @param m
     * @returns {string}
     */
    randomStr:function (m) {

        var m = m || 9; s = '', r = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789';
        for (var i=0; i < m; i++) { s += r.charAt(Math.floor(Math.random()*r.length)); }
        return s;
    },

    /**
     * 获取当前的页面语言
     * return 英文:en_US 中文:zh_CN 法文:fr_FR
     */
    getLanguage:function(){
        var locale = getCookie("org.springframework.web.servlet.i18n.CookieLocaleResolver.LOCALE");
        return locale;
    }
});

