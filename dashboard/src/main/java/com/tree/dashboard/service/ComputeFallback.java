package com.tree.dashboard.service;

import org.springframework.stereotype.Component;

@Component
class ComputeFallback implements ComputeClient{

    @Override
    public Integer add(Integer a, Integer b) {
        return -999;
    }
}