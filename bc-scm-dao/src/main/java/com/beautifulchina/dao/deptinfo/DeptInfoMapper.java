/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: dongjingjun
 * date: 2015-12-21
 */
package com.beautifulchina.dao.deptinfo;

import com.beautifulchina.base.SqlMapper;
import com.beautifulchina.deptinfo.bo.DeptBO;
import com.beautifulchina.deptinfo.bo.DeptInfoBO;
import com.beautifulchina.deptinfo.pojo.Dept;
import com.beautifulchina.deptinfo.vo.DeptVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 部门信息管理dao
 */
@Repository
public interface DeptInfoMapper extends SqlMapper{
    /**
     * 获取部门信息树
     * @param deptVO
     * @return
     */
    List<Dept> getDept(DeptVO deptVO);

    /**
     * 根据部门id获取部门代码
     * @param map
     * @return
     */
    String getSupDeptCode(Map<String,String> map);

    /**
     * 获取所有部门代码和名称
     * @return
     */
    List<DeptBO> getAllDeptCodeAndDeptName(DeptBO deptBO);

    String getDeptCodeById(Map<String,String> map);

    /**
     * 根据条件获取部门信息
     * @param deptVO
     * @return
     */
    List<Dept> getDeptById(DeptVO deptVO);

    /**
     * 根据部门code获取部门信息
     * @param code
     * @return
     */
    List<Dept> getDeptByCode(@Param(value = "code")String code,@Param(value = "language")String language);

    /**
     * 获取部门代码与名称
     * @return
     */
    List<Dept> getDeptCN(@Param(value = "language")String language,
                         @Param(value = "levelCode")String levelCode);

    /**
     * 新增部门信息
     * @param deptBO
     */
    void addDept(DeptBO deptBO);

    /**
     * 更新部门信息
     * @param deptBO
     */
    void editDept(DeptBO deptBO);

    /**
     * 根据id删除节点
     * @param id
     */
    void delDeptById(List<String> id);

    /**
     * 获取所有部门信息
     * @return
     */
    List<Dept> getDeptList(@Param(value = "language")String language);

    /**
     * 根据deptCode获取部门信息
     * @param deptCode
     * @return
     */
    DeptInfoBO getDeptInfoByDeptCode(@Param(value = "deptCode")String deptCode);
}
