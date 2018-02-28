package com.bing.springcloud.sms.stream;

public interface SmsChannel extends SmsInputChannel, SmsOutputChannel {

	String CHANNEL = "sms_event";
}
