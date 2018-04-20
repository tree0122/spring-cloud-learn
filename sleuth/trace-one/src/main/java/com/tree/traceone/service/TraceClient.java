package com.tree.traceone.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "trace-two")
public interface TraceClient {
    @RequestMapping("traces")
    String traces();
}
