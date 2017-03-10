/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: dongjingjun
 * date: 2015-12-21
 */
package com.beautifulchina.dao.dlmanage;

import com.beautifulchina.base.SqlMapper;
import com.beautifulchina.dlmanage.pojo.Level;
import com.beautifulchina.dlmanage.vo.LevelVO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 部门等级管理dao
 */
@Repository
public interface DLManageMapper extends SqlMapper {
    /**
     * 获取部门等级所有数据
     * @param dlManageVO
     * @return
     */
    List<Level> getDLMList(LevelVO dlManageVO);

    /**
     * 根据code删除一条或多条数据
     * @param code
     */
    void deleteDepartmentLevelByCode(List<String> code);

    /**
     * 增加一条数据
     * @param dlManageVO
     */
    void addDepartmentLevel(LevelVO dlManageVO);

    /**
     * 更新数据
     * @param dlManageVO
     */
    void updateDepartmentLevel(LevelVO dlManageVO);

    /**
     * 获取部门数量
     * @param dlManageVO
     * @return
     */
    int getCount(LevelVO dlManageVO);

    /**
     * 获取上级代码
     * @return
     */
    List<String> getSupCode();
}
