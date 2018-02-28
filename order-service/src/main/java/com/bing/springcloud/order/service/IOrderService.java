package com.bing.springcloud.order.service;

import com.bing.springcloud.order.domains.OrderDomain;

public interface IOrderService {

	void save(OrderDomain order) throws Exception;

	void delete(String orderId) throws Exception;

}
