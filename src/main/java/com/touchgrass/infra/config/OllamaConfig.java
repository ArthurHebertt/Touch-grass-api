package com.touchgrass.infra.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class OllamaConfig {

    @Bean
    public RestClient restClient() {
        return RestClient.create("http://localhost:11434");
    }
}
