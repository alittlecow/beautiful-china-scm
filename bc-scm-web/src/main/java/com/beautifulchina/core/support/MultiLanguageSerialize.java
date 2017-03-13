package com.beautifulchina.core.support;

import com.beautifulchina.core.annotation.Local;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @author pengx
 * @date 2017/3/13
 */

@Service
public class MultiLanguageSerialize extends JsonSerializer<Object> implements ContextualSerializer, ApplicationContextAware {

    private static ApplicationContext applicationContext;


    @Override
    public void serialize(Object o, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {

        if(o != null)
        {
            Object val = ((MultiLanguageSupport) applicationContext.getBean("languageRepository")).getLanguageContent((String) o, "en");
            o = val == null ? o : val;
        }
        jsonGenerator.writeObject(o);
    }

    @Override
    public JsonSerializer<?> createContextual(SerializerProvider serializerProvider, BeanProperty beanProperty) throws JsonMappingException {
        if (beanProperty != null) {
            Local local = beanProperty.getAnnotation(Local.class);
            if (local != null) {
                return new MultiLanguageSerialize();
            }
            return serializerProvider.findValueSerializer(beanProperty.getType(), beanProperty);
        }
        return serializerProvider.findNullValueSerializer(beanProperty);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext  ;
    }
}
