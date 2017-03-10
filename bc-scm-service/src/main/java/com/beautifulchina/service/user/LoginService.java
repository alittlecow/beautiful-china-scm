/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: chenghuanhuan
 * date: 2015-12-10
 */
package com.beautifulchina.service.user;

import com.beautifulchina.dao.deptinfo.DeptInfoMapper;
import com.beautifulchina.dao.platform.PlatformMapper;
import com.beautifulchina.dao.rolemanage.RoleManageMapper;
import com.beautifulchina.deptinfo.bo.DeptInfoBO;
import com.beautifulchina.platform.bo.PlatformBO;
import com.beautifulchina.platform.pojo.Platform;
import com.beautifulchina.platform.vo.PlatformVO;
import com.beautifulchina.rolemanage.bo.RoleBO;
import com.beautifulchina.user.vo.UserVO;
import com.beautifulchina.util.MD5Util;
import com.beautifulchina.util.SecurityUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * 登录服务
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class LoginService {

    @Autowired
    private PlatformMapper platformMapper;

    @Autowired
    private RoleManageMapper roleManageMapper;

    @Autowired
    private DeptInfoMapper deptInfoMapper;
    /**
     * 平台用户登录
     * @param platformVO
     * @return
     */
    public boolean platformUserLogin(PlatformVO platformVO,PlatformBO platformBO){
        boolean ret = false;
        if(platformBO != null){
            String password = platformBO.getPassword();
            String psw = platformBO.getPsw();
            String pwd = MD5Util.getDecryptLoginPassword(platformVO.getPassword());
            // 密码采用加盐处理
            String encryptPassword = SecurityUtil.getStoreLogpwd(platformVO.getUsername(),pwd , psw);

            // 密码比较
            if(encryptPassword.equals(password)){
                ret = true;
            }
        }
        return ret;
    }

    /**
     * 根据用户名获取用户信息
     * @param username
     * @return
     */
    public PlatformBO getPlatformByUsername(String username){
        PlatformBO platformBO = null;
        PlatformVO platformVO = new PlatformVO();
        platformVO.setUsername(username);
        Platform platform = platformMapper.login(platformVO);
        if (platform!=null) {
            platformBO = new PlatformBO();
            BeanUtils.copyProperties(platform, platformBO);
        }

        return platformBO;
    }

    /**
     * 根据角色代码获取角色信息
     * @param roleCode
     * @return
     */
    public RoleBO getRoleByRoleCode(String roleCode){
        RoleBO  roleBO = roleManageMapper.getRoleByRoleCode(roleCode);
        if(roleBO ==null){
            roleBO = new RoleBO();
        }
        return roleBO;
    }

    /**
     * 根据deptCode获取部门信息
     * @return
     */
    public DeptInfoBO getDeptInfoByDeptCode(String deptCode){
        DeptInfoBO deptInfoBO = deptInfoMapper.getDeptInfoByDeptCode(deptCode);
        if(deptInfoBO == null){
            deptInfoBO = new DeptInfoBO();
        }
        return deptInfoBO;
    }

    /**
     * author:fengbaitong
     * 保存用户最后登录的ip,时间
     * @param userVO
     */
    public void saveLoginMessage(UserVO userVO){
        platformMapper.saveLoginMessage(userVO);
    }
}
