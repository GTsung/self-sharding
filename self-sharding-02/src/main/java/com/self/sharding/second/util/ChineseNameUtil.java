package com.self.sharding.second.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.concurrent.ThreadLocalRandom;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ChineseNameUtil {

    // 常见姓氏（部分）
    private static final String[] SURNAMES = {
            "赵", "钱", "孙", "李", "周", "吴", "郑", "王",
            "冯", "陈", "褚", "卫", "蒋", "沈", "韩", "杨",
            "朱", "秦", "尤", "许", "何", "吕", "施", "张",
            "孔", "曹", "严", "华", "金", "魏", "陶", "姜"
    };

    // 常见中文名字符（部分）
    private static final String NAME_CHARS =
            "伟刚勇毅俊峰强军平保东文辉力明永健世聪广志义兴良海山仁波宁贵福生龙元国胜学祥才发武新利清飞彬" +
                    "富顺信子杰涛昌成康星光天达安岩中茂进林有坚和彪博诚先雅震振慧思群豪心邦承乐绍功松善厚" +
                    "庆磊民友裕河哲江超丽浩亮政谦亨奇固之轮翰朗伯宏言若鸣鹏斌栋维启克伦翔旭鹏泽晨辰士建家树" +
                    "炎德行泰盛雄琛钧冠策腾楠榕风航弘";

    /**
     * 生成一个随机中文名字
     * @return 如：王伟、李小明
     */
    public static String generateRandomName() {
        // 随机姓
        String surname = SURNAMES[ThreadLocalRandom.current().nextInt(SURNAMES.length)];

        // 名字长度：1或2个字
        int nameLength = ThreadLocalRandom.current().nextBoolean() ? 1 : 2;

        StringBuilder givenName = new StringBuilder();
        for (int i = 0; i < nameLength; i++) {
            int index = ThreadLocalRandom.current().nextInt(NAME_CHARS.length());
            givenName.append(NAME_CHARS.charAt(index));
        }

        return surname + givenName.toString();
    }

    // 测试方法
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(generateRandomName());
        }
    }
}

