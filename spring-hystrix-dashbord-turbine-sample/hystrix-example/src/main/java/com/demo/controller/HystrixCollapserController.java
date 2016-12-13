package com.demo.controller;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.domain.MessageWrapper;
import com.demo.service.CustomerCollapserService;

@RestController
class HystrixCollapserController {

    @Autowired
    private CustomerCollapserService customerCollapserService;

    @RequestMapping(value = "/customer-collapser/{id}", method = RequestMethod.GET, produces = "application/json")
    public MessageWrapper getCustomer(@PathVariable int id) throws ExecutionException, InterruptedException {
        return customerCollapserService.getCustomerById(id).get();
    }



}