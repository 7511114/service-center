package com.bing.springcloud.order.events;

import com.bing.springcloud.order.domains.OrderDomain;

/**
 * 订单取消事件
 * @author chenbing
 *
 */
public class OrderCancelEvent {

	public OrderDomain orderDomain;

	public OrderDomain getOrderDomain() {
		return orderDomain;
	}

	public void setOrderDomain(OrderDomain orderDomain) {
		this.orderDomain = orderDomain;
	}

	public OrderCancelEvent(OrderDomain orderDomain) {
		super();
		this.orderDomain = orderDomain;
	}

	public OrderCancelEvent() {
		super();
	}
}
