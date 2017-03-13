package com.beautifulchina.core.support;

/**
 * @author pengx
 * @date 2017/3/13
 * 多语言取值接口
 */
public interface MultiLanguageSupport {

    /*获取相应语言值*/
    String getLanguageContent(String key, String local);
}
