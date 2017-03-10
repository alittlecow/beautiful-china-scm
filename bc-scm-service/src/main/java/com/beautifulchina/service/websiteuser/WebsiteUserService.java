/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: chengxuemin
 * date: 2015-12-11
 */
package com.beautifulchina.service.websiteuser;

import com.beautifulchina.common.Page;
import com.beautifulchina.dao.websiteuser.WebsiteUserMapper;
import com.beautifulchina.main.bo.WebsiteUserListBO;
import com.beautifulchina.user.bo.UserBO;
import com.beautifulchina.websiteuser.bo.WebsiteUserBO;
import com.beautifulchina.websiteuser.pojo.WebsiteUser;
import com.beautifulchina.websiteuser.vo.WebsiteUserVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 网站用户管理相关服务
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class WebsiteUserService {

    @Autowired
    private WebsiteUserMapper websiteuserMapper;

    /**
     * 根据条件获取所有网站用户信息
     * @param websiteuserVO
     * @return
     */
    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public Page<WebsiteUserListBO> getAllWebsiteUserList(WebsiteUserVO websiteuserVO) {
        WebsiteUserBO websiteuserBO = new WebsiteUserBO();
        BeanUtils.copyProperties(websiteuserVO, websiteuserBO);
        int count = websiteuserMapper.getAllWebsiteUserListCount(websiteuserBO);
        List<WebsiteUserListBO> websiteuserListBOList = new ArrayList<WebsiteUserListBO>();
        Page<WebsiteUserListBO> websiteuserListBOPage = new Page<WebsiteUserListBO>();
        if (count > 0) {
            List<WebsiteUser> websiteuserList = websiteuserMapper.getAllWebsiteUserList(websiteuserBO);
            if (!CollectionUtils.isEmpty(websiteuserList)) {
                for (WebsiteUser websiteuser : websiteuserList) {
                    WebsiteUserListBO websiteuserListBO = new WebsiteUserListBO();
                    BeanUtils.copyProperties(websiteuser, websiteuserListBO);
                    websiteuserListBOList.add(websiteuserListBO);
                }
            }
        }
        websiteuserListBOPage.setTotal(count);
        websiteuserListBOPage.setData(websiteuserListBOList);
        return websiteuserListBOPage;
    }

    /**
     * 冻结网站用户信息
     * @param websiteuserVO
     */
    public void freezeWebsiteUser(WebsiteUserVO websiteuserVO,UserBO userBO){
        WebsiteUserBO websiteuserBO = new WebsiteUserBO();
        BeanUtils.copyProperties(websiteuserVO, websiteuserBO);
        websiteuserBO.setOperateTime(new Date());
        websiteuserBO.setLockTime(new Date());
        websiteuserBO.setOperator(userBO.getUsername());
        websiteuserMapper.freeze(websiteuserBO);
    }
}
