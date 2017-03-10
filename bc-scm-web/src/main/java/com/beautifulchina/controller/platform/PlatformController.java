/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: fengbaitong
 * date: 2015-11-25
 */
package com.beautifulchina.controller.platform;

import com.beautifulchina.base.BaseController;
import com.beautifulchina.common.Page;
import com.beautifulchina.exception.CommException;
import com.beautifulchina.page.config.PlatformConfig;
import com.beautifulchina.platform.bo.PlatformBO;
import com.beautifulchina.platform.pojo.Platform;
import com.beautifulchina.platform.vo.PlatformQuryVO;
import com.beautifulchina.service.platform.PlatformService;
import com.beautifulchina.user.bo.UserBO;
import com.beautifulchina.util.ParameterUtil;
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
 *平台用户管理控制器
 */
@Controller
@RequestMapping(value = "/platform")
public class PlatformController extends BaseController{

    private static Logger logger = LoggerFactory.getLogger(PlatformController.class);

    @Autowired
    private PlatformService platformService;

    /**
     * 获取平台用户列表
     */
    @RequestMapping(value = "list")
    @ResponseBody
    public Page<PlatformBO> list(PlatformQuryVO platformQuryVO,HttpServletRequest request){
        UserBO userBO = this.getUser(request);
        platformQuryVO.setLanguage(this.getLocal(request));
        Page<PlatformBO> page = platformService.getPlatformExtjsList(platformQuryVO,userBO);
        return page;
    }

    /**
     * 删除平台用户
     */
    @RequestMapping(value = "delete")
    @ResponseBody
    public Map<String,Object> delete(String ids) throws CommException {
        Map<String,Object> result = null;
        // TODO 权限判断
        if(ParameterUtil.isBlank(ids)){
            logger.info("删除用户失败 codes={}",ids);
            result = failResult("Parameter is null");
        }
        try{
            platformService.deletePlatformById(ids);
            result = successResult();
        }catch (Exception e){
            logger.error("删除用户失败",e);
            result = failResult();
        }

        return result;
    }

    /**
     * 保存平台用户
     */
    @RequestMapping(value = "save")
    @ResponseBody
    public Map<String,Object> save(@Valid Platform platform){
        // TODO 权限判断
        Map<String,Object> result = null;
        //验证用户登录名是否存在
        String loginName=platform.getLoginName();
        boolean isLoginNameExists = platformService.validateLoginName(loginName);
        if(isLoginNameExists){
            return failResult(PlatformConfig.platformMsg_100.name());
        }


        //验证邮箱是否被占用
        String email=platform.getEmail();
        boolean isEmailExists=platformService.validateEmail(email);
        if(isEmailExists){
            return failResult(PlatformConfig.platformMsg_101.name());
        }

        //保存
        try{
            platformService.savePlatform(platform);
            result = successResult();
        }catch (Exception e){
            logger.error("保存平台用户失败",e);
            result = failResult();
        }
        return result;
    }

    /**
     * 更新平台用户信息
     */
    @RequestMapping(value = "update")
    @ResponseBody
    public Map<String,Object> update(@Valid Platform platform){
        Map<String,Object> result = null;
        // 参数校验
        if(ParameterUtil.isBlank(platform.getId()+"")){
            logger.info("删除平台用户失败 id={}",platform.getId());
            result = failResult("Parameter is null");
        }
        // TODO 权限判断
        /**
         * 所有的Ajax请求自己处理异常返回 参照以下
         */


        try{
            platformService.updatePlatform(platform);
            result = successResult();
        }catch (Exception e){
            logger.error("更新平台用户失败",e);
            result = failResult();
        }

        return result;
    }

//    /**
//     * 验证平台用户名是否存在信息
//     */
//    @RequestMapping(value = "validate")
//    @ResponseBody
//    public Map<String,Object> validate(HttpServletRequest req){
//        Map<String,Object> result = null;
//        String loginName=req.getParameter("loginName");
//        try{
//            String validate=platformService.validateLoginName(loginName)? "Y":"N";
//            result = new HashMap<String, Object>();
//            result.put("result",validate);
//        }catch (Exception e){
//            logger.error("验证用户名失败",e);
//            result = failResult();
//        }
//
//        return result;
//    }
}
