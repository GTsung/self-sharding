package com.self.sharding.seven;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * Hello world!
 */
@MapperScan(basePackages = {"com.self.sharding.seven.mapper"})
@SpringBootApplication(
        exclude = {DataSourceAutoConfiguration.class,
                DruidDataSourceAutoConfigure.class})
public class SevenApp {

    public static void main(String[] args) {
        SpringApplication.run(SevenApp.class, args);
    }

}
