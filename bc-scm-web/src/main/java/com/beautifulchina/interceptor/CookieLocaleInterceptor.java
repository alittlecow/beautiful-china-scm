/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: chenghuanhuan
 * date: 2015-10-30
 */
package com.beautifulchina.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * 基于cookie的国际化
 */
public class CookieLocaleInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        Cookie[] cookies = request.getCookies();
        CookieLocaleResolver cookieLocaleResolver = new CookieLocaleResolver();
        // 默认设置
        Locale locale = new Locale("en", "US");
        cookieLocaleResolver.setDefaultLocale(locale);

        /* 获取cookie中的国际化标示 */
        if(cookies != null && cookies.length>0){
            for (int i=0;i<cookies.length;i++){

                Cookie cookie = cookies[i];
                String cookieName = cookie.getName();

                if(CookieLocaleResolver.DEFAULT_COOKIE_NAME.equals(cookieName)){
                    String cookieValue = cookie.getValue();
                    if ("zh_CN".equals(cookieValue)) {
                        locale = new Locale("zh", "CN");
                    } else if ("fr_FR".equals(cookieValue)) {
                        locale = new Locale("fr", "FR");
                    }
                    break;
                }
            }

        }
        cookieLocaleResolver.setLocale(request,response,locale);
        return true;
    }
}
