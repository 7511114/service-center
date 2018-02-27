package com.bing.springcloud.core.order.stream;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface OrderOutputChannel {

	/**
	 * 这里的channel是用来发送数据的
	 * @return
	 */
	@Output(OrderChannel.CHANNEL)
	MessageChannel output();
}
