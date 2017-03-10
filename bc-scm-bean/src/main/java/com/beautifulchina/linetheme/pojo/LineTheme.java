/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: chengxuemin
 * date: 2015-12-22
 */

package com.beautifulchina.linetheme.pojo;

import com.beautifulchina.linetheme.bo.LineThemeBO;

/**
 * 线路主题管理pojo
 */
public class LineTheme extends LineThemeBO {
    /**
     * 主题代码
     */
    private String inputCode;

    /**
     * 主题名称
     */
    private String inputTitle;

    public String getInputCode() { return inputCode; }

    public void setInputCode(String inputCode) { this.inputCode = inputCode; }

    public String getInputTitle() { return inputTitle; }

    public void setInputTitle(String inputTitle) { this.inputTitle = inputTitle; }
}
