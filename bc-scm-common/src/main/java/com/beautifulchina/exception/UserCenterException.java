/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: chenghuanhuan
 * date: 2015-11-05
 */
package com.beautifulchina.exception;

import java.util.Map;

/**
 * 用户中心异常
 */
public class UserCenterException extends BaseException{

    public UserCenterException() {
    }

    public UserCenterException(Map<String, String> map) {
        super((String)map.get("errorMessage"));
        this.errorCode = (String)map.get("errorCode");
        this.errorMessage = (String)map.get("errorMessage");
    }

    public UserCenterException(String errorCode, String errorMessage) {
        super(errorCode, errorMessage);
    }

    public UserCenterException(String errorMessage) {
        super(errorMessage);
    }
}
