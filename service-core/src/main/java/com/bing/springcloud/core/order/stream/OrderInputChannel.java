package com.bing.springcloud.core.order.stream;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface OrderInputChannel {

	/**
	 * 这里的channel是用来接收数据的
	 * @return
	 */
	@Input(OrderChannel.CHANNEL)
	SubscribableChannel input();
}
