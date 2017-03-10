/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: chenghuanhuan
 * date: 2016-01-05
 */
package com.beautifulchina.menu.vo;


import com.beautifulchina.base.Base;

import java.util.List;

/**
 * 菜单删除(注意此处无需继承BaseBean,只需继承Base)
 */
public class MenuDeleteVO extends Base {

    /**
     * 所有的菜单代码
     */
    private List<String> codes;

    public List<String> getCodes() {
        return codes;
    }

    public void setCodes(List<String> codes) {
        this.codes = codes;
    }
}
