/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: chengxuemin
 * date: 2015-12-11
 */
package com.beautifulchina.websiteuser.pojo;

import com.beautifulchina.websiteuser.bo.WebsiteUserBO;

/**
 * 网站用户管理POJO
 */
public class WebsiteUser extends WebsiteUserBO {
    /**
     * 姓名
     */
    private String inputName;

    /**
     * 昵称
     */
    private String inputnickName;

    public String getInputName() { return inputName; }

    public void setInputName(String inputName) {
        this.inputName = inputName;
    }

    public String getInputnickName() {
        return inputnickName;
    }

    public void setInputnickName(String inputnickName) {
        this.inputnickName = inputnickName;
    }
}
