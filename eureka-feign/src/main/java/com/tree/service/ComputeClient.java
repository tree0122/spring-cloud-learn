package com.tree.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by smafi on 2017/6/19.
 */
@FeignClient(value = "compute-service", fallback = ComputeHystrix.class)
public interface ComputeClient {

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    Integer add(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b);

}

@Component
class ComputeHystrix implements ComputeClient{

    @Override
    public Integer add(Integer a, Integer b) {
        return -999;
    }
}
