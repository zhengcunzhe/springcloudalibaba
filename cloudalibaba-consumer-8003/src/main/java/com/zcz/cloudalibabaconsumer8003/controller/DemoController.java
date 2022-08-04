package com.zcz.cloudalibabaconsumer8003.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RefreshScope//不用重启服务也能使修改的配置生效
public class DemoController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${provider.url}")
    private String providerUrl;

    @GetMapping(value = "getProvider")
    public String getProvider() {
        System.out.println(providerUrl);
        return restTemplate.getForObject(providerUrl + "/getServerPort", String.class);
    }
}
