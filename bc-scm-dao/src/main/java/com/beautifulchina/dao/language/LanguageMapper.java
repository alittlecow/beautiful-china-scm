/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: dongjingjun
 * date: 2016-04-08
 */
package com.beautifulchina.dao.language;

import com.beautifulchina.base.SqlMapper;
import com.beautifulchina.language.pojo.Language;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface LanguageMapper extends SqlMapper {
    /**
     * 新增多语言数据
     *
     * @param languages
     */
    void insertLanguage(List<Language> languages);

    /**
     * 获取相应语言值
     * key:key 语言的键值
     * key:local 语言类型
     */
    String getLanguageContent(Map map);
}
