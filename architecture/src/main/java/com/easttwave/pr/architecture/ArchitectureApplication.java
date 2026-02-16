package com.easttwave.pr.architecture;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class ArchitectureApplication {

    public static void main(String[] args) {
        SpringApplication.run(ArchitectureApplication.class, args);
    }

}
