package com.tree.web;

import com.tree.service.ComputeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by smafi on 2017/6/19.
 */
@RestController
public class HystrixConsumerController {

    @Autowired
    private ComputeService computeService;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(){
        return computeService.addService();
    }
}
