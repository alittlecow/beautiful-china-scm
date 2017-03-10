/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: dongjingjun
 * date: 2015-12-21
 */
package com.beautifulchina.service.dlmanage;

import com.beautifulchina.common.Page;
import com.beautifulchina.dao.dlmanage.DLManageMapper;
import com.beautifulchina.dlmanage.bo.LevelBO;
import com.beautifulchina.dlmanage.pojo.Level;
import com.beautifulchina.dlmanage.vo.LevelVO;
import com.beautifulchina.exception.RedisException;
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
 * 部门等级管理相关服务
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class DLManageService {
    @Autowired
    private DLManageMapper dLManageMapper;

    /**
     * 获取所有表格数据
     *
     * @param dLManageVO
     * @return
     */
    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public Page<LevelBO> getDLMList(LevelVO dLManageVO) {
        List<LevelBO> dLManageBOs = new ArrayList<LevelBO>();
        int count = dLManageMapper.getCount(dLManageVO);
        if (count > 0) {
            List<Level> dLManages = dLManageMapper.getDLMList(dLManageVO);
            for (Level dlm : dLManages) {
                LevelBO dLManageBO = new LevelBO();
                BeanUtils.copyProperties(dlm, dLManageBO);
                dLManageBOs.add(dLManageBO);
            }
        }
        Page<LevelBO> page = new Page<LevelBO>();
        page.setData(dLManageBOs);
        page.setTotal(count);
        return page;
    }

    /**
     * 根据部门等级code删除一行或多行数据
     *
     * @param dLCode
     */
    public void deleteDepartmentLevelByCode(String dLCode) {
        List<String> list = CollectionUtils.arrayToList(dLCode.split(","));
        dLManageMapper.deleteDepartmentLevelByCode(list);
    }

    /**
     * 增加一条数据
     *
     * @param dLManageVO
     * @throws RedisException
     */
    public void addDepartmentLevel(LevelVO dLManageVO,UserBO userBO) throws RedisException {
        dLManageVO.setOperateTime(new Date());
        dLManageVO.setOperating(userBO.getUsername());
        dLManageMapper.addDepartmentLevel(dLManageVO);
    }

    /**
     * 可编辑表格更新一条数据
     *
     * @param dLManageVO
     */
    public void updateDepartmentLevel(LevelVO dLManageVO,UserBO userBO) {
        dLManageVO.setOperating(userBO.getName());
        dLManageVO.setOperateTime(new Date());
        dLManageMapper.updateDepartmentLevel(dLManageVO);
    }

    /**
     * 获取上级代码
     * @return
     */
    public List<String> getSupCode(){
        List<String > list =dLManageMapper.getSupCode();
        return list;
    }
}
