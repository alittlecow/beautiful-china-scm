/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: chengxuemin
 * date: 2015-12-22
 */

package com.beautifulchina.main.bo;

import com.beautifulchina.linetheme.vo.LineThemeVO;

/**
 * 线路主题管理
 */
public class LineThemeListBO extends LineThemeVO {
    /**
     * 主题id
     */
    private Integer id;

    /**
     * 主题名称
     */
    private String title;

    @Override
    public Integer getId() { return id; }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
