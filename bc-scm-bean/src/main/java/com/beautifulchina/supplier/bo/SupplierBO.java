/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: fengbaitong
 * date: 2015-12-10
 */
package com.beautifulchina.supplier.bo;

import com.beautifulchina.supplier.vo.SupplierVO;

import java.util.Date;

/**
 * 供应商
 */
public class SupplierBO extends SupplierVO {
    /**
     * 用户ID
     */
    private Integer  id;



    /**
     * 供应商地址
     */
    private String address;

    /**
     * 供应商电话
     */
    private String tel;


    /**
     * 供应商电话2
     */
    private String tel2;

    /**
     * 法人
     */
    private String legal;

    /**
     * 供应商描述
     */
    private String supDesc;



    /**
     * 供应商许可证
     */
    private String license;

    /**
     * 联系人
     */
    private String contact;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 网址
     */
    private String website;


    /**
     * 暂停备注
     */
    private String sRemark;

    /**
     * 驳回原因
     */
    private String rReason;

    /**
     * 注册时间
     */
    private Date regTime;

    /**
     * 审批人
     */
    private String approver;

    /**
     * 审批时间
     */
    private Date approveTime;

    /**
     * 盐值
     */
    private String psw;

    public String getPsw() {
        return psw;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getTel2() {
        return tel2;
    }

    public void setTel2(String tel2) {
        this.tel2 = tel2;
    }

    public String getLegal() {
        return legal;
    }

    public void setLegal(String legal) {
        this.legal = legal;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getsRemark() {
        return sRemark;
    }

    public void setsRemark(String sRemark) {
        this.sRemark = sRemark;
    }

    public String getrReason() {
        return rReason;
    }

    public void setrReason(String rReason) {
        this.rReason = rReason;
    }

    public Date getRegTime() {
        return regTime;
    }

    public void setRegTime(Date regTime) {
        this.regTime = regTime;
    }

    public String getApprover() {
        return approver;
    }

    public void setApprover(String approver) {
        this.approver = approver;
    }

    public Date getApproveTime() {
        return approveTime;
    }

    public void setApproveTime(Date approveTime) {
        this.approveTime = approveTime;
    }

    public String getSupDesc() {
        return supDesc;
    }

    public void setSupDesc(String supDesc) {
        this.supDesc = supDesc;
    }
}
