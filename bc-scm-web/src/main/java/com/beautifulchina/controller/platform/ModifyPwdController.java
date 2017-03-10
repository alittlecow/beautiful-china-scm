/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 * @author: zhangyun
 * date: 2016-01-29
 */
package com.beautifulchina.controller.platform;

import com.beautifulchina.base.BaseController;
import com.beautifulchina.common.Page;
import com.beautifulchina.handle.PropertyHandler;
import com.beautifulchina.mailtemplate.bo.MailTemplateBO;
import com.beautifulchina.mailtemplate.vo.MailTemplateVO;
import com.beautifulchina.platform.bo.PlatformBO;
import com.beautifulchina.platform.vo.PlatformVO;
import com.beautifulchina.service.mailhistory.MailHistoryService;
import com.beautifulchina.service.mailtemplate.MailTemplateService;
import com.beautifulchina.service.platform.ModifyPwdService;
import com.beautifulchina.service.util.EmailUtil;
import com.beautifulchina.util.MD5Util;
import com.beautifulchina.util.ParameterUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by zhangyun on 2016/1/29.
 * 修改密码控制器
 */
@Controller
@RequestMapping(value = "resetPassword")
public class ModifyPwdController extends BaseController {
    @Autowired
    private ModifyPwdService modifyPwdService;
    @Autowired
    private MailHistoryService mailHistoryService;
    @Autowired
    private MailTemplateService mailTemplateService;
    /**
     * 重置密码页面
     * @param request
     * @param model
     * @return
     * @throws ParseException
     */
    @RequestMapping(method= RequestMethod.GET)
    public String resetPassword(HttpServletRequest request,Model model) throws ParseException {
        long id=Long.parseLong(request.getParameter("id"));
        String authcode=request.getParameter("authcode");
        PlatformBO platformBO=modifyPwdService.selectByAuthcode(id,authcode);
        //链接错误
        if(platformBO==null){
            model.addAttribute("error","Link error");
            return "error";
        }
        //计算时间差，超过24小时链接失效
        String operateTime=platformBO.getOperatetime();
        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date operateDate=sdf.parse(operateTime);//异常
        Date now=new Date();
        //申请链接的时间与当前申请时间转换成long型进行对比
        long operateLong=operateDate.getTime();
        long nowLong=now.getTime();
        long diff = nowLong - operateLong;
        long diffSeconds = diff/1000;
        if(diffSeconds>86400){
            model.addAttribute("error","Have failed, please apply again");//超时
            return "error";
        }else{
            model.addAttribute("username",platformBO.getLoginName());
            return "modifyPwd";
        }
    }

    /**
     * 验证邮箱是否已注册
     * @param platformVO
     * @return
     */
    @RequestMapping(value="uniqueEmail")
    @ResponseBody
    public Map<String, Object> uniqueEmail(@RequestBody PlatformVO platformVO){
        Map<String, Object> result=null;
        String email=platformVO.getEmail();
        PlatformBO platformBO=modifyPwdService.getUserByEmail(email);
        if(platformBO!=null){
            result = successResult();//返回"ok",说明邮箱已注册
        }else{
            result = failResult();
        }
        return result;
    }

    /**
     * 发送重置密码链接
     * @param platformVO
     * @return
     */
    @RequestMapping(value="sendEmail")
    @ResponseBody
    public Map<String, Object> sendEmail(@RequestBody PlatformVO platformVO,MailTemplateVO mailTemplateVO,HttpServletRequest request){
        Map<String, Object> result=null;
        String email=platformVO.getEmail();//邮箱地址
        //根据邮箱获得用户信息
        PlatformBO platformBO=modifyPwdService.getUserByEmail(email);
        //生成20位的随机码
        List<String> list=new ArrayList<String>();
        for(int i=0;i<=9;i++){
            list.add(String.valueOf(i));
        }
        for(char i='a';i<='z';i++){
            list.add(String.valueOf(i));
        }
        for(char i='A';i<='Z';i++){
            list.add(String.valueOf(i));
        }
        String authcode="";
        Random rd=new Random();
        for(int i=0;i<20;i++){
            int t=rd.nextInt(61);
            String s=list.get(t);
            authcode=authcode+s;
        }
        //选取邮件模板
        Page<MailTemplateBO> menuListBOPage=mailTemplateService.getMailTemplateExtjsList(mailTemplateVO);
        //重置密码模板id为2
        MailTemplateBO mailTemplateBO=new MailTemplateBO();
        for(int i=0;i<menuListBOPage.getData().size();i++){
            if(menuListBOPage.getData().get(i).getId()==2){
                mailTemplateBO=menuListBOPage.getData().get(i);
            }
        }
        //提取主题，内容模板
        String language=this.getLocal(request);
        String title=null;
        String content=null;
        if(language.equals("en")){
            title=mailTemplateBO.getTitleEn();
            content=mailTemplateBO.getContentEn();
        }else if(language.equals("fr")){
            title=mailTemplateBO.getTitleFr();
            content=mailTemplateBO.getContentFr();
        }
        String domain= PropertyHandler.getProperty("beautifulChina.localhost.domain");//域名
        content=content.replaceAll("#domain#",domain);//替换域名
        content=content.replaceAll("#id#",String.valueOf(platformBO.getId()));//替换用户ID
        content=content.replaceAll("#authcode#",authcode);//替换随机码
        //发送邮件，并保存邮件历史记录
        EmailUtil.sendEmail(title, content, email, "");
        long userId=platformBO.getId();
        mailHistoryService.saveEmailHistory(title,content,userId,email);
        //用户表更新随机码和操作时间
        modifyPwdService.saveAuthcode(userId,authcode);
        result=successResult();
        return result;
    }


    /**
     * 重置密码
     * @param platformVO
     * @return
     */
    @RequestMapping(value="reset")
    @ResponseBody
    public Map<String, Object> reset(@RequestBody PlatformVO platformVO){
        Map<String, Object> result = null;
        try{
            String password=platformVO.getPassword();
            String pwd= MD5Util.getDecryptLoginPassword(password);//解密，判断长度
            //password不为空
            //密码长度不少于6
            if(!ParameterUtil.isBlankParams(password)&&
                    pwd.length()>=6){
                modifyPwdService.resetPasswordByLoginName(platformVO);
                result = successResult();
            }
        }catch (Exception e){
            result=failResult();
        }
        return result;
    }
}
