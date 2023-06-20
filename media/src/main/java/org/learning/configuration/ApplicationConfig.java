package org.learning.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ApplicationConfig {
    @Value("${application.buckets}")
    private String buckets;

    public List<String> listBuckets() {
        return List.of(buckets.split(","));
    }
}
