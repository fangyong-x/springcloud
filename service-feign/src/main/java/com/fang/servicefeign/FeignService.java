package com.fang.servicefeign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "service-test1",fallback = FeignServiceHystrix.class)
public interface FeignService {

    @RequestMapping(value="/hi", method = RequestMethod.GET)
    String sayFeign(@RequestParam(value="name") String name);
}
