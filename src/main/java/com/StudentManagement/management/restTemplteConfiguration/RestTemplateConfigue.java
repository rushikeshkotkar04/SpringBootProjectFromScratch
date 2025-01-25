package com.StudentManagement.management.restTemplteConfiguration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfigue {

    @Bean
    public RestTemplate restTemplateConfig(){
        return new RestTemplate();
    }
}
