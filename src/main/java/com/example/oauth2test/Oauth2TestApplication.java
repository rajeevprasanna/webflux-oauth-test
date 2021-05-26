package com.example.oauth2test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;
import org.springframework.web.reactive.config.EnableWebFlux;

@SpringBootApplication
@EnableWebFlux
public class Oauth2TestApplication {

	public static void main(String[] args) {
		SpringApplication.run(Oauth2TestApplication.class, args);
	}

}
