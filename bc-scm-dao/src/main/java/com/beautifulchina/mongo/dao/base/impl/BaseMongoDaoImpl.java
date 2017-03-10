/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: chenghuanhuan
 * date: 2015-11-02
 */
package com.beautifulchina.mongo.dao.base.impl;

import com.beautifulchina.base.Page;
import com.beautifulchina.mongo.dao.base.BaseMongoDao;
import com.beautifulchina.util.ReflectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * mongodb基类实现
 */
@Repository
public class BaseMongoDaoImpl<T> implements BaseMongoDao<T> {

    /** 默认分页起始 */
    private static final int DEFAULT_SKIP = 0;
    /** 默认分页限制个数 */
    private static final int DEFAULT_LIMIT = 200;

    /**
     * spring mongodb　集成操作类　
     */
    @Autowired
    protected MongoTemplate mongoTemplate;

    public List<T> find(Query query) {
        return mongoTemplate.find(query, this.getEntityClass());
    }

    public T findOne(Query query) {
        return mongoTemplate.findOne(query, this.getEntityClass());
    }

    public void update(Query query, Update update) {
        mongoTemplate.findAndModify(query, update, this.getEntityClass());
    }

    public T save(T entity) {
        mongoTemplate.insert(entity);
        return entity;
    }

    public T findById(String id) {
        return mongoTemplate.findById(id, this.getEntityClass());
    }

    public T findById(String id, String collectionName) {
        return mongoTemplate.findById(id, this.getEntityClass(), collectionName);
    }

    public Page<T> findPage(Page<T> page,Query query){
        long count = this.count(query);
        page.setTotal(count);
        int pageNumber = page.getPageNo();
        int pageSize = page.getPageSize();
        query.skip((pageNumber - 1) * pageSize).limit(pageSize);
        List<T> rows = this.find(query);
        page.setData(rows);
        return page;
    }

    public long count(Query query){
        return mongoTemplate.count(query, this.getEntityClass());
    }


    /**
     * 获取需要操作的实体类class
     *
     * @return
     */
    private Class<T> getEntityClass(){
        return ReflectionUtils.getSuperClassGenricType(getClass());
    }


}
