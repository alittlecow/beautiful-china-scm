package com.beautifulchina.core.annotation;

import com.beautifulchina.core.support.MultiLanguageSerialize;
import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author pengx
 * @date 2017/3/13
 */
@Retention(RetentionPolicy.RUNTIME)
@JacksonAnnotationsInside
@JsonSerialize(using = MultiLanguageSerialize.class)
public @interface Local {
}
