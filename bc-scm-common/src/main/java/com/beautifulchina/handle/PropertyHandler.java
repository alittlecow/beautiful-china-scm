/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: chenghuanhuan
 * date: 2015-10-22
 */
package com.beautifulchina.handle;

import java.util.Properties;

/**
 * 配置参数工具类
 */
public final class PropertyHandler {
    private static Properties props;

    /**
     * 隐藏工具类的构造方法
     */
    protected PropertyHandler() {
        throw new UnsupportedOperationException();
    }

    public static void loadProperties(Properties properties) {
        props = properties;
    }

    public static String getProperty(String name) {
        return props.getProperty(name);
    }
}
