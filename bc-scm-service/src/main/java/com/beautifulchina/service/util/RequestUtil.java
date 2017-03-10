/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: chenghuanhuan
 * date: 2015-11-04
 */
package com.beautifulchina.service.util;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.StringTokenizer;

/**
 * 请求路径、ip获取，方便cookie存储与检索
 */
public class RequestUtil {

    protected static Logger logger = LoggerFactory.getLogger(RequestUtil.class);

    protected RequestUtil(){
        throw new UnsupportedOperationException();
    }

    /**
     * 获取客户端ip
     */
    public static String getIp(HttpServletRequest request) {

        String ip = request.getHeader("X-Real-IP");
        String xip = request.getHeader("x-forwarded-for");

        if (!checkIP(ip)) {
            ip = request.getHeader("REMOTE-HOST");
        }

        if (StringUtils.isNotBlank(ip) && !ip.equals(xip)) {
            logger.error("getipne   X-Real-IP  " + ip + "    ,x-forwarded-for " + xip);
        }

        if (!checkIP(ip)) {
            ip = request.getHeader("x-forwarded-for");
        }
        if (!checkIP(ip)) {
            ip = request.getHeader("Proxy-Client-IP");//只在 Apache（Weblogic Plug-In Enable）+WebLogic 搭配下出现
        }
        if (!checkIP(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");//只在 Apache（Weblogic Plug-In Enable）+WebLogic 搭配下出现
        }
        if (!checkIP(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (!checkIP(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (!checkIP(ip)) {
            ip = request.getRemoteAddr();
        }

        // 多级反向代理
        if (null != ip && !"".equals(ip.trim())) {
            StringTokenizer st = new StringTokenizer(ip, ",");
            if (st.countTokens() > 1) {
                logger.error("getip StringTokenizer  " + ip);
                return st.nextToken();
            }
        }

        return ip;
    }

    private static boolean checkIP(String ip) {
        if (StringUtils.isNotBlank(ip) && ip.split("\\.").length == 4) {
            return true;
        }
        logger.error("getip checkIPfalse  " + ip);
        return false;
    }

    /**
     * 获取请求路径
     * @param request
     * @return /url/1
     */
    public static String getRestURL(HttpServletRequest request) {
        return (String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
    }

    /**
     * 获取请求路径表达式
     * @param request
     * @return /url/{id}
     */
    public static String getRestPatternURL(HttpServletRequest request) {
        return (String) request.getAttribute(HandlerMapping.BEST_MATCHING_PATTERN_ATTRIBUTE);
    }

    /**
     * Convenience method to set a cookie
     *
     * @param response the current response
     * @param name the name of the cookie
     * @param value the value of the cookie
     * @param path the path to set it on
     */
    public static void setCookie(HttpServletResponse response, String name, String value, String path, int expiry) {
      /*Set-Cookie: <name>=<value>[; <Max-Age>=<age>]
        [; expires=<date>][; domain=<domain_name>]
        [; path=<some_path>][; secure][; HttpOnly]
        */
        Cookie cookie = new Cookie(name, value);
        cookie.setSecure(false);
        cookie.setPath(path);
        cookie.setMaxAge(expiry);
//        cookie.setMaxAge(AppConstants.HOUR * 24 * 30); // 30 days

        response.addCookie(cookie);
    }

    /**
     * Convenience method to get a cookie by name
     *
     * @param request the current request
     * @param name the name of the cookie to find
     *
     * @return the cookie (if found), null if not found
     */
    public static Cookie getCookie(HttpServletRequest request, String name) {
        Cookie[] cookies = request.getCookies();
        Cookie returnCookie = null;
        if (cookies == null) {
            return returnCookie;
        }

        for (final Cookie thisCookie : cookies) {
            if (thisCookie.getName().equals(name) && !"".equals(thisCookie.getValue())) {
                returnCookie = thisCookie;
                break;
            }
        }

        return returnCookie;
    }

    /**
     * Convenience method for deleting a cookie by name
     *
     * @param response the current web response
     * @param cookie the cookie to delete
     * @param path the path on which the cookie was set (i.e. /appfuse)
     */
    public static void deleteCookie(HttpServletResponse response, Cookie cookie, String path) {
        if (cookie != null) {
            // Delete the cookie by setting its maximum age to zero
            cookie.setMaxAge(0);
            cookie.setPath(path);
            response.addCookie(cookie);
        }
    }

    /**
     * 获取当前域名
     *
     * @param request
     * @return
     */
    public static String getCurDomainName(HttpServletRequest request) {
        Object domain = request.getSession().getAttribute("domain");
        if(null == domain){
            return request.getHeader("host");
        }
        return domain.toString();
    }

    /**
     *
     * 验证是否是ajax请求
     * 常用的jquery之类的框架，ajax使用都会带上header [X-Requested-With=XMLHttpRequest]
     *
     * @author chenghuanhuan
     * @date 2015-10-15 下午3:08:04
     * @param request
     * @return
     */
    public static boolean isAjaxRequest(HttpServletRequest request) {
        if ("XMLHttpRequest".equals(request.getHeader("X-Requested-With"))) {
            return true;
        }
        return false;
    }
}
