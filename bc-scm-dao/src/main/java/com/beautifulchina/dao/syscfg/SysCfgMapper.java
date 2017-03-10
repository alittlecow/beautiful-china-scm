/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: liufei
 * date: 2015-12-11
 */
package com.beautifulchina.dao.syscfg;

import com.beautifulchina.base.SqlMapper;
import com.beautifulchina.syscfg.bo.SysCfgBO;
import com.beautifulchina.syscfg.pojo.SysCfg;
import com.beautifulchina.syscfg.vo.SysCfgVO;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 系统配置dao
 */
@Repository
public interface SysCfgMapper extends SqlMapper {


    /**
     * 根据条件获取所有的系统配置信息列表
     *
     * @param syscfgBO
     * @return
     */
    List<SysCfg> getAllSysCfgList(SysCfgBO syscfgBO);

    /**
     * 根据id获取系统配置信息
     *
     * @param syscfgBO
     * @return
     */
    List<Map<String, String>> getSysCfgById(SysCfgBO syscfgBO);

    /**
     * 根据条件获取所有的系统配置信息数量
     *
     * @param syscfgBO
     * @return
     */
    int getAllSysCfgListCount(SysCfgBO syscfgBO);

    /**
     * 保存系统配置
     *
     * @param syscfgBO
     */
    void save(SysCfgBO syscfgBO);

    /**
     * 更新系统配置
     *
     * @param syscfgBO
     */
    void update(SysCfgBO syscfgBO);

    /**
     * 根据系统配置编号删除系统配置
     *
     * @param codes
     */
    void delete(List<String> codes);

    /**
     * 根据id信息删除系统配置多语言信息
     *
     * @param id
     */
    void deleteSysCfgLanguage(Integer id);

}
