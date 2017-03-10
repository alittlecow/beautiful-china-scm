/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: chengxuemin
 * date: 2015-12-11
 */
package com.beautifulchina.main.bo;

import com.beautifulchina.websiteuser.vo.WebsiteUserVO;

/**
 * 网站用户管理
 */
public class WebsiteUserListBO extends WebsiteUserVO {
    /**
     * 姓名
     */
    private String name;

    /**
     * 昵称
     */
    private String nickName;

    @Override
    public String getName() { return name; }

    @Override
    public void setName(String name) { this.name = name; }

    @Override
    public String getNickName() { return nickName; }

    @Override
    public void setNickName(String nickName) { this.nickName = nickName; }
}
