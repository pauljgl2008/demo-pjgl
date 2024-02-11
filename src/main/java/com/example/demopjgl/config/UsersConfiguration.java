package com.example.demopjgl.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties // Cambiado a "spring.data.mongo"
@Data
public class UsersConfiguration {

    @Value("${spring.data.mongodb.uri}")
    private String springDataMongodbUri;
}
