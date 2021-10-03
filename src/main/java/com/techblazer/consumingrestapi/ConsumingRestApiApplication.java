package com.techblazer.consumingrestapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication // same as @Configuration @EnableAutoConfiguration @ComponentScan
public class ConsumingRestApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumingRestApiApplication.class, args);
    }

}
