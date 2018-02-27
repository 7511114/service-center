package com.bing.springcloud.core.order.stream;

public interface OrderChannel extends OrderInputChannel,OrderOutputChannel {

	String CHANNEL = "order-event";
}
