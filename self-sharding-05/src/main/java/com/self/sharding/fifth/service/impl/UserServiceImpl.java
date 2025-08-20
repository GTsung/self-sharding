package com.self.sharding.fifth.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.self.sharding.fifth.domain.UserDO;
import com.self.sharding.fifth.mapper.UserMapper;
import com.self.sharding.fifth.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserDO> implements UserService {

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean saveUsers(List<UserDO> users) {
        return saveBatch(users);
    }

    @Override
    public UserDO getUserById(Long userId) {
        return list(Wrappers.<UserDO>lambdaQuery()
                .eq(UserDO::getUserId, userId))
                .stream()
                .findFirst()
                .orElse(null);
    }
}
