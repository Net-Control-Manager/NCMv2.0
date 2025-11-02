package org.ncm.ncmv2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "org.ncm.ncmv2")
public class NCMApplication {
    public static void main(String[] args) {
        SpringApplication.run(NCMApplication.class, args);
    }
}