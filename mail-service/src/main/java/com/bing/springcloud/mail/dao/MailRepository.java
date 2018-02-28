package com.bing.springcloud.mail.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.bing.springcloud.mail.domains.MailDomain;

public interface MailRepository extends PagingAndSortingRepository<MailDomain, Long> {

}
