package com.bing.springcloud.wms.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.bing.springcloud.core.wms.domains.GoodsDomain;
import com.bing.springcloud.wms.dao.GoodsRepository;
import com.bing.springcloud.wms.service.IGoodsService;

@Service
public class GoodsServiceImpl implements IGoodsService {

	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	GoodsRepository goodsRepository;
	
	@Override
	public void lock(long goodsId){
		int c = 0;
		while(0 == c){
			GoodsDomain goodsDomain = goodsRepository.findOne(goodsId);
			c = jdbcTemplate.update("update tb_goods set stock_count = stock_count - 1 where goods_id=" + goodsId
					+ " and version=" + goodsDomain.getVersion());
		}
		logger.debug("锁定商品，编号为：{}，库存-1", goodsId);
	}
	
	@Override
	public void release(long goodsId) {
		int c = 0;
		// 乐观锁，如果版本不一致，则再次获取
		// update <table> set xx=xx where version = <version>
		while (c == 0) {
			GoodsDomain goodsDomain = goodsRepository.findOne(goodsId);
			c = jdbcTemplate.update("update tb_goods set stock_count = stock_count + 1 where goods_id=" + goodsId
					+ " and version=" + goodsDomain.getVersion());
		}

		logger.debug("释放库存锁定，商品编号为：{},，库存+1", goodsId);
	}
}
