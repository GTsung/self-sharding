package com.self.sharding.third.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.self.sharding.third.domain.UserDO;
import com.self.sharding.third.mapper.UserMapper;
import com.self.sharding.third.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserDO> implements UserService {
}
