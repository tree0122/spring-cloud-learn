package com.tree.web;

import com.tree.service.ComputeClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by smafi on 2017/6/19.
 */
@RestController
@Slf4j
public class ConsumerController {

    @Autowired(required = false)
    ComputeClient computeClient;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public Integer add(){
        log.info("===call add-1===");
        return computeClient.add(10, 20);
    }

}
