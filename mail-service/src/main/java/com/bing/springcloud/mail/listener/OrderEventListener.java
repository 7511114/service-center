package com.bing.springcloud.mail.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

import com.bing.springcloud.core.mail.domains.MailDomain;
import com.bing.springcloud.core.order.events.OrderCancelEvent;
import com.bing.springcloud.core.order.events.OrderCreateEvent;
import com.bing.springcloud.core.order.stream.OrderChannel;
import com.bing.springcloud.mail.dao.MailRepository;

@Component
public class OrderEventListener {

	final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	MailRepository mailRepository;
	
	@StreamListener(target=OrderChannel.CHANNEL, condition="headers['event-type']=='OrderCreateEvent'")
	public void receive(OrderCreateEvent orderCreateEvent){
		MailDomain mainDomain = new MailDomain();
		mainDomain.setSendTo(orderCreateEvent.getOrderDomain().getEmail());
		mainDomain.setSubject("新订单提醒");
		mainDomain.setContent("你有一个新的订单，订单编号为：" + orderCreateEvent.getOrderDomain().getOrderId());
		mailRepository.save(mainDomain);
		logger.debug("发送一封新订单邮件");
	}
	
	@StreamListener(target=OrderChannel.CHANNEL, condition="headers['event-type']=='OrderCancelEvent'")
	public void receive(OrderCancelEvent orderCancelEvent){
		MailDomain mailDomain = new MailDomain();
		mailDomain.setSendTo(orderCancelEvent.getOrderDomain().getEmail());
		mailDomain.setSubject("取消订单提醒");
		mailDomain.setContent("订单取消成功，清单号为：" + orderCancelEvent.getOrderDomain().getOrderId());
		mailRepository.save(mailDomain);
		logger.debug("发送一封取消订单的邮件");
	}
	
}
