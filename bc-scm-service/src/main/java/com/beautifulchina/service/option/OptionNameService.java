/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: liufei
 * date: 2015-12-22
 */
package com.beautifulchina.service.option;

import com.beautifulchina.common.Page;
import com.beautifulchina.dao.option.OptionMapper;
import com.beautifulchina.dao.option.ValueMapper;
import com.beautifulchina.exception.RedisException;
import com.beautifulchina.option.bo.OptionBO;
import com.beautifulchina.option.bo.OptionListBO;
import com.beautifulchina.option.vo.OptionVO;
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
 * 选项相关
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class OptionNameService {
    @Autowired
    private OptionMapper optionMapper;

    @Autowired
    private ValueMapper valueMapper;
    /**
     * 查询选项
     */
    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public Page<OptionListBO> getOptionList(OptionVO optionVO,UserBO userBO){
        OptionBO optionBO = new OptionBO();
        if("SUPPLIER".equalsIgnoreCase(userBO.getDeptInfoBO().getLevelCode())){
            optionVO.setDeptCode(userBO.getDeptInfoBO().getDeptCode());
        }
        BeanUtils.copyProperties(optionVO,optionBO);
        int count = optionMapper.getOptionCount(optionBO);
        List<OptionListBO>  optionBOList = new ArrayList<OptionListBO>();
        Page<OptionListBO> optionBOPage = new Page<OptionListBO>();
        if(count > 0){
            List<OptionBO> optionList = optionMapper.getOption(optionBO);
            if(!CollectionUtils.isEmpty(optionList)){
                for(OptionBO option:optionList){
                    OptionListBO optionListBO = new OptionListBO();
                    BeanUtils.copyProperties(option,optionListBO);
                    optionBOList.add(optionListBO);
                }
            }
        }
        optionBOPage.setTotal(count);
        optionBOPage.setData(optionBOList);
        return  optionBOPage;
    }

    /**
     * 保存选项
     * @param optionVO
     */
    public void saveOption(OptionVO optionVO, UserBO userBO) throws RedisException {
        OptionBO optionBO = new OptionBO();
        if("SUPPLIER".equalsIgnoreCase(userBO.getDeptInfoBO().getLevelCode())){
            optionVO.setDeptCode(userBO.getDeptInfoBO().getDeptCode());
        }
        BeanUtils.copyProperties(optionVO,optionBO);
        optionMapper.saveName(optionBO);
    }

    /**
     * 判断是否可以删除
     * @param optionVO
     */
    public int judge(OptionVO optionVO){
        OptionBO optionBO = new OptionBO();
        BeanUtils.copyProperties(optionVO,optionBO);
        int number = optionMapper.judgeOptionId(optionBO);
        return number;
    }


    /**
     * 根据选项编号删除选项
     * @param codes
     */
    public int deleteOptionCode(String codes){
        OptionBO optionBO = new OptionBO();
        optionBO.setOptionId(Integer.valueOf(codes));
        if(optionMapper.judgeOptionId(optionBO)==0){
            optionMapper.deleteName(codes);
            valueMapper.deleteOption(codes);
            return 0;
        }
        return 1;
    }


}
