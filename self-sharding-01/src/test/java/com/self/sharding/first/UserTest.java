package com.self.sharding.first;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.google.common.collect.Lists;
import com.self.sharding.first.domain.SelfUser;
import com.self.sharding.first.service.SelfUserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
public class UserTest {

    @Resource
    private SelfUserService selfUserService;

    @Test
    public void insert() {
        // 0-man 1-woman
        SelfUser u1 = SelfUser.builder().name("jane").sex(1).build();
        SelfUser u2 = SelfUser.builder().name("lucy").sex(1).build();
        SelfUser u3 = SelfUser.builder().name("nancy").sex(1).build();
        SelfUser u4 = SelfUser.builder().name("eden").sex(1).build();
        SelfUser u5 = SelfUser.builder().name("adams").sex(0).build();
        SelfUser u6 = SelfUser.builder().name("jack").sex(0).build();
        SelfUser u7 = SelfUser.builder().name("roy").sex(0).build();
        SelfUser u8 = SelfUser.builder().name("jimmy").sex(0).build();
        List<SelfUser> users = Lists.newArrayList(u1, u2, u3, u4, u5, u6, u7, u8);
        selfUserService.saveBatch(users);
    }

    @Test
    public void queryTest() {
        SelfUser user = selfUserService.getOne(
                Wrappers.<SelfUser>lambdaQuery().eq(SelfUser::getName, "jane")
        );
        System.out.println(user);

        List<SelfUser> users = selfUserService.list(Wrappers.<SelfUser>lambdaQuery().eq(SelfUser::getSex, 1));
        System.out.println(users);
    }

}
