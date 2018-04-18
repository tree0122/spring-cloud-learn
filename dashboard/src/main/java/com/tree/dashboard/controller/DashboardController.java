package com.tree.dashboard.controller;

import com.tree.dashboard.service.ComputeClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("dashboard")
public class DashboardController {

    @Autowired
    private ComputeClient computeClient;

    @RequestMapping("add")
    public Integer add(@RequestParam("a") Integer a,
                       @RequestParam("b") Integer b){
        return computeClient.add(a, b);
    }
}
