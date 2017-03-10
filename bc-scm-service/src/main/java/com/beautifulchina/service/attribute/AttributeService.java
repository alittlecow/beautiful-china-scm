/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: fengbaitong
 * date: 2015-11-25
 */
package com.beautifulchina.service.attribute;

import com.beautifulchina.attribute.bo.AttributeBO;
import com.beautifulchina.attribute.vo.AddAttrVO;
import com.beautifulchina.attribute.vo.AttributeVO;
import com.beautifulchina.attributevalue.bo.AttributeValueBO;
import com.beautifulchina.common.Page;
import com.beautifulchina.dao.attribute.AttributeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 供应商相关服务
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class AttributeService {

    @Autowired
    private AttributeMapper attributeMapper;


    /**
     * 获取属性列表
     */
    @Transactional(propagation= Propagation.NOT_SUPPORTED,readOnly =true)
    public Page<AttributeBO> getAll(AttributeVO attributeVO){
        int count=attributeMapper.getAttributeCount(attributeVO);
        Page<AttributeBO> attributePage = new Page<AttributeBO>();
        if(count>0){
            List<AttributeBO> attributeList= attributeMapper.getAll(attributeVO);
            List<AttributeValueBO> valueList=attributeMapper.getAllAttributeValue(attributeVO);
            /**
             * 把属性名和属性值分别从数据库里取出来,因为这是一对多的关系,
             * 所以AttributeBO的属性值为拼接的字符串用<br>相连接用于前段grid的显示
             */
            for(AttributeBO attributeBO:attributeList){
                for(AttributeValueBO attributeValueBO:valueList){
                    Integer attrBOId=attributeBO.getAttributeId();
                    Integer attrId=attributeValueBO.getAttrId();
                    if(attrBOId==attrId){
                        if(attributeBO.getAttributeValueEn()==null||attributeBO.getAttributeValueEn()==""){
                            attributeBO.setAttributeValueEn(attributeValueBO.getValueEn());
                            attributeBO.setAttributeValue(attributeValueBO.getAttributeValue());
                        }else{
                            attributeBO.setAttributeValueEn(
                                    attributeBO.getAttributeValueEn()+"<br>"+attributeValueBO.getValueEn());
                            attributeBO.setAttributeValue(attributeBO.getAttributeValue()+"<br>"+attributeValueBO.getAttributeValue());
                        }
                        if(attributeBO.getAttributeValueFr()==null||attributeBO.getAttributeValueFr()==""){
                            attributeBO.setAttributeValueFr(attributeValueBO.getValueFr());
                            attributeBO.setAttributeValue(attributeValueBO.getAttributeValue());
                        }else{
                            attributeBO.setAttributeValueFr(attributeBO.getAttributeValueFr()+"<br>"+
                                    attributeValueBO.getValueFr());
                            attributeBO.setAttributeValue(attributeBO.getAttributeValue()+"<br>"+attributeValueBO.getAttributeValue());
                        }

                    }
                }
            }

            attributePage.setData(attributeList);
            attributePage.setTotal(count);
        }
        return attributePage;
    }

    /**
     * 保存新增的属性名称
     * @param addAttrVO
     */
    public void saveAttribute(AddAttrVO addAttrVO){
        attributeMapper.saveAttribute(addAttrVO);
    }

    /**
     * 更新属性名称
     * @param attributeVO
     */
    public void updateAttribute(AttributeVO attributeVO){
        attributeMapper.updateAttribute(attributeVO);
    }

    /**
     * 根据属性id获取属性值列表
     * @param attrId
     * @return
     */
    @Transactional(propagation= Propagation.NOT_SUPPORTED,readOnly =true)
    public List<AttributeValueBO> getAttrValueList(Integer attrId,String language){
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("attrId",attrId);
        map.put("language",language);
        return attributeMapper.getAttrValueList(map);
    }

    /**
     * 根据id编号删除属性和相关的属性值
     */
    public void deleteAttributeById(String id){
        attributeMapper.deleteAttribute(id);
        attributeMapper.deleteAttributeValue(id);
    }

    /**
     * 新增属性值
     * @param attrValue
     */
    public void addAttrValue(AttributeValueBO attrValue){
        attributeMapper.addAttrValue(attrValue);
    }

    /**
     * 更新属性值
     * @param attrValue
     */
    public void updateAttrValue(AttributeValueBO attrValue){
        attributeMapper.updateAttrValue(attrValue);
    }

    /**
     * 删除属性值
     * @param ids
     */
    public void deleteAttrValue(String ids){
        List<String> list = CollectionUtils.arrayToList(ids.split(","));
        attributeMapper.deleteAttrValue(list);
    }



}
