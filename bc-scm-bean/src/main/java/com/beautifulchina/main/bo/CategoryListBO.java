/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: chengxuemin
 * date: 2015-12-24
 */

package com.beautifulchina.main.bo;

import com.beautifulchina.category.vo.CategoryVO;

/**
 * 分类管理
 */
public class CategoryListBO extends CategoryVO {
    /**
     * 分类名称代码
     */
    private String name;

    @Override
    public String getName() { return name; }

    @Override
    public void setName(String name) { this.name = name; }
}
