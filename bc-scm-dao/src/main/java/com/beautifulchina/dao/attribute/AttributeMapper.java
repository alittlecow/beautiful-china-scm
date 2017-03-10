/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: chenghuanhuan
 * date: 2015-12-10
 */
package com.beautifulchina.dao.attribute;

import com.beautifulchina.attribute.bo.AttributeBO;
import com.beautifulchina.attribute.vo.AddAttrVO;
import com.beautifulchina.attribute.vo.AttributeVO;
import com.beautifulchina.attributevalue.bo.AttributeValueBO;
import com.beautifulchina.base.SqlMapper;
import com.beautifulchina.supplier.vo.SupplierVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 分类
 */
@Repository
public interface AttributeMapper extends SqlMapper {

    /**
     * 获取所有属性信息
     * @param attributeVO
     * @return
     */
    List<AttributeBO> getAll(AttributeVO attributeVO);

    /**
     * @param attributeVO
     * @return
     */
    int getAttributeCount(AttributeVO attributeVO);

    /**
     * 保存新增的属性名称
     */
    void saveAttribute(AddAttrVO addAttrVO);

    /**
     * 更新属性名称
     */
    void updateAttribute(AttributeVO attributeVO);

    /**
     * 获取所有属性值
     */
    List<AttributeValueBO> getAllAttributeValue(AttributeVO attributeVO);

    /**
     * 根据属性id获取属性值
     */
    List<AttributeValueBO> getAttrValueList(Map<String,Object> map);

    /**
     * 根据id删除属性
     */
    void deleteAttribute(String id);

    /**
     * 根据id删除属性
     */
    void deleteAttributeValue(String id);

    /**
     * 新增属性值
     * @param attrValue
     */
    void addAttrValue(AttributeValueBO attrValue);

    /**
     * 更新属性值
     * @param attrValue
     */
    void updateAttrValue(AttributeValueBO attrValue);

    /**
     * 删除属性值
     * @param ids
     */
    void deleteAttrValue(List<String> ids);


}
