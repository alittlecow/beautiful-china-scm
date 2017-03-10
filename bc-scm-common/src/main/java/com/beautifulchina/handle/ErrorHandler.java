/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: chenghuanhuan
 * date: 2015-10-22
 */
package com.beautifulchina.handle;

import org.apache.commons.lang.StringUtils;

import java.util.Properties;

/**
 * 错误处理器
 */
public class ErrorHandler {
    private static Properties errorCodesProps;

    /**
     * 隐藏工具类的构造方法
     */
    protected ErrorHandler() {
        throw new UnsupportedOperationException();
    }

    public static String getErrMsg(String errId) {
        String errMsg = errorCodesProps.getProperty(errId);

        if (StringUtils.isBlank(errMsg)) {
            errMsg = errId;
        }

        return errMsg;
    }

    public static String getErrMsg(String errId, Object... args) {
        String errMsg = errorCodesProps.getProperty(errId);

        if (StringUtils.isBlank(errMsg)) {
            errMsg = errId;
        } else {
            errMsg = String.format(errMsg, args);
        }

        return errMsg;
    }

    public static void loadErrorCodes(Properties props) {
        errorCodesProps = props;
    }
}
