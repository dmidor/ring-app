package com.ring.config;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = { "com.ring" })
@EntityScan(basePackages = "com.ring.persistence.model")
@EnableJpaRepositories(basePackages = "com.ring.persistence.repository")
public class RingAppApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(RingAppApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(RingAppApplication.class, args);
    }
}
