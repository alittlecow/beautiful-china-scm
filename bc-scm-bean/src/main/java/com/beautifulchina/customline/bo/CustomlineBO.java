/**
 * Copyright @ 2016 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: zhangyu
 * date: 2016-1-6
 */


package com.beautifulchina.customline.bo;

import com.beautifulchina.customline.vo.CustomlineVO;

import java.util.Date;

/**
 * Created by zhangyu on 2016/1/6.
 * 定制线路
 */
public class CustomlineBO extends CustomlineVO {
    /**
     *
     *姓名
     */
    private String name;

    /**
     *
     *创建时间
     */
    private Date createTime;

    /**
     *
     * email
     */
    private String email;

    /**
     *
     * 电话
     */
    private String phone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
