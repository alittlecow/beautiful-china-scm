/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: zhuhoufeng
 * date: 2016-01-20
 */
package com.beautifulchina.service.order;


import com.beautifulchina.common.Page;
import com.beautifulchina.dao.mailtemplate.MailTemplateMapper;
import com.beautifulchina.dao.option.OptionMapper;
import com.beautifulchina.dao.order.OrderMapper;
import com.beautifulchina.dao.tour.TourMapper;
import com.beautifulchina.mailtemplate.bo.MailTemplateBO;
import com.beautifulchina.order.bo.OrderBO;
import com.beautifulchina.order.pojo.Order;
import com.beautifulchina.order.pojo.OrderDetail;
import com.beautifulchina.order.pojo.OrderHistory;
import com.beautifulchina.order.pojo.OrderPassenger;
import com.beautifulchina.order.vo.OrderVO;
import com.beautifulchina.service.util.EmailUtil;
import com.beautifulchina.tour.pojo.TourOption;
import com.beautifulchina.tour.vo.TourOptionVO;
import com.beautifulchina.user.bo.UserBO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * 订单管理
 */

@Service
@Transactional(rollbackFor = Exception.class)
public class OrderService {

    /**
     *
     */
    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private TourMapper tourMapper;

    @Autowired
    private OptionMapper optionMapper;

    @Autowired
    private MailTemplateMapper mailtemplateMapper;

    /**
     * 查询订单列表
     * @param
     * @return
     */
    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public Page<OrderBO> getOrderList(OrderVO orderVO,UserBO userBO) {
        OrderBO orderBO=new OrderBO();
        BeanUtils.copyProperties(orderVO, orderBO);
        orderBO.setDeptCode(userBO.getDeptInfoBO().getDeptCode());
        orderBO.setLevelCode(userBO.getDeptInfoBO().getLevelCode());
        orderBO.setDeptId(userBO.getDeptInfoBO().getId());

        int count=orderMapper.getOrderListCount(orderBO);
        List<OrderBO> orderBOList=new ArrayList<OrderBO>();
        if(count>0){
            List<Order> orders=orderMapper.getOrderList(orderBO);
            for(Order order:orders){
                OrderBO orderBo=new OrderBO();
                BeanUtils.copyProperties(order, orderBo);
                orderBOList.add(orderBo);
            }
        }
        Page<OrderBO> page = new Page<OrderBO>();
        page.setData(orderBOList);
        page.setTotal(count);
        return page;
    }

    /**
     * 查询订单历史列表
     * @param
     * @return
     */
    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public Page<OrderBO> getOrderHistoryList(OrderVO orderVO,UserBO userBO) {
        OrderBO orderBO=new OrderBO();
        orderBO.setDeptCode(userBO.getDeptInfoBO().getDeptCode());
        orderBO.setLevelCode(userBO.getDeptInfoBO().getLevelCode());
        orderBO.setDeptId(userBO.getDeptInfoBO().getId());
        BeanUtils.copyProperties(orderVO, orderBO);
        int count=orderMapper.getOrderHistoryListCount(orderBO);
        List<OrderBO> orderBOList=new ArrayList<OrderBO>();
        if(count>0){
            List<OrderHistory> orders=orderMapper.getOrderHistoryList(orderBO);
            for(OrderHistory orderHistory:orders){
                OrderBO orderBo=new OrderBO();
                BeanUtils.copyProperties(orderHistory, orderBo);
                orderBOList.add(orderBo);
            }
        }
        Page<OrderBO> page = new Page<OrderBO>();
        page.setData(orderBOList);
        page.setTotal(count);
        return page;
    }


