package com.tree.tracetwo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@Slf4j
@RestController
public class TraceTwoApplication {


	@RequestMapping("traces")
	public String traces(){

		log.info("=== call traces-2 ===");

		return "traces";
	}


	public static void main(String[] args) {
		SpringApplication.run(TraceTwoApplication.class, args);
	}
}
