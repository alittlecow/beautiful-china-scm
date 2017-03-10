/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: chenghuanhuan
 * date: 2015-10-22
 */
package com.beautifulchina.util;

import com.beautifulchina.constants.CommonEnum;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 常用工具类
 *
 */
public class CommUtil {
    /**
     * 隐藏工具类的构造方法
     */
    protected CommUtil() {
        throw new UnsupportedOperationException();
    }

    /**
     * 将字符串前后空值去除，如果是空字符串则将空字符串改为null值
     *
     * @param value - 字符串
     * @return - 字符串
     */
    public static String empty2Null(String value) {
        if (value == null || value.trim().isEmpty()) {
            return null;
        }

        return value.trim();
    }

    /**
     * 函数功能：将map转换为String
     *
     * @author chenghuanhuan
     * @date 2013-3-11 下午03:49:18
     * @param map
     * @return
     */
    public static String map2String(Map<String, String[]> map) {
        if (map == null) {
            return null;
        }

        StringBuffer strBuf = new StringBuffer("{");
        Set<Map.Entry<String, String[]>> set = map.entrySet();
        Iterator<Map.Entry<String, String[]>> setIter = set.iterator();

        String[] valArr = null;
        Map.Entry<String, String[]> entry = null;
        while (setIter.hasNext()) {
            entry = setIter.next();
            if (entry == null) {
                continue;
            }
            if (strBuf.length() > 1) {
                strBuf.append(",");
            }

            strBuf.append(entry.getKey());
            strBuf.append(":");
            valArr = entry.getValue();
            if (valArr == null) {
                strBuf.append("null");
            } else {
                strBuf.append("\"[");
                for (int i = 0; i < valArr.length; i++) {
                    if (i > 0) {
                        strBuf.append(",");
                    }
                    strBuf.append(valArr[i]);
                }
                strBuf.append("]\"");
            }
        }
        strBuf.append("}");

        return strBuf.toString();
    }

    /**
     * 格式化字符串，如果值为null则返回空字符串， 如果是多个空格字符串则返回空字符串，如果字 符串首尾有空格则去掉空格
     *
     * @param str - 格式化的字符串
     * @return - 格式化后的字符串
     */
    public static String formatString(String str) {
        if (str == null) {
            return "";
        }

        if (str.matches("^\\s*$")) {
            return "";
        }

        return str.trim();
    }

    /**
     * 格式化 BigDecimal
     *
     * @author chenghuanhuan
     * @param str
     * @return
     */
    public static String formatBigDecimal(Object str) {
        if (str == null) {
            return null;
        }
        DecimalFormat df = new DecimalFormat(CommonEnum.PRICE_FORMAT_STR.getValue());
        return df.format(Double.parseDouble(str.toString()));
    }

    /**
     * 带格式的BigDecimal格式化
     *
     * @param str
     * @param format
     * @return
     */
    public static String formatBigDecimal(Object str, String format) {
        if (str == null) {
            return null;
        }
        DecimalFormat df = new DecimalFormat(format);
        return df.format(Double.parseDouble(str.toString()));
    }

    /**
     * 格式化 BigDecimal
     *
     * @author chenghuanhuan
     * @param str
     * @return BigDecimal
     */
    public static BigDecimal formatBigDecimalToBigDecimal(Object str) {
        if (str == null) {
            return null;
        }
        DecimalFormat df = new DecimalFormat(CommonEnum.PRICE_FORMAT_STR.getValue());
        return new BigDecimal(df.format(Double.parseDouble(str.toString())));
    }
}
