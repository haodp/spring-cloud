package com.demo.controller;

import com.demo.domain.Customer;
import com.demo.service.CustomerCacheService;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheKey;
import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController
class HystrixCacheController {

    @Autowired
    CustomerCacheService customerCacheService;

    @RequestMapping(value = "/customer-cache/{id}", method = RequestMethod.GET, produces = "application/json")
    public Customer getCustomer(@CacheKey @PathVariable int id, @RequestParam String name) throws ExecutionException, InterruptedException {
        try {
            HystrixRequestContext.initializeContext();
            return customerCacheService.createCustomer(id, name);
        } finally {
            HystrixRequestContext.getContextForCurrentThread().shutdown();
        }
    }



}