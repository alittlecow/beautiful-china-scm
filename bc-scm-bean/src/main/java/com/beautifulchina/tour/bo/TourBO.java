/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: dongjingjun
 * date: 2015-12-25
 */
package com.beautifulchina.tour.bo;

import com.beautifulchina.tour.vo.TourVO;

import java.util.Date;

/**
 * 旅游线路业务
 */
public class TourBO extends TourVO {
    /**
     * 操作时间
     */
    private Date operateTime;
    /**
     * 出发城市法语
     */
    private String startCityFr;
    /**
     * 结束城市法语
     */
    private String endCityFr;
    /**
     * 类别
     */
    private Integer category;
    /**
     * 操作人
     */
    private String operator;
    /**
     * 配置英文名
     */
    private String contentEn;
    /**
     * 配置法语名
     */
    private String contentFr;
    /**
     * 配置类型
     */
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContentEn() {
        return contentEn;
    }

    public void setContentEn(String contentEn) {
        this.contentEn = contentEn;
    }

    public String getContentFr() {
        return contentFr;
    }

    public void setContentFr(String contentFr) {
        this.contentFr = contentFr;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getStartCityFr() {
        return startCityFr;
    }

    public void setStartCityFr(String startCityFr) {
        this.startCityFr = startCityFr;
    }

    public String getEndCityFr() {
        return endCityFr;
    }

    public void setEndCityFr(String endCityFr) {
        this.endCityFr = endCityFr;
    }

    public Date getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
    }

}
