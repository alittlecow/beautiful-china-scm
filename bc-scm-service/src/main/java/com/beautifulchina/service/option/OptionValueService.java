/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: liufei
 * date: 2015-12-22
 */
package com.beautifulchina.service.option;

import com.beautifulchina.common.Page;
import com.beautifulchina.dao.option.ValueMapper;
import com.beautifulchina.exception.RedisException;
import com.beautifulchina.option.bo.ValueBO;
import com.beautifulchina.option.bo.ValueListBO;
import com.beautifulchina.option.vo.ValueVO;
import com.beautifulchina.user.bo.UserBO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 选项值相关
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class OptionValueService {
    @Autowired
    public ValueMapper valueMapper;

    /**
     * 根据条件获取所有选项值信息
     * @param valueVO
     * @return
     */
    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public Page<ValueListBO> getValueList(ValueVO valueVO){
        ValueBO valueBO = new ValueBO();
        BeanUtils.copyProperties(valueVO,valueBO);
        int count = valueMapper.getValueCount(valueBO);
        List<ValueListBO> valueBOList = new ArrayList<ValueListBO>();
        Page<ValueListBO> valueBOPage = new Page<ValueListBO>();
        if(count > 0){
            List<ValueVO> valueList = valueMapper.getValue(valueBO);
            if(!CollectionUtils.isEmpty(valueList)){
                for(ValueVO value:valueList){
                    ValueListBO optionListBO = new ValueListBO();
                    BeanUtils.copyProperties(value,optionListBO);
                    valueBOList.add(optionListBO);
                }
            }
        }
        valueBOPage.setTotal(count);
        valueBOPage.setData(valueBOList);
        return  valueBOPage;
    }

    /**
     * 保存选项值
     * @param valueVO
     */
    public void saveValue(ValueVO valueVO, UserBO userBO) throws RedisException {
        ValueBO valueBO = new ValueBO();
        BeanUtils.copyProperties(valueVO,valueBO);
        valueMapper.saveValue(valueBO);
    }

    /**
     * 更新选项值
     * @param valueVO
     */
    public void updateValue(ValueVO valueVO, UserBO userBO) throws RedisException {
        ValueBO valueBO = new ValueBO();
        BeanUtils.copyProperties(valueVO,valueBO);
        valueMapper.updateValue(valueBO);
    }

    /**
     * 判断是否可以删除
     * @param valueVO
     */
    public int judge(ValueVO valueVO){
        ValueBO valueBO = new ValueBO();
        BeanUtils.copyProperties(valueVO,valueBO);
        int number = valueMapper.judgeValueId(valueBO);
        return number;
    }
    
    /**
     * 根据选项值编号删除选项值
     * @param codes
     */
    public int deleteValueCode(String codes){
        ValueBO valueBO = new ValueBO();
        valueBO.setValueId(Integer.valueOf(codes));
        if(valueMapper.judgeValueId(valueBO) == 0){
            List<String> list = CollectionUtils.arrayToList(codes.split(","));
            valueMapper.deleteValue(list);
            return 0;
        }
        return 1;
    }

}
