package com.bing.springcloud.core.sms.stream;

public interface SmsChannel extends SmsInputChannel, SmsOutputChannel {

	String CHANNEL = "sms_event";
}
