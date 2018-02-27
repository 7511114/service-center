package com.bing.springcloud.order.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import feign.hystrix.FallbackFactory;

/**
 * 这是一个feign写的客户端，用于请求wms服务相关的接口
 * @author chenbing
 *
 */
@FeignClient(name="wms-service", path="wms")
public interface WmsServiceClient {

	@RequestMapping(value="/lock/{goodsId}", method=RequestMethod.POST)
	String lock(@PathVariable("goodsId") long goodsId);
	
	@RequestMapping(value="/release/{goodsId}", method=RequestMethod.POST)
	String release(@PathVariable("goodsId") long goodsId);
}

/**
 * 降级工厂
 * @author chenbing
 *
 */
@Component
class WmsFallbackFactory implements FallbackFactory<WmsServiceClient> {

	static final Logger logger = LoggerFactory.getLogger(WmsFallbackFactory.class);
	
	@Autowired
	WmsServiceFallback wmsServiceFallback;
	
	@Override
	public WmsServiceClient create(Throwable arg0) {
		if(null == wmsServiceFallback){
			return new WmsServiceFallback();
		}
		logger.info("wms服务调用异常", arg0);
		return wmsServiceFallback;
	}
	
}

@Component
class WmsServiceFallback implements WmsServiceClient{
	static final Logger logger = LoggerFactory.getLogger(WmsServiceFallback.class);
	
	@Override
	public String lock(long skuid) {
		logger.warn("降级：WmsService.lock异常");
		return null;
	}

	@Override
	public String release(long goodsId) {
		logger.warn("降级：WmsService.release异常");
		return null;
	}
}

