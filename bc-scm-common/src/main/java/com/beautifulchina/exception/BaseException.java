/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: chenghuanhuan
 * date: 2015-10-22
 */
package com.beautifulchina.exception;

import java.util.Map;

/**
 * 基础异常类
 */
public class BaseException extends Exception {

    protected String errorMessage = null;

    protected String errorCode = null;


    public BaseException() {
    }

    public BaseException(Map map) {
        super((String)map.get("errorMessage"));
        this.errorCode = (String)map.get("errorCode");
        this.errorMessage = (String)map.get("errorMessage");
    }

    public BaseException(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }

    public BaseException(String errorCode, String errorMessage) {
        super(errorMessage);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public BaseException(BaseException e) {
        super(e != null ? e.getErrorMessage() : "");

        if (e == null) {
            return;
        }

        this.errorCode = e.errorCode;
        this.errorMessage = e.errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return null;
    }
}
