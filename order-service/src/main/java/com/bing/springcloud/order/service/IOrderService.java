package com.bing.springcloud.order.service;

import java.util.List;

import com.bing.springcloud.order.domains.OrderDomain;

public interface IOrderService {

	void save(OrderDomain order) throws Exception;

	void delete(String orderId) throws Exception;
	
	List<OrderDomain> findByPhone(String phone);

}
