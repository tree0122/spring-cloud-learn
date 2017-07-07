package com.tree.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by smafi on 2017/6/19.
 */
//@RefreshScope
@RestController
public class TestController {

    @Value("${info.profile}")
    private String from;

    @Autowired
    private Environment env;

    @RequestMapping(value = "/from", method = RequestMethod.GET)
    public String from(){
        String[] profiles = env.getActiveProfiles();
        System.out.println(profiles);
        return this.from;
    }
}
