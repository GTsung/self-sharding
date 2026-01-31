package com.self.sharding.seven.config;

import com.alibaba.druid.pool.DruidDataSource;
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
import java.util.stream.Collectors;

@Configuration
public class ShardingConfig {

    @Value("${self.datasource.table.count}")
    private Integer tableCount;

    @Value("${self.datasource.base-url}")
    private String dbUrl;

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
    public DataSource dataSource() throws SQLException {
        Map<String, DataSource> dataSourceMap = new HashMap<>();
        dataSourceMap.put("ds0", createDataSource());

        ShardingRuleConfiguration shardingRuleConfig =
                new ShardingRuleConfiguration();
        List<TableRuleConfiguration> tableRuleConfigurations = getTableRuleConfigurations();
        tableRuleConfigurations.forEach(tableRuleConfiguration -> {
            shardingRuleConfig.getTableRuleConfigs().add(tableRuleConfiguration);
        });
        return ShardingDataSourceFactory.createDataSource(
                dataSourceMap,
                shardingRuleConfig,
                null
        );
    }

    private List<TableRuleConfiguration> getTableRuleConfigurations() {
        return TableNameConstant.ALL_TABLE_NAME
                .stream()
                .map(this::createRule)
                .collect(Collectors.toList());
    }

    private TableRuleConfiguration createRule(String logicTable) {
        TableRuleConfiguration tableRule =
                new TableRuleConfiguration(
                        logicTable,
                        "ds0." + logicTable + "_${0.." + tableCount + "}");
        tableRule.setTableShardingStrategyConfig(
                new HintShardingStrategyConfiguration(
                        new MyTableShardingAlgorithm()));
        return tableRule;
    }

    private DataSource createDataSource() {
        DruidDataSource ds = new DruidDataSource();
        ds.setDriverClassName(dbDriverName);
        ds.setUrl(dbUrl);
        ds.setUsername(dbUsername);
        ds.setPassword(dbPassword);
        ds.setInitialSize(dbInitSize);
        ds.setMaxActive(maxActive);
        ds.setMinIdle(minIdle);
        ds.setMaxWait(maxWait);
        return ds;
    }

}
