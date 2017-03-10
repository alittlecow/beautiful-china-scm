/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: chengxuemin
 * date: 2015-12-11
 */
package com.beautifulchina.service.mailhistory;

import com.beautifulchina.common.Page;
import com.beautifulchina.dao.mailhistory.MailHistoryMapper;
import com.beautifulchina.exception.RedisException;
import com.beautifulchina.mailhistory.bo.MailHistoryBO;
import com.beautifulchina.mailhistory.vo.MailHistoryVO;
import com.beautifulchina.main.bo.MailHistoryListBO;
import com.beautifulchina.manager.RedisManager;
import com.beautifulchina.mailhistory.pojo.MailHistory;
import com.beautifulchina.util.DateUtil;
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
 * 邮件历史记录相关服务
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class MailHistoryService {

    @Autowired
    private MailHistoryMapper mailhistoryMapper;

    @Autowired
    private RedisManager redisManager;

    /**
     * 根据条件获取所有邮件信息
     * @param mailhistoryVO
     * @return
     */
    @Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly =true)
    public Page<MailHistoryListBO> getAllMailHistoryList(MailHistoryVO mailhistoryVO){
        MailHistoryBO mailhistoryBO = new MailHistoryBO();
        BeanUtils.copyProperties(mailhistoryVO,mailhistoryBO);
        int count = mailhistoryMapper.getAllMailHistoryListCount(mailhistoryBO);
        List<MailHistoryListBO> mailhistoryListBOList = new ArrayList<MailHistoryListBO>();
        Page<MailHistoryListBO> mailhistoryListBOPage = new Page<MailHistoryListBO>();
        if(count > 0){
            List<MailHistory> mailhistoryList = mailhistoryMapper.getAllMailHistoryList(mailhistoryBO);
            if(!CollectionUtils.isEmpty(mailhistoryList)){
                for (MailHistory mailhistory:mailhistoryList){
                    MailHistoryListBO mailhistoryListBO = new MailHistoryListBO();
                    BeanUtils.copyProperties(mailhistory,mailhistoryListBO);
                    mailhistoryListBOList.add(mailhistoryListBO);
                }
            }
        }
        mailhistoryListBOPage.setTotal(count);
        mailhistoryListBOPage.setData(mailhistoryListBOList);
        return mailhistoryListBOPage;
    }

    /**
     * 保存邮件历史记录
     * @param title
     * @param content
     * @param userId
     * @param email
     */
    public void saveEmailHistory(String title,String content,Long userId,String email){
        MailHistoryVO mailHistoryVO=new MailHistoryVO();
        mailHistoryVO.setTitle(title);
        mailHistoryVO.setContent(content);
        String id=String.valueOf(userId);
        mailHistoryVO.setUserId(id);
        mailHistoryVO.setEmail(email);
        //获取当前时间
        String datetime= DateUtil.getCurrentDate();
        mailHistoryVO.setOperateTime(datetime);
        mailhistoryMapper.saveEmailHistory(mailHistoryVO);
    }
}
