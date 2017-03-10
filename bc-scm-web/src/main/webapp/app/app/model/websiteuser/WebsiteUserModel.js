/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: chengxuemin
 * date: 2015-12-11
 */

/**
 * 网站用户管理表格数据模型
 */
Ext.define('app.model.websiteuser.WebsiteUserModel',{
    extend: 'Ext.data.Model',
    fields: [
    /**
     * id代码
     */
        {
            type: 'string',
            name: 'id'
        },
    /**
     * 封装姓名代码
     */
        {
            type: 'string',
            name: 'name'
        },
    /**
     * 封装昵称代码
     */
        {
            type: 'string',
            name: 'nickName'
        },
    /**
     * 封装邮箱代码
     */
        {
            type: 'string',
            name: 'email'
        },
    /**
     * 封装性别代码
     */
        {
            type: 'string',
            name: 'sex'
        },
    /**
     * 封装护照号代码
     */
        {
            type: 'string',
            name: 'passport'
        },
    /**
     * 封装状态代码
     */
        {
            type: 'string',
            name: 'status'
        },
    /**
     * 冻结时间代码
     */
        {
            type: 'string',
            name: 'lockTime'
        },
    /**
     * 冻结原因代码
     */
        {
            type: 'string',
            name: 'lockReson'
        },
    /**
     * 注册时间代码
     */
        {
            type: 'string',
            name: 'regTime'
        },
    /**
     * 总积分代码
     */
        {
            type: 'string',
            name: 'point'
        },
    /**
     * 可用积分代码
     */
        {
            type: 'string',
            name: 'usablePoint'
        },
    /**
     * 封装用户类型代码
     */
        {
            type: 'string',
            name: 'type'
        },
    /**
     * 封装facebook账号代码
     */
        {
            type: 'string',
            name: 'faceBookName'
        },
    /**
     * 封装最后登录ip代码
     */
        {
            type: 'string',
            name: 'ip'
        }
    ]
})
