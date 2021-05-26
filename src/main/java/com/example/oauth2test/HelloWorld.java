package com.example.oauth2test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class HelloWorld {

    @GetMapping("/open")
    public Mono<String> openAPI(){
        return Mono.just("open");
    }

    @GetMapping("/secure")
    public Mono<String> protectedAPI(){
        return Mono.just("i am secured");
    }
}
