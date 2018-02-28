package com.bing.springcloud.order.stream;

public interface OrderChannel extends OrderInputChannel,OrderOutputChannel {

	String CHANNEL = "order-event";
}
