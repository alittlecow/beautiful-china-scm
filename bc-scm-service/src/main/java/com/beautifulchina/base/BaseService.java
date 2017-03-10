/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: dongjingjun
 * date: 2016-04-11
 */
package com.beautifulchina.base;

import com.alibaba.fastjson.JSONObject;
import com.beautifulchina.dao.language.LanguageMapper;
import com.beautifulchina.language.pojo.Language;
import com.beautifulchina.util.ReflectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

public class BaseService {
    @Autowired
    public LanguageMapper languageMapper;

    /**
     * 获取多言值
     *
     * @param clazz
     * @param jsonString
     * @return
     */
    public Object getMultiLanguage(Class clazz, String jsonString, String local) throws IllegalAccessException, InstantiationException {
        Object object = clazz.newInstance();
        List<Language> languages = new ArrayList<Language>();
        JSONObject jsonObject = JSONObject.parseObject(jsonString);
        Set<String> keys = jsonObject.keySet();
        Map<String, JSONObject> jsonMap = new HashMap<String, JSONObject>();
        for (String key : keys) {
            jsonMap.put(key, jsonObject.getJSONObject(key));
        }
        String uuid;
        for (String childKey : jsonMap.get(local).keySet()) {
            uuid = UUID.randomUUID().toString().replace("-", "");
            ReflectionUtils.setFieldValue(object, childKey, uuid);
            for (Map.Entry<String, JSONObject> map : jsonMap.entrySet()) {
                Language language = new Language();
                language.setType(map.getKey());
                if (map.getValue().getString(childKey) != null) {
                    language.setContent(map.getValue().getString(childKey));
                } else {
                    language.setContent("");
                }
                language.setUuid(uuid);
                languages.add(language);
            }
        }
        languageMapper.insertLanguage(languages);
        return object;
    }
}
