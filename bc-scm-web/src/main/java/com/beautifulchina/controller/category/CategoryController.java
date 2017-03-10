/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: chengxuemin
 * date: 2015-12-22
 */

package com.beautifulchina.controller.category;

import com.beautifulchina.base.BaseController;
import com.beautifulchina.category.bo.CategoryExtjsBO;
import com.beautifulchina.common.Page;
import com.beautifulchina.exception.CommException;
import com.beautifulchina.category.vo.CategoryVO;
import com.beautifulchina.main.bo.CategoryListBO;
import com.beautifulchina.service.category.CategoryService;
import com.beautifulchina.user.bo.UserBO;
import com.beautifulchina.util.ParameterUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 分类管理控制器
 */
@Controller
@RequestMapping(value = "/category")
public class CategoryController extends BaseController {

    private static Logger logger = LoggerFactory.getLogger(CategoryController.class);

    @Autowired
    private CategoryService categoryService;


    /**
     * 查询分类管理列表
     * @param categoryVO
     * @return
     */
    @RequestMapping(value = "query")
    @ResponseBody
    public Page<CategoryListBO> queryCategorys(@Valid CategoryVO categoryVO,HttpServletRequest request){
        String language = this.getLocal(request);
        categoryVO.setLanguage(language);
        if(null == categoryVO.getId() || "".equals(categoryVO.getId())){
            categoryVO.setId(1);
        }
        Page<CategoryListBO> page = categoryService.getAllCategoryList(categoryVO);
        return page;
    }


    /**
     * 查询顶级分类
     * @return
     */
    @RequestMapping(value = "queryrootcategory")
    @ResponseBody
    public Map<String, Object>  queryRootCategorys(){
        Map<String, Object> map = new HashMap<String, Object>();
        CategoryVO categoryVO = new CategoryVO();
        categoryVO.setId(0);
        Page<CategoryListBO> page = categoryService.getAllCategoryList(categoryVO);
        List<CategoryListBO> list = page.getData();
        CategoryListBO categoryListBO = list.get(0);
        map.put("root",categoryListBO.getNameEn());
        return map;
    }

    /**
     * 进入子分类管理信息
     * @param categoryVO
     * @return
     */
    @RequestMapping(value = "intoSub")
    @ResponseBody
    public Page<CategoryListBO> intoSubCategorys(@Valid CategoryVO categoryVO){
        Page<CategoryListBO> page = categoryService.getAllIntoSubCategoryList(categoryVO);
        return page;
    }

    /**
     * 返回父分类管理信息
     * @param categoryVO
     * @return
     */
    @RequestMapping(value = "return")
    @ResponseBody
    public Page<CategoryListBO> returnCategorys(@Valid CategoryVO categoryVO){
        Page<CategoryListBO> page = categoryService.getAllReturnCategoryList(categoryVO);
        return page;
    }

    /**
     * 添加子分类管理信息
     * @param categoryVO
     * @return
     */
    @RequestMapping(value = "addASub")
    @ResponseBody
    public Map<String,Object> addASub(@Valid CategoryVO categoryVO,HttpServletRequest request){
        Map<String,Object> result;
        try{
            UserBO userBO = this.getUser(request);
            categoryService.addASubCategory(categoryVO,userBO);
            result = successResult();
        }catch (Exception e){
            logger.error("添加子分类管理信息失败",e);
            result = failResult();
        }
        return result;
    }

    /**
     * 更新分类管理信息
     * @param categoryVO
     * @return
     */
    @RequestMapping(value = "update")
    @ResponseBody
    public Map<String,Object> update(@Valid CategoryVO categoryVO, HttpServletRequest request){
        Map<String,Object> result = null;
        // 参数校验
        //if(ParameterUtil.isBlank(categoryVO.getId())){
        if(categoryVO.getId() == null){
            logger.info("更新分类管理信息失败 id={}",categoryVO.getId());
            result = failResult("Parameter is null");
        }else {
            try {
                UserBO userBO = this.getUser(request);
                categoryService.updateCategory(categoryVO, userBO);
                result = successResult();
            } catch (Exception e) {
                logger.error("更新分类管理信息失败", e);
                result = failResult();
            }
        }
        return result;
    }


    /**
     * 删除分类管理信息
     * @param codes
     * @return
     */
    @RequestMapping(value = "delete")
    @ResponseBody
    public Map<String, Object> delete(String codes, Integer[] ids) throws CommException {
        Map<String, Object> result = null;
        if (ParameterUtil.isBlank(codes)) {
            logger.info("删除分类管理信息失败 codes={}", codes);
            result = failResult("Parameter is null");
        } else {
            try {
                boolean flag = categoryService.deleteCategoryByCode(codes, ids);
                result = successResult();
                result.put("flag", flag);
            } catch (Exception e) {
                logger.error("更新分类管理信息失败", e);
                result = failResult();
            }
        }
        return result;
    }

    /**
     * 获取category树
     */
    @RequestMapping(value = "tree")
    @ResponseBody
    public List<CategoryExtjsBO> listTree(HttpServletRequest request){
        String language=this.getLocal(request);
        List<CategoryExtjsBO> listTree = categoryService.getCategoryTree(language);
        return listTree;
    }
}
