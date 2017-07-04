package com.tree.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by smafi on 2017/6/19.
 */
@Service
public class ComputeService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "addServiceFallback")
    public String addService(){
        String url = "http://compute-service/add?a=10&b=20";
        return restTemplate.getForEntity(url, String.class).getBody();
    }

    public String addServiceFallback(){
        return "error";
    }
}
