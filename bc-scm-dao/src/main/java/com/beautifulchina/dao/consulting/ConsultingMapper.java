/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: chengxuemin
 * date: 2016-01-18
 */

package com.beautifulchina.dao.consulting;

import com.beautifulchina.base.SqlMapper;
import com.beautifulchina.consulting.bo.ConsultingBO;
import com.beautifulchina.consulting.pojo.Consulting;

import java.util.List;

/**
 * 咨询投诉管理dao
 */
public interface ConsultingMapper  extends SqlMapper {
    /**
     * 根据条件获取所有的咨询管理信息列表
     * @param consultingBO
     * @return
     */
    public List<Consulting> getAllConsultingList(ConsultingBO consultingBO);

    /**
     * 根据条件获取所有的咨询管理信息数量
     * @param consultingBO
     * @return
     */
    public int getAllConsultingListCount(ConsultingBO consultingBO);

    /**
     * 提交咨询管理
     * @param consultingBO
     */
    public void submit(ConsultingBO consultingBO);

    /**
     * 处理咨询管理
     * @param consultingBO
     */
    public void deal(ConsultingBO consultingBO);
}
