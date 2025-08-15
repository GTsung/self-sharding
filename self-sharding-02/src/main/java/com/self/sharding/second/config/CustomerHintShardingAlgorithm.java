package com.self.sharding.second.config;

import org.apache.shardingsphere.api.sharding.hint.HintShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.hint.HintShardingValue;

import java.util.Collection;
import java.util.stream.Collectors;

public class CustomerHintShardingAlgorithm implements HintShardingAlgorithm<String> {

    private final int dbCount;

    public CustomerHintShardingAlgorithm(int dbCount) {
        this.dbCount = dbCount;
    }

    @Override
    public Collection<String> doSharding(Collection<String> availableTargetNames, HintShardingValue<String> shardingValue) {
        // 从HintManager中获取分片值（客户编号）
        String customerId = shardingValue.getValues().iterator().next();
        // 计算分库索引（对库数量取模）
        int dbIndex = Math.abs(customerId.hashCode()) % dbCount;
        String targetDb = "ds" + dbIndex;
        // 过滤出目标数据源
        return availableTargetNames.stream()
                .filter(name -> name.equals(targetDb))
                .collect(Collectors.toList());
    }

}
