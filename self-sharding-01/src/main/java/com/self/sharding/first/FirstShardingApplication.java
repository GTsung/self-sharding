package com.self.sharding.first;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DruidDataSourceAutoConfigure.class, DataSourceAutoConfiguration.class})
@MapperScan(basePackages = {"com.self.sharding.first.mapper"})
public class FirstShardingApplication {

    public static void main(String[] args) {
        SpringApplication.run(FirstShardingApplication.class, args);
    }

}
