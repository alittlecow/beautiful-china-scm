/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: fengbaitong
 * date: 2015-11-25
 */
package com.beautifulchina.service.supplier;

import com.beautifulchina.common.Page;
import com.beautifulchina.dao.deptinfo.DeptInfoMapper;
import com.beautifulchina.dao.mailtemplate.MailTemplateMapper;
import com.beautifulchina.dao.platform.PlatformMapper;
import com.beautifulchina.dao.supplier.SupplierMapper;
import com.beautifulchina.deptinfo.bo.DeptBO;
import com.beautifulchina.deptinfo.bo.DeptInfoBO;
import com.beautifulchina.exception.RedisException;
import com.beautifulchina.mailtemplate.bo.MailTemplateBO;
import com.beautifulchina.mailtemplate.pojo.MailTemplate;
import com.beautifulchina.platform.pojo.Platform;
import com.beautifulchina.service.util.EmailUtil;
import com.beautifulchina.supplier.bo.ApproveBO;
import com.beautifulchina.supplier.bo.SupplierBO;
import com.beautifulchina.supplier.pojo.Supplier;
import com.beautifulchina.supplier.vo.ApproveVO;
import com.beautifulchina.supplier.vo.SupplierVO;
import com.beautifulchina.user.bo.UserBO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;


import java.util.Date;
import java.util.List;

/**
 * 供应商相关服务
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class SupplierService {

    @Autowired
    private SupplierMapper supplierMapper;
    @Autowired
    private DeptInfoMapper deptInfoMapper;
    @Autowired
    private PlatformMapper platformMapper;
    @Autowired
    private MailTemplateMapper mailtemplateMapper;

    /**
     * 获取供应商列表
     */
    @Transactional(propagation= Propagation.NOT_SUPPORTED,readOnly =true)
    public Page<SupplierBO> getSupplierExtjsList(SupplierVO supplierVO){
        int count=supplierMapper.getSupplierCount(supplierVO);
        Page<SupplierBO> supplierPage = new Page<SupplierBO>();
        if(count>0){
            List<SupplierBO> supplierList= supplierMapper.getAllUser(supplierVO);
            supplierPage.setData(supplierList);
            supplierPage.setTotal(count);
        }
        return supplierPage;
    }


    /**
     *  更改供应商信息
     */
    @Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly =true)
    public void updateSupplier(ApproveVO approveVO,UserBO userBO){
        ApproveBO approveBO = new ApproveBO();
        BeanUtils.copyProperties(approveVO, approveBO);
        String ids=approveVO.getIds();//批量审批,多个供应商的id
        List list=CollectionUtils.arrayToList(ids.split(","));//审批的供应商的id列表
        approveBO.setDate(new Date());
        approveBO.setListIds(list);
        supplierMapper.updateSupplier(approveBO);

        if(approveBO.getStatus().equals("N")) {
            MailTemplateBO mailTemplate = mailtemplateMapper.getMailTemplateByName("ApprovalPass");//获取审批通过的邮件模板
            for (int i = 0; i < list.size(); i++) {
                SupplierBO supplierBO = supplierMapper.getSupplier(Integer.parseInt(list.get(i).toString()));//根据id获取供应商信息
                //author:zhuhoufeng.如果供应商审批通过,就创建新的部门.
                DeptInfoBO deptInfoBO = deptInfoMapper.getDeptInfoByDeptCode(supplierBO.getDeptCode());
                if (deptInfoBO == null) {
                    DeptBO deptBO = new DeptBO();
                    deptBO.setDeptCode(supplierBO.getDeptCode());
                    deptBO.setLevelCode("SUPPLIER");
                    deptBO.setOperateTime(new Date());
                    deptBO.setOperator(approveBO.getApprover());
                    deptBO.setDeptNameEn(supplierBO.getNameEn());
                    deptBO.setDeptNameFr(supplierBO.getNameFr());
                    deptBO.setStatus("N");
                    deptBO.setSupDept(deptBO.getLevelCode());
                    deptInfoMapper.addDept(deptBO);
                }
                //author:fengbaitong.如果供应商审批通过,就创建新的平台用户.
                Integer numberOfUser = platformMapper.getByLoginName(supplierBO.getDeptCode());//根据部门名称判断,登录名是否被占用
                if (numberOfUser == 0) {
                    Platform platform = new Platform();
                    platform.setDeptCode(supplierBO.getDeptCode());
                    platform.setLoginName(supplierBO.getDeptCode());
                    platform.setPsw(supplierBO.getPsw());
                    String password = supplierMapper.getPasswordByDeptCode(supplierBO.getDeptCode());
                    platform.setPassword(password);
                    platform.setEmail(supplierBO.getEmail());
                    platform.setTel(supplierBO.getTel());
                    platform.setTel2(supplierBO.getTel2());
                    platform.setRoleCode("SUPPLIER ADMIN");
                    platform.setStatus("N");
                    platformMapper.save(platform);
                    //给审批通过的用户发邮件
                    String language = supplierMapper.getLanguageByDeptCode(supplierBO.getDeptCode());

                    if ("en".equals(language)) {//把获取的用户名称,插入到邮件模板内容里
                        String content = mailTemplate.getContentEn().replaceAll("#Username#", supplierBO.getNameEn());
                        EmailUtil.sendEmail(mailTemplate.getTitleEn(), content, supplierBO.getEmail(), "");
                    } else if ("fr".equals(language)) {
                        String content = mailTemplate.getContentFr().replaceAll("#Username#", supplierBO.getNameFr());
                        EmailUtil.sendEmail(mailTemplate.getTitleFr(), content, supplierBO.getEmail(), "");
                    }
                }
            }
        }else if(approveBO.getStatus().equals("R")){//如果是拒绝了申请
            String rejectReason=approveBO.getrReason();//获取拒绝申请的理由
            MailTemplateBO mailTemplate = mailtemplateMapper.getMailTemplateByName("ApprovalReject");//获取拒绝的邮件模板
            for (int i = 0; i < list.size(); i++) {
                SupplierBO supplierBO = supplierMapper.getSupplier(Integer.parseInt(list.get(i).toString()));//根据id获取供应商信息
                String language = supplierMapper.getLanguageByDeptCode(supplierBO.getDeptCode());

                if ("en".equals(language)) {//把获取的用户名称,插入到邮件模板内容里
                    String content = mailTemplate.getContentEn().replaceAll("#Username#", supplierBO.getNameEn()).replaceAll("#RejectReason#", rejectReason);
                    EmailUtil.sendEmail(mailTemplate.getTitleEn(), content, supplierBO.getEmail(), "");
                } else if ("fr".equals(language)) {
                    String content = mailTemplate.getContentFr().replaceAll("#Username#", supplierBO.getNameFr()).replaceAll("#RejectReason#", rejectReason);
                    EmailUtil.sendEmail(mailTemplate.getTitleFr(), content, supplierBO.getEmail(), "");
                }
            }
        }






    }



    /**
     *  修改供应商信息
     */

    public void update(Supplier supplier){

        supplierMapper.update(supplier);

    }

    /**
     * 新增供应商信息
     */
    public void add(SupplierBO supplierBO) throws RedisException {
        Date date=new Date();
        supplierBO.setRegTime(date);
        supplierBO.setStatus("W");
        supplierMapper.add(supplierBO);


    }

}
