/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: chengxuemin
 * date: 2016-01-11
 */

package com.beautifulchina.service.consultive;

import com.beautifulchina.common.Page;
import com.beautifulchina.consultive.bo.ConsultiveBO;
import com.beautifulchina.consultive.pojo.Consultive;
import com.beautifulchina.consultive.vo.ConsultiveVO;
import com.beautifulchina.dao.consultive.ConsultiveMapper;
import com.beautifulchina.main.bo.ConsultiveListBO;
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
 * 咨询管理相关服务
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ConsultiveService {

    @Autowired
    private ConsultiveMapper consultiveMapper;

    /**
     * 根据条件获取所有的咨询管理信息列表
     * @param consultiveVO
     * @return
     */
    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public Page<ConsultiveListBO> getAllConsultiveList(ConsultiveVO consultiveVO,UserBO userBO) {
        ConsultiveBO consultiveBO = new ConsultiveBO();
        consultiveVO.setLevelCode(userBO.getDeptInfoBO().getLevelCode());
        if("SUPPLIER".equalsIgnoreCase(userBO.getDeptInfoBO().getLevelCode())){
            consultiveVO.setDeptCode(userBO.getDeptInfoBO().getDeptCode());
        }
        consultiveVO.setDeptId(userBO.getDeptInfoBO().getId());
        consultiveVO.setUserId(userBO.getId());
        BeanUtils.copyProperties(consultiveVO, consultiveBO);
        int count = consultiveMapper.getAllConsultiveListCount(consultiveBO);
        List<ConsultiveListBO> consultiveListBOList = new ArrayList<ConsultiveListBO>();
        Page<ConsultiveListBO> consultiveListBOPage = new Page<ConsultiveListBO>();
        if (count > 0) {
            List<Consultive> consultiveList = consultiveMapper.getAllConsultiveList(consultiveBO);
            if (!CollectionUtils.isEmpty(consultiveList)) {
                for (Consultive consultive : consultiveList) {
                    ConsultiveListBO consultiveListBO = new ConsultiveListBO();
                    BeanUtils.copyProperties(consultive, consultiveListBO);
                    consultiveListBOList.add(consultiveListBO);
                }
            }
        }
        consultiveListBOPage.setTotal(count);
        consultiveListBOPage.setData(consultiveListBOList);
        return consultiveListBOPage;
    }

    /**
     * 提交咨询管理信息
     * @param consultiveVO
     */
    public void replyConsultive(ConsultiveVO consultiveVO, UserBO userBO) {
        ConsultiveBO consultiveBO = new ConsultiveBO();
        BeanUtils.copyProperties(consultiveVO,consultiveBO);
        consultiveBO.setOperateTime(new Date());
        consultiveBO.setUserId(userBO.getId());
        if("SUPPLIER".equalsIgnoreCase(userBO.getDeptInfoBO().getDeptCode())){
            consultiveBO.setType("P");
        }else{
            consultiveBO.setType("S");
        }
        consultiveMapper.reply(consultiveBO);
    }

    /**
     * 关闭咨询管理信息
     * @param consultiveVO
     */
    public void closeConsultive(ConsultiveVO consultiveVO,UserBO userBO){
        ConsultiveBO consultiveBO = new ConsultiveBO();
        BeanUtils.copyProperties(consultiveVO, consultiveBO);
        consultiveBO.setOperateTime(new Date());
        consultiveBO.setOperator(userBO.getUsername());
        consultiveMapper.close(consultiveBO);
    }
}
