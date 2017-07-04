package com.tree.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by smafi on 2017/6/19.
 */
@RestController
public class ConsumerController {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/add1", method = RequestMethod.GET)
    public String add(){
        String url = "http://compute-service/add?a=10&b=20";
        return restTemplate.getForEntity(url, String.class).getBody();
    }
}
