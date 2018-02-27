package com.bing.springcloud.wms.dao;

import java.io.Serializable;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.bing.springcloud.core.wms.domains.GoodsDomain;

public interface GoodsRepository extends PagingAndSortingRepository<GoodsDomain, Serializable> {

}
