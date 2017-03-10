/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: zhangyun
 * date: 2016/1/29
 */
package com.beautifulchina.dao.platform;

import com.beautifulchina.base.SqlMapper;
import com.beautifulchina.platform.bo.PlatformBO;
import com.beautifulchina.platform.vo.PlatformVO;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * Created by zhangyun on 2016/1/29.
 * 忘记密码Mapper
 */
@Repository
public interface ModifyPwdMapper extends SqlMapper {
    /**
     * 根据邮箱获得用户信息
     * @param email
     * @return
     */
    PlatformBO getUserByEmail(String email);

    /**
     * 用户表更新随机码和操作时间
     * @param map
     */
    void saveAuthcode(Map<String,Object> map);

    /**
     * 根据邮件提示的参数id和随机码查询是否存在该邮件
     * @param map
     * @return
     */
    PlatformBO selectByAuthcode(Map<String,Object> map);

    /**
     * 根据id重置密码
     * @param platformVO
     */
    void resetPasswordByLoginName(PlatformVO platformVO);
}
