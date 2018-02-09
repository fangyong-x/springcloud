package com.fang.servicefeign;

import org.springframework.stereotype.Component;

@Component
public class FeignServiceHystrix implements FeignService {
    @Override
    public String sayFeign(String name) {
        return "FeignServiceHystrix error";
    }
}
