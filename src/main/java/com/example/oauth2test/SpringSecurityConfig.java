package com.example.oauth2test;

import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.util.matcher.PathPatternParserServerWebExchangeMatcher;

@EnableWebFluxSecurity
@EnableReactiveMethodSecurity
public class SpringSecurityConfig {
    @Bean
    @Order(1)
    public SecurityWebFilterChain openAccess(ServerHttpSecurity http) {
        http.securityMatcher(new PathPatternParserServerWebExchangeMatcher("/open"))
                .authorizeExchange(exchanges -> exchanges.anyExchange().permitAll())
                .httpBasic()
                .disable()
                .formLogin()
                .disable();
        return http.build();
    }

    @Bean
    @Order(3)
    public SecurityWebFilterChain oauthAccess(ServerHttpSecurity http) {
        http
                .securityMatcher(new PathPatternParserServerWebExchangeMatcher("/secure"))
                .authorizeExchange(exchanges -> exchanges.anyExchange().authenticated())
                .oauth2Login();
        return http.build();
    }
}
