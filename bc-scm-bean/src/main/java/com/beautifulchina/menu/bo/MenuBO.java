/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: chenghuanhuan
 * date: 2015-11-19
 */
package com.beautifulchina.menu.bo;

import com.beautifulchina.menu.vo.MenuVO;

import java.util.Date;

/**
 * 菜单业务
 */
public class MenuBO extends MenuVO{
    /**
     * 操作时间
     */
    private Date operateTime;
    /**
     * 操作人
     */
    private String operator;

    public Date getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }
}
