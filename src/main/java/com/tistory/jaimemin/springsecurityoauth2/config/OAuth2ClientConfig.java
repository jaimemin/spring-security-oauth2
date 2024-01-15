package com.tistory.jaimemin.springsecurityoauth2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class OAuth2ClientConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests(authRequest -> authRequest
                .antMatchers("/loginPage")
                .permitAll()
                .anyRequest()
                .authenticated());
        http.oauth2Login(oauth2 -> oauth2.loginPage("/loginPage"));

        return http.build();
    }
}
