package com.self.sharding.second;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 */
@MapperScan(basePackages = {"com.self.sharding.second.mapper"})
@SpringBootApplication
public class SecApp {

    public static void main(String[] args) {
        SpringApplication.run(SecApp.class, args);
    }

}
