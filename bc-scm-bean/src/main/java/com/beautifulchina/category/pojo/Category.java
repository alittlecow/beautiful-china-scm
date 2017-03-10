/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: chengxuemin
 * date: 2015-12-24
 */

package com.beautifulchina.category.pojo;

import com.beautifulchina.category.bo.CategoryBO;

/**
 * 分类管理
 */
public class Category extends CategoryBO {
    /**
     * 分类名称代码pojo
     */
    private String inputName;

    public String getInputName() { return inputName; }

    public void setInputName(String inputName) { this.inputName = inputName; }
}
