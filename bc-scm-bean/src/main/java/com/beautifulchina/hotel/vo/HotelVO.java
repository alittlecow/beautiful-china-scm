/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: dongjingjun
 * date: 2016-01-03
 */
package com.beautifulchina.hotel.vo;

import com.beautifulchina.common.PageQuery;

/**
 * 酒店管理
 */
public class HotelVO extends PageQuery {
    /**
     * 酒店id
     */
    private Integer id;
    /**
     * 酒店供应商代码
     */
    private String supDeptCode;
    /**
     * 酒店英文名
     */
    private String hotelNameEn;
    /**
     * 酒店法文名
     */
    private String hotelNameFr;
    /**
     * 酒店中文名
     */
    private String hotelNameCn;
    /**
     * 酒店电话
     */
    private String hotelTel;
    /**
     * 酒店传真
     */
    private String hotelFax;
    /**
     * 酒店英文描述
     */
    private String descEn;
    /**
     * 酒店发文描述
     */
    private String descFr;
    /**
     * 酒店地址英文
     */
    private String addressEn;
    /**
     * 酒店地址法文
     */
    private String addressFr;
    /**
     * 酒店地址中文
     */
    private String addressCn;
    /**
     * 酒店地址
     */
    private String address;
    /**
     * 酒店星级
     */
    private String hotelStar;
    /**
     * 酒店状态
     */
    private String status;
    /**
     * 酒店类型英文
     */
    private String typeNameEn;
    /**
     * 酒店名
     */
    private String hotelName;
    /**
     * 酒店所在城市id
     */

    private String language;
    /**
     * 酒店名称
     */
    private Integer CityId;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getCityId() {
        return CityId;
    }

    public void setCityId(Integer cityId) {
        CityId = cityId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSupDeptCode() {
        return supDeptCode;
    }

    public void setSupDeptCode(String supDeptCode) {
        this.supDeptCode = supDeptCode;
    }

    public String getHotelNameEn() {
        return hotelNameEn;
    }

    public void setHotelNameEn(String hotelNameEn) {
        this.hotelNameEn = hotelNameEn;
    }

    public String getHotelNameFr() {
        return hotelNameFr;
    }

    public void setHotelNameFr(String hotelNameFr) {
        this.hotelNameFr = hotelNameFr;
    }

    public String getHotelNameCn() {
        return hotelNameCn;
    }

    public void setHotelNameCn(String hotelNameCn) {
        this.hotelNameCn = hotelNameCn;
    }

    public String getHotelTel() {
        return hotelTel;
    }

    public void setHotelTel(String hotelTel) {
        this.hotelTel = hotelTel;
    }

    public String getHotelFax() {
        return hotelFax;
    }

    public void setHotelFax(String hotelFax) {
        this.hotelFax = hotelFax;
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

    public String getAddressEn() {
        return addressEn;
    }

    public void setAddressEn(String addressEn) {
        this.addressEn = addressEn;
    }

    public String getAddressFr() {
        return addressFr;
    }

    public void setAddressFr(String addressFr) {
        this.addressFr = addressFr;
    }

    public String getAddressCn() {
        return addressCn;
    }

    public void setAddressCn(String addressCn) {
        this.addressCn = addressCn;
    }

    public String getHotelStar() {
        return hotelStar;
    }

    public void setHotelStar(String hotelStar) {
        this.hotelStar = hotelStar;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTypeNameEn() {
        return typeNameEn;
    }

    public void setTypeNameEn(String typeNameEn) {
        this.typeNameEn = typeNameEn;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
