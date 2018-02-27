package com.bing.springcloud.order.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import com.bing.springcloud.core.order.domains.OrderDomain;
import com.bing.springcloud.core.sms.domains.SmsDomain;
import com.bing.springcloud.core.sms.stream.SmsChannel;
import com.bing.springcloud.core.sms.stream.SmsOutputChannel;

/**
 * 通过MQ异步发送短信
 * 多种写法
 * @author chenbing
 *
 */
@Component
public class SmsServiceClient {

	/**
	 * 可以直接注入这个接口，获取channel对象，使用方式和上面的一样
	 */
	@Autowired
	SmsOutputChannel smsOutputChannel;
	
	/**
	 * 发送新订单短信，用的是注入channel的方式
	 * @param orderDomain
	 */
	public void sendNewOrderSms(OrderDomain orderDomain){
		SmsDomain smsDomain = new SmsDomain();
		smsDomain.setPhone(orderDomain.getPhone());
		smsDomain.setContent("您订单创建成功，订单号为：" + orderDomain.getOrderId());
		smsOutputChannel.output().send(MessageBuilder.withPayload(smsDomain).build());
	}
	
	/**
	 * 发送取消订单的提示短信，用的是注解的方式
	 * 这里使用了一个注解，表示这个方法的返回值，将会被放入对应的MQ中
	 * 并且这里返回的是一个对象，springcloud stream 会将它转为json格式
	 * 对象的转换可以自己写convert，spring也提供了很多内置转换，可以在配置文件中调整
	 * @param orderDomain
	 * @return
	 */
	@SendTo(SmsChannel.CHANNEL)
	public SmsDomain sendCancelOrderSms(OrderDomain orderDomain){
		SmsDomain sms = new SmsDomain();
		sms.setPhone(orderDomain.getPhone());
		sms.setContent("您订单取消成功，订单号为：" + orderDomain.getOrderId());
		return sms;
	}
	
}
