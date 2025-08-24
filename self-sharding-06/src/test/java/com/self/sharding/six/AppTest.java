package com.self.sharding.six;


import com.google.common.collect.Lists;
import com.self.sharding.six.domain.PeopleDO;
import com.self.sharding.six.service.PeopleService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
public class AppTest {

    @Resource
    private PeopleService peopleService;

    @Test
    public void testSave() {
        List<PeopleDO> peopleDOS = Lists.newArrayList(
                PeopleDO.builder()
                        .userId(1L)
                        .userName("adams")
                        // 此处不需要给 userNamePlain 设值,sharding会根据配置自动将明文设置到该字段
//                        .userNamePlain("adams")
                        .pwd("123456")
                        .assistedQueryPwd("123456")
                        .build(),
                PeopleDO.builder()
                        .userId(2L)
                        .userName("jane")
                        .pwd("1q2w3e")
                        .assistedQueryPwd("1q2w3e")
                        .build(),
                PeopleDO.builder()
                        .userId(3L)
                        .userName("jack")
                        .pwd("okNotOk123")
                        .assistedQueryPwd("okNotOk123")
                        .build()
        );
        peopleService.saveBatch(peopleDOS);
    }

    @Test
    public void testSelect() {
        // 会将加密名字字段自动解密
        peopleService.list().forEach(System.out::println);
    }

}
