package com.beautifulchina.core.service;

import com.beautifulchina.core.support.MultiLanguageSupport;
import com.beautifulchina.dao.language.LanguageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * @author pengx
 * @date 2017/3/13
 */
@Repository("languageRepository")
public class LanguageDataRepository implements MultiLanguageSupport {
    @Autowired
    LanguageMapper languageMapper;

    @Override
    public String getLanguageContent(String key, String local) {
        Map<String, String> params = new HashMap<String, String>();
        params.put("key", key);
        params.put("local", local);
        return languageMapper.getLanguageContent(params);
    }
}
