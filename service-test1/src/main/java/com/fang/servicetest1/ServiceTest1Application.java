package com.fang.servicetest1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class ServiceTest1Application {

	public static void main(String[] args) {
		SpringApplication.run(ServiceTest1Application.class, args);
	}

	@Value("${server.port}")
	String port;

	@RequestMapping(value="/hi")
	public String sayHi(@RequestParam String name){
		return "myName is "+ name + ", myPort is " + port;
	}
}
