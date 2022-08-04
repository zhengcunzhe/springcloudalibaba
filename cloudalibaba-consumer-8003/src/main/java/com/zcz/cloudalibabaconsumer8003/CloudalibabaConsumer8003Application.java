package com.zcz.cloudalibabaconsumer8003;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
public class CloudalibabaConsumer8003Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudalibabaConsumer8003Application.class, args);
    }

    //这种就是针对于ribbon的负载均衡了,默认nacos实现了ribbon的负载均衡，轮询策略
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
