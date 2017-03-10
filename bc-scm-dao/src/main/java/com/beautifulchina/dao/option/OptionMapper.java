/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 选项Dao
 * @author: liufei
 * date: 2015-12-22
 */
package com.beautifulchina.dao.option;

import com.beautifulchina.base.SqlMapper;
import com.beautifulchina.option.bo.OptionBO;

import java.util.List;

public interface OptionMapper extends SqlMapper{
    /**
     * 获取选项
     * @param optionBO
     * @return
     */
    public List<OptionBO> getOption(OptionBO optionBO);

    /**
     * 获取选项信息数量
     * @param optionBO
     * @return
     */
    public int getOptionCount(OptionBO optionBO);

    /**
     * 保存选项
     */
    public void saveName(OptionBO optionBO);

    /**
     *  删除选项
     * @param codes
     */
    public void deleteName(String codes);

    /**
     * 判断是否可以删除
     * @param optionBO
     * @return
     */
    public int judgeOptionId(OptionBO optionBO);

    /**
     * 根据optionId取valueId
     * @param id
     * @return
     */
    public List<Integer> getOptionById(Integer id);
}
