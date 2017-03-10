/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: chenghuanhuan
 * date: 2015-12-15
 */
package com.beautifulchina.user.bo;

import com.beautifulchina.base.BaseBean;
import com.beautifulchina.deptinfo.bo.DeptInfoBO;
import com.beautifulchina.rolemanage.bo.RoleBO;

/**
 * 用户信息
 */
public class UserBO extends BaseBean{

    /**
     * 主键id
     */
    private Integer id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 用户名
     */
    private String username;

    /**
     * 用户头像
     */
    private String photo;

    /**
     * 角色信息
     */
    private RoleBO roleBO;

    /**
     * 部门信息
     */
    private DeptInfoBO deptInfoBO;

    public DeptInfoBO getDeptInfoBO() {
        return deptInfoBO;
    }

    public void setDeptInfoBO(DeptInfoBO deptInfoBO) {
        this.deptInfoBO = deptInfoBO;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public RoleBO getRoleBO() {
        return roleBO;
    }

    public void setRoleBO(RoleBO roleBO) {
        this.roleBO = roleBO;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
