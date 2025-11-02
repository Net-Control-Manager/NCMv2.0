package org.ncm.ncmv2.test;

import org.junit.jupiter.api.*;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.PostgreSQLContainer;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public interface Containers {
    PostgreSQLContainer<?> POSTGRES = new PostgreSQLContainer<>("postgis/postgis:16-3.4").withDatabaseName("ncm").withUsername("ncm").withPassword("Passw0rd!");
    GenericContainer<?> REDIS = new GenericContainer<>("redis:7-alpine").withExposedPorts(6379);

    @BeforeAll
    default void startContainers() {
        if (!POSTGRES.isRunning()) POSTGRES.start();
        if (!REDIS.isRunning()) REDIS.start();
        System.setProperty("spring.datasource.url", POSTGRES.getJdbcUrl());
        System.setProperty("spring.datasource.username", POSTGRES.getUsername());
        System.setProperty("spring.datasource.password", POSTGRES.getPassword());
        System.setProperty("spring.data.redis.host", REDIS.getHost());
        System.setProperty("spring.data.redis.port", String.valueOf(REDIS.getFirstMappedPort()));
        System.setProperty("spring.jpa.hibernate.ddl-auto", "none");
    }
}
