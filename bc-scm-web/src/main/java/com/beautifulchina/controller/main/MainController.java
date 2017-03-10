/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: chenghuanhuan
 * date: 2015-11-16
 */
package com.beautifulchina.controller.main;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.beautifulchina.base.BaseController;
import com.beautifulchina.constants.CommonEnum;
import com.beautifulchina.main.bo.MenuExtjsBO;
import com.beautifulchina.main.bo.ModuleExtjsBO;
import com.beautifulchina.main.bo.PlateExtjsBO;
import com.beautifulchina.service.menu.MenuService;
import com.beautifulchina.user.bo.UserBO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.support.RequestContext;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * 主页面控制器
 */
@Controller
@RequestMapping(value = "/main")
public class MainController extends BaseController{

    private static Logger logger = LoggerFactory.getLogger(MainController.class);

    @Autowired
    private MenuService menuService;

    /**
     * 获取用户拥有的板块
     * @return
     */
    @RequestMapping(value = "plates")
    @ResponseBody
    public List<PlateExtjsBO> getPlates(HttpServletRequest request){
        String userId = "";// TODO 从session中获取
        String language = this.getLocal(request);
        String roleCode=this.getUser(request).getRoleBO().getRoleCode();
        List<PlateExtjsBO> plateBOList = menuService.getPlateExtjsList(userId,language,roleCode);

        return plateBOList;
    }

    /**
     * 获取用户拥有的模块
     * @param plateId
     * @return
     */
    @RequestMapping(value = "modules")
    @ResponseBody
    public List<ModuleExtjsBO> getModules(String plateId,HttpServletRequest request){
        String userId = "";// TODO 从session中获取
        String language = this.getLocal(request);
        String roleCode=this.getUser(request).getRoleBO().getRoleCode();
        List<ModuleExtjsBO> moduleBOList = menuService.getModuleList(userId, plateId,language,roleCode);

        return moduleBOList;
    }

    /**
     * 获取用户菜单
     * @param plateId
     * @param moduleId
     * @return
     */
    @RequestMapping(value = "menus")
    @ResponseBody
    public Map<String,List<MenuExtjsBO>> getMenus(String plateId,String moduleId,HttpSession session,HttpServletRequest request){
        String language = this.getLocal(request);
        logger.info("=================="+language);
        UserBO userBO = (UserBO)session.getAttribute(CommonEnum.SESSION_KEY_USER.getValue());
        String roleCode = userBO.getRoleBO().getRoleCode();
        List<MenuExtjsBO> menuBOList = menuService.getMenu(plateId,moduleId,roleCode,language);
        Map<String,List<MenuExtjsBO>> listMap = new HashMap<String, List<MenuExtjsBO>>();
        listMap.put("treeList",menuBOList);
        return listMap;
    }

    /**
     * 获取公共的国际化资源
     * @return
     */
    @RequestMapping(value = "properties")
    @ResponseBody
    public Map<String,Object> properties(HttpServletRequest request,String config) throws ClassNotFoundException {
        Map<String,Object> listMap = new HashMap<String, Object>();

        //从后台代码获取国际化信息
        RequestContext requestContext = new RequestContext(request);
        Class<?> clazz = Class.forName("com.beautifulchina.page.config."+config);
        Field[] fields = clazz.getFields();
        for(Field field:fields){
            String fieldName = field.getName();
            String message = requestContext.getMessage(fieldName);
            if(fieldName.lastIndexOf("_JSON")>-1){
                JSONArray jsonArray = JSON.parseArray(message);
                listMap.put(field.getName(),jsonArray);
            }else {
                listMap.put(field.getName(),message);
            }
        }
        return listMap;
    }

    @ResponseBody
    @RequestMapping("/{langType}")
    public Map<String,Object> languageSet(@PathVariable String langType,  HttpServletRequest request, HttpServletResponse response){
        CookieLocaleResolver cookieLocaleResolver = new CookieLocaleResolver();
        if ("zh_CN".equals(langType)) {
            Locale locale = new Locale("zh", "CN");
            cookieLocaleResolver.setLocale(request, response, locale);
        } else if ("fr_FR".equals(langType)) {
            Locale locale = new Locale("fr", "FR");
            cookieLocaleResolver.setLocale(request, response, locale);
        } else {
            cookieLocaleResolver.setLocale(request, response, new Locale("en", "US"));
        }
        return successResult();
    }

    @ResponseBody
    @RequestMapping(value = "exit")
    public Map<String,Object> exit( HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        Cookie[] cookies = request.getCookies();

        try
        {
            //清空session
            session.removeAttribute(CommonEnum.SESSION_KEY_USER.getValue());
            //清空cookie
            for(int i=0;i<cookies.length;i++)
            {
                Cookie cookie = new Cookie(cookies[i].getName(), null);
                cookie.setMaxAge(0);
                response.addCookie(cookie);
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return successResult();
    }
}
