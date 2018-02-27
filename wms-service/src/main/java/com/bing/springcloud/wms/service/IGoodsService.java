package com.bing.springcloud.wms.service;

public interface IGoodsService {

	void lock(long goodsId);

	void release(long goodsId);

}
