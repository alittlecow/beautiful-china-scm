/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 * @author: chenghuanhuan
 * date: 2015-10-22
 */
package com.beautifulchina.controller.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;


/**
 * rest风格
 */
@Controller
@RequestMapping("rest")
public class RestController {

    @RequestMapping(value="/user/{id}",method=RequestMethod.GET)
    public String get(@PathVariable("id") Integer id,HttpServletRequest request,HttpServletResponse response){
        //new CookieLocaleResolver().setLocale(request, response, new Locale("en", "US"));
        System.out.println("get"+id);
        return "hello";
    }

    @RequestMapping(value="/user/{id}",method= RequestMethod.POST)
    public String post(@PathVariable("id") Integer id){
        System.out.println("post"+id);
        return "/hello";
    }

    @RequestMapping(value="/user/{id}",method=RequestMethod.PUT)
    public String put(@PathVariable("id") Integer id){
        System.out.println("put"+id);
        return "/hello";
    }

    @RequestMapping(value="/user/{id}",method=RequestMethod.DELETE)
    public String delete(@PathVariable("id") Integer id,HttpServletRequest request,HttpServletResponse response){
        System.out.println("delete"+id);
        new CookieLocaleResolver().setLocale(request, response, new Locale("en", "US"));
        return "/hello";
    }
}
