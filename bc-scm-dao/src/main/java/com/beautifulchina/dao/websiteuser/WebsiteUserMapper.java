/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: chengxuemin
 * date: 2015-12-11
 */
package com.beautifulchina.dao.websiteuser;

import com.beautifulchina.base.SqlMapper;
import com.beautifulchina.websiteuser.pojo.WebsiteUser;
import com.beautifulchina.websiteuser.bo.WebsiteUserBO;

import java.util.List;

/**
 *  网站用户管理dao
 */
public interface WebsiteUserMapper extends SqlMapper {
    /**
     *根据条件获取所有的网站用户信息列表
     * @param websiteuserBO
     * @return
     */
    public List<WebsiteUser> getAllWebsiteUserList(WebsiteUserBO websiteuserBO);

    /**
     * 根据条件获取所有的网站用户信息数量
     * @param websiteuserBO
     * @return
     */
    public int getAllWebsiteUserListCount(WebsiteUserBO websiteuserBO);

    /**
     *冻结菜单
     * @param websiteuserBO
     */
    public void freeze(WebsiteUserBO websiteuserBO);

}
