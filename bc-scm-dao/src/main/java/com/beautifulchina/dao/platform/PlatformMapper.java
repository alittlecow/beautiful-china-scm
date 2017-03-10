/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: chenghuanhuan
 * date: 2015-12-10
 */
package com.beautifulchina.dao.platform;

import com.beautifulchina.base.SqlMapper;
import com.beautifulchina.platform.bo.PlatformBO;
import com.beautifulchina.platform.pojo.Platform;
import com.beautifulchina.platform.vo.PlatformQuryVO;
import com.beautifulchina.platform.vo.PlatformVO;
import com.beautifulchina.user.vo.UserVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 平台用户
 */
@Repository
public interface PlatformMapper extends SqlMapper {
    /**
     * 获取单个用户信息
     * @param platformVO
     * @return
     */
    Platform login(PlatformVO platformVO);

    /**
     * 获取所有平台用户
     */
    List<PlatformBO> getAllUser(PlatformQuryVO platformQuryVO);

    /**
     * 获取平台用户总数
     */
    int getPlatformCount(PlatformQuryVO platformQuryVO);

    /**
     * 根据id删除平台用户
     */
    void delete(List<String> ids);
    /**
     * 保存菜单
     */
    void save(Platform platform);

    /**
     * 更新平台用户信息
     */
    void updatePlatform(Platform platform);

    /**
     * 验证登录名是否存在
     */
    Integer getByLoginName(@Param(value = "loginName")String loginName);

    /**
     * 验证邮箱是否存在
     */
    Integer getByEmail(@Param(value = "email")String email);

    /**
     * 保存用户最后登录的时间,ip
     * @param userVO
     */
    void saveLoginMessage(UserVO userVO);

}
