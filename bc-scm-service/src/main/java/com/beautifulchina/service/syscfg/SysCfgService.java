/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: liufei
 * date: 2015-12-11
 */
package com.beautifulchina.service.syscfg;

import com.alibaba.fastjson.JSONObject;
import com.beautifulchina.base.BaseService;
import com.beautifulchina.common.Page;
import com.beautifulchina.dao.syscfg.SysCfgMapper;

import com.beautifulchina.syscfg.bo.SysCfgListBO;
import com.beautifulchina.syscfg.bo.SysCfgBO;
import com.beautifulchina.syscfg.pojo.SysCfg;
import com.beautifulchina.syscfg.vo.SysCfgVO;
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
import java.util.Map;

/**
 * 系统配置相关服务
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class SysCfgService extends BaseService {

    @Autowired
    public SysCfgMapper syscfgMapper;


    /**
     * 查询系统配置
     *
     * @param syscfgVO
     * @return
     */
    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public Page<SysCfgListBO> getAllSysCfgList(SysCfgVO syscfgVO) {
        SysCfgBO syscfgBO = new SysCfgBO();
        BeanUtils.copyProperties(syscfgVO, syscfgBO);
        int count = syscfgMapper.getAllSysCfgListCount(syscfgBO);
        List<SysCfgListBO> syscfgBOList = new ArrayList<SysCfgListBO>();
        Page<SysCfgListBO> syscfgBOPage = new Page<SysCfgListBO>();
        if (count > 0) {
            List<SysCfg> syscfgList = syscfgMapper.getAllSysCfgList(syscfgBO);
            if (!CollectionUtils.isEmpty(syscfgList)) {
                for (SysCfg syscfg : syscfgList) {
                    SysCfgListBO syscfgListBO = new SysCfgListBO();
                    BeanUtils.copyProperties(syscfg, syscfgListBO);
                    syscfgBOList.add(syscfgListBO);
                }
            }
        }
        syscfgBOPage.setTotal(count);
        syscfgBOPage.setData(syscfgBOList);
        return syscfgBOPage;
    }

    /**
     * 更新系统配置
     *
     * @param sysCfgVO
     */
    public void updateSysCfg(SysCfgVO sysCfgVO, UserBO userBO, String local) throws IllegalAccessException, InstantiationException {
        //根据id删除原多语言配置
        syscfgMapper.deleteSysCfgLanguage(sysCfgVO.getId());
        //保存多语言参数，并获取多语言相关参数uuid值
        SysCfgVO newSysCfgVO = (SysCfgVO) getMultiLanguage(SysCfgVO.class, sysCfgVO.getMultiLanguage(), local);

        newSysCfgVO.setGroupCode(sysCfgVO.getGroupCode());
        newSysCfgVO.setId(sysCfgVO.getId());

        SysCfgBO syscfgBO = new SysCfgBO();
        BeanUtils.copyProperties(newSysCfgVO, syscfgBO);

        syscfgBO.setOperateTime(new Date());
        syscfgBO.setOperator(userBO.getUsername());

        syscfgMapper.update(syscfgBO);
    }

    /**
     * 保存系统配置
     *
     * @param sysCfgVO
     */
    public void saveSysCfg(SysCfgVO sysCfgVO, UserBO userBO, String local) throws IllegalAccessException, InstantiationException {
        SysCfgVO newSysCfgVO = (SysCfgVO) getMultiLanguage(SysCfgVO.class, sysCfgVO.getMultiLanguage(), local);

        newSysCfgVO.setGroupCode(sysCfgVO.getGroupCode());
        newSysCfgVO.setId(sysCfgVO.getId());

        SysCfgBO syscfgBO = new SysCfgBO();
        BeanUtils.copyProperties(newSysCfgVO, syscfgBO);

        syscfgBO.setOperateTime(new Date());
        syscfgBO.setOperator(userBO.getUsername());

        syscfgMapper.save(syscfgBO);
    }

    /**
     * 根据系统配置编号删除系统配置
     *
     * @param codes
     */
    public void deleteSysCfgByCode(String codes) {
        List<String> list = CollectionUtils.arrayToList(codes.split(","));
        syscfgMapper.delete(list);
    }

    /**
     * 根据id获取多语言数据
     *
     * @param id
     * @return
     */
    public JSONObject getLanguageById(Integer id,String[] types) {
        SysCfgBO sysCfgBO = new SysCfgBO();
        sysCfgBO.setId(id);
        JSONObject jsonObject = new JSONObject();
        for (String language : types) {
            sysCfgBO.setLanguage(language);
            List<Map<String, String>> sysCfg = syscfgMapper.getSysCfgById(sysCfgBO);
            jsonObject.put(language, sysCfg.get(0));
        }
        return jsonObject;
    }
}