    /**
     * 更新订单信息
     * @param orderVO
     */
    public void updateOrder(OrderVO orderVO,UserBO userBO,String language){
        OrderBO orderBO = new OrderBO();
        BeanUtils.copyProperties(orderVO, orderBO);
        orderBO.setOperateTime(new Date());
        orderBO.setPassId(userBO.getId());
        orderMapper.update(orderBO);
        orderMapper.saveOrderHistory(orderBO);
        if(orderBO.getState().equals("SS")){
            MailTemplateBO mailTemplate = mailtemplateMapper.getMailTemplateByName("orderConfirm");
            if(language.equals("en")){
                String content = mailTemplate.getContentEn().replaceAll("#UserName#", orderBO.getUserName()).replaceAll("#OrderNo#",orderBO.getOrderNo());
                EmailUtil.sendEmail(mailTemplate.getTitleEn(),content,orderVO.getEmail(),"");

            }
            if(language.equals("fr")){
                String content = mailTemplate.getContentFr().replaceAll("#UserName#",orderBO.getUserName()).replaceAll("#OrderNo#",orderBO.getOrderNo());
                EmailUtil.sendEmail(mailTemplate.getTitleFr(),content,orderVO.getEmail(),"");
            }
        }
    }

    /**
     * 根据订单号关联客户信息
     * @param orderVO
     * @return
     */
    public List<OrderPassenger> getOrderPassenger(OrderVO orderVO){
        OrderBO orderBO=new OrderBO();
        BeanUtils.copyProperties(orderVO, orderBO);
        List<OrderPassenger> item = orderMapper.getOrderPassenger(orderBO);
        return item;
    }

    /**
     * 获取所有选项
     *
     * @return
     */
    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public List<Map<String, String>> getAllOption(Integer optionId,Integer tourId, String language) {
            List<Integer> valueIds = optionMapper.getOptionById(optionId);
            List<Map<String, String>> list = tourMapper.selectAllOptionByOrderNo(language, tourId, valueIds);
            return list;
    }

    /**
     * 根据选项id获取选项值
     *
     * @param id
     * @return
     */
    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public List<Map<String, String>> getOptionValueById(Integer id, Integer tourId, String language) {
        List<Map<String, String>> list = tourMapper.selectOptionValueById(id, language, tourId);
        return list;
    }


    /**
     * 根据订单号关联option选项
     * @param orderVO
     * @return
     */
    public List<Order> getOrderDetail(OrderVO orderVO){
        OrderBO orderBO=new OrderBO();
        BeanUtils.copyProperties(orderVO, orderBO);
        List<OrderDetail> optionList = orderMapper.getOrderDetail(orderBO);
        List<Order> orderList =orderMapper.getOptions(orderBO);
        List<Order> list =new ArrayList<Order>();

        for(Order order:orderList){
           for(OrderDetail option:optionList){
               if(order.getValueId()==option.getValueId()){
                   order.setCheck(true);
               }
           }
            list.add(order);
        }
        return list;
    }
    /**
     * 根据订单号获取线路选项信息
     *
     * @param tourId,orderNo
     * @return
     */
    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public Page<TourOption> getOptionValueByTourId(Integer tourId,String language) {
        int count = tourMapper.selectTourOptionByIdCount(tourId);
        List<TourOption> tourOptionList = new ArrayList<TourOption>();
        TourOption option = null;
        if (count > 0) {
            List<TourOption> tourOptionLists = tourMapper.selectTourOptionById(tourId,language);
            int len = tourOptionLists.size();
            int flagId = tourOptionLists.get(0).getOptionId();
            Boolean flag = true;
            for (int i = 0; i < len; i++) {
                if (flagId == tourOptionLists.get(i).getOptionId()) {
                    if (flag) {
                        option = new TourOption();
                        option.setOptionName(tourOptionLists.get(i).getOptionName());
                        option.setOptionId(tourOptionLists.get(i).getOptionId());
                        option.setOptionValueNameList(new ArrayList<String>());
                        option.setOptionValuePriceList(new ArrayList<Double>());
                        option.setIdList(new ArrayList<Integer>());
                        flag = false;
                    }
                    option.getOptionValueNameList().add(tourOptionLists.get(i).getOptionValueName());
                    option.getOptionValuePriceList().add(tourOptionLists.get(i).getPrice());
                    option.getIdList().add(tourOptionLists.get(i).getId());
                } else {
                    tourOptionList.add(option);
                    flagId = tourOptionLists.get(i--).getOptionId();
                    flag = true;
                }
            }
            tourOptionList.add(option);
        }
        Page<TourOption> page = new Page<TourOption>();
        page.setData(tourOptionList);
        page.setTotal(count);
        return page;
    }

