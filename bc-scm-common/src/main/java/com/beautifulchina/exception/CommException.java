/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: chenghuanhuan
 * date: 2015-11-20
 */
package com.beautifulchina.exception;

import com.beautifulchina.handle.ErrorHandler;

/**
 * 公共异常
 */
public class CommException extends BaseException{

    public CommException(){

    }
    public CommException(String errorCode)
    {
        super(errorCode, ErrorHandler.getErrMsg(errorCode));
        this.errorMessage = ErrorHandler.getErrMsg(errorCode);
        this.errorCode = errorCode;
    }

    public CommException(Exception e, String errorCode)
    {
        super(errorCode, ErrorHandler.getErrMsg(errorCode));
        this.errorMessage = ErrorHandler.getErrMsg(errorCode);
        this.errorCode = errorCode;
    }
}
