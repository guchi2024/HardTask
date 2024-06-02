package com.sparta.hardtask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class HardtaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(HardtaskApplication.class, args);
    }

}
