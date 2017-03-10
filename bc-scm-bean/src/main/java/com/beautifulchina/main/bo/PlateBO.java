/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: chenghuanhuan
 * date: 2015-11-18
 */
package com.beautifulchina.main.bo;

import com.beautifulchina.menu.vo.PlateVO;

/**
 * 板块
 */
public class PlateBO extends PlateVO{
    /**
     * 编号
     */
    private String code;
    /**
     * 英文名
     */
    private String enName;
    /**
     * 法文名
     */
    private String frName;

    /**
     * 板块名称
     */
    private String plateName;

    public String getPlateName() {
        return plateName;
    }

    public void setPlateName(String plateName) {
        this.plateName = plateName;
    }

    public String getEnName() {
        return enName;
    }

    public void setEnName(String enName) {
        this.enName = enName;
    }

    public String getFrName() {
        return frName;
    }

    public void setFrName(String frName) {
        this.frName = frName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
