package com.tree.service;

import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by smafi on 2017/6/19.
 */
public class ComputeClientHystrix implements ComputeClient {
    @Override
    public Integer add(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b) {
        return -9999;
    }
}
