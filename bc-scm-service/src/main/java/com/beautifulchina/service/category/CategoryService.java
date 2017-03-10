/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: chengxuemin
 * date: 2015-12-22
 */

package com.beautifulchina.service.category;

import com.beautifulchina.category.bo.CategoryExtjsBO;
import com.beautifulchina.common.Page;
import com.beautifulchina.dao.category.CategoryMapper;
import com.beautifulchina.exception.RedisException;
import com.beautifulchina.category.bo.CategoryBO;
import com.beautifulchina.category.pojo.Category;
import com.beautifulchina.category.vo.CategoryVO;
import com.beautifulchina.main.bo.CategoryListBO;
import com.beautifulchina.user.bo.UserBO;
import org.springframework.beans.BeanUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 分类管理相关服务
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    /**
     * 根据条件获取所有分类管理信息
     * @param categoryVO
     * @return
     */
    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public Page<CategoryListBO> getAllCategoryList(CategoryVO categoryVO) {
        CategoryBO categoryBO = new CategoryBO();
        BeanUtils.copyProperties(categoryVO, categoryBO);
        //如果是返回上一级分类将id清空
        if("returnSub".equals(categoryBO.getFlag())){
            categoryBO.setParent(categoryBO.getId());
            List<Category> categoryList = categoryMapper.getCategoryListById(categoryBO);
            Category c = categoryList.get(0);
            BeanUtils.copyProperties(categoryVO, categoryBO);
            categoryBO.setId(c.getParent());
        }
        //根据条件获取所有的分类管理信息数量
        int count = categoryMapper.getAllCategoryListCount(categoryBO);
        List<CategoryListBO> categoryListBOList = new ArrayList<CategoryListBO>();
        Page<CategoryListBO> categoryListBOPage = new Page<CategoryListBO>();
        if (count > 0) {
            List<Category> categoryList = categoryMapper.getAllCategoryList(categoryBO);
            if (!CollectionUtils.isEmpty(categoryList)) {
                for (Category category : categoryList) {
                    CategoryListBO categoryListBO = new CategoryListBO();
                    BeanUtils.copyProperties(category, categoryListBO);
                    categoryListBOList.add(categoryListBO);
                }
            }
        }
        categoryListBOPage.setTotal(count);
        categoryListBOPage.setData(categoryListBOList);
        return categoryListBOPage;
    }

    /**
     * 进入子分类管理信息
     * @param categoryVO
     * @return
     */
    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public Page<CategoryListBO> getAllIntoSubCategoryList(CategoryVO categoryVO) {
        CategoryBO categoryBO = new CategoryBO();
        BeanUtils.copyProperties(categoryVO, categoryBO);
        int count = categoryMapper.getAllIntoSubCategoryListCount(categoryBO);
        List<CategoryListBO> categoryListBOList = new ArrayList<CategoryListBO>();
        Page<CategoryListBO> categoryListBOPage = new Page<CategoryListBO>();
        //子分类管理信息列表
        if (count > 0) {
            List<Category> categoryList = categoryMapper.getAllIntoSubCategoryList(categoryBO);
            if (!CollectionUtils.isEmpty(categoryList)) {
                for (Category category : categoryList) {
                    CategoryListBO categoryListBO = new CategoryListBO();
                    BeanUtils.copyProperties(category, categoryListBO);
                    categoryListBOList.add(categoryListBO);
                }
            }
        }
        categoryListBOPage.setTotal(count);
        categoryListBOPage.setData(categoryListBOList);
        return categoryListBOPage;
    }

    /**
     * 返回父分类管理信息
     * @param categoryVO
     * @return
     */
    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public Page<CategoryListBO> getAllReturnCategoryList(CategoryVO categoryVO) {
        CategoryBO categoryBO = new CategoryBO();
        BeanUtils.copyProperties(categoryVO, categoryBO);
        int count = categoryMapper.getAllReturnCategoryListCount(categoryBO);
        List<CategoryListBO> categoryListBOList = new ArrayList<CategoryListBO>();
        Page<CategoryListBO> categoryListBOPage = new Page<CategoryListBO>();
        //返回父分类管理信息列表
        if (count > 0) {
            List<Category> categoryList = categoryMapper.getAllReturnCategoryList(categoryBO);
            if (!CollectionUtils.isEmpty(categoryList)) {
                for (Category category : categoryList) {
                    CategoryListBO categoryListBO = new CategoryListBO();
                    BeanUtils.copyProperties(category, categoryListBO);
                    categoryListBOList.add(categoryListBO);
                }
            }
        }
        categoryListBOPage.setTotal(count);
        categoryListBOPage.setData(categoryListBOList);
        return categoryListBOPage;
    }

    /**
     * 添加子分类管理子类信息
     * @param categoryVO
     */
    public void addASubCategory(CategoryVO categoryVO,UserBO userBO){
        CategoryBO categoryBO = new CategoryBO();
        BeanUtils.copyProperties(categoryVO,categoryBO);
        //根据id查询父类分类
        List<Category> categoryList = categoryMapper.getCategoryListById(categoryBO);
        //生成子类code，修改父类subcode,
        if(categoryList.size() > 0){
            Category parentCategory = categoryList.get(0);
            int subcode = Integer.valueOf(parentCategory.getSubCode());
            int nextsubcode = subcode + 1;
            StringBuilder code = new StringBuilder(parentCategory.getCode());
            int nextsubcodelength = String.valueOf(nextsubcode).length();
            StringBuilder nextsubcodestr = new StringBuilder();
            //判断有没有子类
            while(nextsubcodelength<3){
                nextsubcodestr.append("0");
                nextsubcodelength++;
            }
            nextsubcodestr = nextsubcodestr.append(nextsubcode);
            code = code.append(nextsubcodestr.toString());
            categoryBO.setCode(code.toString());
            parentCategory.setSubCode(nextsubcodestr.toString());

            CategoryBO parentCategoryBO = new CategoryBO();
            BeanUtils.copyProperties(parentCategory,parentCategoryBO);
            categoryMapper.update(parentCategoryBO);

            int level = Integer.valueOf(parentCategory.getLevel())+1;
            categoryBO.setLevel(Integer.valueOf(level));
        }
        //子类的subcode
        categoryBO.setSubCode("000");
        categoryBO.setOperateTime(new Date());
        categoryBO.setOperator(userBO.getUsername());
        categoryMapper.addASub(categoryBO);

    }

    /**
     * 更新分类管理信息
     * @param categoryVO
     */
    public void updateCategory(CategoryVO categoryVO,UserBO userBO){

        CategoryBO categoryBO = new CategoryBO();
        BeanUtils.copyProperties(categoryVO, categoryBO);
        categoryBO.setOperateTime(new Date());
        categoryBO.setOperator(userBO.getUsername());
        categoryMapper.update(categoryBO);
    }

    /**
     * 根据编号删除分类管理信息
     * @param codes
     */
    public boolean deleteCategoryByCode(String codes, Integer[] integers) {
        boolean flag = true;
        List<String> list = CollectionUtils.arrayToList(codes.split(","));
        List<Integer> idList = CollectionUtils.arrayToList(integers);
        List<Integer> children = categoryMapper.getChildrenById(idList);
        if (children.size() == 0) {
            categoryMapper.delete(list);
            flag = false;
        }
        return flag;
    }
     /**
      *  获取category树
     */
    @Transactional(propagation= Propagation.NOT_SUPPORTED,readOnly =true)
    public List<CategoryExtjsBO> getCategoryTree(String language){
        List<CategoryBO> listAll=categoryMapper.getAllCategory(language);//获取所有分类

        /**
         * 获取根节点
         */
        List<CategoryBO> listRoot=new ArrayList<CategoryBO>();
        for(CategoryBO categoryBO :listAll){
            if(categoryBO.getParent()==null||categoryBO.getParent()==0){
                listRoot.add(categoryBO);
            }
        }
        /**
         * 获取关于树的list
         */
        List<CategoryExtjsBO> categoryExtjsBOList = getTreeList(listAll,listRoot);
        return categoryExtjsBOList;
    }



    /**
     * 获取树子节点工具函数
     * @param list
     * @return
     */
    public List<CategoryExtjsBO> getTreeList(List<CategoryBO> listAll,List<CategoryBO> list){
        List<CategoryExtjsBO> extjsBOList = new ArrayList<CategoryExtjsBO>();
        /**
         * 查找是否是子节点,如果有:子节点调用当前方法继续寻找子节点,
         * 没有子节点则添加到关于树的list里,并且设置当前节点为叶子节点
         */
        for(CategoryBO categoryBO:list){
            Integer id = categoryBO.getId();
            List<CategoryExtjsBO> childList = new ArrayList();
            List<CategoryBO> child = new ArrayList();
            for(CategoryBO  category:listAll){
                if(id==category.getParent()){
                    child.add(category);
                }
            }

            //子节点调用本方法继续查找
            if(child.size()>0){
                childList=getTreeList(listAll,child);
            }

            CategoryExtjsBO extjsBO = new CategoryExtjsBO();
            extjsBO.setId(id);
            extjsBO.setText(categoryBO.getName());
            extjsBO.setChildren(childList);
            if(childList.size()==0){
                extjsBO.setLeaf(true);//设置为叶子节点
            }
            extjsBOList.add(extjsBO);
        }
        return extjsBOList;
    }


}
