/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 * @author: chenghuanhuan
 * date: 2015-10-22
 */
package com.beautifulchina.service.user;

import com.beautifulchina.mongo.dao.usercenter.impl.UserMongoDaoImpl;
import com.beautifulchina.user.bo.UserTestBO;
import com.beautifulchina.dao.user.UserMapper;
import com.beautifulchina.pojo.user.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 用户服务
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserService {

    private static Logger logger = LoggerFactory.getLogger(UserService.class);
    /**
     * 使用@Autowired注解标注userMapper变量，
     * 当需要使用UserMapper时，Spring就会自动注入UserMapper
     */
    @Autowired
    private UserMapper userMapper;//注入dao
    @Autowired
    private UserMongoDaoImpl userMongoDao;
    public void addUser(UserTestBO userBO) {
        logger.trace("Hello World! this is addUser method!");
        logger.debug("How are you today?");
        logger.info("I am fine.");
        logger.warn("I love programming.");
        logger.error("I am programming.");
        userMapper.insert(userBO);
    }

    /**
     * 通过用户编号获取用户信息
     * @param userId
     * @return
     */
    public UserTestBO getUserById(String userId) {

        User user = userMapper.selectByPrimaryKey(userId);
        UserTestBO userBO = new UserTestBO();
        BeanUtils.copyProperties(user, userBO);
        return userBO;
    }

    public void saveUserToMongodb(UserTestBO userBO){

        userMongoDao.save(userBO);
    }
}
