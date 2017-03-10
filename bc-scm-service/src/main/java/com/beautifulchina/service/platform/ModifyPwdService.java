/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: zhangyun
 * date: 2016/1/29
 */
package com.beautifulchina.service.platform;

import com.beautifulchina.dao.platform.ModifyPwdMapper;
import com.beautifulchina.platform.bo.PlatformBO;
import com.beautifulchina.platform.vo.PlatformVO;
import com.beautifulchina.util.DateUtil;
import com.beautifulchina.util.MD5Util;
import com.beautifulchina.util.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhangyun on 2016/1/29.
 * 忘记密码服务
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ModifyPwdService {
    @Autowired
    private ModifyPwdMapper modifyPwdMapper;

    /**
     * 根据邮箱获得用户信息
     * @param email
     * @return
     */
    public PlatformBO getUserByEmail(String email){
        return modifyPwdMapper.getUserByEmail(email);
    }

    /**
     * 用户表更新随机码和操作时间
     * @param id
     * @param authcode
     */
    public void saveAuthcode(long id,String authcode){
        //获取当前时间
        String datetime= DateUtil.getCurrentDate();
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("id",id);
        map.put("authcode",authcode);
        map.put("operatetime",datetime);
        modifyPwdMapper.saveAuthcode(map);
    }

    /**
     * 根据邮件提示的参数id和随机码查询是否存在该邮件
     * @param id
     * @param authcode
     * @return
     */
    public PlatformBO selectByAuthcode(long id,String authcode){
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("id",id);
        map.put("authcode",authcode);
        return modifyPwdMapper.selectByAuthcode(map);
    }

    /**
     * 根据id重置密码
     * @param platformVO
     */
    public void resetPasswordByLoginName(PlatformVO platformVO){
        platformVO = this.setPassword(platformVO);
        modifyPwdMapper.resetPasswordByLoginName(platformVO);
    }
    private PlatformVO setPassword(PlatformVO platformVO){
        String pwd = MD5Util.getDecryptLoginPassword(platformVO.getPassword());
        String psw = SecurityUtil.getNewPsw();
        // 密码采用加盐处理
        String encryptPassword = SecurityUtil.getStoreLogpwd(platformVO.getLoginName(),pwd , psw);
        platformVO.setPassword(encryptPassword);
        platformVO.setPsw(psw);
        return platformVO;
    }
}
