package com.demo.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ComputeService {

    @Autowired
    RestTemplate restTemplate;

    /**
     * HystrixCommand 断路器
     * @return
     */
    @HystrixCommand(fallbackMethod = "addServiceFallback")
    public String addService() {
        return restTemplate.getForEntity("http://compute-service:2222/add?a=10&b=20", String.class).getBody();
    }

    /**
     * 路断器发生错误的时候，执行的方法。
     * @return
     *
     */
    public String addServiceFallback() {
        return "error";
    }

}
