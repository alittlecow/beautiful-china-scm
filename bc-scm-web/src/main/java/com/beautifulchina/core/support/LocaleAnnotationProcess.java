package com.beautifulchina.core.support;

import com.beautifulchina.city.vo.CityVO;
import com.beautifulchina.core.annotation.Locale;

import java.lang.reflect.Field;

/**
 * @author pengx
 * @date 2017/3/14
 */
public class LocaleAnnotationProcess {

    public Object doProcess(Object object, String locale) {
        Field[] fields = object.getClass().getDeclaredFields();

        for (Field field : fields) {
            Locale localeAnnotation = field.getAnnotation(Locale.class);
            if(localeAnnotation != null ){
                System.out.println("--------需要本地化的注解--------:"+field.getName());
            }
        }

        return null;
    }

    public static void main(String[] args) {
        CityVO cityVO = new CityVO();
        LocaleAnnotationProcess process = new LocaleAnnotationProcess();
        process.doProcess(cityVO, "en");
        System.out.println("end");

    }

}
