package com.bing.springcloud.sms.dao;

import java.io.Serializable;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.bing.springcloud.core.sms.domains.SmsDomain;

public interface SmsRepository extends PagingAndSortingRepository<SmsDomain, Serializable> {

}
