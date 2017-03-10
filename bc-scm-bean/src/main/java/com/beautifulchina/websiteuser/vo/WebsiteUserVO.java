/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: chengxuemin
 * date: 2015-12-11
 */
package com.beautifulchina.websiteuser.vo;

import com.beautifulchina.common.PageQuery;

import java.util.Date;

/**
 * 网站用户管理业务,前台传入
 */
public class WebsiteUserVO extends PageQuery  {
    /**
     * id代码
     */
    private String id;

    /**
     * 姓名代码
     */
    private String name;

    /**
     * 昵称代码
     */
    private String nickName;

    /**
     * 邮箱代码
     */
    private String email;

    /**
     * 性别代码
     */
    private String sex;

    /**
     * 护照号代码
     */
    private String passport;

    /**
     * 状态代码
     */
    private String status;

    /**
     * 冻结时间代码
     */
    private Date lockTime;

    /**
     * 冻结原因代码
     */
    private String lockReson;

    /**
     * 注册时间代码
     */
    private String regTime;

    /**
     * 总积分代码
     */
    private String point;

    /**
     * 可用积分代码
     */
    private String usablePoint;

    /**
     * 用户类型代码
     */
    private String type;

    /**
     * facebook账号代码
     */
    private String faceBookName;

    /**
     * 最后登录ip代码
     */
    private String ip;

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getNickName() { return nickName; }

    public void setNickName(String nickName) { this.nickName = nickName; }

    public String getStatus() {  return status; }

    public void setStatus(String status) { this.status = status; }

    public String getType() { return type; }

    public void setType(String type) { this.type = type; }

    public String getIp() { return ip; }

    public void setIp(String ip) { this.ip = ip; }

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getSex() { return sex; }

    public void setSex(String sex) { this.sex = sex; }

    public String getPassport() { return passport; }

    public void setPassport(String passport) { this.passport = passport; }

    public Date getLockTime() { return lockTime; }

    public void setLockTime(Date lockTime) { this.lockTime = lockTime; }

    public String getLockReson() { return lockReson; }

    public void setLockReson(String lockReson) { this.lockReson = lockReson; }

    public String getRegTime() { return regTime; }

    public void setRegTime(String regTime) { this.regTime = regTime; }

    public String getPoint() { return point; }

    public void setPoint(String point) { this.point = point; }

    public String getUsablePoint() { return usablePoint; }

    public void setUsablePoint(String usablePoint) { this.usablePoint = usablePoint; }

    public String getFaceBookName() { return faceBookName; }

    public void setFaceBookName(String faceBookName) { this.faceBookName = faceBookName; }
}
