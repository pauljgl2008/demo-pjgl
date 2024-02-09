package com.example.demopjgl.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    /**
    private static final String[] NO_AUTH_LIST = {
            "/api-docs",
            "/configuracion/v1",
            "/swagger-resources",
            "/configuration/security",
            "/login"
    };*/

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        /**
         return http.csrf(csrf -> csrf.disable()).build();
         return http.build();
        */
        return http.csrf(AbstractHttpConfigurer::disable).build();

        /**
         return http.csrf(csrf -> csrf.disable())
         .authorizeHttpRequests(auth -> auth
         .anyRequest().authenticated()
         )
         .httpBasic(withDefaults())
         .formLogin(withDefaults())
         .build();*/

        /**
         return http.csrf(csrf -> csrf.disable())
         .authorizeHttpRequests(auth -> auth
         .requestMatchers(NO_AUTH_LIST).permitAll()
         .requestMatchers(HttpMethod.POST, "/usuarios/**").authenticated()
         .requestMatchers(HttpMethod.GET, "/usuarios/**").hasRole("ADMIN")
         .anyRequest().authenticated()
         )
         .httpBasic(withDefaults())
         .formLogin(withDefaults())
         .build();
         */
    }
    /**
    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration cc = new CorsConfiguration();

        cc.setAllowedHeaders(Arrays.asList("Origin,Accept", "X-Requested-With", "Content-Type", "Access-Control-Request-Method", "Access-Control-Request-Headers", "Authorization"));
        cc.setExposedHeaders(Arrays.asList("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"));
        cc.setAllowedOrigins(Arrays.asList("/*"));
        cc.setAllowedMethods(Arrays.asList("GET", "POST", "OPTIONS", "PUT", "PATCH", "DELETE"));
        cc.addAllowedOriginPattern("*");
        cc.setMaxAge(Duration.ZERO);
        cc.setAllowCredentials(Boolean.TRUE);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", cc);
        return source;
    }*/


}

