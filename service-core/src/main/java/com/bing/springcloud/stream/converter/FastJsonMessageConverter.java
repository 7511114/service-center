package com.bing.springcloud.stream.converter;

import java.nio.charset.Charset;
import java.util.Collection;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.converter.AbstractMessageConverter;
import org.springframework.util.MimeType;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
//自定义的消息转换器，MQ中的消息就通过这个转换。
//json转对象，对象转json
//@Component // 开启这个注释，这个转换器就会起作用了
public class FastJsonMessageConverter extends AbstractMessageConverter {

	protected FastJsonMessageConverter(){
		super(new MimeType("application", "json", Charset.forName("UTF-8")));
	}
	
	protected FastJsonMessageConverter(Collection<MimeType> supportedMimeTypes) {
		super(supportedMimeTypes);
	}

	@Override
	protected boolean supports(Class<?> arg0) {
		return false;
	}

	@Override
	protected Object convertFromInternal(Message<?> message,
			Class<?> targetClass, Object conversionHint) {
		Object parseObject = JSON.parseObject(message.getPayload().toString(),targetClass);
		return parseObject;
	}

	@Override
	protected Object convertToInternal(Object payload, MessageHeaders headers,
			Object conversionHint) {
		if(byte[].class == getSerializedPayloadClass()){
			payload = JSONObject.toJSONBytes(payload);
		}else{
			payload = JSONObject.toJSONString(payload);
		}
		return payload;
	}
	
	

}
