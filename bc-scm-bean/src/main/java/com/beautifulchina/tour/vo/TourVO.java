/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: dongjingjun
 * date: 2015-12-25
 */
package com.beautifulchina.tour.vo;

import com.beautifulchina.common.PageQuery;

import java.util.List;

/**
 * 旅游线路
 */
public class TourVO extends PageQuery {
    /**
     * 旅游线路id
     */
    private Integer id;
    /**
     * 线路代码
     */
    private String code;
    /**
     * 线路名称
     */
    private String title;
    /**
     * 天数
     */
    private Integer days;

    /**
     * 出发城市
     */
    private String startCityName;
    /**
     * 结束城市
     */
    private String endCityName;
    /**
     * 出发城市
     */
    private Integer startCity;
    /**
     * 结束城市
     */
    private Integer endCity;

    /**
     * 状态
     */
    private String status;
    /**
     * 线路所属供应商代码
     */
    private String deptCode;
    /**
     * 线路英文名称
     */
    private String titleEn;
    /**
     * 线路法文名称
     */
    private String titleFr;
    /**
     * 客户推荐度
     */
    private Integer rating;
    /**
     * 线路描述英文
     */
    private String descEn;
    /**
     * 线路描述法文
     */
    private String descFr;
    /**
     * 费用包含英文
     */
    private String includeEn;
    /**
     * 费用包含法文
     */
    private String includeFr;
    /**
     * 费用不包含英文
     */
    private String excludeEn;
    /**
     * 费用不包含法文
     */
    private String excludeFr;
    /**
     * 重要提示英文
     */
    private String importantEn;
    /**
     * 重要提示法文
     */
    private String importantFr;
    /**
     * 旅途提示英文
     */
    private String triphintEn;
    /**
     * 旅途提示法文
     */
    private String triphintFr;
    /**
     * 条款英文
     */
    private String termEn;
    /**
     * 条款法文
     */
    private String termFr;
    /**
     * 线路主题
     */
    private String theme;
    /**
     * 出发城市英语
     */
    private String startCityEn;
    /**
     * 结束城市英语
     */
    private String endCityEn;

    /**
     * 提前预定天数
     */
    private Integer advanceDays;
    /**
     * 副标题英
     */
    private String subTitleEn;
    /**
     * 副标题法
     */
    private String subTitleFr;
    /**
     * 封面序号
     */
    private List<Integer> cover;
    /**
     * 图片地址
     */
    private List<String> imageData;
    private List<Integer> destination;
    /**
     * 语言
     */
    private String language;

    /**
     * 线路归属
     */
    private String owner;
    /**
     * 途径城市
     */
    private List<Integer> wayCity;

    public List<Integer> getWayCity() {
        return wayCity;
    }

    public void setWayCity(List<Integer> wayCity) {
        this.wayCity = wayCity;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getStartCityName() {
        return startCityName;
    }

    public void setStartCityName(String startCityName) {
        this.startCityName = startCityName;
    }

    public String getEndCityName() {
        return endCityName;
    }

    public void setEndCityName(String endCityName) {
        this.endCityName = endCityName;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public List<Integer> getDestination() {
        return destination;
    }

    public void setDestination(List<Integer> destination) {
        this.destination = destination;
    }

    public List<Integer> getCover() {
        return cover;
    }

    public void setCover(List<Integer> cover) {
        this.cover = cover;
    }

    public List<String> getImageData() {
        return imageData;
    }

    public void setImageData(List<String> imageData) {
        this.imageData = imageData;
    }

    public Integer getAdvanceDays() {
        return advanceDays;
    }

    public void setAdvanceDays(Integer advanceDays) {
        this.advanceDays = advanceDays;
    }

    public String getSubTitleEn() {
        return subTitleEn;
    }

    public void setSubTitleEn(String subTitleEn) {
        this.subTitleEn = subTitleEn;
    }

    public String getSubTitleFr() {
        return subTitleFr;
    }

    public void setSubTitleFr(String subTitleFr) {
        this.subTitleFr = subTitleFr;
    }

    public String getStartCityEn() {
        return startCityEn;
    }

    public void setStartCityEn(String startCityEn) {
        this.startCityEn = startCityEn;
    }

    public String getEndCityEn() {
        return endCityEn;
    }

    public void setEndCityEn(String endCityEn) {
        this.endCityEn = endCityEn;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStartCity() {
        return startCity;
    }

    public void setStartCity(Integer startCity) {
        this.startCity = startCity;
    }

    public Integer getEndCity() {
        return endCity;
    }

    public void setEndCity(Integer endCity) {
        this.endCity = endCity;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    public String getTitleEn() {
        return titleEn;
    }

    public void setTitleEn(String titleEn) {
        this.titleEn = titleEn;
    }

    public String getTitleFr() {
        return titleFr;
    }

    public void setTitleFr(String titleFr) {
        this.titleFr = titleFr;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getDescEn() {
        return descEn;
    }

    public void setDescEn(String descEn) {
        this.descEn = descEn;
    }

    public String getDescFr() {
        return descFr;
    }

    public void setDescFr(String descFr) {
        this.descFr = descFr;
    }

    public String getIncludeEn() {
        return includeEn;
    }

    public void setIncludeEn(String includeEn) {
        this.includeEn = includeEn;
    }

    public String getIncludeFr() {
        return includeFr;
    }

    public void setIncludeFr(String includeFr) {
        this.includeFr = includeFr;
    }

    public String getExcludeEn() {
        return excludeEn;
    }

    public void setExcludeEn(String excludeEn) {
        this.excludeEn = excludeEn;
    }

    public String getExcludeFr() {
        return excludeFr;
    }

    public void setExcludeFr(String excludeFr) {
        this.excludeFr = excludeFr;
    }

    public String getImportantEn() {
        return importantEn;
    }

    public void setImportantEn(String importantEn) {
        this.importantEn = importantEn;
    }

    public String getImportantFr() {
        return importantFr;
    }

    public void setImportantFr(String importantFr) {
        this.importantFr = importantFr;
    }

    public String getTriphintEn() {
        return triphintEn;
    }

    public void setTriphintEn(String triphintEn) {
        this.triphintEn = triphintEn;
    }

    public String getTriphintFr() {
        return triphintFr;
    }

    public void setTriphintFr(String triphintFr) {
        this.triphintFr = triphintFr;
    }

    public String getTermEn() {
        return termEn;
    }

    public void setTermEn(String termEn) {
        this.termEn = termEn;
    }

    public String getTermFr() {
        return termFr;
    }

    public void setTermFr(String termFr) {
        this.termFr = termFr;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
