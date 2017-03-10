/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: chenghuanhuan
 * date: 2015-11-04
 */
package com.beautifulchina.interceptor;

import com.alibaba.fastjson.JSON;
import com.beautifulchina.constants.CommonEnum;
import com.beautifulchina.service.util.RequestUtil;
import com.beautifulchina.user.bo.UserBO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * 安全拦截器
 */
public class SecurityInterceptor extends HandlerInterceptorAdapter {

    private Logger logger = LoggerFactory.getLogger(SecurityInterceptor.class);

    private static final int SESSION_INVALID_STATUS = 499;

    private String redirectUrl;

    private static final String ERROR_SCRIPT = "";
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        boolean isAjax = RequestUtil.isAjaxRequest(request);

        // TODO 从session中获取用户信息，如果不存在则从cookie中恢复，cookie恢复失败则跳转到登录页面
        UserBO userBO =  (UserBO) WebUtils.getSessionAttribute(request, CommonEnum.SESSION_KEY_USER.getValue());

        // 从cookie中恢复
        if(userBO == null){

        }

        // 非法请求
        if (userBO == null) {
            String path = request.getServletPath();
            logger.debug("---------------------"+path+"---------------");
            if (isAjax) {
                response.setStatus(SESSION_INVALID_STATUS);
                //response.getWriter().print(String.format(ERROR_SCRIPT, redirectUrl));
                Map<String, Object> jsonMap = new HashMap<String, Object>();
                jsonMap.put("result","fail");
                jsonMap.put("rescode", SESSION_INVALID_STATUS);
                jsonMap.put("msg", "SESSION_INVALID_STATUS");
                jsonMap.put("data", "window.location.href='redirectUrl'");
                String retString = JSON.toJSONString(jsonMap);
                response.getWriter().print(retString);
                return false;
            } else {

                /*response.setContentType("text/html;charset=UTF-8");
                String url = redirectUrl;
                if (StringUtils.isNotEmpty(request.getQueryString())){
                    url = redirectUrl+"?"+request.getQueryString();
                }*/
                response.setContentType("text/html;charset=UTF-8");
                response.sendRedirect(redirectUrl);
                //response.getWriter().print("<script>" + String.format(ERROR_SCRIPT, url) + "</script>");
            }
            return false;
        }

        return true;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }
}
