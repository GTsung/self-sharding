package com.self.sharding.second.util;

import org.apache.shardingsphere.api.hint.HintManager;

public class HintUtil {

    public static void setDatabase(String customerNo) {
        HintManager.clear();
        HintManager hintManager = HintManager.getInstance();
        hintManager.setDatabaseShardingValue(customerNo);
    }

    public static void clear() {
        HintManager.clear();
    }

}
