package com.example.demopjgl.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    private static final String[] NO_AUTH_LIST ={
            "/api-docs",
            "/configuracion/v1",
            "/swagger-resources",
            "/configuration/security",
            "/login"
    };
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        /*
        return http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().authenticated()
                )
                .httpBasic(withDefaults())
                .formLogin(withDefaults())
                .build();
        */
        return http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(NO_AUTH_LIST).permitAll()
                        .requestMatchers(HttpMethod.POST, "/*usuarios*/**").authenticated()
                        .requestMatchers(HttpMethod.GET, "/*usuarios*/**").hasRole("ADMIN")
                        .anyRequest().authenticated()
                )
                .httpBasic(withDefaults())
                .formLogin(withDefaults())
                .build();

    }


}

