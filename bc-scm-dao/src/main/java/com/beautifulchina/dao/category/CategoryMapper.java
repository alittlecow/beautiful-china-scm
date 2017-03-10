/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: chengxuemin
 * date: 2015-12-24
 */

package com.beautifulchina.dao.category;

import com.beautifulchina.base.SqlMapper;
import com.beautifulchina.category.bo.CategoryBO;
import com.beautifulchina.category.pojo.Category;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 分类管理dao
 */
public interface CategoryMapper extends SqlMapper {
    /**
     * 根据条件获取所有的分类管理信息列表
     * @param categoryBO
     * @return
     */
    public List<Category> getAllCategoryList(CategoryBO categoryBO);

    /**
     * 根据条件获取所有的分类管理信息数量
     * @param categoryBO
     * @return
     */
    public int getAllCategoryListCount(CategoryBO categoryBO);

    /**
     * 进入子分类管理信息列表
     * @param categoryBO
     * @return
     */
    public List<Category> getAllIntoSubCategoryList(CategoryBO categoryBO);

    /**
     * 根据id查询分类
     * @param categoryBO
     * @return
     */
    public List<Category> getCategoryListById(CategoryBO categoryBO);

    /**
     * 进入的子分类管理信息数量
     * @param categoryBO
     * @return
     */
    public int getAllIntoSubCategoryListCount(CategoryBO categoryBO);

    /**
     * 返回父分类管理信息列表
     * @param categoryBO
     * @return
     */
    public List<Category> getAllReturnCategoryList(CategoryBO categoryBO);

    /**
     * 返回的父分类管理信息数量
     * @param categoryBO
     * @return
     */
    public int getAllReturnCategoryListCount(CategoryBO categoryBO);

    /**
     * 添加分类管理子类
     * @param categoryBO
     */
    public void addASub(CategoryBO categoryBO);

    /**
     * 更新分类管理
     * @param categoryBO
     */
    public void update(CategoryBO categoryBO);

    /**
     * 根据分类管理编号删除菜单
     * @param codes
     */
    void delete(List<String> codes);


    /**
     * 获取所有分类，名称，等级，parent字段
     */
    List<CategoryBO> getAllCategory(@Param(value = "language")String language);

    /**
     * 获取分类总数
     */
    int getCategoryCount(Category category);

    /**
     * 获取子节点
     * @param codes
     * @return
     */
    List<Integer> getChildrenById(List<Integer> ids);

}
