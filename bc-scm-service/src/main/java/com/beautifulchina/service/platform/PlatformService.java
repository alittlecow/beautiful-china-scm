/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: fengbaitong
 * date: 2015-11-25
 */
package com.beautifulchina.service.platform;

import com.beautifulchina.common.Page;
import com.beautifulchina.dao.platform.PlatformMapper;
import com.beautifulchina.exception.RedisException;
import com.beautifulchina.platform.bo.PlatformBO;
import com.beautifulchina.platform.pojo.Platform;
import com.beautifulchina.platform.vo.PlatformQuryVO;
import com.beautifulchina.user.bo.UserBO;
import com.beautifulchina.util.MD5Util;
import com.beautifulchina.util.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * 平台用户相关服务
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class PlatformService {

    @Autowired
    private PlatformMapper platformMapper;


    /**
     * 获取所有平台用户列表
     */
    @Transactional(propagation= Propagation.NOT_SUPPORTED,readOnly =true)
    public Page<PlatformBO> getPlatformExtjsList(PlatformQuryVO platformQuryVO,UserBO userBO){
        platformQuryVO.setDeptId(userBO.getDeptInfoBO().getId());
        platformQuryVO.setLevelCode(userBO.getDeptInfoBO().getLevelCode());
        int count=platformMapper.getPlatformCount(platformQuryVO);
        Page<PlatformBO> platformPage = new Page<PlatformBO>();
        if(count>0){
            List<PlatformBO> platformList= platformMapper.getAllUser(platformQuryVO);
            platformPage.setData(platformList);
            platformPage.setTotal(count);
        }
        return platformPage;
    }

    /**
     * 根据id编号删除平台用户
     */
    public void deletePlatformById(String ids){
        List<String> list = CollectionUtils.arrayToList(ids.split(","));
        platformMapper.delete(list);
    }

    /**
     * 保存平台用户
     */
    public void savePlatform(Platform platform) throws RedisException {

        platform = this.setPassword(platform);
        platformMapper.save(platform);
    }

    /**
     *  更改平台用户信息
     */
    public void updatePlatform(Platform platform ){
        if(!StringUtils.isEmpty(platform.getPassword())){
            this.setPassword(platform);
        }
        platformMapper.updatePlatform(platform);
    }

    private Platform setPassword(Platform platform){
        String pwd = MD5Util.getDecryptLoginPassword(platform.getPassword());
        String psw = SecurityUtil.getNewPsw();
        // 密码采用加盐处理
        String encryptPassword = SecurityUtil.getStoreLogpwd(platform.getLoginName(),pwd , psw);
        platform.setPassword(encryptPassword);
        platform.setPsw(psw);
        return platform;
    }

    /**
     * 验证用户登录名是否存在
     * @param loginName
     * @return
     */
    public Boolean validateLoginName(String loginName){
        Integer exsit=platformMapper.getByLoginName(loginName);
        if(exsit==0){
            return false;
        }
        return true;
    }

    /**
     * 验证邮箱是否存在
     * @param email
     * @return
     */
    public Boolean validateEmail(String email){
        Integer exsit=platformMapper.getByEmail(email);
        if(exsit==0){
            return false;
        }
        return true;
    }

}
