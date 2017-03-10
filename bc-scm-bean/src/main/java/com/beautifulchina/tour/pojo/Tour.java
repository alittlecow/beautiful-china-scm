/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: dongjingjun
 * date: 2015-12-25
 */
package com.beautifulchina.tour.pojo;

import com.beautifulchina.tour.bo.TourBO;

/**
 * 旅游线路pojo
 */
public class Tour extends TourBO {
    /**
     * 类别id
     */
    private Integer categoryId;

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }
}
