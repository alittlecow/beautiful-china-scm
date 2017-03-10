/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: chenghuanhuan
 * date: 2015-12-17
 */
package com.beautifulchina.constants;

/**
 * 信息提示相关
 */
public enum MessageEnum {
    /** 操作成功 */
    SUCCESS("success"),

    /** 操作失败 */
    FAILURE("failure");

    private String value;

    private MessageEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public boolean equals(String str) {
        return this.value.equals(str);
    }

    public boolean equalsIgnoreCase(String str) {
        return this.value.equalsIgnoreCase(str);
    }

    @Override
    public String toString() {
        return this.value;
    }
}
