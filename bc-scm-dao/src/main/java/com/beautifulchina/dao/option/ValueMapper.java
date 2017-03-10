/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 选项值Dao
 * @author: liufei
 * date: 2015-12-22
 */
package com.beautifulchina.dao.option;

import com.beautifulchina.base.SqlMapper;
import com.beautifulchina.option.bo.ValueBO;
import com.beautifulchina.option.vo.ValueVO;

import java.util.List;


public interface ValueMapper extends SqlMapper {

    /**
     * 获取选项
     * @param valueBO
     * @return
     */
    public List<ValueVO> getValue(ValueBO valueBO);

    /**
     * 获取选项数量
     * @param valueBO
     * @return
     */
    public int getValueCount(ValueBO valueBO);


    /**
     * 保存选项
     */
    public void saveValue(ValueBO valueBO);

    /**
     *  删除选项
     * @param codes
     */
    public void deleteValue(List<String> codes);

    /**
     * 判断是否可以删除
     * @param valueBO
     * @return
     */
    public int judgeValueId(ValueBO valueBO);

    /**
     * 根据选项id删除选项值
     * @param codes
     */
    public void deleteOption(String codes);

    /**
     * 更新选项
     */
    public void updateValue(ValueBO valueBO);

}
