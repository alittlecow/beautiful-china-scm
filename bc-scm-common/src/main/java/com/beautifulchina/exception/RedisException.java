/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: chenghuanhuan
 * date: 2015-10-22
 */
package com.beautifulchina.exception;

import com.beautifulchina.handle.ErrorHandler;

/**
 * Redis异常类
 */
public class RedisException extends BaseException {
    public RedisException() {
    }

    public RedisException(String errorCode)
    {
        super(errorCode, ErrorHandler.getErrMsg(errorCode));
        this.errorMessage = ErrorHandler.getErrMsg(errorCode);
        this.errorCode = errorCode;
    }

    public RedisException(Exception e, String errorCode)
    {
        super(errorCode, ErrorHandler.getErrMsg(errorCode));
        this.errorMessage = ErrorHandler.getErrMsg(errorCode);
        this.errorCode = errorCode;
    }
}
