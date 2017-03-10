/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: chengxuemin
 * date: 2016-01-11
 */

package com.beautifulchina.consultive.vo;

import com.beautifulchina.common.PageQuery;

/**
 * 咨询管理
 */
public class ConsultiveVO extends PageQuery {
    /**
     * id
     */
    private Integer id;

    /**
     * 线路id
     */
    private Integer tourId;

    /**
     * 内容
     */
    private String content;

    /**
     * QA状态
     */
    private String status;

    /**
     * 提问人id
     */
    private Integer userId;

    /**
     * 提问时间
     */
    private String time;

    /**
     * 回复内容
     */
    private String contentAn;

    /**
     * 回复人类型
     */
    private String type;

    /**
     * 线路名称(英)
     */
    private String tourName;

    /**
     * 语言
     */
    private String language;

    /**
     * 部门id
     */
    private Integer deptId;

    private String deptCode;

    private String email;

    private String nickname;

    /**
     * 级别代码
     */
    private String levelCode;

    public String getContentAn() { return contentAn;  }

    public void setContentAn(String contentAn) { this.contentAn = contentAn; }

    public String getType() { return type; }

    public void setType(String type) { this.type = type; }

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public Integer getTourId() { return tourId; }

    public void setTourId(Integer tourId) { this.tourId = tourId; }

    public String getContent() { return content; }

    public void setContent(String content) { this.content = content; }

    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status; }

    public Integer getUserId() { return userId; }

    public void setUserId(Integer userId) { this.userId = userId; }

    public String getTime() { return time; }

    public void setTime(String time) { this.time = time; }

    public String getTourName() {
        return tourName;
    }

    public void setTourName(String tourName) {
        this.tourName = tourName;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getLevelCode() {
        return levelCode;
    }

    public void setLevelCode(String levelCode) {
        this.levelCode = levelCode;
    }

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
