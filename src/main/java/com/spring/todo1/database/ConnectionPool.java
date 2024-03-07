package com.spring.todo1.database;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ConnectionPool {
    private final String username;
    private final Integer password;

    public ConnectionPool(@Value("${spring.datasource.username}") String username,
                          @Value("${spring.datasource.password}") Integer password) {
        this.username = username;
        this.password = password;
    }

    @PostConstruct
    private void init() {
        log.info("Init connection pool");
    }

    @PreDestroy
    private void destroy() {
        System.out.println("Clean connection pool");
    }

}
