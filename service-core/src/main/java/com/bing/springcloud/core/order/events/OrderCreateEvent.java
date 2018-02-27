package com.bing.springcloud.core.order.events;

import com.bing.springcloud.core.order.domains.OrderDomain;

/**
 * 订单创建事件
 * @author chenbing
 *
 */
public class OrderCreateEvent {

	public OrderDomain orderDomain;

	public OrderDomain getOrderDomain() {
		return orderDomain;
	}

	public void setOrderDomain(OrderDomain orderDomain) {
		this.orderDomain = orderDomain;
	}

	public OrderCreateEvent(OrderDomain orderDomain) {
		super();
		this.orderDomain = orderDomain;
	}

	public OrderCreateEvent() {
		super();
	}
}
