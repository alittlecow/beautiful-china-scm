/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: chengxuemin
 * date: 2016-01-11
 */

package com.beautifulchina.dao.consultive;

import com.beautifulchina.base.SqlMapper;
import com.beautifulchina.consultive.bo.ConsultiveBO;
import com.beautifulchina.consultive.pojo.Consultive;

import java.util.List;

/**
 * 咨询管理dao
 */
public interface ConsultiveMapper  extends SqlMapper {
    /**
     * 根据条件获取所有的咨询管理信息列表
     * @param consultiveBO
     * @return
     */
    public List<Consultive> getAllConsultiveList(ConsultiveBO consultiveBO);

    /**
     * 根据条件获取所有的咨询管理信息数量
     * @param consultiveBO
     * @return
     */
    public int getAllConsultiveListCount(ConsultiveBO consultiveBO);

    /**
     * 提交咨询管理
     * @param consultiveBO
     */
    public void reply(ConsultiveBO consultiveBO);

    /**
     * 关闭咨询管理
     * @param consultiveBO
     */
    public void close(ConsultiveBO consultiveBO);


}
