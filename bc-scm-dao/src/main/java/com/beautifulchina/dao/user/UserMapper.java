/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 * @author: chenghuanhuan
 * date: 2015-10-22
 */
package com.beautifulchina.dao.user;

import com.beautifulchina.base.SqlMapper;
import com.beautifulchina.user.bo.UserTestBO;
import com.beautifulchina.pojo.user.User;
import org.springframework.stereotype.Repository;

/**
 * 用户Mapper
 */
@Repository
public interface UserMapper extends SqlMapper {

    int insert(UserTestBO userBO);

    User selectByPrimaryKey(String userId);
}
