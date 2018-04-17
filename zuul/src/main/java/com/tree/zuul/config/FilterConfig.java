package com.tree.zuul.config;

import com.tree.zuul.filter.TokenFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {
//    @Bean
    public TokenFilter tokenFilter(){
        return new TokenFilter();
    }
}
