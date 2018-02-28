package com.bing.springcloud.sms.stream;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface SmsOutputChannel {

	/**
	 * 这里的channel是用来发送数据的
	 * @return
	 */
	@Output(SmsChannel.CHANNEL)
	MessageChannel output();
}
