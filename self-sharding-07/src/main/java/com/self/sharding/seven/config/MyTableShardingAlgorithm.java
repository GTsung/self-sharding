package com.self.sharding.seven.config;

import org.apache.shardingsphere.api.sharding.hint.HintShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.hint.HintShardingValue;

import java.util.Collection;

public class MyTableShardingAlgorithm implements HintShardingAlgorithm<Long> {

    private static final int TABLE_SIZE = 2;

    @Override
    public Collection<String> doSharding(Collection<String> availableTargetNames,
                                         HintShardingValue<Long> shardingValue) {
        Long value = shardingValue.getValues().iterator().next();
        int index = (int) (value % TABLE_SIZE);
        for (String tableName : availableTargetNames) {
            if (tableName.endsWith("_" + index)) {
                return java.util.Collections.singleton(tableName);
            }
        }
        throw new UnsupportedOperationException("cannot route table");
    }

}
