package com.tree.traceone;

import com.tree.traceone.service.TraceClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@Slf4j
@RestController
@EnableFeignClients
public class TraceOneApplication {

	@Autowired
	TraceClient traceClient;

	@Bean
	@LoadBalanced
	RestTemplate restTemplate(){
		return new RestTemplate();
	}

	@RequestMapping("traces")
	public String traces(){
		log.info("=== call traces-1 ===");

		return restTemplate().getForEntity("http://trace-two/traces", String.class).getBody();
	}

	@RequestMapping("feign")
	public String feign(){
		log.info("=== call feign ==");

		return traceClient.traces();
	}



	public static void main(String[] args) {
		SpringApplication.run(TraceOneApplication.class, args);
	}
}
