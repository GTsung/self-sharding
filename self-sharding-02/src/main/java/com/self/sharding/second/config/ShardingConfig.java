package com.self.sharding.second.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.google.common.collect.Lists;
import org.apache.shardingsphere.api.config.sharding.KeyGeneratorConfiguration;
import org.apache.shardingsphere.api.config.sharding.ShardingRuleConfiguration;
import org.apache.shardingsphere.api.config.sharding.TableRuleConfiguration;
import org.apache.shardingsphere.api.config.sharding.strategy.HintShardingStrategyConfiguration;
import org.apache.shardingsphere.shardingjdbc.api.ShardingDataSourceFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;

@Configuration
public class ShardingConfig {

    @Value("${self.datasource.count}")
    private Integer dbCount;

    @Value("${self.datasource.base-url}")
    private String dbPrefix;

    @Value("${self.datasource.driver-class-name}")
    private String dbDriverName;

    @Value("${self.datasource.username}")
    private String dbUsername;

    @Value("${self.datasource.password}")
    private String dbPassword;

    @Value("${self.datasource.druid.initial-size}")
    private Integer dbInitSize;

    @Value("${self.datasource.druid.max-active}")
    private Integer maxActive;

    @Value("${self.datasource.druid.min-idle}")
    private Integer minIdle;

    @Value("${self.datasource.druid.max-wait}")
    private Integer maxWait;

    @Bean
    @Primary
    public DataSource shardingDataSource() throws SQLException {
        ShardingRuleConfiguration shardingRuleConfig = new ShardingRuleConfiguration();
        // 配置表规则（所有表使用相同的分库策略）
        List<TableRuleConfiguration> tableRules = getTables()
                .stream()
                .map(this::createTableRule)
                .collect(Collectors.toList());
        shardingRuleConfig.setTableRuleConfigs(tableRules);
        // 设置分库策略（Hint强制路由）
        shardingRuleConfig.setDefaultDatabaseShardingStrategyConfig(
                new HintShardingStrategyConfiguration(new CustomerHintShardingAlgorithm(dbCount))
        );
        return ShardingDataSourceFactory.createDataSource(
                createDataSourceMap(),
                shardingRuleConfig,
                new Properties()
        );
    }

    private Map<String, DataSource> createDataSourceMap() {
        Map<String, DataSource> dataSourceMap = new HashMap<>();
        for (int i = 0; i < dbCount; i++) {
            dataSourceMap.put("ds" + i, buildDruidDataSource(i));
        }
        return dataSourceMap;
    }

    private DataSource buildDruidDataSource(int dbIndex) {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(String.format("%s?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC",
                dbPrefix + "ds" + dbIndex));
        dataSource.setUsername(dbUsername);
        dataSource.setPassword(dbPassword);
        dataSource.setDriverClassName(dbDriverName);
        dataSource.setMaxActive(maxActive);
        dataSource.setInitialSize(dbInitSize);
        dataSource.setMinIdle(minIdle);
        dataSource.setMaxWait(maxWait);
        return dataSource;
    }

    private List<String> getTables() {
        return Lists.newArrayList(
                "t_customer",
                "t_loan",
                "t_repay_plan",
                "t_repay_detail"
        );
    }

    /**
     * 创建表规则（不配置分表，仅分库）
     */
    private TableRuleConfiguration createTableRule(String tableName) {
        TableRuleConfiguration tableRuleConfiguration = new TableRuleConfiguration(tableName,
                String.format("ds${0..%s}.%s", (dbCount - 1), tableName));
        tableRuleConfiguration.setKeyGeneratorConfig(new KeyGeneratorConfiguration("SNOWFLAKE", "id"));
        return tableRuleConfiguration;
    }

}
