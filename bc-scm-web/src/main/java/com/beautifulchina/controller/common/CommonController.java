/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: chenghuanhuan
 * date: 2015-12-14
 */
package com.beautifulchina.controller.common;

import com.beautifulchina.base.BaseController;
import com.beautifulchina.city.bo.CityBO;
import com.beautifulchina.common.Page;
import com.beautifulchina.common.vo.CityQueryVO;
import com.beautifulchina.service.common.CommonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.support.RequestContext;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;


/**
 * 公共控制器
 */

@Controller
@RequestMapping(value = "/common")
public class CommonController extends BaseController{

    private static Logger logger = LoggerFactory.getLogger(CommonController.class);


    @Autowired
    private CommonService commonService;

    /**
     * 获取key/value值
     * @param list
     * @param request
     * @return
     */
    @RequestMapping(value = "query")
    @ResponseBody
    public List<Map<String,Object>> queryMenus(List<String> list, HttpServletRequest request){
        //从后台代码获取国际化信息
        RequestContext requestContext = new RequestContext(request);
        String value = requestContext.getMessage("");
        return null;
    }

    /**
     * 城市查询下拉框
     * @param cityQueryVO
     * @param request
     * @return
     */
    @RequestMapping(value = "queryCity")
    @ResponseBody
    public Page<CityBO> queryCity(@Valid CityQueryVO cityQueryVO, HttpServletRequest request){
        String language = this.getLocal(request);
        Page<CityBO> cityBOPage = commonService.queryCityList(cityQueryVO,language);
        return cityBOPage;
    }
}
