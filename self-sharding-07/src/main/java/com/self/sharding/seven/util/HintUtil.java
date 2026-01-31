package com.self.sharding.seven.util;

import org.apache.shardingsphere.api.hint.HintManager;

import java.util.function.Supplier;

public class HintUtil {

    public static <T> T hintAndExecute(String tableName, Long shardingKey, Supplier<T> supplier) {
        HintManager.clear();
        HintManager hintManager = HintManager.getInstance();
        hintManager.addTableShardingValue(tableName, shardingKey);
        try {
            return supplier.get();
        } finally {
            HintManager.clear();
        }
    }

    public static void hintAndExecute(String tableName, Long shardingKey, Runnable runnable) {
        HintManager.clear();
        HintManager hintManager = HintManager.getInstance();
        hintManager.addTableShardingValue(tableName, shardingKey);
        try {
            runnable.run();
        } finally {
            HintManager.clear();
        }
    }

}
