package com.example.vkrestapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class VkRestApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(VkRestApiApplication.class, args);
    }

}
