/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: fengbaitong
 * date: 2015-12-10
 */
package com.beautifulchina.dao.supplier;

import com.beautifulchina.base.SqlMapper;
import com.beautifulchina.supplier.bo.ApproveBO;
import com.beautifulchina.supplier.bo.SupplierBO;
import com.beautifulchina.supplier.pojo.Supplier;
import com.beautifulchina.supplier.vo.SupplierVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 供应商
 */
@Repository
public interface SupplierMapper extends SqlMapper {

    /**
     * 获取所有供应商
     */
    List<SupplierBO> getAllUser(SupplierVO supplierVO);

    /**
     * 获取供应商总数
     */
    int getSupplierCount(SupplierVO supplierVO);


    /**
     * 更新审批供应商信息
     */
    void updateSupplier(ApproveBO approveBO);


    /**
     * 更新首页展示项
     */
    void update(Supplier supplier);


    /**
     * 增加首页展示项
     */
    void add(SupplierBO supplierBO);

    /**
     * 根据id查找供应商
     * @param id
     * @return
     */
    SupplierBO getSupplier(@Param(value = "id") Integer id);

    //根据部门编码获取密码
    String getPasswordByDeptCode(@Param(value = "deptCode") String deptCode);
    //根据部门编码获取供应商习惯的语言
    String getLanguageByDeptCode(@Param(value = "deptCode") String deptCode);
}
