package com.self.sharding.fifth;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Hello world!
 */
@EnableTransactionManagement
@MapperScan(basePackages = {"com.self.sharding.fifth.mapper"})
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, DruidDataSourceAutoConfigure.class})
public class FifthApp {


    public static void main(String[] args) {
        SpringApplication.run(FifthApp.class, args);
    }


}
