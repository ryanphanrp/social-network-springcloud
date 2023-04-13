package com.ryan.infrastructure;

import feign.RequestInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfiguration {

    private static final String TOKEN_NAME = "x-api-key";

    @Value("${service.feign.token}")
    private String token;

    @Bean
    public RequestInterceptor requestInterceptor() {
        return template -> template.header(TOKEN_NAME, token);
    }
}
