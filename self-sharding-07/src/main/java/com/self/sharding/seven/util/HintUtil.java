package com.self.sharding.seven.util;

import org.apache.shardingsphere.api.hint.HintManager;

import java.util.function.Supplier;

public class HintUtil {

    public static <T> T hintAndExecute(String tableName, Long shardingKey, Supplier<T> supplier) {
        try (HintManager hintManager = HintManager.getInstance()) {
            hintManager.addTableShardingValue(tableName, shardingKey);
            return supplier.get();
        }
    }

    public static void hintAndExecute(String tableName, Long shardingKey, Runnable runnable) {
        try (HintManager hintManager = HintManager.getInstance()) {
            hintManager.addTableShardingValue(tableName, shardingKey);
            runnable.run();
        }
    }

}
