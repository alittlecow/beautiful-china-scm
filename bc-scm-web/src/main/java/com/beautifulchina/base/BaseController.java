/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: chenghuanhuan
 * date: 2015-10-22
 */
package com.beautifulchina.base;

import com.beautifulchina.constants.CommonEnum;
import com.beautifulchina.constants.MessageEnum;
import com.beautifulchina.exception.BaseException;
import com.beautifulchina.user.bo.UserBO;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.context.NoSuchMessageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.support.RequestContext;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * 控制器基类
 */
public class BaseController implements MessageSourceAware {

    protected MessageSource resource;

    /**
     * 成功的Status Code.
     */
    private static final int RESCODE_OK = 200;
    /**
     * 失败的Status Code.
     */
    private static final int RESCODE_FAIL = 201;

    protected static final String SERVER_PATH = "Z:";

    private static Logger logger = LoggerFactory.getLogger(BaseController.class);

    /**
     * 获取当前登录用户信息
     *
     * @param request
     * @return
     */
    public UserBO getUser(HttpServletRequest request) {
        UserBO userBO = (UserBO) request.getSession().getAttribute(CommonEnum.SESSION_KEY_USER.getValue());
        return userBO;
    }

    /**
     * 获取成功信息.
     * 返回操作信息code
     *
     * @param code
     * @return
     */
    protected Map<String, Object> successResult(String code) {
        return createJson(true, RESCODE_OK, getMessage(code), Collections.EMPTY_MAP);
    }

    /**
     * 获取失败信息.
     *
     * @param code
     * @return
     */
    protected Map<String, Object> failResult(String code) {
        return createJson(false, RESCODE_FAIL, getMessage(code), Collections.EMPTY_MAP);
    }

    /**
     * 默认失败信息.
     *
     * @return
     */
    protected Map<String, Object> failResult() {
        return createJson(false, RESCODE_FAIL, getMessage(MessageEnum.FAILURE.getValue()), Collections.EMPTY_MAP);
    }

    /**
     * 获取成功信息.
     * 返回操作信息code，与数据对象
     *
     * @param code
     * @return
     */
    protected Map<String, Object> successResult(String code, Object obj) {
        return createJson(true, RESCODE_OK, getMessage(code), obj);
    }

    /**
     * 获取成功信息.
     * 只返回数据，默认操作信息为操作成功
     *
     * @param obj
     * @return
     */
    protected Map<String, Object> successDataResult(Object obj) {
        return createJson(true, RESCODE_OK, "OK!", obj);
    }

    /**
     * 获取默认ajax成功信息.
     *
     * @return
     */
    protected Map<String, Object> successResult() {
        return createJson(true, RESCODE_OK, getMessage(MessageEnum.SUCCESS.getValue()), Collections.EMPTY_MAP);
    }

    /**
     * 描述：组装json格式返回结果
     *
     * @param isOk
     * @param resCode
     * @param errorMsg
     * @param obj
     * @return
     */
    protected Map<String, Object> createJson(boolean isOk, int resCode, String errorMsg, Object obj) {
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        jsonMap.put("result", isOk ? "ok" : "fail");
        jsonMap.put("rescode", resCode);
        jsonMap.put("msg", errorMsg);
        jsonMap.put("data", obj);
        return jsonMap;
    }

    /**
     * 根据错误码获取错误信息
     *
     * @param code
     * @return
     */
    protected String getMessage(String code) {
        RequestContext requestContext = new RequestContext(requestContext());
        String result;
        // 如果没有找到相应的错误信息则直接返回传入参数
        try {
            result = requestContext.getMessage(code);
        } catch (NoSuchMessageException e) {
            result = code;
        }
        return StringUtils.trimToEmpty(result);
    }

    /**
     * 根据错误码获取错误信息
     *
     * @param code
     * @return
     */
    protected Map<String, String> getMessageToMap(String code) {
        RequestContext requestContext = new RequestContext(requestContext());
        String result = requestContext.getMessage(code);
        Map<String, String> map = new HashMap<String, String>();
        map.put("errorCode", code);
        map.put("errorMessage", result);
        return map;
    }

    /**
     * 获取请求作用域.
     *
     * @return
     */
    protected HttpServletRequest requestContext() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }

    public void setMessageSource(MessageSource messageSource) {
        this.resource = messageSource;
    }

    public static void main(String[] args) {
        System.out.println(Calendar.getInstance().getTimeInMillis());
    }

    /**
     * 初始化数据绑定相关解析
     *
     * @param request
     * @param binder
     * @throws Exception
     */
    @InitBinder
    protected void initBinder(HttpServletRequest request,
                              ServletRequestDataBinder binder) throws Exception {
        //对于需要转换为Date类型的属性，使用DateEditor进行处理
        binder.registerCustomEditor(Date.class, new DateEditor());
    }

    /**
     * 全局自定义异常处理
     *
     * @param e
     * @return
     */
    @ExceptionHandler
    protected ResponseEntity<Map<String, String>> exceptionHandler(BaseException e) {
        logger.error("ControllerException", e);
        Map<String, String> map = new HashMap<String, String>();
        map.put("result", "fail");
        map.put("msg", e.getErrorMessage());
        map.put("code", e.getErrorCode());
        return new ResponseEntity<Map<String, String>>(map, HttpStatus.OK);
    }

    /**
     * 系统异常处理
     *
     * @param e
     * @return
     */
    @ExceptionHandler
    public ResponseEntity<Map<String, String>> handle(Exception e) {
        logger.error("ControllerException", e);
        Map<String, String> map = new HashMap<String, String>();
        map.put("result", "fail");
        map.put("msg", "System error!");
        return new ResponseEntity<Map<String, String>>(map, HttpStatus.OK);
    }

    /**
     * 获取当前请求语言类型
     *
     * @param request
     * @return
     */
    public String getLocal(HttpServletRequest request) {
        RequestContext requestContext = new RequestContext(request);
        Locale locale = requestContext.getLocale();
        String language = locale.getLanguage();
        return language;
    }

    /**
     * 获取国际化语言类型
     *
     * @return
     */
    public String[] getLanguage() {
        ResourceBundle resource = ResourceBundle.getBundle("/config/language");
        String[] language = resource.getString("language").split(",");
        return language;
    }
}
