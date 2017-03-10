/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: dongjingjun
 * date: 2015-12-21
 */
package com.beautifulchina.service.deptinfo;

import com.beautifulchina.dao.deptinfo.DeptInfoMapper;
import com.beautifulchina.dao.dlmanage.DLManageMapper;
import com.beautifulchina.deptinfo.bo.DeptBO;
import com.beautifulchina.deptinfo.bo.DeptExtjsBO;
import com.beautifulchina.deptinfo.pojo.Dept;
import com.beautifulchina.deptinfo.vo.DeptVO;
import com.beautifulchina.dlmanage.pojo.Level;
import com.beautifulchina.exception.RedisException;
import com.beautifulchina.user.bo.UserBO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * 部门信息管理相关服务
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class DeptInfoService {
    @Autowired
    private DeptInfoMapper deptInfoMapper;
    @Autowired
    private DLManageMapper dlManageMapper;

    /**
     * 获取部门树数据
     *
     * @param deptVO
     * @return
     */
    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public List<DeptExtjsBO> getDept(DeptVO deptVO) {
        List<Dept> deptList = deptInfoMapper.getDeptList(deptVO.getLanguage());//获取所有部门信息
        List<Dept> list = deptInfoMapper.getDeptByCode(deptVO.getDeptCode(),deptVO.getLanguage());
        List<DeptExtjsBO> deptExtjsBOList = getTreeList(list, deptList);
        return deptExtjsBOList;
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public List<DeptExtjsBO> getLevelTree(String language) {
        List<Level> levelList = dlManageMapper.getDLMList(null);
        List<Dept> list = new ArrayList<Dept>();
        if (levelList.size() > 0) {
            Integer i=-1;
            for (Level level : levelList) {
                Dept dept = new Dept();
                dept.setId(i--);
                dept.setDeptCode(level.getCode());
                if("fr".equalsIgnoreCase(language)){
                    dept.setDeptName(level.getFnName());
                }else{
                    dept.setDeptName(level.getEnName());
                }
                dept.setSupDept(level.getSupCode());
                list.add(dept);
            }
        }
        List<Dept> listRoot = getRoot(list);
        List<DeptExtjsBO> deptExtjsBOList = getTreeList(listRoot, list);
        return deptExtjsBOList;
    }

    public List<Dept> getRoot(List<Dept> list) {
        List<Dept> listRoot = new ArrayList<Dept>();//父节点
        Iterator<Dept> iterator = list.iterator();
        while (iterator.hasNext()) {
            Dept dept = iterator.next();
            if (dept.getSupDept() == null || "".equals(dept.getSupDept())) {
                listRoot.add(dept);
                iterator.remove();
            }
        }
        return listRoot;
    }

    /**
     * 获取树子节点工具函数
     *
     * @param list
     * @param deptList
     * @return
     */
    public List<DeptExtjsBO> getTreeList(List<Dept> list, List<Dept> deptList) {
        List<DeptExtjsBO> deptExtjsBOList = new ArrayList<DeptExtjsBO>();//return value
        for (Dept dept : list) {
            List<Dept> child = new ArrayList<Dept>();//get child by supDept
            Iterator<Dept> iterator = deptList.iterator();
            while (iterator.hasNext()) {
                Dept dept1 = iterator.next();
                if (dept.getDeptCode().equals(dept1.getSupDept())) {
                    child.add(dept1);
                    iterator.remove();
                }
            }
            List<DeptExtjsBO> childList = new ArrayList<DeptExtjsBO>();
            if (child.size() > 0) {
                childList = getTreeList(child, deptList);
            }
            DeptExtjsBO deptExtjsBO = new DeptExtjsBO();
            deptExtjsBO.setText(dept.getDeptName());
            deptExtjsBO.setChildren(childList);
            deptExtjsBO.setId(dept.getId());
            deptExtjsBO.setCode(dept.getDeptCode());
            if (child.size() <= 0) {
                deptExtjsBO.setLeaf(true);
            }
            if ("BEAUTIFULCHINA".equalsIgnoreCase(dept.getDeptCode())) {
                deptExtjsBO.setExpanded(true);
            }
            deptExtjsBOList.add(deptExtjsBO);
        }
        return deptExtjsBOList;
    }

    /**
     * 获取所有部门代码和名称
     *
     * @return
     */
    public List<DeptBO> getAllDeptCodeAndDeptName(String language, UserBO userBO) {
        DeptBO deptBO = new DeptBO();
        deptBO.setLanguage(language);
        deptBO.setRoleLevel(userBO.getRoleBO().getRoleLevel());
        deptBO.setId(userBO.getDeptInfoBO().getId());
        return deptInfoMapper.getAllDeptCodeAndDeptName(deptBO);
    }

    /**
     * 根据id获取部门信息
     *
     * @param deptVO
     * @return
     */
    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public List<Dept> getDeptById(DeptVO deptVO) {
        List<Dept> list = deptInfoMapper.getDeptById(deptVO);
        return list;
    }

    /**
     * 根据父节点删除自身及子节点
     *
     * @param id
     */
    public void delDeptById(String id) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("id", id);
        //根据选中的id获取部门代码
        String code = deptInfoMapper.getDeptCodeById(map);
        List<String> idList = new ArrayList<String>();
        //获取子节点id
        idList = getIdList(idList, code);
        idList.add(id);
        deptInfoMapper.delDeptById(idList);
    }

    /**
     * 循环获取子节点id
     *
     * @param idList
     * @param code
     * @return
     */
    public List<String> getIdList(List<String> idList, String code) {
        //获取子节点信息
        List<Dept> list = deptInfoMapper.getDeptByCode(code,"fr");
        for (Dept dept : list) {
            if (dept.getDeptCode() != null) {
                idList.add(dept.getId().toString());
                getIdList(idList, dept.getDeptCode());
            }
        }
        return idList;
    }

    /**
     * 获取部门代码与名称
     *
     * @return
     */
    public List<Dept> getDeptCN(String language,String levelCode) {
        List<Dept> list = deptInfoMapper.getDeptCN(language,levelCode);
        return list;
    }

    /**
     * 新增部门信息
     *
     * @param deptVO
     */
    public void addDept(DeptVO deptVO, UserBO userBO) throws RedisException {
        DeptBO deptBO = new DeptBO();
        BeanUtils.copyProperties(deptVO, deptBO);
        deptBO.setOperateTime(new Date());
        deptBO.setOperator(userBO.getUsername());
        if("".equals(deptBO.getSupDept())){
            deptBO.setSupDept(deptBO.getLevelCode());
        }
        deptInfoMapper.addDept(deptBO);
    }

    /**
     * 更新部门信息
     *
     * @param deptVO
     */
    public void editDept(DeptVO deptVO, UserBO userBO) {
        DeptBO deptBO = new DeptBO();
        BeanUtils.copyProperties(deptVO, deptBO);
        deptBO.setOperateTime(new Date());
        deptBO.setOperator(userBO.getUsername());
        if("".equals(deptBO.getSupDept())){
            deptBO.setSupDept(deptBO.getLevelCode());
        }
        deptInfoMapper.editDept(deptBO);
    }
}
