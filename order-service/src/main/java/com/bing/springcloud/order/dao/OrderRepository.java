package com.bing.springcloud.order.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.bing.springcloud.core.order.domains.OrderDomain;

public interface OrderRepository extends PagingAndSortingRepository<OrderDomain, Serializable> {

	/**
	 * 根据手机号查找订单
	 * @param phone
	 * @return
	 */
	List<OrderDomain> findByPhone(String phone);
}
