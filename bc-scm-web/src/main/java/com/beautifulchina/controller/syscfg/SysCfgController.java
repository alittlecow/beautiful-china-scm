/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: liufei
 * date: 2015-12-10
 */
package com.beautifulchina.controller.syscfg;

import com.beautifulchina.base.BaseController;
import com.beautifulchina.common.Page;
import com.beautifulchina.exception.CommException;
import com.beautifulchina.syscfg.bo.SysCfgListBO;
import com.beautifulchina.service.syscfg.SysCfgService;
import com.beautifulchina.syscfg.vo.SysCfgVO;
import com.beautifulchina.user.bo.UserBO;
import com.beautifulchina.util.ParameterUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.*;

/**
 * 系统配置管路控制器
 */
@Controller
@RequestMapping(value = " /syscfg")
public class SysCfgController extends BaseController {
    private static Logger logger = LoggerFactory.getLogger(SysCfgController.class);

    @Autowired
    private SysCfgService syscfgService;


    /**
     * 查询系统配置列表
     *
     * @param syscfgVO
     * @return
     */
    @RequestMapping(value = "query")
    @ResponseBody
    public Page<SysCfgListBO> queryMenus(@Valid SysCfgVO syscfgVO, HttpServletRequest request) {
        syscfgVO.setLanguage(this.getLocal(request));
        Page<SysCfgListBO> page = syscfgService.getAllSysCfgList(syscfgVO);
        return page;
    }

    /**
     * 更新系统配置信息
     *
     * @param sysCfgVO
     * @return
     */
    @RequestMapping(value = "update")
    @ResponseBody
    public Map<String, Object> update(@Valid SysCfgVO sysCfgVO, HttpServletRequest request) {
        Map<String, Object> result = null;
        try {
            UserBO userBO = this.getUser(request);
            syscfgService.updateSysCfg(sysCfgVO, userBO, this.getLocal(request));
            result = successResult();
        } catch (Exception e) {
            logger.error("更新系统配置失败", e);
            result = failResult();
        }
        return result;
    }

    /**
     * 保存系统配置
     *
     * @return
     */
    @RequestMapping(value = "save")
    @ResponseBody
    public Map<String, Object> save(SysCfgVO sysCfgVO, HttpServletRequest request) {
        Map<String, Object> result;
        try {
            UserBO userBO = this.getUser(request);
            syscfgService.saveSysCfg(sysCfgVO, userBO, this.getLocal(request));
            result = successResult();
        } catch (Exception e) {
            logger.error("保存系统配置失败", e);
            result = failResult();
        }
        return result;
    }

    /**
     * 删除系统配置
     *
     * @param
     */
    @RequestMapping(value = "delete")
    @ResponseBody
    public Map<String, Object> delete(String codes) throws CommException {
        Map<String, Object> result = null;
        if (ParameterUtil.isBlank(codes)) {
            logger.info("删除系统配置失败 codes={}", codes);
            result = failResult("Parameter is null");
            return result;
        }
        try {
            syscfgService.deleteSysCfgByCode(codes);
            result = successResult();
        } catch (Exception e) {
            logger.error("更新系统配置失败", e);
            result = failResult();
        }
        return result;
    }

    /**
     * 根据id获取多语言数据
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "getLanguageById")
    @ResponseBody
    public Map<String, Object> getLanguageById(Integer id) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("data", syscfgService.getLanguageById(id,this.getLanguage()));
        return map;
    }
}