    /**
     * 根据id获取线路选项信息
     *
     * @param tourId,orderNo
     * @return
     */
    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public Page<TourOption> getOptions(Integer tourId,String orderNo,String language) {
        int count = tourMapper.getOptionValueByOrderNoCount(tourId,orderNo);
        List<TourOption> tourOptionList = new ArrayList<TourOption>();
        TourOption option = null;
        if (count > 0) {
            List<TourOption> tourOptionLists = tourMapper.getOptionValueByOrderNo(tourId,orderNo,language);
            int len = tourOptionLists.size();
            int flagId = tourOptionLists.get(0).getOptionId();
            Boolean flag = true;
            for (int i = 0; i < len; i++) {
                if (flagId == tourOptionLists.get(i).getOptionId()) {
                    if (flag) {
                        option = new TourOption();
                        option.setOptionName(tourOptionLists.get(i).getOptionName());
                        option.setOptionId(tourOptionLists.get(i).getOptionId());
                        option.setOptionValueNameList(new ArrayList<String>());
                        option.setOptionValuePriceList(new ArrayList<Double>());
                        option.setIdList(new ArrayList<Integer>());
                        option.setDefaults(new ArrayList<Integer>());
                        flag = false;
                    }
                    option.getOptionValueNameList().add(tourOptionLists.get(i).getOptionValueName());
                    option.getOptionValuePriceList().add(tourOptionLists.get(i).getPrice());
                    option.getIdList().add(tourOptionLists.get(i).getId());
                    option.getDefaults().add(tourOptionLists.get(i).getToleration());
                } else {
                    tourOptionList.add(option);
                    flagId = tourOptionLists.get(i--).getOptionId();
                    flag = true;
                }
            }
            tourOptionList.add(option);
        }
        Page<TourOption> page = new Page<TourOption>();
        page.setData(tourOptionList);
        page.setTotal(count);
        return page;
    }

    /**
     * 保存选项值
     *
     * @param tourOptionVO
     * @return
     */
    public Double saveOption(TourOptionVO tourOptionVO) {
        List<Integer> idList = tourOptionVO.getOptionValueIdList();
        List<Double> priceList = tourOptionVO.getOptionValuePriceList();
        String orderNo = tourOptionVO.getOrderNo();
        Integer count = tourOptionVO.getCount();

        if (idList != null) {
            OrderBO orderBO = new OrderBO();
            orderBO.setOrderNo(orderNo);
            double plusPrice = 0;
            Order order =orderMapper.getOrderList(orderBO).get(0);
            order.setTotal(order.getTotal()-orderMapper.getPlusPrice(orderNo)*count);

            List<Map> list = new ArrayList<Map>();
            for (int i = 0, len = idList.size(); i < len; i++) {
                Map map = new HashMap();
                map.put("price", priceList.get(i));
                map.put("valueId", idList.get(i));
                map.put("orderNo",orderNo);
                map.put("type","O");
                map.put("upgrade","N");
                map.put("totalPrice",priceList.get(i)*count);
                plusPrice+=priceList.get(i)*count;
                list.add(map);
            }
            order.setTotal(order.getTotal()+plusPrice);
            OrderBO orderBo = new OrderBO();
            BeanUtils.copyProperties(order, orderBo);
            orderMapper.update(orderBo);
            orderMapper.updateHistory(orderBo);

            if (tourOptionVO.getStatus() != null && "edit".equalsIgnoreCase(tourOptionVO.getStatus())) {
                orderMapper.deleteOrderOptionValue(orderNo);
            }
            orderMapper.insertOrderOptionValue(list);
            return order.getTotal();
        }
        return null;
    }

//    /**
//     * 保存订单历史记录
//     * @param orderVO
//     */
//    public void saveOrderHistory(OrderVO orderVO){
//        OrderBO orderBO = new OrderBO();
//        BeanUtils.copyProperties(orderVO, orderBO);
//        orderMapper.saveOrderHistory(orderBO);
//    }
}
