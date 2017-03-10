/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: fengbaitong
 * date: 2015-11-25
 */
package com.beautifulchina.controller.attribute;


import com.beautifulchina.attribute.bo.AttributeBO;
import com.beautifulchina.attribute.vo.AddAttrVO;
import com.beautifulchina.attribute.vo.AttributeVO;
import com.beautifulchina.attributevalue.bo.AttributeValueBO;
import com.beautifulchina.base.BaseController;
import com.beautifulchina.common.Page;
import com.beautifulchina.exception.CommException;
import com.beautifulchina.service.attribute.AttributeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;


/**
 *供应商管理控制器
 */
@Controller
@RequestMapping(value = "/attribute")
public class AttributeController extends BaseController{

    private static Logger logger = LoggerFactory.getLogger(AttributeController.class);

    @Autowired
    private AttributeService attributeService;

    /**
     * 获取所有属性
     */
    @RequestMapping(value = "list")
    @ResponseBody
    public Page<AttributeBO> list(AttributeVO attributeVO,HttpServletRequest request){
        String language = this.getLocal(request);
        attributeVO.setLanguage(language);
        Page<AttributeBO> page = attributeService.getAll(attributeVO);
        return page;
    }

    /**
     * 保存新增的属性名称
     * @param addAttrVO
     * @return
     */
    @RequestMapping(value = "saveAttribute")
    @ResponseBody
    public Map<String,Object> saveAttribute(AddAttrVO addAttrVO){
        Map<String,Object> result = null;
        try{
            attributeService.saveAttribute(addAttrVO);
            result = successResult();
        }catch (Exception e){
            logger.error("保存属性值失败",e);
            result = failResult();
        }
        return result;
    }

    /**
     * 编辑属性名称
     * @param attributeVO
     * @return
     */
    @RequestMapping(value = "editAttribute")
    @ResponseBody
    public Map<String,Object> editAttribute(AttributeVO attributeVO){
        Map<String,Object> result = null;
        try{
            attributeService.updateAttribute(attributeVO);
            result = successResult();
        }catch (Exception e){
            logger.error("更新属性失败",e);
            result = failResult();
        }
        return result;
    }


    /**
     * 根据属性id获取所有属性值
     */
    @RequestMapping(value = "getAttrValueList")
    @ResponseBody
    public List<AttributeValueBO> getAttrValueList(Integer id,HttpServletRequest request){
        String language=this.getLocal(request);
        List<AttributeValueBO> list = attributeService.getAttrValueList(id,language);
        return list;
    }

    /**
     * 删除属性名与相关属性值
     */
    @RequestMapping(value = "delete")
    @ResponseBody
    public Map<String,Object> delete(String id) throws CommException {
        Map<String,Object> result = null;
        // TODO 权限判断
        if(id==null){
            logger.info("删除属性失败 id={}",id);
            result = failResult("Parameter is null");
            return result;
        }
        try{
            attributeService.deleteAttributeById(id);
            result = successResult();
        }catch (Exception e){
            logger.error("删除属性失败",e);
            result = failResult();
        }

        return result;
    }

    /**
     * 删除属性值
     */
    @RequestMapping(value = "deleteAttrValue")
    @ResponseBody
    public Map<String,Object> deleteAttrValue(String ids) throws CommException {
        Map<String,Object> result = null;
        // TODO 权限判断
        try{
            attributeService.deleteAttrValue(ids);
            result = successResult();
        }catch (Exception e){
            logger.error("删除属性值失败",e);
            result = failResult();
        }

        return result;
    }


    /**
     * 新增属性值
     * @param attrValue
     * @return
     */
    @RequestMapping(value = "addAttrValue")
    @ResponseBody
    public Map<String,Object> addAttrValue(AttributeValueBO attrValue) {
        Map<String,Object> result = null;
        try{
            attributeService.addAttrValue(attrValue);
            result = successResult();
        }catch (Exception e){
            logger.error("增加属性值失败",e);
            result = failResult();
        }
        return result;
    }

    /**
     * 更新属性值
     * @param attrValue
     * @return
     */
    @RequestMapping(value = "editAttrValue")
    @ResponseBody
    public Map<String,Object> updateAttrValue(AttributeValueBO attrValue) {
        Map<String,Object> result = null;
        try{
            attributeService.updateAttrValue(attrValue);
            result = successResult();
        }catch (Exception e){
            logger.error("增加属性值失败",e);
            result = failResult();
        }
        return result;
    }





}
