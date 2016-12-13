package com.demo.service;

import com.demo.domain.Customer;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheKey;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheResult;

import org.springframework.stereotype.Service;


@Service
public class CustomerCacheService {

    @CacheResult
    @HystrixCommand
    public Customer createCustomer(@CacheKey int id, String name) {
        return new Customer(id, name, name);
    }

}
