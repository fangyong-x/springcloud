package com.fang.serviceribbon;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TestController {

    @Autowired
    private TestServiceImpl testService;
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value="/sayhello")
    @HystrixCommand(fallbackMethod = "sayError")
    public String hello(){
        return restTemplate.getForObject("http://service-test1/hi?name="+"sddd",String.class);
    }

    public String sayError(){
        return testService.hystrix();
    }

}
