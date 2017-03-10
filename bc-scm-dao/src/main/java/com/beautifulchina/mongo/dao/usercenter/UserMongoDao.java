/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: chenghuanhuan
 * date: 2015-11-02
 */
package com.beautifulchina.mongo.dao.usercenter;

import com.beautifulchina.mongo.dao.base.BaseMongoDao;

/**
 * 测试
 */
public interface UserMongoDao<UserBO> extends BaseMongoDao {
    public void insertTest(UserBO userBO);
}
