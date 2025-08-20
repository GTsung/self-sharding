package com.self.sharding.fifth;

import com.google.common.collect.Lists;
import com.self.sharding.fifth.domain.UserDO;
import com.self.sharding.fifth.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
public class FifthTest {

    @Resource
    private UserService userService;

    @Test
    public void testSave() {
        List<UserDO> userDOS = Lists.newArrayList(
                UserDO.builder()
                        .userId(1L)
                        .userName("adams")
                        .pwd("1111")
                        .userNamePlain("adams")
                        .assistedQueryPwd("1111")
                        .build(),
                UserDO.builder()
                        .userId(2L)
                        .userName("jane")
                        .pwd("2222")
                        .userNamePlain("jane")
                        .assistedQueryPwd("2222")
                        .build()
        );
        System.out.println(userService.saveUsers(userDOS));
    }

    @Test
    public void testSelect() {
        UserDO userById = userService.getUserById(1L);
        System.out.println(userById);
    }


}
