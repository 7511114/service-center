package com.bing.springcloud.order.controller;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bing.springcloud.order.domains.OrderDomain;
import com.bing.springcloud.order.service.IOrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

	final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	ApplicationContext applicationContext;
	
	@Autowired
	IOrderService orderService;
	
	@RequestMapping("/new/{goodsId}")
	public String add(@PathVariable()long goodsId, @RequestHeader(name="phone")String phone,
			@RequestHeader(name="email")String email) throws Exception{
		OrderDomain order = new OrderDomain();
		order.setOrderId(UUID.randomUUID().toString());
		order.setCreateTime(new Date());
		order.setEmail(email);
		order.setPhone(phone);
		order.setGoodsId(goodsId);
		orderService.save(order);
		return "下单成功，这个响应来自(新版)订单服务器：" + applicationContext.getEnvironment().getProperty("HOSTNAME");
	}
	
	/**
	 * 取消订单
	 * @param orderId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/cancel/{orderId}")
	public String cancel(@PathVariable("orderId")String orderId) throws Exception{
		orderService.delete(orderId);
		return "取消订单成功，这个响应来自(新版)订单服务器：" + applicationContext.getEnvironment().getProperty("HOSTNAME");
	}
	
	/**
	 * 根据手机号码查订单
	 * @param phone
	 * @return
	 */
	@RequestMapping("/orders")
	public List<OrderDomain> orders(@RequestHeader(name="phone")String phone){
		return orderService.findByPhone(phone);
	}
}
