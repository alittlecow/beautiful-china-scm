/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: dongjingjun
 * date: 2015-12-21
 */
package com.beautifulchina.rolemanage.bo;

import com.beautifulchina.rolemanage.vo.RoleMenuVO;

import java.util.Date;

/**
 * 角色菜单业务
 */
public class RoleMenuBO extends RoleMenuVO {
    /**
     * 操作时间
     */
    private Date operateTime;
    /**
     * 操作人
     */
    private String loginName;

    public Date getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }
}
