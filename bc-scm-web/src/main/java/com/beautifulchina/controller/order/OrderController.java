/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: zhuhoufeng
 * date: 2016-01-20
 */
package com.beautifulchina.controller.order;

import com.beautifulchina.base.BaseController;
import com.beautifulchina.common.Page;
import com.beautifulchina.order.bo.OrderBO;
import com.beautifulchina.order.pojo.Order;
import com.beautifulchina.order.pojo.OrderPassenger;
import com.beautifulchina.order.vo.OrderVO;
import com.beautifulchina.service.order.OrderService;
import com.beautifulchina.tour.pojo.TourOption;
import com.beautifulchina.tour.vo.TourOptionVO;
import com.beautifulchina.user.bo.UserBO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;


/**
 * 订单管理控制器
 */

@Controller
@RequestMapping(value = "/order")
public class OrderController extends BaseController{

    private static Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private OrderService orderService;



    /**ss
     * 查询订单
     * @param orderVO
     * @return
     */
    @RequestMapping(value = "query")
    @ResponseBody
    public Page<OrderBO> queryOrders(@Valid OrderVO orderVO,HttpServletRequest request){
        UserBO userBO = this.getUser(request);
        String language = this.getLocal(request);
        orderVO.setLanguage(language);
        Page<OrderBO> page = orderService.getOrderList(orderVO,userBO);
        return page;
    }

    /**ss
     * 查询订单历史记录
     * @param orderVO
     * @return
     */
    @RequestMapping(value = "history")
    @ResponseBody
    public Page<OrderBO> queryOrderHistory(@Valid OrderVO orderVO,HttpServletRequest request){
        UserBO userBO = this.getUser(request);
        String language = this.getLocal(request);
        orderVO.setLanguage(language);
        Page<OrderBO> page = orderService.getOrderHistoryList(orderVO,userBO);
        return page;
    }


    /**
     * 更新订单管理信息
     * @param orderVO
     * @return
     */
    @RequestMapping(value = "update")
    @ResponseBody
    public Map<String,Object> update(@Valid OrderVO orderVO, HttpServletRequest request){
        Map<String,Object> result = null;
        String language = this.getLocal(request);

        /**
         * 所有的Ajax请求自己处理异常返回 参照以下
         */
        try{
            UserBO userBO = this.getUser(request);
            orderService.updateOrder(orderVO,userBO,language);
            result = successResult();
        }catch (Exception e){
            logger.error("更新订单管理信息失败",e);
            result = failResult();
        }
        return result;
    }

    /**
     * 确认订单
     * @param orderVO
     * @return
     */
    @RequestMapping(value = "confirm")
    @ResponseBody
    public Map<String,Object> confirm(@Valid OrderVO orderVO, HttpServletRequest request){
        Map<String,Object> result = null;
        String language = this.getLocal(request);
        /**
         * 所有的Ajax请求自己处理异常返回 参照以下
         */
        try{
            UserBO userBO = this.getUser(request);
            orderVO.setState("SS");
            orderService.updateOrder(orderVO, userBO,language);
            result = successResult();
        }catch (Exception e){
            logger.error("确认订单失败",e);
            result = failResult();
        }
        return result;
    }

    /**
     * 根据订单号关联客户信息
     * @param orderVO
     * @return
     */
    @RequestMapping(value = "getPassenger")
    @ResponseBody
    public List<OrderPassenger> confgetPassengerirm(@Valid OrderVO orderVO){
        List<OrderPassenger> list = orderService.getOrderPassenger(orderVO);
        return list;
    }


    /**
     * 根据订单号关联订单明细
     * @param orderVO
     * @return
     */
    @RequestMapping(value = "getDetail")
    @ResponseBody
    public List<Order> getOrderDetail(@Valid OrderVO orderVO,HttpServletRequest request){
        UserBO userBO = this.getUser(request);
        String language = this.getLocal(request);
        orderVO.setLanguage(language);
        List<Order> list = orderService.getOrderDetail(orderVO);
        return list;
    }

    /**
     * 根据线路id获取线路选项信息
     *
     * @param tourId,orderNo
     * @return
     */
    @RequestMapping(value = "getOptionValueByTourId")
    @ResponseBody
    public Page<TourOption> getOptionValueByTourId(Integer tourId,HttpServletRequest request) {
        Page<TourOption> page = orderService.getOptionValueByTourId(tourId,this.getLocal(request));
        return page;
    }

    /**
     * 获取线路选项信息
     *
     * @return
     */
    @RequestMapping(value = "getOptionByTourId")
    @ResponseBody
    public List<Map<String, String>> getOptionByTourId(Integer optionId,Integer tourId, HttpServletRequest request) {
        List<Map<String, String>> list = orderService.getAllOption(optionId,tourId, this.getLocal(request));
        return list;
    }
    /**
     * 根据线路id获取线路选项信息
     *
     * @param tourId,orderNo
     * @return
     */
    @RequestMapping(value = "getOptions")
    @ResponseBody
    public Page<TourOption> getOptions(Integer tourId,String orderNo,HttpServletRequest request) {
        String language = this.getLocal(request);
        Page<TourOption> page = orderService.getOptions(tourId,orderNo,language);
        return page;
    }


    /**
     * 保存选项值
     *
     * @param tourOptionVO
     * @return
     */
    @RequestMapping(value = "saveOption")
    @ResponseBody
    public Map<String, Object> saveOption(TourOptionVO tourOptionVO) {
        Map<String, Object> result=null;
        try {
            Double total=orderService.saveOption(tourOptionVO);
            result = successResult();
            result.put("total",total);
        } catch (Exception e) {
            logger.error("保存路线选项失败", e);
            result = failResult();
        }
        return result;
    }
}
