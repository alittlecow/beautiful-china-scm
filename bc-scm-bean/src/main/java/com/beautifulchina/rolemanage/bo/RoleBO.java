/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: dongjingjun
 * date: 2015-12-21
 */
package com.beautifulchina.rolemanage.bo;

import com.beautifulchina.rolemanage.vo.RoleVO;

import java.util.Date;

/**
 * 角色业务
 */
public class RoleBO extends RoleVO {
    /**
     * 操作时间
     */
    private Date operateTime;
    /**
     * 操作人
     */
    private String operatingPersonnel;

    public Date getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
    }

    public String getOperatingPersonnel() {
        return operatingPersonnel;
    }

    public void setOperatingPersonnel(String operatingPersonnel) {
        this.operatingPersonnel = operatingPersonnel;
    }
}
