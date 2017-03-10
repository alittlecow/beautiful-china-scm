/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: chenghuanhuan
 * date: 2015-11-17
 */
package com.beautifulchina.dao.menu;

import com.beautifulchina.base.SqlMapper;
import com.beautifulchina.main.bo.PlateBO;
import com.beautifulchina.menu.pojo.Plate;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 板块dao
 */
@Repository
public interface PlateMapper extends SqlMapper{
    /**
     * 获取所有的板块信息
     * @return
     */
    List<Plate> getPlateList(@Param(value = "language") String language,@Param(value = "roleCode") String roleCode);
}
