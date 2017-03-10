/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: chenghuanhuan
 * date: 2016-01-05
 */
package com.beautifulchina.base;

import com.beautifulchina.util.CommUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 用于和数据库映射无关的Bean继承
 */
public class Base implements Serializable {

    private static final long serialVersionUID = -5198612570349066479L;



    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    /*
     * 该方法把作为查询条件的bo中的字段进行String
     */
    public String boToString() {
        Class<?> c = this.getClass();
        Field[] fields = c.getDeclaredFields();
        int iLen = fields.length;
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < iLen; i++) {
            Object o = null;
            try {
                fields[i].setAccessible(true);
                o = fields[i].get(this);
            } catch (Exception ex) {
                o = "null";
            }
            if (o == null) {
                o = "null";
            }
            result = result.append('_').append(o.toString());
        }
        return c + String.valueOf(System.currentTimeMillis()) + result.toString();
    }

    public boolean isBlank(Object obj) {
        return StringUtils.isBlank(String.valueOf(obj));
    }

    /**
     * 将字段的空字符串转为null,除去前后字段的前后空格
     *
     * @throws Exception
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    public boolean fieldEmpty2Null() {
        try {
            Class cls = this.getClass();
            Method[] methodArr = cls.getMethods();
            if (methodArr == null || methodArr.length == 0) {
                return true;
            }

            for (Method getMethod : methodArr) {
                if (getMethod.getName().startsWith("get") && getMethod.getReturnType() == String.class) {
                    String str = (String) getMethod.invoke(this, new Object[]{});
                    if (str == null) {
                        continue;
                    }

                    str = CommUtil.empty2Null(str);
                    StringBuffer strBuf = new StringBuffer("s");
                    strBuf.append(getMethod.getName().substring(1));
                    try {
                        Method setMethod = cls.getMethod(strBuf.toString(), String.class);
                        if (setMethod == null) {
                            continue;
                        }
                        setMethod.invoke(this, str);
                    } catch (Exception e) {
                        continue;
                    }
                }
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
