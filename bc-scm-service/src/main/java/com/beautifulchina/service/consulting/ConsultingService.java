/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: chengxuemin
 * date: 2016-01-18
 */

package com.beautifulchina.service.consulting;

import com.beautifulchina.common.Page;
import com.beautifulchina.consulting.bo.ConsultingBO;
import com.beautifulchina.consulting.pojo.Consulting;
import com.beautifulchina.consulting.vo.ConsultingVO;
import com.beautifulchina.dao.consulting.ConsultingMapper;
import com.beautifulchina.main.bo.ConsultingListBO;
import com.beautifulchina.user.bo.UserBO;
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
 * 咨询投诉管理相关服务
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ConsultingService {
    @Autowired
    private ConsultingMapper consultingMapper;

   /**
    * 根据条件获取所有的咨询管理信息列表
    * @param consultingVO
    * @return
    */
    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public Page<ConsultingListBO> getAllConsultingList(ConsultingVO consultingVO) {
        ConsultingBO consultingBO = new ConsultingBO();
        BeanUtils.copyProperties(consultingVO, consultingBO);
        int count = consultingMapper.getAllConsultingListCount(consultingBO);
        List<ConsultingListBO> consultingListBOList = new ArrayList<ConsultingListBO>();
        Page<ConsultingListBO> consultingListBOPage = new Page<ConsultingListBO>();
        if (count > 0) {
            List<Consulting> consultingList = consultingMapper.getAllConsultingList(consultingBO);
            if (!CollectionUtils.isEmpty(consultingList)) {
                for (Consulting consulting : consultingList) {
                    ConsultingListBO consultingListBO = new ConsultingListBO();
                    BeanUtils.copyProperties(consulting, consultingListBO);
                    consultingListBOList.add(consultingListBO);
                }
            }
        }
        consultingListBOPage.setTotal(count);
        consultingListBOPage.setData(consultingListBOList);
        return consultingListBOPage;
    }

    /**
     * 提交咨询管理信息
     * @param consultingVO
     */
    public void submitConsulting(ConsultingVO consultingVO, UserBO userBO) {
        ConsultingBO consultingBO = new ConsultingBO();
        BeanUtils.copyProperties(consultingVO,consultingBO);
        consultingBO.setOperateTime(new Date());
        consultingBO.setOperator(userBO.getUsername());
        consultingMapper.submit(consultingBO);
    }

    /**
     * 处理咨询管理信息
     * @param consultingVO
     */
    public void dealConsulting(ConsultingVO consultingVO, UserBO userBO) {
        ConsultingBO consultingBO = new ConsultingBO();
        BeanUtils.copyProperties(consultingVO,consultingBO);
        consultingBO.setOperateTime(new Date());
        consultingBO.setOperator(userBO.getUsername());
        consultingMapper.deal(consultingBO);
    }

}
