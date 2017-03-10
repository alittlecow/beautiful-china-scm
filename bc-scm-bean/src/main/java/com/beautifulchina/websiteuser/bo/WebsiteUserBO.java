/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: chengxuemin
 * date: 2015-12-11
 */
package com.beautifulchina.websiteuser.bo;

import com.beautifulchina.websiteuser.vo.WebsiteUserVO;

import java.util.Date;
/**
 * 网站用户管理业务
 */
public class WebsiteUserBO extends WebsiteUserVO {
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

    public void setOperateTime(Date operateTime) { this.operateTime = operateTime; }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) { this.operator = operator; }
}
