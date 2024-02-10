package com.example.demopjgl.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "spring.data.mongo") // Cambiado a "spring.data.mongo"
@Data
public class UsersServiceConfiguration {

    private String url;
}
