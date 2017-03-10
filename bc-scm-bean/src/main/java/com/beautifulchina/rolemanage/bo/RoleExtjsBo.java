/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: dongjingjun
 * date: 2015-12-21
 */
package com.beautifulchina.rolemanage.bo;

import com.beautifulchina.main.bo.MenuExtjsBO;

/**
 * 角色树模块
 */
public class RoleExtjsBo extends MenuExtjsBO {
    /**
     * 复选框
     */
    private boolean checked;

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}
