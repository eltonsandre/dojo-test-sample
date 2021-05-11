package com.github.eltonsandre.sample.domain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.config.EnableWebFlux;

@EnableWebFlux
@SpringBootApplication
public class CucumberSampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(CucumberSampleApplication.class, args);
    }

}
