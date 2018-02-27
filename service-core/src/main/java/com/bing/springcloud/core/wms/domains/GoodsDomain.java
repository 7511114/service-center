package com.bing.springcloud.core.wms.domains;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_goods")
public class GoodsDomain implements Serializable {

	private static final long serialVersionUID = -5995454765139711455L;

	@Id
	@GeneratedValue
	@Column(name="goods_id")
	private Long goodsId;
	
	@Column(name="sku_id")
	private String skuId;
	
	@Column(name="goods_name")
	private String goodsName;
	
	/**
	 * 余量
	 */
	@Column(name="stock_count")
	private Integer stockCount;
	
	/**
	 * 数据版本号，乐观锁
	 */
	@Column
	private Integer version;
	public Long getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}

	public String getSkuId() {
		return skuId;
	}

	public void setSkuId(String skuId) {
		this.skuId = skuId;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public int getStockCount() {
		return stockCount;
	}

	public void setStockCount(int stockCount) {
		this.stockCount = stockCount;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}
}
