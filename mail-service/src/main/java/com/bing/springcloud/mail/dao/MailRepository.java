package com.bing.springcloud.mail.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import com.bing.springcloud.core.mail.domains.MailDomain;

@Service
public interface MailRepository extends PagingAndSortingRepository<MailDomain, Long> {

}
