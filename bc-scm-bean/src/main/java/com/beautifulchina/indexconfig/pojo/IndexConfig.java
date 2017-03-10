/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: dongjingjun
 * date: 2016-03-04
 */
package com.beautifulchina.indexconfig.pojo;

import com.beautifulchina.indexconfig.bo.IndexConfigBO;

public class IndexConfig extends IndexConfigBO {
    String ids;
    String ItemIds;
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }

    public String getItemIds() {
        return ItemIds;
    }

    public void setItemIds(String itemIds) {
        ItemIds = itemIds;
    }
}
