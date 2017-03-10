/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: chenghuanhuan
 * date: 2015-12-10
 */
package com.beautifulchina.controller.user;

import com.beautifulchina.base.BaseController;
import com.beautifulchina.constants.CommonEnum;
import com.beautifulchina.constants.UserCenterErrorCode;
import com.beautifulchina.deptinfo.bo.DeptInfoBO;
import com.beautifulchina.platform.bo.PlatformBO;
import com.beautifulchina.platform.vo.PlatformVO;
import com.beautifulchina.rolemanage.bo.RoleBO;
import com.beautifulchina.service.user.LoginService;
import com.beautifulchina.user.bo.UserBO;
import com.beautifulchina.user.vo.UserVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * 登录
 */
@Controller
@RequestMapping(value = "/login")
public class LoginController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private LoginService loginService;

    @RequestMapping(method = RequestMethod.GET)
    public String index(){
        return "login";
    }


    /**
     * 登录
     * @param platformVO
     * @param request
     * @return
     */
    @RequestMapping("platformLogin")
    @ResponseBody
    public Map<String,Object> platformUserLogin(@Valid PlatformVO platformVO, HttpServletRequest request){

        // 判断用户是否存在
        PlatformBO platformBO = loginService.getPlatformByUsername(platformVO.getUsername());

        if(platformBO!=null) {
            // 验证用户名密码
            boolean isTrue = loginService.platformUserLogin(platformVO, platformBO);
            if (isTrue){
                HttpSession session = request.getSession();
                UserBO userBO = new UserBO();
                userBO.setId(platformBO.getId());
                userBO.setName(platformBO.getUsername());
                userBO.setPhoto("/app/resources/images/2.png");
                userBO.setUsername(platformBO.getUsername());
                RoleBO roleBO = loginService.getRoleByRoleCode(platformBO.getRoleCode());
                userBO.setRoleBO(roleBO);
                DeptInfoBO deptInfoBO = loginService.getDeptInfoByDeptCode(platformBO.getDeptCode());
                userBO.setDeptInfoBO(deptInfoBO);
                session.setAttribute(CommonEnum.SESSION_KEY_USER.getValue(),userBO);

                //保存登录的信息,包括最后登录时间,登录ip地址,作者:fengbaitong,begin
                UserVO userVO = new UserVO();
                userVO.setLoginName(userBO.getUsername());
                userVO.setLastLoginIp(getIp(request));
                SimpleDateFormat myFmt=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                userVO.setLastLoginTime(myFmt.format(new Date()));
                loginService.saveLoginMessage(userVO);
                //保存登录的信息,包括最后登录时间,登录ip地址.end

                return successDataResult(userBO);
            }
        }else {
            return failResult(UserCenterErrorCode.LOGIN_100000);
        }

        return failResult(UserCenterErrorCode.LOGIN_100001);
    }

    /**
     * 获取客户端IP
     * author:fengbaitong
     * @param request
     * @return
     */
    public static String getIp(HttpServletRequest request) {
        String remoteAddr = request.getRemoteAddr();
        String forwarded = request.getHeader("X-Forwarded-For");
        String realIp = request.getHeader("X-Real-IP");

        String ip = null;
        if (realIp == null) {
              if (forwarded == null) {
                   ip = remoteAddr;
                     } else {
                         ip = remoteAddr + "/" + forwarded;
                     }
             } else {
                 if (realIp.equals(forwarded)) {
                         ip = realIp;
                     } else {
                         ip = realIp + "/" + forwarded.replaceAll(", " + realIp, "");
                     }
             }
         return ip;
    }
}
