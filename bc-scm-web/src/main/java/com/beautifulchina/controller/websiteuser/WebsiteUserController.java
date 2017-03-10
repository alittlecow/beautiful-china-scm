/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: chengxuemin
 * date: 2015-12-11
 */
package com.beautifulchina.controller.websiteuser;

import com.beautifulchina.base.BaseController;
import com.beautifulchina.common.Page;
import com.beautifulchina.main.bo.WebsiteUserListBO;
import com.beautifulchina.service.websiteuser.WebsiteUserService;
import com.beautifulchina.user.bo.UserBO;
import com.beautifulchina.websiteuser.vo.WebsiteUserVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Map;
/**
 * 网站用户管理控制器
 */
@Controller
@RequestMapping(value = "/websiteuser")
public class WebsiteUserController extends BaseController {

    private static Logger logger = LoggerFactory.getLogger(WebsiteUserController.class);

    @Autowired
    private WebsiteUserService websiteuserService;

    /**
     * 查询网站用户信息列表
     * @param websiteuserVO
     * @return
     */
    @RequestMapping(value = "query")
    @ResponseBody
    public Page<WebsiteUserListBO> queryWebsiteUser(@Valid WebsiteUserVO websiteuserVO) {
        Page<WebsiteUserListBO> page = websiteuserService.getAllWebsiteUserList(websiteuserVO);
        return page;
    }

    /**
     * 冻结:更新网站用户信息
     * @param websiteuserVO
     * @return
     */
    @RequestMapping(value = "update")
    @ResponseBody
    public Map<String,Object> update(@Valid WebsiteUserVO websiteuserVO, HttpServletRequest request){
        Map<String,Object> result = null;
        try{
            UserBO userBO = this.getUser(request);
            websiteuserService.freezeWebsiteUser(websiteuserVO,userBO);
            result = successResult();
        }catch (Exception e){
            logger.error("冻结:更新网站用户信息失败",e);
            result = failResult();
        }
        return result;
    }


}
