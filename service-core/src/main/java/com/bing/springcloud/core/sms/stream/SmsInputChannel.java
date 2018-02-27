package com.bing.springcloud.core.sms.stream;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface SmsInputChannel {

	/**
	 * 这里的channel是用来接收数据的
	 * @return
	 */
	@Input(SmsChannel.CHANNEL)
	SubscribableChannel input();
}
