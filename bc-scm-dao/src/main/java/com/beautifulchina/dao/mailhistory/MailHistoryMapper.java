/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: chengxuemin
 * date: 2015-12-11
 */
package com.beautifulchina.dao.mailhistory;

import com.beautifulchina.base.SqlMapper;
import com.beautifulchina.mailhistory.bo.MailHistoryBO;
import com.beautifulchina.mailhistory.pojo.MailHistory;
import com.beautifulchina.mailhistory.vo.MailHistoryVO;

import java.util.List;

/**
 * 邮件历史记录dao
 */
public interface MailHistoryMapper extends SqlMapper {
    /**
     *根据条件获取所有的邮件历史记录信息列表
     * @param mailhistoryBO
     * @return
     */
    public List<MailHistory> getAllMailHistoryList(MailHistoryBO mailhistoryBO);

    /**
     * 根据条件获取所有的邮件历史记录信息数量
     * @param mailhistoryBO
     * @return
     */
    public int getAllMailHistoryListCount(MailHistoryBO mailhistoryBO);

    /**
     * 查看邮件内容
     * @param mailhistoryBO
     */
    void check(MailHistoryBO mailhistoryBO);
    /**
     * 保存邮件历史记录
     * @param mailHistoryVO
     */
    void saveEmailHistory(MailHistoryVO mailHistoryVO);
}
