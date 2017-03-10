/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: fengbaitong
 * date: 2015-11-25
 */
package com.beautifulchina.controller.supplier;


import com.beautifulchina.base.BaseController;
import com.beautifulchina.common.Page;
import com.beautifulchina.service.supplier.SupplierService;
import com.beautifulchina.supplier.bo.SupplierBO;
import com.beautifulchina.supplier.pojo.Supplier;
import com.beautifulchina.supplier.vo.ApproveVO;
import com.beautifulchina.supplier.vo.SupplierVO;
import com.beautifulchina.user.bo.UserBO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Map;

/**
 *供应商管理控制器
 */
@Controller
@RequestMapping(value = "/supplier")
public class SupplierController extends BaseController{

    private static Logger logger = LoggerFactory.getLogger(SupplierController.class);

    @Autowired
    private SupplierService supplierService;

    /**
     * 获取供应商列表
     */
    @RequestMapping(value = "list")
    @ResponseBody
    public Page<SupplierBO> list(@Valid SupplierVO supplierVO,HttpServletRequest request){
        String language = this.getLocal(request);
        supplierVO.setLanguage(language);
        Page<SupplierBO> page = supplierService.getSupplierExtjsList(supplierVO);
        return page;
    }



    /**
     * 保存供应商审批结果
     * */
    @RequestMapping(value = "update")
    @ResponseBody
    public Map<String,Object> update(ApproveVO approveVO,HttpServletRequest request){

        // TODO 权限判断
        Map<String,Object> result = null;
        try{
            UserBO userBO = this.getUser(request);
            supplierService.updateSupplier(approveVO,userBO);
            result = successResult();
        }catch (Exception e){
            logger.error("供应商审批失败",e);
            result = failResult();
        }
        return result;
    }


    /**
     * 修改供应商信息
     * */
    @RequestMapping(value = "updateSupplier")
    @ResponseBody
    public Map<String,Object> updateSupplier(@Valid Supplier supplier){

        // TODO 权限判断
        Map<String,Object> result = null;
        try{
            supplierService.update(supplier);
            result = successResult();
        }catch (Exception e){
            logger.error("供应商信息修改失败",e);
            result = failResult();
        }
        return result;
    }

    /**
     * 新增供应商信息
     * @return
     */
    @RequestMapping(value = "add")
    @ResponseBody
    public Map<String, Object> add(SupplierBO supplierBO) {
        Map<String, Object> result = null;
        try {
            supplierService.add(supplierBO);
            result = successResult();
        } catch (Exception e) {
            logger.error("供应商信息保存信息失败",e);
            result = failResult();
        }
        return result;
    }


}
