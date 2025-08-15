package com.self.sharding.second.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.concurrent.ThreadLocalRandom;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PhoneUtil {

    public static String generateRandomPhoneNumber() {
        // 常见运营商前缀段（仅示例，非完整）
        String[] prefixes = {
                "133", "149", "153", "173", "177", "180", "181", "189", // 电信
                "130", "131", "132", "145", "155", "156", "166", "175", "176", "185", "186", // 联通
                "134", "135", "136", "137", "138", "139", "147", "150", "151", "152", "157", "158", "159", "172", "178", "182", "183", "184", "187", "188", "198" // 移动
        };

        // 随机选一个前缀
        String prefix = prefixes[ThreadLocalRandom.current().nextInt(prefixes.length)];

        // 随机生成后 8 位数字，补零对齐
        int suffix = ThreadLocalRandom.current().nextInt(0, 100_000_000);
        String suffixStr = String.format("%08d", suffix);

        return prefix + suffixStr;
    }

}
