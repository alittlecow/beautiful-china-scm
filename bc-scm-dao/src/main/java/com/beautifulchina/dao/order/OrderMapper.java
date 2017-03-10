/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: zhuhoufeng
 * date: 2016-01-20
 */
package com.beautifulchina.dao.order;


import com.beautifulchina.base.SqlMapper;
import com.beautifulchina.order.bo.OrderBO;
import com.beautifulchina.order.pojo.Order;
import com.beautifulchina.order.pojo.OrderDetail;
import com.beautifulchina.order.pojo.OrderHistory;
import com.beautifulchina.order.pojo.OrderPassenger;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by ZHF on 2016/1/6.
 */
@Repository
public interface OrderMapper extends SqlMapper{

    /**
     * 根据条件查询订单信息
     * @param orderBO
     */
    public List<Order> getOrderList(OrderBO orderBO);

    /**
     * 根据条件获取所有的订单信息数量
     * @param orderBO
     * @return
     */
    public int getOrderListCount(OrderBO orderBO);

    /**
     * 根据订单号查询订单历史记录信息
     * @param orderBO
     */
    public List<OrderHistory> getOrderHistoryList(OrderBO orderBO);

    /**
     * 根据订单号获取历史记录数量
     * @param orderBO
     * @return
     */
    public int getOrderHistoryListCount(OrderBO orderBO);


    /**
     * 更新订单
     * @param orderBO
     */
    public void update(OrderBO orderBO);

    /**
     * 更新历史记录订单
     * @param orderBO
     */
    public void updateHistory(OrderBO orderBO);


    /**
     * 保存订单历史记录
     * @param orderBO
     */
    public void saveOrderHistory(OrderBO orderBO);

    /**
     * 根据订单号查询关联客户信息
     * @param orderBO
     * @return
     */
    public List<OrderPassenger> getOrderPassenger(OrderBO orderBO);

    /**
     * 根据订单号关联option选项
     * @param orderBO
     * @return
     */
    public List<OrderDetail> getOrderDetail(OrderBO orderBO);

    /**
     * 根据订单号及路线id关联option所有选项
     * @param orderBO
     * @return
     */
    public List<Order> getOptions(OrderBO orderBO);

    /**
     * 根据路线id删除路线选项值
     *
     * @param id,orderNo
     */
    void deleteOrderOptionValue(String orderNo);

    /**
     * 根据路线id插入路线选项值
     *
     * @param map
     */
    void insertOrderOptionValue(List<Map> map);

    /**
     * 获取订单原选项价格
     * @param orderNo
     * @return
     */
    double getPlusPrice(String orderNo);
}
