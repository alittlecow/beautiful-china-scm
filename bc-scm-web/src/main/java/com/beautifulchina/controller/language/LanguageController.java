/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: dongjingjun
 * date: 2016-04-11
 */
package com.beautifulchina.controller.language;

import com.beautifulchina.base.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 多语言控制器
 */
@Controller
@RequestMapping(value = "/language")
public class LanguageController extends BaseController {
    @ResponseBody
    @RequestMapping(value = "getCountry")
    public String[] getCountry() {
        return this.getLanguage();
    }
}
