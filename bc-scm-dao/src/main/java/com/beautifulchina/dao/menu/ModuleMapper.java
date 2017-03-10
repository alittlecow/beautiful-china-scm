/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: chenghuanhuan
 * date: 2015-11-17
 */
package com.beautifulchina.dao.menu;

import com.beautifulchina.base.SqlMapper;
import com.beautifulchina.menu.pojo.Module;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 模块dao
 */
@Repository
public interface ModuleMapper extends SqlMapper{

    /**
     * 获取用户所拥有的模块 TODO 暂未做权限控制
     * @param userId
     * @return
     */
    List<Module> getModuleList(@Param(value = "userId") String userId,
                               @Param(value = "plateId") String plateId,
                               @Param(value = "language") String language,
                               @Param(value = "roleCode") String roleCode);

    /**
     * 获取所有模块
     * @return
     */
     List<Module> getAllModuleList(@Param(value = "language") String language);
}
