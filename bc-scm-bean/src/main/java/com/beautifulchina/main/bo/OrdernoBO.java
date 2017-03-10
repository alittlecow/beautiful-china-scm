/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: chengxuemin
 * date: 2015-12-11
 */
package com.beautifulchina.main.bo;

import com.beautifulchina.mailhistory.vo.OrdernoVO;
/**
 * 关联单号
 */
public class OrdernoBO extends OrdernoVO {
    /**
     * 编号
     */
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }


}
