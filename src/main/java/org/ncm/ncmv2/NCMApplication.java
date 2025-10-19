package org.ncm.ncmv2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("org.ncm.ncmv2.domain.repo")
@EntityScan("org.ncm.ncmv2.domain.model")
public class NCMApplication {
    public static void main(String[] args) {
        SpringApplication.run(NCMApplication.class, args);
    }
}