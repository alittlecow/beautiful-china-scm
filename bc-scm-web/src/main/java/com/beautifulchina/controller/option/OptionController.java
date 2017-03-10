/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: liufei
 * date: 2015-12-22
 */
package com.beautifulchina.controller.option;

import com.beautifulchina.base.BaseController;
import com.beautifulchina.common.Page;
import com.beautifulchina.exception.CommException;
import com.beautifulchina.option.bo.OptionListBO;
import com.beautifulchina.option.bo.ValueListBO;
import com.beautifulchina.option.vo.OptionVO;
import com.beautifulchina.option.vo.ValueVO;
import com.beautifulchina.service.option.OptionNameService;
import com.beautifulchina.service.option.OptionValueService;
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
import java.util.Map;

/**
 * 选项管理控制器
 */
@Controller
@RequestMapping(value = "/option")
public class OptionController extends BaseController {
    private static Logger logger = LoggerFactory.getLogger(OptionController.class);

    @Autowired
    private OptionNameService optionNameService;

    @Autowired
    private OptionValueService optionValueService;
    /**
     * 查询选项列表
     * @param optionVO
     * @return
     */
    @RequestMapping(value = "queryName")
    @ResponseBody
    public Page<OptionListBO> queryOption(@Valid OptionVO optionVO,HttpServletRequest request){
        String language=this.getLocal(request);
        UserBO userBO = this.getUser(request);
        optionVO.setLanguage(language);

        Page<OptionListBO> page = optionNameService.getOptionList(optionVO,userBO);
        return page;
    }



    /**
     * 保存选项名
     * @param optionVO
     * @return
     */
    @RequestMapping(value = "saveName")
    @ResponseBody
    public Map<String,Object> saveName(@Valid OptionVO optionVO, HttpServletRequest request){
        System.out.println(optionVO);
        Map<String,Object> result;
        try{
            UserBO userBO = this.getUser(request);
            optionNameService.saveOption(optionVO,userBO);
            result = successResult();
        } catch (Exception e) {
            logger.error("保存选项失败",e);
            result = failResult();
        }
        return result;
    }



    /**
     * 删除选项
     * @param codes
     * @return
     * @throws CommException
     */
    @RequestMapping(value = "deleteName")
    @ResponseBody
    public Map<String,Object> deleteName(String codes) throws CommException {
        Map<String,Object> result = null;
            try{
                if(optionNameService.deleteOptionCode(codes) == 0){
                    if(ParameterUtil.isBlank(codes)){
                        logger.info("删除选项失败 codes={}",codes);
                        result = failResult("Parameter is null");
                        return result;
                    }
                }else{
                    logger.info("选项已占用,删除选项失败 codes={}",codes);
                    result = failResult("选项已占用，删除选项失败");
                }
            }catch (Exception e){
                logger.error("更新选项失败",e);
                result = failResult();
            }
            return result;


    }

    /**
     * 查询选项值列表
     *
     * @param valueVO
     * @return
     */
    @RequestMapping(value = "queryValue")
    @ResponseBody
    public Page<ValueListBO> queryValue(@Valid ValueVO valueVO,HttpServletRequest request) {
        String language=this.getLocal(request);
        valueVO.setLanguage(language);

        Page<ValueListBO> page = optionValueService.getValueList(valueVO);
        return page;
    }

    /**
     * 保存选项值
     *
     * @param valueVO
     * @param request
     * @return
     */
    @RequestMapping(value = "saveValue")
    @ResponseBody
    public Map<String, Object> saveValue(@Valid ValueVO valueVO, HttpServletRequest request) {
        Map<String, Object> result;
        try {
            UserBO userBO = this.getUser(request);
            optionValueService.saveValue(valueVO, userBO);
            result = successResult();
        } catch (Exception e) {
            logger.error("保存选项值失败", e);
            result = failResult();
        }
        return result;
    }

    /**
     * 更新选项值
     *
     * @param valueVO
     * @return
     */
    @RequestMapping(value = "updateValue")
    @ResponseBody
    public Map<String,Object> updateValue(@Valid ValueVO valueVO, HttpServletRequest request){
        Map<String,Object> result = null;
        if(valueVO.getValueId() == null){
            logger.info("更新选项值失败 valueId={}",valueVO.getValueId());
            result = failResult("Parameter is null");
        }else {
            try {
                UserBO userBO = this.getUser(request);
                optionValueService.updateValue(valueVO, userBO);
                result = successResult();
            } catch (Exception e) {
                logger.error("更新分类管理信息失败", e);
                result = failResult();
            }
        }
        return result;
    }

    /**
     * 删除选项值
     * @param codes
     * @return
     * @throws CommException
     */
    @RequestMapping(value = "deleteValue")
    @ResponseBody
    public Map<String, Object> deleteValue(String codes) throws CommException {
        Map<String, Object> result = null;
        try {
            if(optionValueService.deleteValueCode(codes) == 0){
                if (ParameterUtil.isBlank(codes)) {
                    logger.info("删除选项值失败 codes={}", codes);
                    result = failResult("Parameter is null");
                    return result;
                }
            }else{
                logger.info("选项值已占用,删除选项值失败 codes={}",codes);
                result = failResult("选项已占用，删除选项值失败");
            }
        } catch (Exception e) {
            logger.error("删除选项值失败", e);
            result = failResult();
        }
        return result;
    }

}
